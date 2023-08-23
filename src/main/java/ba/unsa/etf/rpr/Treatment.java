package ba.unsa.etf.rpr;

public class Treatment {  //javabean klasa Treatment
    private String name,description; //naziv i opis tretmana
    private int duration,treatment_id; //trajanje tretmana
    private double price; //cijena tretmana
public Treatment(int treatment_id,String name, String description,int duration,double price){
    this.treatment_id=treatment_id;
    this.name=name;
    this.description=description;
    this.duration=duration;
    this.price=price;
}
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
}
