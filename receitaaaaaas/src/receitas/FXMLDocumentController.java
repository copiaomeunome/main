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
 * @author Fernanda Thomaz
 */
public class FXMLDocumentController implements Initializable {
    
   
    Receita receita;
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
            receita.adicionarIngrediente(new Ingrediente(nome, tipo));
            txt_nome.setText(" ");
            txt_tipo.setText(" ");
        }
    }
    
    @FXML
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

        

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        receita = new Receita();
        originalHome = AnchorPane;
        //Image image = new Image(getClass().getResourceAsStream("/WhatsApp Image 2024-09-06 at 20.37.15.jpeg"));
        //imageView.setImage(image);

    }    

    
    @FXML
    private void home(MouseEvent event){
        borderPane.setCenter(originalHome);
        //loadPage("FXMLDocument");
    } 
    
    @FXML
    private void page1(MouseEvent event){
        loadPage("page1");
    } 
    
    @FXML
    private void page2(MouseEvent event){
        loadPage("page2");
    }
   
   private void loadPage(String page) {
    Parent root = null;
    
    try {
        root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
    } catch (IOException ex) {
        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
    }
        borderPane.setCenter(root);
    }
}