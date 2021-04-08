/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.pizzaria.controle;

import br.edu.ifnmg.poo.pizzaria.dados.CorridaDAO;
import br.edu.ifnmg.poo.pizzaria.modelo.Corrida;
import java.util.List;

/**
 *
 * @author luana
 */
public class CorridaControlador {
    public void cadastrarCorrida(Corrida corrida){
        CorridaDAO.adicionarCorrida(corrida);
    }

    public List<Corrida> buscarTodasCorridas(){
        return CorridaDAO.buscarTodasCorridas();
    }

}
