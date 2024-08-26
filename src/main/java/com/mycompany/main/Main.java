/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

import java.util.ArrayList;

/**
 *
 * @author heito
 */
public class Main {

    public static void main(String[] args) {
        Ingrediente ingrediente1 = new Ingrediente("ovo","animal");
        Ingrediente ingrediente2 = new Ingrediente("leite","animal");
        Ingrediente ingrediente3 = new Ingrediente("massa","industrializado");
        Ingrediente ingrediente4 = new Ingrediente("fermento","seila");
        Ingrediente ingrediente5 = new Ingrediente("amburgui de siri","animal");
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        ingredientes.add(ingrediente1);
        ingredientes.add(ingrediente2);
        ingredientes.add(ingrediente3);
        ingredientes.add(ingrediente4);
        Escritor.abrirArquivo();
        ArrayList<Receita> receitas = Escritor.ler();
        Escritor.fecharArquivo();
        for(Receita receita : receitas){
            System.out.println(receita.verificarIngredientes(ingredientes));
        }
        
        
    }
}
