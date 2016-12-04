
import br.com.web3.models.Moto;
import interfaces.AbstractFactoryVeiculo;
import interfaces.FabricaVeiculos;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jose.jorge.dos.neto
 */
public class Teste {

    public static void main(String[] args) {

        AbstractFactoryVeiculo fabrica = new FabricaVeiculos();
        Moto moto = fabrica.criarMoto();
        moto.exibirTipo();
    }

}
