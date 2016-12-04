package br.com.web3.controllers;

import br.com.web3.dao.CarroDAO;
import br.com.web3.models.Carro;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "carroMB")
@ApplicationScoped
public class CarroMB implements Serializable {

    private Carro carro = new Carro();
    private List<Carro> carroLista = new ArrayList<Carro>();

    /**
     * Creates a new instance of PessoaMB
     */
    public CarroMB() throws SQLException {
        CarroDAO daoCarro = new CarroDAO();
        carroLista = daoCarro.listar();
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Carro> getCarroLista() {
        return carroLista;
    }

    public void setCarroLista(List<Carro> carroLista) {
        this.carroLista = carroLista;
    }

    public void salvarCarro() throws SQLException {
        CarroDAO daoCarro = new CarroDAO();
        daoCarro.inserir(carro);
        carroLista.add(carro);
        carro = new Carro();
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso",  "Carro cadastrado com sucesso!!") );
    }

    public void onRowEdit(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Car Edited", ((Carro) event.getObject()).getModelo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Carro) event.getObject()).getModelo());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        carroLista.remove((Carro) event.getObject());
    }

    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();

        if (newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
}
