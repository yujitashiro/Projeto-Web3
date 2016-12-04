/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import br.com.web3.models.Carro;
import br.com.web3.models.Moto;

/**
 *
 * @author jose.jorge.dos.neto
 */
public class FabricaVeiculos implements AbstractFactoryVeiculo {

    @Override
    public Moto criarMoto() {
        return new Moto();
    }

    @Override
    public Carro criarCarro() {
        return new Carro();
    }
    
}
