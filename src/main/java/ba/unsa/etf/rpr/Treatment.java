package ba.unsa.etf.rpr;

/**
 * This class represents a treatment offered to customers
 */
public class Treatment {
    private String name,description;
    private int duration,treatment_id,customer_id;
    private double price;

    /**
     * Constructor that constructs a new Treatment object with the provided information
     * @param treatment_id unique ID of the treatment
     * @param customer_id the id of the customer associated with the treatment
     * @param name the name of the treatment
     * @param description the description of the treatment
     * @param duration the duration of the treatment
     * @param price the price of the treatment
     */
    public Treatment(int treatment_id,int customer_id,String name, String description,int duration,double price){
    this.customer_id=customer_id;
    this.treatment_id=treatment_id;
    this.name=name;
    this.description=description;
    this.duration=duration;
    this.price=price;
}

    /**
     * Empty Constructor which constructs a new empty Treatment object
     */
    public Treatment(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTreatment_id() {
        return treatment_id;
    }

    public void setTreatment_id(int treatment_id) {
        this.treatment_id = treatment_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }
}
