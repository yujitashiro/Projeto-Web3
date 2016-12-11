/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import br.com.web3.models.Vaga;
import br.com.web3.models.VagaCarro;
import br.com.web3.models.VagaMoto;



/**
 *
 * @author jose.jorge.dos.neto
 */
public class FactoryVaga implements AbstractFactoryVaga {

    @Override
    public Vaga criarVagaCarro() {
        return new VagaCarro();
    }

    @Override
    public Vaga criarVagaMoto() {
        return new VagaMoto();
    }
    
}
