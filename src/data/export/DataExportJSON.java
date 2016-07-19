package data.export;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import entity.Student;

import java.io.File;
import java.io.IOException;

/**
 * Created by mladen on 11/07/16.
 */
public class DataExportJSON {

    private ObjectMapper mapper;

    private File file;

    /**
     * Default constructor.
     */
    public DataExportJSON() {

        // Initialise the schema.
        mapper = new ObjectMapper();

        // Configure
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    public void setFile(File file) {
        this.file = file;
    }
    public File getFile() {
        return file;
    }

    /**
     *
     * @param student
     */
    public void convertStudent(Student student) {
        try {
            // Convert and write output to the given file.
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, student);
        } catch(JsonGenerationException e) {
            e.printStackTrace();
        } catch(JsonMappingException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
