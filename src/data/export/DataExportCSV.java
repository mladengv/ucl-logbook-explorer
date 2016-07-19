package data.export;

import entity.Student;
import entity.Visit;

import java.io.File;
import java.io.PrintWriter;

/**
 * Created by mladen on 19/07/16.
 */
public class DataExportCSV {

    ExporterSchema schema;

    File file;

    /**
     *
     */
    public DataExportCSV() {
        // Create the schema
        schema = new ExporterSchema();
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
            PrintWriter writer = new PrintWriter(file, "UTF-8");

            // Create the header
            writer.println(schema.createVisitHeader());
            // Print records
            for (Visit visit : student.getVisits()) {
                writer.println(schema.createVisit(visit));
            }
            // Close file
            writer.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
