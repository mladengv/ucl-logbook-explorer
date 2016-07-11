package helper;

import java.util.HashMap;

/**
 * Created by mladen on 10/07/16.
 */
public class Statistics<Type> {

    private HashMap<Type, Integer> descriptive;

    /**
     *
     */
    public Statistics() {
        descriptive = new HashMap<>();
    }

    /**
     *
     * @param name
     * @param value
     */
    public void addDescriptive(Type name, Integer value) {
        descriptive.put(name, value);
    }

    /**
     *
     * @param name
     * @return
     */
    public Integer getDescriptive(Type name) {
        return descriptive.get(name);
    }

    /**
     *
     * @param name
     * @param value
     */
    public void updateDescriptive(Type name, Integer value) {
        if (!descriptive.containsKey(name)) {
            addDescriptive(name, 0);
        }
        descriptive.put(name, descriptive.get(name) + value);
    }

    /**
     *
     * @param name
     */
    public void increaseDescriptive(Type name) {
        updateDescriptive(name, 1);
    }
}
