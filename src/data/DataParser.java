package data;

import entity.Logbook;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * Created by mladen on 08/07/16.
 */
public class DataParser {

    // Local copy of the Logbook.
    private Logbook book;

    // Map for the parser.
    private ParserMap map;
    private File file;
    private Scanner scanner;

    // Schema for the parser.
    private ParserSchema schema;

    /**
     * Default constructor.
     */
    public DataParser() {
        // Initialise the book.
        book = new Logbook();
        // Initialise the map.
        map = new ParserMap();
        // Initialise the schema.
        schema = new ParserSchema();
    }

    /**
     * Process a file.
     *
     * This method takes the generated CSV files from Moodle and
     * processes all fields to populate the Logbook instance.
     *
     * @param file The file to be read.
     * @return The created book.
     * @throws FileNotFoundException
     */
    public void open(File file)
            throws FileNotFoundException {

        this.file = file;
        // Instantiate a scanner.
        scanner = new Scanner(file);

        // Identify fields using a map.
        if (scanner.hasNextLine()) {
            String[] fieldsMap = scanner.nextLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            map.populate(fieldsMap);
        }

        // Set the parser's map for the schema.
        schema.setMap(map);
    }

    /**
     *
     * @return
     */
    public int processNext() {
        // Count of lines read
        int count = 0;

        // Read all the remaining lines.
        if (scanner.hasNextLine()) {
            String line = "";

            // Fix trailing new lines.
            do {
                // Increment line counter
                count++;
                // Concatenate
                line += scanner.nextLine();
            } while(line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)").length < map.size());

            // Extract fields.
            String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

            // Trim all strings.
            for (int i = 0; i < fields.length; i++) {
                fields[i] = fields[i].trim();
            }

            /**
             * Add a record to the Logbook.
             */
            book.addRecord(
                    schema.createStudent(fields),
                    schema.createPatient(fields),
                    schema.createVisit(fields)
            );
        } else {
            // Close scanner as no longer needed.
            scanner.close();
        }

        return count;
    }

    public Logbook getBook() {
        // Return the generated book.
        return book;
    }

    public int countLines() {
        int lines = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.readLine() != null) lines++;
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }

}
