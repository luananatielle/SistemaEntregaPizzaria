/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.pizzaria.controle;

import br.edu.ifnmg.poo.pizzaria.dados.MotoboyDAO;
import br.edu.ifnmg.poo.pizzaria.modelo.Motoboy;

/**
 *
 * @author luana
 */
public class MotoboyControlador {
    public void cadastrarMotoboy(Motoboy motoboy){
        MotoboyDAO.adicionarMotoboy(motoboy);
    }

    public Motoboy buscarMotoboy(String motoboy) {
        return MotoboyDAO.getMotoboy(motoboy);
    }
    
}
