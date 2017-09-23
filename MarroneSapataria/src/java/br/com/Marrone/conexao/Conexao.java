/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Marrone.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Guilherme Freitas
 */
public class Conexao {
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                
                String driver = "org.postgresql.Driver";
                String url = "jdbc:postgresql://localhost:5432/marrone";
                String user = "postgres";
                String password = "root";

                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
                //JOptionPane.showMessageDialog(null, "Conexao efetuada com sucesso");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro Conexão");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Erro Inesperado Conexão");
            }
            return connection;
        }

    }
    
}
