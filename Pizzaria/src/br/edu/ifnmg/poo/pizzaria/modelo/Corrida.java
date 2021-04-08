/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.pizzaria.modelo;

import java.util.Date;

/**
 *
 * @author luana
 */
public class Corrida {
    
    private int qtdPizzas;
    private int qtdRefrigerante;
    private Date dataHora;
    
    private Motoboy motoboy;
    
    public Corrida(int pizza, int refrigerante, Date data, Motoboy motoboy){
        this.qtdPizzas=pizza;
        this.qtdRefrigerante=refrigerante;
        this.dataHora=data;
        this.motoboy=motoboy;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public int getQtdPizzas() {
        return qtdPizzas;
    }

    public int getQtdRefrigerante() {
        return qtdRefrigerante;
    }

    public Motoboy getMotoboy() {
        return motoboy;
    }
    
    
    
}
