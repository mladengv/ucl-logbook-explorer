package helper;

import java.util.HashMap;

/**
 * Created by mladen on 10/07/16.
 */
public class Statistics {

    private HashMap<String, Integer> listDescriptive;

    /**
     * Default constructor.
     */
    public Statistics() {
        listDescriptive = new HashMap<>();
    }

    public HashMap<String, Integer> getListDescriptive() {
        return listDescriptive;
    }

    /**
     *
     * @param name
     * @param value
     */
    public void addDescriptive(String name, Integer value) {
        listDescriptive.put(name, value);
    }

    /**
     *
     * @param name
     * @return
     */
    public Integer getDescriptive(String name) {
        return listDescriptive.get(name);
    }

    /**
     *
     * @param name
     * @param value
     */
    public void updateDescriptive(String name, Integer value) {
        if (!listDescriptive.containsKey(name)) {
            addDescriptive(name, 0);
        }
        listDescriptive.put(name, listDescriptive.get(name) + value);
    }

    /**
     *
     * @param name
     */
    public void increaseDescriptive(String name) {
        updateDescriptive(name, 1);
    }
}
