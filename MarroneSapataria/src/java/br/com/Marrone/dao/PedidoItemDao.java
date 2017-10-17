/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Marrone.dao;

import br.com.Marrone.conexao.Conexao;
import br.com.Marrone.model.PedidoItem;
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
public class PedidoItemDao {

    private Connection conexao;

    public PedidoItemDao() {
        conexao = Conexao.getConnection();
    }

    public void Inserir(PedidoItem pi) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("insert into pedidoitem(codpedido, coditem, quantidade, valorunitario) values (?, ?, ?, ?)");
            // Parameters start with 1
            preparedStatement.setInt(1, pi.getPedido().getNumero());
            preparedStatement.setInt(2, pi.getItem().getId());
            preparedStatement.setInt(3, pi.getQuantidade());
            preparedStatement.setDouble(4, pi.getValorunitario());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Remover(int nrpedido, int coditem) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("delete from pedidoitem where codpedido=? and coditem=?");
            // Parameters start with 1
            preparedStatement.setInt(1, nrpedido);
            preparedStatement.setInt(2, coditem);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Alterar(PedidoItem pi) {
        try {
            PreparedStatement preparedStatement = conexao
                    .prepareStatement("update pedidoitem set quantidade=?, valorunitario=? where codpedido=? and coditem=?");
            // Parameters start with 1
            preparedStatement.setInt(1, pi.getQuantidade());
            preparedStatement.setDouble(2, pi.getValorunitario());
            preparedStatement.setInt(3, pi.getPedido().getNumero());
            preparedStatement.setInt(4, pi.getItem().getId());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PedidoItem> ConsultarTodos() {
        List<PedidoItem> pis = new ArrayList<PedidoItem>();
        try {
            Statement statement = conexao.createStatement();
            ResultSet rs = statement.executeQuery("select * from pedidoitem p, produto i where p.coditem = i.id_prod");
            while (rs.next()) {
                PedidoDao dalp = new PedidoDao();
                ProdutoDao dali = new ProdutoDao();
                PedidoItem pi = new PedidoItem();
                pi.setPedido(dalp.ConsultarPorId(rs.getInt("codpedido")));
                pi.setItem(dali.ListarPorId(rs.getInt("coditem")));
                pi.setQuantidade(rs.getInt("quantidade"));
                pi.setValorunitario(rs.getDouble("valorunitario"));
                pis.add(pi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pis;
    }

    public List<PedidoItem> ConsultarTodosPorPedido(int numero) {
        List<PedidoItem> pis = new ArrayList<PedidoItem>();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from pedidoitem p, produto i where p.coditem = i.id_prod and p.codpedido=?");
            preparedStatement.setInt(1, numero);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                PedidoDao dalp = new PedidoDao();
                ProdutoDao dali = new ProdutoDao();
                PedidoItem pi = new PedidoItem();
                pi.setPedido(dalp.ConsultarPorId(rs.getInt("codpedido")));
                pi.setItem(dali.ListarPorId(rs.getInt("coditem")));
                pi.setQuantidade(rs.getInt("quantidade"));
                pi.setValorunitario(rs.getDouble("valorunitario"));
                pis.add(pi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pis;
    }

    public PedidoItem ConsultarPorCodigo(int nrpedido, int coditem) {
        PedidoItem pi = new PedidoItem();
        PedidoDao pedDao = new PedidoDao();
        ProdutoDao proDao = new ProdutoDao();
        try {
            PreparedStatement preparedStatement = conexao.
                    prepareStatement("select * from pedidoitem p, produto i where p.coditem = i.id_prod and p.codpedido=? and p.coditem=?");
            preparedStatement.setInt(1, nrpedido);
            preparedStatement.setInt(2, coditem);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                pi.setPedido(pedDao.ConsultarPorId(rs.getInt("codpedido")));
                pi.setItem(proDao.ListarPorId(rs.getInt("coditem")));
                pi.setQuantidade(rs.getInt("quantidade"));
                pi.setValorunitario(rs.getDouble("valorunitario"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pi;
    }
}
