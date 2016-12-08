/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import br.com.web3.models.Vaga;


/**
 *
 * @author jose.jorge.dos.neto
 */
public interface AbstractFactoryVaga {
    Vaga criarVagaCarro();
    Vaga criarVagaMoto();
}
