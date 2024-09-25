/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;

/**
 *
 * @author Heitor, Mariana, Fernanda, Felipe, Emanuelle
 */
public class EscritorReceitas {
    private static Formatter escritor;
    public static void abrirArquivo(){
        try{
            escritor = new Formatter("receitas1.txt");
        }
        catch(SecurityException e){
            System.err.print("Permissão negada para abrir o arquivo");
            System.exit(1);
        }
        catch(FileNotFoundException e){
            System.err.print("Erro ao abrir o arquivo");
            System.exit(1);
        }
    }
    
    public static void escrever(Receita receita){
        String ingredientes = "";
        for(Ingrediente ingrediente :receita.getIngredientes()){
            ingredientes+= ingrediente.getNome()+"\n"+ingrediente.getTipo()+"\n";
        }
        try{
            escritor.format("%s\n%s\n%sr\n", receita.getNome(),receita.getPreparo(),ingredientes);
        }catch(FormatterClosedException e){
            System.err.print("Erro ao abrir o arquivo");
            System.exit(1);
        }
        catch(NoSuchElementException e){
            System.err.print("Input inválido");
            System.exit(1);
        }
    }
    public static void fecharArquivo(){
        if(escritor!=null)
            escritor.close();
    }
}
