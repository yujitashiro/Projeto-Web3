/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web3.dao;

import br.com.web3.conexao.Conexao;
import br.com.web3.models.Carro;
import interfaces.AbstractFactoryVeiculo;
import interfaces.FabricaVeiculos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose.jorge.dos.neto
 */
public class CarroDAO {

    private final Connection conexao;
    private Statement stmt;
    private boolean sucesso = false;
    private final AbstractFactoryVeiculo fabrica = new FabricaVeiculos();
    private String sql = "";

    public CarroDAO() throws SQLException {
        conexao = Conexao.getInstancia();
        stmt = (Statement) conexao.createStatement();
    }

    public boolean inserir(Carro carro) throws SQLException {
        try {
            sql = "INSERT INTO carro (modelo, placa, cor) VALUES ('"+carro.getModelo()+"','"+carro.getPlaca()+"','"+carro.getCor()+"')";
            stmt.execute(sql);
//            stmt.setString(1, carro.getModelo());
//            stmt.setString(2, carro.getPlaca());
//            stmt.setString(3, carro.getCor());
//
          //  stmt.execute();
            stmt.close();

            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }

        return sucesso;
    }

    public boolean alterar(Carro carro) throws SQLException {
        try {

            sql = "UPDATE carro SET modelo = '?', placa = '?', cor ='?' WHERE codigo = ?";
            stmt = conexao.prepareStatement(sql);
//            stmt.setString(1, carro.getModelo());
//            stmt.setString(2, carro.getPlaca());
//            stmt.setString(3, carro.getCor());
//            stmt.setInt(4, (int) carro.getId());

           // stmt.execute();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }

        return sucesso;
    }

    public boolean remover(Carro carro) throws SQLException {
        try {
            
            sql = "DELETE FROM carro WHERE codigo = ?";
            stmt = conexao.prepareStatement(sql);
//            stmt.setInt(1, carro.getId());
//            stmt.execute();
            sucesso = true;
            stmt.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }

        return sucesso;
    }

    public List<Carro> listar() throws SQLException {
        List<Carro> carros = new ArrayList<Carro>();
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM carro");
            while (rs.next()) {
                Carro carro = fabrica.criarCarro();
                carro.setId(rs.getInt("id_carro"));
                carro.setCor(rs.getString("cor"));
                carro.setModelo(rs.getString("modelo"));
                carro.setPlaca(rs.getString("placa"));
                carros.add(carro);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }

        return carros;
    }
}
