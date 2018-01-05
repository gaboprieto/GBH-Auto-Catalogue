import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminController extends Admin{

    @FXML
    private TextField year;

    @FXML
    private TextField price;

    @FXML
    private TextField model;

    @FXML
    private TextField manufacturer;

    @FXML
    private TextField carToAdd;

    @FXML
    private Button userList;

    @FXML
    private Button deleteCar;

    @FXML
    private ChoiceBox<String> carType;

    @FXML
    private ListView carList;

    private Admin admin;

    //On startup populates all car lists, the dropdown menu and a listener for the delete car button and the dropdown menu.
    @FXML
    void initialize() throws IOException {

        setTruckList(fetchCars(Trucks,1,900000));

        setSuvList(fetchCars(SUV,1,900000));

        setSedanList(fetchCars(Sedan,1,900000));

        setCoupeList(fetchCars(Coupes,1,900000));

        carType.getItems().addAll("Trucks", "SUV", "Sedans", "Coupes");
        carType.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

            //Listener for delete car button and what dropdown option is selected.
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {

                deleteCar.setText("Delete Car");


                String choice = carType.getItems().get((Integer) number2);

                if(choice.equals("Trucks")){

                        fillList(getTruckList());

                }else if(choice.equals("SUV")){


                    fillList(getSuvList());


                }else if(choice.equals("Coupes")){


                    fillList(getCoupeList());


                }else if (choice.equals("Sedans")){


                    fillList(getSedanList());

                }

            }
        });

        carType.getSelectionModel().selectFirst();

    }

    //Reads users.txt and populates the list with the usernames found.
    @FXML
    void getUserList() throws IOException {

        deleteCar.setText("Delete User");

        ArrayList<String> userList = new ArrayList<>();

        File users = new File("Users.txt");

        Scanner scan = new Scanner(users);

        for(int i = 0; i < countLines(users); i++){

            userList.add(scan.nextLine());

        }

        carList.getItems().clear();

        for (int i = 0; i < userList.size(); i++) {

            carList.getItems().add(i,userList.get(i));
        }


    }

    //Method for adding cars to the list.
    @FXML
    void setAddCar() {

    String text = price.getText() + " " + manufacturer.getText() + " " + model.getText()+ " " + year.getText();

    String selectedItem = carType.getSelectionModel().getSelectedItem();

        if(selectedItem.equals("Trucks")){

            getTruckList().add(new Cars(price.getText(), manufacturer.getText(), model.getText(), year.getText()));
           // setTruckList(admin.fetchCars(Trucks,1,900000));


        }else if(selectedItem.equals("SUV")){

            getSuvList().add(new Cars(price.getText(), manufacturer.getText(), model.getText(), year.getText()));
           // setSuvList(admin.fetchCars(SUV,1,900000));

        }else if(selectedItem.equals("Coupes")){

            getCoupeList().add(new Cars(price.getText(), manufacturer.getText(), model.getText(), year.getText()));
           // setSuvList(admin.fetchCars(Coupes,1,900000));

        }else if (selectedItem.equals("Sedans")){

            getSedanList().add(new Cars(price.getText(), manufacturer.getText(), model.getText(), year.getText()));
          //  setSuvList(admin.fetchCars(Sedan,1,900000));
        }

    carList.getItems().add("\n" + text);

    }

    //Simple method to remove selected car from the list.
    @FXML
    void removeCar(){

        carList.getItems().remove(carList.getSelectionModel().getSelectedItem());

    }

    //Method to populates the list given the arraylist provided.
    void fillList(ArrayList<Cars> carsArrayList) {

        clearList();

        for (int i = 0; i < carsArrayList.size(); i++) {

            carList.getItems().add(i,carsArrayList.get(i).toString());
        }

    }

    //Clears the list.
    @FXML
    void clearList(){

        carList.getItems().clear();

    }

    //Counts lines in a file using LineNumberReader.
    private static int countLines(File aFile) throws IOException {
        LineNumberReader reader = null;
        try {
            reader = new LineNumberReader(new FileReader(aFile));
            while ((reader.readLine()) != null);
            return reader.getLineNumber();
        } catch (Exception ex) {
            return -1;
        } finally {
            if(reader != null)
                reader.close();
        }
    }

}
