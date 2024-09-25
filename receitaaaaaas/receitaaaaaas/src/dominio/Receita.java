/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;

/**
 *
 * @author Heitor, Mariana, Fernanda, Felipe, Emanuelle
 */
public class Receita {
    private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
    private String nome;
    private String preparo;
    
    public Receita(){}
    public Receita(String nome, String preparo) {
        this.nome = nome;
        this.preparo = preparo;
    }
    
    public void adicionarIngrediente(Ingrediente ingrediente){
        this.ingredientes.add(ingrediente);
    }
    
    public void adicionarMuitosIngredientes(ArrayList<Ingrediente> ingredientes){
        this.ingredientes.addAll(ingredientes);
    }
    
    public boolean verificarIngredientes(ArrayList<Ingrediente> ingredientes){
        boolean validador = false;
        for(Ingrediente ingrediente : this.ingredientes){
            for(Ingrediente in:ingredientes)
                if(in.comparaIngrediente(ingrediente)){
                    validador = true;
                    break;
                }
            if(!validador){
                return validador;
            }
        }
        return validador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreparo() {
        return preparo;
    }

    public void setPreparo(String preparo) {
        this.preparo = preparo;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    
}
