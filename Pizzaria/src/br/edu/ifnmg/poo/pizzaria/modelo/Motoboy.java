/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.pizzaria.modelo;

/**
 *
 * @author luana
 */
public class Motoboy {
    private String nome;
    private String placaMoto;
    private float remuneracao;
    
    public Motoboy(String nome, String placaMoto){
        this.nome=nome;
        this.placaMoto=placaMoto;
        this.remuneracao=0;
    }

    public Motoboy(){
    
    }
    public String getNome() {
        return nome;
    }

    public String getPlacaMoto() {
        return placaMoto;
    }

    public float getRemuneracao() {
        return remuneracao;
    }
    
    public boolean verificarPlaca(String placaMoto){
           boolean placa;
           placa=placaMoto.matches("\\w{3}-\\d{4}"); 
           if(placa==false){
               return false;
           }
           return true;
    }  
    
    public void atualizarRemuneracao(){
        this.remuneracao+=2.50;
    }
}
