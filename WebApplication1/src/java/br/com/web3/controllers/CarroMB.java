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
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.primefaces.context.RequestContext;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "carroMB")
@ApplicationScoped
public class CarroMB implements Serializable {

    private Carro carro = new Carro();
    private List<Carro> carroLista = new ArrayList<Carro>();
    
    @Length(min = 7, max=7, message = "A Placa deve contar 7 caracteres!")
    private String placa;
    
    @NotEmpty
    private String modelo;
    
    @NotEmpty
    private String cor;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
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
        try {
          CarroDAO daoCarro = new CarroDAO();
            carro.setPlaca(placa);
            carro.setModelo(modelo);
            carro.setCor(cor);
            daoCarro.inserir(carro);
            carroLista.add(carro);
            carro = new Carro();
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("alert('Carro cadastrado com sucesso!!')");
//            context.update("growl");
            context.execute("$('.center').load('template/carro_datatable.xhtml')");
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
