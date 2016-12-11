package br.com.web3.controllers;


import br.com.web3.dao.VagaDAO;
import br.com.web3.models.Vaga;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "vagaManagedBean")
@ViewScoped
public class VagaManagedBean implements Serializable {

    private List<Vaga> vagas;
    private Vaga vaga;

    public VagaManagedBean() throws SQLException {
        VagaDAO daoVaga = new VagaDAO();
        vagas = daoVaga.listar();
    }

    public List<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(List<Vaga> vagas) {
        this.vagas = vagas;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public void onRowEdit(RowEditEvent event) {
        try {
            VagaDAO daoVaga = new VagaDAO();
            Vaga vg = (Vaga) event.getObject();
            if (daoVaga.UpdateLiberar(vg.getId(), vg.getVeiculo())) {
                vagas.remove(vg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void att() throws SQLException{
        VagaDAO daoVaga = new VagaDAO();
        vagas = daoVaga.listar();
    }
}
