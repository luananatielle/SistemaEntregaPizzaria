/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.pizzaria.dados;

import br.edu.ifnmg.poo.pizzaria.modelo.Motoboy;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luana
 */
public class MotoboyDAO {
    private static Map<String,Motoboy> motoboys= new HashMap<>();
    
   public static void adicionarMotoboy(Motoboy motoboy){
        motoboys.put(motoboy.getNome(), motoboy);
    }

    public static Motoboy getMotoboy(String nome) {
        Motoboy motoboy = motoboys.get(nome);
        return motoboy;

    }
    
}
