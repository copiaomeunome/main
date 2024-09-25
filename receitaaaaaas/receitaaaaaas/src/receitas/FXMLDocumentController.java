/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package receitas;

import dominio.Ingrediente;
import dominio.LeitorReceitas;
import dominio.Receita;
//import javafx.scene.image.Image; //EU IA USAR ISSO PRA TENTAR FAZER A IMAGEM QUE EU COLOQUEI NA INTERFACE APARECER MAS TA DANDO BUG
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;


/**
 *
 * @author  Heitor, Mariana, Fernanda, Felipe, Emanuelle
 */
public class FXMLDocumentController implements Initializable {
    
   
    ArrayList<Ingrediente> ingredientes;
    AnchorPane originalHome;
   
    @FXML
    private AnchorPane AnchorPane;
    
    @FXML
    private AnchorPane app;
    
    @FXML
    private AnchorPane ap;

    @FXML
    private StackPane StackPane;
    
    @FXML
    private BorderPane borderPane;
    
    @FXML
    private Button btn_adicionar;

    @FXML
    private Button btn_procurar;

    @FXML
    private TextField txt_tipo;

    @FXML
    private TextField txt_nome;
    
    @FXML
    private ImageView imageView;
    
    //@FXML
    //private ListView<?> list_receitas; //essa interrogação é pq é uma lista de receitas, aí nao tem a função que retorna entao n sei
    //nao sei usar o listView tb, foi oq eu pensei q pode retornar uma lista de receitas disponíveis pra fazer
    
    @FXML
    private Label lbl_receitas;
    
    
    @FXML
    private void addIngrediente(ActionEvent event){
        String face = ((Button)event.getSource()).getText();
        String nome = txt_nome.getText();
        String tipo = txt_tipo.getText();
        
        
        if(face.equals("ADICIONAR INGREDIENTE")){
            Ingrediente ing = new Ingrediente(nome, tipo);
            ingredientes.add(ing);
            txt_nome.setText("");
            txt_tipo.setText("");
        }
    }
    
    /*@FXML
    private void procuraReceita(ActionEvent event){
        String face = ((Button)event.getSource()).getText();
        ArrayList<Ingrediente> ingredientesEscolhidos = receita.getIngredientes();
        LeitorReceitas.abrirArquivo();
        if(face.equals("PROCURAR RECEITAS")){
        receita.verificarIngredientes(ingredientesEscolhidos);
            
        LeitorReceitas.abrirArquivo();
                    ArrayList<Receita> receitas = LeitorReceitas.ler();
                    LeitorReceitas.fecharArquivo();
                    for(Receita receita : receitas)
                        if(receita.verificarIngredientes(ingredientesEscolhidos))
                            lbl_receitas.setText(receita.getNome());

        }
        }
    */
    
    @FXML
    private void procuraReceita(ActionEvent event) {
    // Obtenha os ingredientes escolhidos na interface gráfica
    ArrayList<Ingrediente> ingredientesEscolhidos = ingredientes;

    // Leia as receitas do arquivo
    LeitorReceitas.abrirArquivo();
    ArrayList<Receita> receitas = LeitorReceitas.ler();
    LeitorReceitas.fecharArquivo();

    // Lista de receitas encontradas
    String receitasEncontradas = "Receitas que podem ser feitas:\n";

    // Verifique quais receitas podem ser feitas com os ingredientes escolhidos
    for (Receita receita1 : receitas) {
        if (receita1.verificarIngredientes(ingredientesEscolhidos)) {
            receitasEncontradas = receitasEncontradas + receita1.getNome()+"\n";
        }
    }

    // Exiba as receitas encontradas no label
    lbl_receitas.setText(receitasEncontradas);
}

        

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ingredientes = new ArrayList<>();
        originalHome = AnchorPane;
        //Image image = new Image(getClass().getResourceAsStream("/WhatsApp Image 2024-09-06 at 20.37.15.jpeg"));
        //imageView.setImage(image);
        
        LeitorReceitas.abrirArquivo();
        //receitas = LeitorReceitas.ler();
        LeitorReceitas.fecharArquivo();

    }    

    
    @FXML
    private void home(MouseEvent event){
        borderPane.setCenter(originalHome);
        //loadPage("FXMLDocument");
    } 
    
    @FXML
    private void page1(MouseEvent event) {
    loadPage("page1", ingredientes);  // Passa a lista de ingredientes da receita atual
}
    
    @FXML
    private void page2(MouseEvent event){
        loadPage("page2", ingredientes);
    }
    
   /*private void loadPage(String page) {
    Parent root = null;
    
    try {
        root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
    } catch (IOException ex) {
        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
    }
        borderPane.setCenter(root);
    }*/
   
   private void loadPage(String page, ArrayList<Ingrediente> ingredientesEscolhidos) {
    try {
        // Carrega o FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource(page + ".fxml"));
        Parent root = loader.load();

        // Verifica se o arquivo FXML contém um label ou outro elemento para atualizar
        if (page.equals("page1")) {
            // Se for a página 1, atualiza os elementos com os ingredientes
            Label lbl_receitas = (Label) loader.getNamespace().get("lbl_receitas"); // nome do label no arquivo FXML
            /*StringBuilder sb = new StringBuilder();
            for (Ingrediente ingrediente : ingredientesEscolhidos) {
                sb.append(ingrediente.getNome()).append(" (").append(ingrediente.getTipo()).append(")\n");
            }
            lbl_receitas.setText(sb.toString());
            */
            ingredientesEscolhidos = ingredientes;

            // Leia as receitas do arquivo
            LeitorReceitas.abrirArquivo();
            ArrayList<Receita> receitas = LeitorReceitas.ler();
            LeitorReceitas.fecharArquivo();

                // Lista de receitas encontradas
            String receitasEncontradas = "Receitas que podem ser feitas:\n";

                // Verifique quais receitas podem ser feitas com os ingredientes escolhidos
            
            for(Receita receita1 : receitas){
                if(receita1.verificarIngredientes(ingredientesEscolhidos))
                    receitasEncontradas = receitasEncontradas.concat(receita1.getNome()).concat("\n");
            }
            // Exiba as receitas encontradas no label
            lbl_receitas.setText(receitasEncontradas);
        }

        // Exibe a nova página
        borderPane.setCenter(root);

    } catch (IOException ex) {
        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

}