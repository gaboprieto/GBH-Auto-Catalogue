import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class MainViewController extends Customer{

    @FXML
    private Button searchButton;

    @FXML
    private TextField minPrice;

    @FXML
    private TextField maxPrice;

    @FXML
    private ListView<String> carList;

    @FXML
    private ChoiceBox<String> carDropdown;

    @FXML
    private Customer user;

    //Populates the drop down button on startup and sets first option as default.
    @FXML
    void initialize() throws IOException {

        carDropdown.getItems().addAll("Trucks", "SUV", "Sedans", "Coupes");
        carDropdown.getSelectionModel().selectFirst();


    }

    //Checks what type of car is selected from the dropdown menu.
    @FXML
    ArrayList<Cars> carTypeSelect(){

        if(carDropdown.getSelectionModel().getSelectedIndex() == 0){

            return getTruckList();

        }else if (carDropdown.getSelectionModel().getSelectedIndex() == 1){

            return getSuvList();
        }else if (carDropdown.getSelectionModel().getSelectedIndex() == 2){

            return getSedanList();
        }else

        return getCoupeList();

    }

    //When search button is pressed clears the list, and populates it with most appropriate cars.
    @FXML
    void search(Event event) throws IOException {

        clearList();

        ArrayList<Cars> arrayList = carTypeSelect();

        String minimum = minPrice.getText();
        String maximum = maxPrice.getText();

        arrayList = sortPrice(arrayList, Integer.valueOf(minimum), Integer.valueOf(maximum));

        for (int i = 0; i < arrayList.size(); i++) {

            carList.getItems().add(i, arrayList.get(i).toString());
        }

    }

    //When user right clicks the selected car it removes it from the list.
    @FXML
    void rightClickCar() {

        //purchaseCar(carList.getSelectionModel().getSelectedItem().toString());
        carList.getItems().remove(carList.getSelectionModel().getSelectedItem());
    }

    //Clears the list.
    @FXML
    void clearList(){

        carList.getItems().clear();

    }


}