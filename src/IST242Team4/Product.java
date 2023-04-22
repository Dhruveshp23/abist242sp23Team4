package IST242Team4;

public class Product {
    int id; String brand; String model; String processor; int ram; String storage; double price; String condition;


    public Product(int id,String brand, String model, String processor, int ram,  String storage,
                   double price, String condition){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.price = price;
        this.condition = condition;

    }
    public int getid() {
        return id;
    }

    /**   Getter Methods for brand
     * @return brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Setter merhod for brand
     */

    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**   Getter Methods for model
     * @return model
     */
    public String getModel() {
        return model;
    }
    /**
     * Setter merhod for model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**   Getter Methods for processor
     * @return processor
     */
    public String getProcessor() {
        return processor;
    }

    /**
     * Setter merhod for processor
     */
    public void setProcessor(String model) {
        this.processor= processor;
    }
    /**   Getter Methods for ram
     * @return ram
     */
    public int getRam() {
        return ram;
    }

    /**
     * Setter merhod for ram
     */
    public void setRam(int ram) {
        this.ram = ram;
    }

    /**   Getter Methods for storage
     * @return storage
     */
    public String getStorage() {
        return model;
    }

    /**
     * Setter merhod for storage
     */
    public void setStorage(String storage) {
        this.storage = storage;
    }

    /**   Getter Methods for price
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter merhod for price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**   Getter Methods for condition
     * @return condition
     */
    public String getCondition() {
        return condition;
    }

    /**
     * Setter merhod for condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }



}

