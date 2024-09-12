/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package dominio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author heito
 */
public class Main {

    public static void main(String[] args) {
        int escolha = 1;
        Scanner leitor = new Scanner(System.in);
        while((escolha>=1) && (escolha <=5)){
            System.out.println("Escolha o que deseja fazer: \n (1)Cadastrar Receitas \n (2)Listar Receitas \n (3)Cadastrar Ingredientes (não implementado) \n (4)Listar Ingredientes (não implementado) \n (5)Fazer uma lista de Ingredientes que tem em casa e ver quais receitas podem ser feitas \n (qualquer número não listado)Sair \n");
                            
            escolha = leitor.nextInt();
            switch(escolha){
                case 1: {
                    LeitorReceitas.abrirArquivo();
                    ArrayList<Receita> receitas = LeitorReceitas.ler();
                    LeitorReceitas.fecharArquivo();
                    EscritorReceitas.abrirArquivo();
                    for(Receita receita : receitas){
                        EscritorReceitas.escrever(receita);
                    }
                    System.out.println("Escreva na ordem:\no nome da receita, o modo de preparo, a quantidade de ingredientes e os ingredientes");
                    leitor.nextLine();
                    Receita receita = new Receita();
                    receita.setNome(leitor.nextLine());
                    receita.setPreparo(leitor.nextLine());
                    
                    int quantI = leitor.nextInt();
                    leitor.nextLine();
                    ArrayList<Ingrediente> ingredientes = new ArrayList<>();
                    for(int i = 0;i<quantI;i++){
                        Ingrediente ingrediente = new Ingrediente();
                        System.out.println("Nome do ingrediente "+i+":");
                        ingrediente.setNome(leitor.nextLine());
                        System.out.println("Tipo do ingrediente "+i+":");
                        ingrediente.setTipo(leitor.nextLine());
                        ingredientes.add(ingrediente);
                    }
                    receita.setIngredientes(ingredientes);
                    EscritorReceitas.escrever(receita);
                    receita.setIngredientes(ingredientes);
                    EscritorReceitas.fecharArquivo();
                    break;
                }
                case 2: {
                    System.out.println("entrou");
                    LeitorReceitas.abrirArquivo();
                    ArrayList<Receita> receitas = LeitorReceitas.ler();
                    LeitorReceitas.fecharArquivo();
                    for(Receita receita: receitas)
                        System.out.println(receita.getNome());
                    break;
                }
                case 5: {
                    System.out.println("Digite a quantidade de ingredientes que tem em casa:");
                    int quantI = leitor.nextInt();
                    leitor.nextLine();
                    ArrayList<Ingrediente> ingredientes = new ArrayList<>();
                    for(int i=0;i<quantI;i++){
                        Ingrediente ingrediente = new Ingrediente();
                        System.out.println("Digite o nome do ingrediente "+i+":");
                        ingrediente.setNome(leitor.nextLine());
                        System.out.println("Digite o tipo do ingrediente "+i+":");
                        ingrediente.setTipo(leitor.nextLine());
                        ingredientes.add(ingrediente);
                    }
                    LeitorReceitas.abrirArquivo();
                    ArrayList<Receita> receitas = LeitorReceitas.ler();
                    LeitorReceitas.fecharArquivo();
                    System.out.println("Receitas que podem ser feitas:");
                    for(Receita receita : receitas)
                        if(receita.verificarIngredientes(ingredientes))
                            System.out.println(receita.getNome());
                    
                    break;
                }
                default: {
                    
                }
            }
        
        }
        
        
        
    }
}
