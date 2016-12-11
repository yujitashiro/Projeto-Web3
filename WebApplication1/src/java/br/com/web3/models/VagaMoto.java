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
public class VagaMoto extends Vaga{
    
    private double valorHoraMoto = 3;

    public double getValorHoraMoto() {
        return valorHoraMoto;
    }

    public void setValorHoraMoto(double valorHoraMoto) {
        this.valorHoraMoto = valorHoraMoto;
    }
    
    /**
     *
     * @param horas
     * @return
     */
    @Override
    public double getValorHora(double horas){
        return horas * valorHoraMoto;
    }
}
