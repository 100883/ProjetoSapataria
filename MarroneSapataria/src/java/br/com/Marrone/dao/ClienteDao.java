/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Marrone.dao;

import br.com.Marrone.conexao.Conexao;
import br.com.Marrone.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Gui Freitas
 */
public class ClienteDao {

    private final Connection conexao;

    public ClienteDao() {
        conexao = Conexao.getConnection();
    }

    public void Adicionar(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente "
                    + "(nome_cli, "
                    + "cpf_cli, "
                    + "endereco_cli, "
                    + "email_cli, "
                    + "celular_cli, "
                    + "sexo_cli, "
                    + "status_cli)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement prd = conexao.prepareStatement(sql);
            prd.setString(1, cliente.getNome());
            prd.setString(2, cliente.getCpf());
            prd.setString(3, cliente.getEndereco());
            prd.setString(4, cliente.getEmail());
            prd.setString(5, cliente.getCelular());
            prd.setString(6, cliente.getSexo());
            prd.setBoolean(7, cliente.isStatus());

            prd.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    public void Excluir(int id) {
        try {
            String sql = "DELETE FROM cliente WHERE id_cli = ?";
            PreparedStatement prd = conexao.prepareStatement(sql);

            prd.setInt(1, id);
            prd.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    public void Alterar(Cliente cliente) {
        try {
            String sql = "UPDATE cliente SET "
                    + "nome_cli = ?, "
                    + "cpf_cli = ?, "
                    + "endereco_cli = ?, "
                    + "email_cli = ?, "
                    + "celular_cli = ?, "
                    + "sexo_cli = ?, "
                    + "status_cli = ? "
                    + " WHERE id_cli = ?";
            PreparedStatement prd = conexao.prepareStatement(sql);
            prd.setString(1, cliente.getNome());
            prd.setString(2, cliente.getCpf());
            prd.setString(3, cliente.getEndereco());
            prd.setString(4, cliente.getEmail());
            prd.setString(5, cliente.getCelular());
            prd.setString(6, cliente.getSexo());
            prd.setBoolean(7, cliente.isStatus());
            prd.setInt(8, cliente.getId());

            prd.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    public List<Cliente> Listar(String nome) {
        List<Cliente> cliente = new ArrayList<Cliente>();
        try {
//            String sql = "SELECT * "
//                    + "FROM cliente "
//                    + "WHERE 1=1 ";
//
//            if (nome != null) {
//                if (!nome.isEmpty()) {
//                    sql += " and nome_cli like ? ";
//                }
//            }
//
//            sql += "ORDER BY nome_cli";
//
//            PreparedStatement prd = conexao.prepareStatement(sql);
//
//            if (nome != null) {
//                if (!nome.isEmpty()) {
//                    prd.setString(1, "%" + nome + "%");
//                }
//            }
            String sql = "SELECT * "
                    + "FROM cliente "
                    + "WHERE 1=1 ";
            Statement prd = conexao.createStatement();
            ResultSet rs = prd.executeQuery(sql);

            while (rs.next()) {
                Cliente cli = new Cliente();
                cli.setId(rs.getInt("id_cli"));
                cli.setNome(rs.getString("nome_cli"));
                cli.setCpf(rs.getString("cpf_cli"));
                cli.setEndereco(rs.getString("endereco_cli"));
                cli.setEmail(rs.getString("email_cli"));
                cli.setCelular(rs.getString("celular_cli"));
                cli.setSexo(rs.getString("sexo_cli"));
                cli.setStatus(rs.getBoolean("status_cli"));
                cliente.add(cli);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
        return cliente;
    }

    public Cliente ListarPorId(int id) {
        Cliente cliente = new Cliente();
        try {
            String sql = "SELECT * FROM cliente WHERE id_cli = ?";
            PreparedStatement prd = conexao.prepareStatement(sql);
            prd.setInt(1, id);
            ResultSet rs = prd.executeQuery();

            if (rs.next()) {
                cliente.setId(rs.getInt("id_cli"));
                cliente.setNome(rs.getString("nome_cli"));
                cliente.setCpf(rs.getString("cpf_cli"));
                cliente.setEndereco(rs.getString("endereco_cli"));
                cliente.setEmail(rs.getString("email_cli"));
                cliente.setCelular(rs.getString("celular_cli"));
                cliente.setSexo(rs.getString("sexo_cli"));
                cliente.setStatus(rs.getBoolean("status_cli"));
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
        return cliente;
    }
}
