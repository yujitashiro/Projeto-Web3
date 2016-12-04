/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web3.conexao;

/**
 *
 * @author jose.jorge.dos.neto
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static String driver = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/web3";
    private static String USER = "root";
    private static String SENHA = "root";
    private static Connection conn;
  
    public static Connection getInstancia() {
        if (conn == null) {
            return getConexao();
        }
        return conn;
    }

    private static Connection getConexao() {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(URL, USER, SENHA);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private Conexao() {
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(URL, USER, SENHA);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void fecharConexao() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
