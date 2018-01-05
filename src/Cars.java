public class Cars {

    private String price;
    private String model;
    private String manufacturer;
    private String year;

    //Constructor.
    Cars(String price,
         String manufacturer,
         String model,
         String year) {

        this.price = price;
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;

    }

    //Getter for price.
    public String getPrice() {
        return price;
    }

    //Setter for price.
    public void setPrice(String price) {
        this.price = price;
    }

    //Getter for model.
    public String getModel() {
        return model;
    }

    //Setter for model.
    public void setModel(String model) {
        this.model = model;
    }

    //Getter for manufacturer.
    public String getManufacturer() {
        return manufacturer;
    }

    //Setter for manufacturer.
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    //Getter for year.
    public String getYear() {
        return year;
    }

    //Setter for year.
    public void setYear(String year) {
        this.year = year;
    }

    //Overridden toString method.
    @Override
    public String toString() {

        return "\n" + price + " " + manufacturer + " " + model + " " + year;
    }
}