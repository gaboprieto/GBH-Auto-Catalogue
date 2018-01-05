import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class User extends Scan {

    private File carType;
    private ArrayList<Cars> carsArrayList;
    private ArrayList<Cars> truckList;
    private ArrayList<Cars> suvList;
    private ArrayList<Cars> sedanList;
    private ArrayList<Cars> coupeList;

    //Constructor, sets up the lists.
    User() {

        try {
            setTruckList(fetchCars(Trucks,1,900000));

        setSuvList(fetchCars(SUV,1,900000));

        setSedanList(fetchCars(Sedan,1,900000));

        setCoupeList(fetchCars(Coupes,1,900000));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Getter for trucklist.
    public ArrayList<Cars> getTruckList() {
        return truckList;
    }

    //Setter for trucklist.
    public void setTruckList(ArrayList<Cars> truckList) {
        this.truckList = truckList;
    }

    //Getter for suvlist.
    public ArrayList<Cars> getSuvList() {
        return suvList;
    }

    //Setter for suvlist.
    public void setSuvList(ArrayList<Cars> suvList) {
        this.suvList = suvList;
    }

    //Getter for sedanlist.
    public ArrayList<Cars> getSedanList() {
        return sedanList;
    }

    //Setter for sedanlist.
    public void setSedanList(ArrayList<Cars> sedanList) {
        this.sedanList = sedanList;
    }

    //Getter for coupelist.
    public ArrayList<Cars> getCoupeList() {
        return coupeList;
    }

    //Setter for coupelist.
    public void setCoupeList(ArrayList<Cars> coupeList) {
        this.coupeList = coupeList;
    }

    //Purchase car method, calls sort method in parent.
    public void purchaseCar(String model) {

        sort(carsArrayList, model);

    }

    //Getter for cartype.
    public File getCarType() {

        return this.carType;

    }

    //Setter for cartype.
    public void setCarType(File carType) {

        this.carType = carType;

    }

    //Getter for arraylist.
    public ArrayList<Cars> getCarsArrayList() {
        return carsArrayList;
    }

    //Setter for arraylist.
    public void setCarsArrayList(ArrayList<Cars> carsArrayList) {

        this.carsArrayList = carsArrayList;
    }

    //Sort price method, calls sort method from parent.
    public ArrayList<Cars> sortPrice(ArrayList<Cars> list, int min, int max){


        return sort(list, min, max);

    }

    //Request price method, calls setCarsArrayList from parent.
    public void requestPrice(int min, int max) throws IOException {

        setCarsArrayList(fetchCars(getCarType(), min, max));

    }
}
