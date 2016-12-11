/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web3.dao;

/**
 *
 * @author jose.jorge.dos.neto
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import br.com.web3.conexao.Conexao;
import br.com.web3.models.Vaga;
import interfaces.AbstractFactoryVeiculo;
import interfaces.FabricaVeiculos;
import interfaces.FactoryVaga;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose.jorge.dos.neto
 */
public class VagaDAO {

    private final Connection conexao;
    private Statement stmt;
    private final AbstractFactoryVeiculo fabrica;
    private String sql = "";

    public VagaDAO() throws SQLException {
        this.fabrica = new FabricaVeiculos();
        conexao = Conexao.getInstancia();
        stmt = (Statement) conexao.createStatement();
    }
    
    public List<Vaga> listarTodas() throws SQLException {
        List<Vaga> vagas = new ArrayList<>();
        FactoryVaga fvaga = new FactoryVaga();

        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga");
            while (rs.next()) {
                Vaga vaga;
                if (rs.getString("setor").contains("C")) {
                    vaga = fvaga.criarVagaMoto();
                } else {
                    vaga = fvaga.criarVagaCarro();
                }

                vaga.setId(rs.getInt("id_vaga"));
                vaga.setSetor(rs.getString("setor"));
                vaga.setOcupado(rs.getBoolean("ocupada"));
                vaga.setVeiculo(rs.getInt("id_carro"));

                vagas.add(vaga);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }

        return vagas;
    }

    public List<Vaga> listar() throws SQLException {
        List<Vaga> vagas = new ArrayList<>();
        FactoryVaga fvaga = new FactoryVaga();

        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM vaga WHERE ocupada = 1 and id_carro is not null");
            while (rs.next()) {
                Vaga vaga;
                if (rs.getString("setor").contains("C")) {
                    vaga = fvaga.criarVagaMoto();
                } else {
                    vaga = fvaga.criarVagaCarro();
                }

                vaga.setId(rs.getInt("id_vaga"));
                vaga.setSetor(rs.getString("setor"));
                vaga.setOcupado(rs.getBoolean("ocupada"));
                vaga.setVeiculo(rs.getInt("id_carro"));

                vagas.add(vaga);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }

        return vagas;
    }

    public boolean Update(int idCarro, int idVaga) throws SQLException {
        boolean teste = false;
        try {
            sql = "UPDATE vaga SET ocupada = 1, id_carro = " + idCarro + " WHERE id_vaga = " + idVaga + "";
            stmt.execute(sql);
            stmt.close();

            teste = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return teste;

    }

    public boolean UpdateLiberar(int idVaga, int idCarro) throws SQLException {
        boolean teste = false;
        try {
            sql = "UPDATE vaga SET ocupada = 0, id_carro = null WHERE id_vaga = " + idVaga + "";
            stmt.execute(sql);
            sql = "UPDATE carro SET  id_vaga = null WHERE id_carro = " + idCarro + "";
            stmt.execute(sql);
            stmt.close();

            teste = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conexao.close();
        }
        return teste;

    }

}
