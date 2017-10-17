/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Marrone.dao;

import br.com.Marrone.conexao.Conexao;
import br.com.Marrone.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gui Freitas
 */
public class PedidoDao {

    private Connection conexao;

    public PedidoDao() {
        conexao = Conexao.getConnection();
    }

    public Pedido Inserir(Pedido pedido) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("insert into pedido(data, codcliente) values (?, ?) RETURNING numero ");
            // Parameters start with 1
            preparedStatement.setDate(1, new java.sql.Date(pedido.getData().getTime()));
            preparedStatement.setInt(2, pedido.getCliente().getId());
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return ConsultarPorId(rs.getInt("numero"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void Remover(int numero) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("delete from pedido where numero=?");
            // Parameters start with 1
            preparedStatement.setInt(1, numero);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Alterar(Pedido pedido) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("update pedido set data=?, codcliente=? where numero=?");
            // Parameters start with 1
            preparedStatement.setDate(1, new java.sql.Date(pedido.getData().getTime()));
            preparedStatement.setInt(2, pedido.getCliente().getId());
            preparedStatement.setInt(3, pedido.getNumero());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Pedido> ConsultarTodos() {
        List<Pedido> pedidos = new ArrayList<Pedido>();
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("select * from pedido p, cliente c where p.codcliente = c.id_cli");
            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setNumero(rs.getInt("numero"));
                pedido.setData(rs.getDate("data"));
                ClienteDao cliDao = new ClienteDao();
                pedido.setCliente(cliDao.ListarPorId(rs.getInt("id_cli")));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }

    public Pedido ConsultarPorId(int numero) {
        Pedido pedido = new Pedido();
        ClienteDao cliDao = new ClienteDao();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from pedido p, cliente c where p.codcliente = c.id_cli and numero=?");
            preparedStatement.setInt(1, numero);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                pedido.setNumero(rs.getInt("numero"));
                pedido.setData(rs.getDate("data"));
                pedido.setCliente(cliDao.ListarPorId(rs.getInt("id_cli")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedido;
    }
}
