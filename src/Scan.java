import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Scan {

    //Static file names.
    public static final File Trucks = new File("Trucks price.txt");
    public static final File SUV = new File("SUV price.txt");
    public static final File Sedan = new File("Sedan Cars.txt");
    public static final File Coupes = new File("Coupes.txt");

    //Gets car data and creates a arraylist of type Cars to fill the object using a for loop.
    public ArrayList<Cars> fetchCars(File myFile, int min, int max) throws IOException {

        ArrayList<Cars> cars = new ArrayList<Cars>();
        Scanner scan = new Scanner(myFile);
        scan.useDelimiter(":");

        for (int i = 0; i < count(myFile); i++) {

            cars.add(new Cars(scan.next(), scan.next(), scan.next(), scan.next()));


        }

        cars = sort(cars, min, max);

        scan.close();

        return cars;
    }

    //Sorting method for price using a while loop. TODO: Use Colletions library.
    public ArrayList<Cars> sort(ArrayList<Cars> cars, int min, int max) {

        while (true) {

            int temp = cars.size();

            for (int i = 0; i < cars.size(); i++) {

                String price = cars.get(i).getPrice();

                if (Integer.valueOf(price) < min || Integer.valueOf(price) > max) {

                    cars.remove(i);

                }

            }

            if (temp == cars.size()) {

                break;


            }
        }

        return cars;
    }

    //Overloaded sorting method for model name using a while loop. TODO: Use Colletions library.
    public ArrayList<Cars> sort(ArrayList<Cars> cars, String model) {

        while (true) {

            int temp = cars.size();

            for (int i = 0; i < cars.size(); i++) {


                if (cars.get(i).getModel().equals(model)) {

                    cars.remove(i);

                }

            }

            if (temp == cars.size()) {

                break;


            }
        }


        return cars;
    }

    //Counter for delimiter  " : " in file.
    private int count(File myFile) throws FileNotFoundException {

        int count = 0;

        Scanner scan = new Scanner(myFile);

        String line = scan.next();

        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == ':') count++;
        }

        //count divided by 4, since fetchCars method takes 4 data at a time.
        return count / 4;
    }

}
