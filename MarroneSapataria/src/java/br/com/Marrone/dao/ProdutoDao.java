/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Marrone.dao;

import br.com.Marrone.conexao.Conexao;
import br.com.Marrone.model.Produto;
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
 * @author Guilherme Freitas
 */
public class ProdutoDao {

    private final Connection conexao;

    public ProdutoDao() {
        conexao = Conexao.getConnection();
    }

    public void Adicionar(Produto produto) {
        try {
            String sql = "INSERT INTO produto "
                    + "(desc_prod, "
                    + "tipo_prod, "
                    + "tamanho_prod, "
                    + "marca_prod, "
                    + "fabricante_prod, "
                    + "vidautil_prod)"
                    + " VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement prd = conexao.prepareStatement(sql);
            prd.setString(1, produto.getDesc());
            prd.setString(2, produto.getTipo());
            prd.setInt(3, produto.getTamanho());
            prd.setString(4, produto.getMarca());
            prd.setString(5, produto.getFabricante());
            prd.setString(6, produto.getVidaUtil());

            prd.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    public void Excluir(int id){
        try {
            String sql = "DELETE FROM produto WHERE id_prod = ?";
            PreparedStatement prd = conexao.prepareStatement(sql);

            prd.setInt(1, id);
            prd.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    public void Alterar(Produto produto) {
        try {
            String sql = "UPDATE produto SET "
                    + " desc_prod = ?, "
                    + "tipo_prod = ?, "
                    + "tamanho_prod = ?, "
                    + "marca_prod = ?, "
                    + "fabricante_prod = ?, "
                    + "vidautil_prod = ?"
                    + " WHERE id_prod = ?";
            PreparedStatement prd = conexao.prepareStatement(sql);
            prd.setString(1, produto.getDesc());
            prd.setString(2, produto.getTipo());
            prd.setInt(3, produto.getTamanho());
            prd.setString(4, produto.getMarca());
            prd.setString(5, produto.getFabricante());
            prd.setString(6, produto.getVidaUtil());
            prd.setInt(7, produto.getId());

            prd.executeUpdate();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
    }

    public List<Produto> Listar(String nome) {
        List<Produto> produto = new ArrayList<Produto>();
        try {
//            String sql = "SELECT * "
//                    + "FROM produto "
//                    + "WHERE 1=1 ";
//
//            if (nome != null) {
//                if (!nome.isEmpty()) {
//                    sql += " and desc_prod like ? ";
//                }
//            }
//
//            sql += "ORDER BY desc_prod";
//
//            PreparedStatement prd = conexao.prepareStatement(sql);
//
//            if (nome != null) {
//                if (!nome.isEmpty()) {
//                    prd.setString(1, "%" + nome + "%");
//                }
//            }
            String sql = "SELECT * "
                    + "FROM produto "
                    + "WHERE 1=1 ";
            Statement prd = conexao.createStatement();
            ResultSet rs = prd.executeQuery(sql);

            while (rs.next()) {
                Produto prod = new Produto();
                prod.setId(rs.getInt("id_prod"));
                prod.setDescProd(rs.getString("desc_prod"));
                prod.setTipoProd(rs.getString("tipo_prod"));
                prod.setTamanho(rs.getInt("tamanho_prod"));
                prod.setMarca(rs.getString("marca_prod"));
                prod.setFabricante(rs.getString("fabricante_prod"));
                prod.setVidaUtil(rs.getString("vidautil_prod"));
                produto.add(prod);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
        return produto;
    }

    public Produto ListarPorId(int id) {
        Produto produto = new Produto();
        try {
            String sql = "SELECT * FROM produto WHERE id_prod = ?";
            PreparedStatement prd = conexao.prepareStatement(sql);
            prd.setInt(1, id);
            ResultSet rs = prd.executeQuery();

            if (rs.next()) {
                produto.setId(rs.getInt("id_prod"));
                produto.setDescProd(rs.getString("desc_prod"));
                produto.setTipoProd(rs.getString("tipo_prod"));
                produto.setTamanho(rs.getInt("tamanho_prod"));
                produto.setMarca(rs.getString("marca_prod"));
                produto.setFabricante(rs.getString("fabricante_prod"));
                produto.setVidaUtil(rs.getString("vidautil_prod"));
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro);
        }
        return produto;
    }
}
