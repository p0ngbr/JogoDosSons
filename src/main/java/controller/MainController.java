package controller;

import javafx.fxml.Initializable;
import model.Animal;
import services.AnimalService;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    public void initialize(URL location, ResourceBundle resources) {
        List<Animal> list = AnimalService.listar();
        for(Animal a : list){
            System.out.println(a.getNome());
        }
    }
}
