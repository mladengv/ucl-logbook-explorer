package entity.type;

import java.util.ArrayList;

/**
 * Created by mladen on 12/07/16.
 */
public class Trauma {

    private String traumaType;

    private ArrayList<String> trauma;

    public Trauma() {
        trauma = new ArrayList<>();
    }

    public Trauma(String type, String[] trauma) {
        this();

        setTraumaType(type);
        addTrauma(trauma);
    }

    public void setTraumaType(String traumaType) {
        this.traumaType = traumaType;
    }

    public String getTraumaType() {
        return traumaType;
    }

    public void addTrauma(String type) {
        this.trauma.add(type);
    }

    public void addTrauma(String[] types) {
        for (String type : types) {
            addTrauma(type);
        }
    }

    public ArrayList<String> getTrauma() {
        return trauma;
    }
}
