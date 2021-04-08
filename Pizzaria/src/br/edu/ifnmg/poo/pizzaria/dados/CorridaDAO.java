/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.pizzaria.dados;

import br.edu.ifnmg.poo.pizzaria.modelo.Corrida;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luana
 */
public class CorridaDAO {
    private static Map<String,Corrida> corridas= new HashMap<>();
    
    public static void adicionarCorrida(Corrida corrida){
        corridas.put(corrida.toString(), corrida);
    }
    
    public static List<Corrida> buscarTodasCorridas(){
        return new ArrayList<>(corridas.values());
    }
            
}
