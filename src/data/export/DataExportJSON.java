package data.export;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import entity.Student;

import java.io.IOException;

/**
 * Created by mladen on 11/07/16.
 */
public class DataExportJSON {

    ObjectMapper mapper;

    /**
     * Default constructor.
     */
    public DataExportJSON() {

        // Initialise the mapper.
        mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    /**
     *
     * @param student
     */
    public void convertStudent(Student student) {
        try {


            String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(student);
            System.out.println(json);

        } catch(JsonGenerationException e) {
            e.printStackTrace();
        } catch(JsonMappingException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
