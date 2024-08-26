/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author heito
 */
public class Escritor {
    private static Scanner entrada;
    public static void abrirArquivo(){
        try{
            entrada = new Scanner(Paths.get(System.getProperty("user.dir")+"\\src\\main\\java\\com\\mycompany\\main\\"+"receitas.txt"+"\\"));
        }
        catch(IOException e){
            System.err.print(e);
        }
    }
    public static void fecharArquivo(){
        if(entrada != null)
            entrada.close();
    }
    public static ArrayList<Receita> ler(){
        ArrayList<Receita> receitas = new ArrayList<>();
        
        try{
            
            while (entrada.hasNext()){
                Receita receita = new Receita();
                Ingrediente ingrediente = new Ingrediente();
                String prox;
                receita.setNome(entrada.nextLine());
                receita.setPreparo(entrada.nextLine());
                prox = entrada.nextLine();
                while(!prox.equals("r")){
                    
                    ingrediente.setNome(prox);
                    ingrediente.setTipo(entrada.nextLine());
                    receita.adicionarIngrediente(ingrediente);
                    prox = entrada.nextLine();
                }
                receitas.add(receita);
            }
        }
        catch(NoSuchElementException | IllegalStateException e){
            System.err.println(e.getMessage());
            System.exit(1);
        }
        finally{
            return receitas;
        }
    }
}
