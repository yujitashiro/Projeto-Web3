/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.web3.models;

/**
 *
 * @author jose.jorge.dos.neto
 */
public class VagaCarro extends Vaga{
    
    private double valorHoraCarro = 6;

    public double getvalorHoraCarro() {
        return valorHoraCarro;
    }

    public void setValorvalorHoraCarro(double valorHoraCarro) {
        this.valorHoraCarro = valorHoraCarro;
    }
    
    /**
     *
     * @param horas
     * @return
     */
    @Override
    public double getValorHora(double horas){
        return horas * valorHoraCarro;
    }
}
