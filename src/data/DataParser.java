package data;

import config.ParserConfig;
import entity.Logbook;
import entity.Student;
import entity.Visit;
import entity.type.Diagnosis;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by mladen on 08/07/16.
 */
public class DataParser {

    // Local copy of the Logbook.
    private Logbook book;

    // Map for the parser.
    ParserMap map;

    // Schema for the parser.
    ParserSchema schema;

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
    public Logbook process(File file)
            throws FileNotFoundException {

        // Instantiate a scanner.
        Scanner scanner = new Scanner(file);

        // Identify fields using a map.
        if (scanner.hasNextLine()) {
            String[] fieldsMap = scanner.nextLine().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
            map.populate(fieldsMap);
        }

        // Set the parser's map for the schema.
        schema.setMap(map);

        // Read all the remaining lines.
        while (scanner.hasNextLine()) {
            String line = "";

            // Fix trailing new lines.
            do {
                line += scanner.nextLine();
            } while(line.split(",").length < map.size());

            // Extract fields.
            String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

            // Trim all strings.
            for (int i = 0; i < fields.length; i++) {
                fields[i] = fields[i].trim();
            }

            /*
            System.out.println(
                    fields[map.get(ParserMap.Field.DATA_DIAGNOSIS)]
            );
            */

            /**
             * Add a record to the Logbook.
             */
            book.addRecord(
                    schema.createStudent(fields),
                    schema.createPatient(fields),
                    schema.createVisit(fields)
            );
        }

        // Finish with scanner.
        scanner.close();

        return book;
    }
}
