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

/**
 *
 * @author Gui Freitas
 */
public class ClienteDao {
    
    private final Connection conexao;
    
    public ClienteDao(){
        conexao = Conexao.getConnection();
    }
    
    public void adicionar(Cliente cliente){
        try {
            String sql = "INSERT INTO marrone "
                    + "(nome_cli, "
                    + "cpf_cli, "
                    + "endereco_cli, "
                    + "email_cli, "
                    + "celular_cli, "
                    + "sexo_cli, "
                    + "status_cli)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement prd = conexao.prepareStatement(sql);
            
             
        } catch (Exception e) {
        }
    }
    
}
