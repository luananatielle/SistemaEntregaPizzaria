/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.poo.pizzaria.apresentacao;

import br.edu.ifnmg.poo.pizzaria.controle.CorridaControlador;
import br.edu.ifnmg.poo.pizzaria.controle.MotoboyControlador;
import br.edu.ifnmg.poo.pizzaria.modelo.Corrida;
import br.edu.ifnmg.poo.pizzaria.modelo.Motoboy;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author luana
 */
public class SistemaPizzaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int operacao=0;

        do{
            try{//menu
                System.out.println("\n\n ***Menu***");
                System.out.println("Operação:");
                System.out.println("1- Cadastrar motoboy:");
                System.out.println("2-Cadastrar corrida");
                System.out.println("3-Mostrar lista das entregas");
                System.out.println("4-Mostrar lista das entregas com totais:");
                System.out.println("5-Carregar dados pré cadastrados:");
                System.out.println("0-Sair");

                operacao= Integer.parseInt(scanner.nextLine());

                switch (operacao) {
                    case 1:
                        cadastrarMotoboy(scanner);
                        break;
                    case 2:
                        cadastrarCorrida(scanner);
                        break;
                    case 3:
                        mostrarCorridas();
                        break;
                    case 4:
                        mostrarCorridasComTotais();
                        break;
                    default:
                        break;
                }
            }catch(NumberFormatException e){
                System.out.println("\nValor inválido!Tente novamente\n");
                operacao=-1;

            }catch (NullPointerException e){
                System.out.println("\nNão encontrado! Tente novamente. \n");
                operacao=-1;
            }
        }while(operacao !=0);
    }   

    private static void cadastrarMotoboy(Scanner scanner){
            System.out.println("\n\n******Cadastro de Motoboys******\n");
            Motoboy motoboy=new Motoboy();
            System.out.println("Nome: ");
            String nome=scanner.nextLine();
            
            int controle=0;
            String placa;
            do{
                System.out.println("Placa da moto: ");
                placa=scanner.nextLine();

                if(motoboy.verificarPlaca(placa)==false){
                    controle=1;
                    System.out.println("Placa inválida! Digite novamente:");
                    System.out.println("O formato esperado é: AAA-2222");
                }
                else controle=0;
            }while(controle==1);
            
            motoboy=new Motoboy(nome,placa);
            MotoboyControlador motoboyControlador =new MotoboyControlador();
            motoboyControlador.cadastrarMotoboy(motoboy);
            
            System.out.println("Motoboy cadastrado com sucesso!");
    }
    
    
    private static void cadastrarCorrida(Scanner scanner){
        System.out.println("\n\n******Cadastro de Corridas******\n");
            int controle=0;
            int pizza, refrigerante;
            do{
                System.out.println("Quantidade de pizzas: ");
                pizza=Integer.parseInt(scanner.nextLine());
                if((pizza<1)||(pizza>6)){
                   controle=1;
                   System.out.println("Número de pizzas inválido!");
                }
                else controle=0;
            }while(controle==1);
            do{
                
                System.out.println("Quantidade de refrigerantes: ");
                refrigerante=Integer.parseInt(scanner.nextLine());
                if(refrigerante>5){
                   controle=1;
                   System.out.println("Número de refrigerantes inválido!");
                }else controle=0;
                
            }while(controle==1);
            Date data=new Date();
            Motoboy motoboyVerificado;
            do{
                System.out.println("Digite o nome do motoboy: ");
                String motoboy=scanner.nextLine();
                MotoboyControlador motoboyControlador=new MotoboyControlador();
                motoboyVerificado=motoboyControlador.buscarMotoboy(motoboy);
                if(motoboyVerificado==null){
                    System.out.println("Motoboy não encontrado! Tente novamente: ");
                    controle=1;
                }else controle=0;
            }while(controle==1);
            motoboyVerificado.atualizarRemuneracao();
            Corrida corrida=new Corrida(pizza,refrigerante,data,motoboyVerificado);
            CorridaControlador corridaControlador=new CorridaControlador();
            corridaControlador.cadastrarCorrida(corrida);
            
            System.out.println("Corrida cadastrado com sucesso!");
    }
    
     private static void mostrarCorridas(){
        System.out.println("\nEntregas feitas:\n");
        
        CorridaControlador corridaControlador= new CorridaControlador();
        List<Corrida> corridas=corridaControlador.buscarTodasCorridas();

        OrdenadorCorrida ordenadorCorrida=new OrdenadorCorrida();
        Collections.sort(corridas,ordenadorCorrida);

        for(Corrida corrida:corridas){
            System.out.println(corrida.getDataHora() + "\t " + corrida.getMotoboy().getNome()+ "\t " +
                    corrida.getMotoboy().getPlacaMoto()+ "\t"+ corrida.getQtdPizzas()+"\t" + corrida.getQtdRefrigerante());
        }
    }
    private static class OrdenadorCorrida implements Comparator<Corrida> {

        @Override
        public int compare(Corrida corrida1, Corrida corrida2){
            return corrida2.getDataHora().compareTo(corrida1.getDataHora());
        }

    }
    private static void mostrarCorridasComTotais(){
        mostrarCorridas();
        CorridaControlador corridaControlador= new CorridaControlador();
        List<Corrida> corridas=corridaControlador.buscarTodasCorridas();
        int totalPizzas=0, totalRefrigerantes=0;
        float totalRemuneracaoMotoboys=0;
        for(Corrida corrida:corridas){
            totalPizzas+=corrida.getQtdPizzas();
            totalRefrigerantes+=corrida.getQtdRefrigerante();
            totalRemuneracaoMotoboys=corrida.getMotoboy().getRemuneracao();
        }
        System.out.println("Total de pizzas vendidas:"+ totalPizzas);
        System.out.println("Total de refrigerantes vendidas:"+ totalRefrigerantes);
        System.out.println("Valor total da remuneração paga aos motoboys:"+totalRemuneracaoMotoboys);
        
        
    }
    
    

}