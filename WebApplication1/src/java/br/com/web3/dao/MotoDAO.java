///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.web3.dao;
//
//import br.com.web3.conexao.Conexao;
//import br.com.web3.models.Moto;
//import interfaces.AbstractFactoryVeiculo;
//import interfaces.FabricaVeiculos;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author jose.jorge.dos.neto
// */
//public class MotoDAO {
//
//    private final Conexao conexao;
//    private final Statement stmt;
//    private boolean sucesso = false;
//    private AbstractFactoryVeiculo fabrica = new FabricaVeiculos();
//
//    public MotoDAO() throws SQLException {
//        conexao = Conexao.getInstancia();
//        stmt = (Statement) conexao.getConn().createStatement();
//    }
//
//    public boolean inserir(Moto moto) {
//        try {
//            //   stmt.execute("INSERT INTO moto (nome, telefone) VALUES ('" + moto.getNome() + "','" + moto.getTelefone() + "')");
//            sucesso = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            conexao.fecharConexao();
//        }
//
//        return sucesso;
//    }
//
//    public boolean alterar(Moto moto) {
//        try {
//            //   stmt.execute("UPDATE moto SET nome = '" + moto.getNome() + "', telefone = '" + moto.getTelefone() + "' WHERE codigo = '" + moto.getCodigo() + "'");
//            sucesso = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            conexao.fecharConexao();
//        }
//
//        return sucesso;
//    }
//
//    public boolean remover(Moto moto) {
//        try {
//            //    stmt.execute("DELETE FROM moto WHERE codigo = '" + moto.getCodigo() + "'");
//            sucesso = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            conexao.fecharConexao();
//        }
//
//        return sucesso;
//    }
//
//    public List<Moto> listar() {
//        List<Moto> motos = new ArrayList<Moto>();
//        try {
//            ResultSet rs = stmt.executeQuery("SELECT * FROM moto ORDER BY nome");
//            while (rs.next()) {
//                Moto moto = fabrica.criarMoto();
////                moto.setCodigo(rs.getInt("codigo"));
////                moto.setNome(rs.getString("nome"));
////                moto.setTelefone(rs.getString("telefone"));
//
//                motos.add(moto);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            conexao.fecharConexao();
//        }
//
//        return motos;
//    }
//}
