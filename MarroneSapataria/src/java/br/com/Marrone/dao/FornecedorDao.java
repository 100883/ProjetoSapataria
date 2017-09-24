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
import java.sql.SQLException;
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
}
