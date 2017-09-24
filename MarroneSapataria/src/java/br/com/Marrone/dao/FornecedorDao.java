/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Marrone.dao;

import br.com.Marrone.conexao.Conexao;
import br.com.Marrone.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme Freitas
 */
public class FornecedorDao {

    private final Connection conexao;

    public FornecedorDao() {
        conexao = Conexao.getConnection();
    }

    public void Adicionar(Fornecedor fornecedor) {
        try {
            String sql = "INSERT INTO fornecedor "
                    + "(cnpj_forn, "
                    + "razaosocial_forn, "
                    + "endereco_forn, "
                    + "telefone_forn, "
                    + "celular_forn, "
                    + "email_forn, "
                    + "contato_forn, "
                    + "tipoprod_forn) "
                    + "VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement prd = conexao.prepareStatement(sql);
            prd.setString(1, fornecedor.getCnpj());
            prd.setString(2, fornecedor.getRazaoSocial());
            prd.setString(3, fornecedor.getEndereco());
            prd.setString(4, fornecedor.getTelefone());
            prd.setString(5, fornecedor.getCelular());
            prd.setString(6, fornecedor.getEmail());
            prd.setString(7, fornecedor.getContato());
            prd.setString(8, fornecedor.getTipoProd());

            prd.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    public void Excluir(int id) {
        try {
            String sql = "DELETE FROM fornecedor WHERE id_forn = ?";
            PreparedStatement prd = conexao.prepareStatement(sql);

            prd.setInt(1, id);
            prd.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    public void Alterar(Fornecedor fornecedor) {
        try {
            String sql = "UPDATE fornecedor SET "
                    + "cnpj_forn = ?, "
                    + "razaosocial_forn = ?, "
                    + "endereco_forn = ?, "
                    + "telefone_forn = ?, "
                    + "celular_forn = ?, "
                    + "email_forn = ?, "
                    + "contato_forn = ?, "
                    + "tipoprod_forn = ? "
                    + " WHERE id_cli = ?";
            PreparedStatement prd = conexao.prepareStatement(sql);
            prd.setString(1, fornecedor.getCnpj());
            prd.setString(2, fornecedor.getRazaoSocial());
            prd.setString(3, fornecedor.getEndereco());
            prd.setString(4, fornecedor.getTelefone());
            prd.setString(5, fornecedor.getCelular());
            prd.setString(6, fornecedor.getEmail());
            prd.setString(7, fornecedor.getContato());
            prd.setString(8, fornecedor.getTipoProd());
            prd.setInt(9, fornecedor.getId());

            prd.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    public List<Fornecedor> Listar(String nome) {
        List<Fornecedor> fornecedor = new ArrayList<Fornecedor>();
        try {
            String sql = "SELECT * "
                    + "FROM fornecedor "
                    + "WHERE 1=1 ";

            if (nome != null) {
                if (!nome.isEmpty()) {
                    sql += " and razaosocial_forn like ? ";
                }
            }

            sql += "ORDER BY razaosocial_forn";

            PreparedStatement prd = conexao.prepareStatement(sql);

            if (nome != null) {
                if (!nome.isEmpty()) {
                    prd.setString(1, "%" + nome + "%");
                }
            }

            ResultSet rs = prd.executeQuery(sql);

            while (rs.next()) {
                Fornecedor forn = new Fornecedor();
                forn.setId(rs.getInt("id_forn"));
                forn.setCnpj(rs.getString("cnpj_forn"));
                forn.setRazaoSocial(rs.getString("razaosocial_forn"));
                forn.setEndereco(rs.getString("endereco_forn"));
                forn.setTelefone(rs.getString("telefone_forn"));
                forn.setCelular(rs.getString("celular_forn"));
                forn.setEmail(rs.getString("email_forn"));
                forn.setContato(rs.getString("contato_forn"));
                forn.setTipoProd(rs.getString("tipoprod_forn"));
                fornecedor.add(forn);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
        return fornecedor;
    }

    public List<Fornecedor> ListarPorId(int id) {
        List<Fornecedor> fornecedor = new ArrayList<Fornecedor>();
        try {
            String sql = "SELECT * FROM fornecedor WHERE id_forn = ?";
            PreparedStatement prd = conexao.prepareStatement(sql);
            prd.setInt(1, id);
            ResultSet rs = prd.executeQuery();

            while (rs.next()) {
                Fornecedor forn = new Fornecedor();
                forn.setId(rs.getInt("id_forn"));
                forn.setCnpj(rs.getString("cnpj_forn"));
                forn.setRazaoSocial(rs.getString("razaosocial_forn"));
                forn.setEndereco(rs.getString("endereco_forn"));
                forn.setTelefone(rs.getString("telefone_forn"));
                forn.setCelular(rs.getString("celular_forn"));
                forn.setEmail(rs.getString("email_forn"));
                forn.setContato(rs.getString("contato_forn"));
                forn.setTipoProd(rs.getString("tipoprod_forn"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
        return fornecedor;
    }
}
