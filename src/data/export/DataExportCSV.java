package data.export;

import entity.Student;
import entity.Visit;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
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

        PrintWriter writer = null;
        try {
            // Create writer with encoding
            writer = new PrintWriter(file.getAbsoluteFile(), "UTF-8");
            // Print schema
            writer.println(schema.createVisitHeader());
            // Print records
            for (Visit visit : student.getVisits()) {
                writer.println(schema.createVisit(visit));
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            // Close file
            if (writer != null) {
                writer.close();
            }
        }
    }
}
