package data.export;

import com.sun.deploy.util.StringUtils;
import config.ExportConfig;
import data.ParserMap;
import entity.Visit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mladen on 19/07/16.
 */
public class ExporterSchema {

    ExporterMap map;

    /**
     * Default constructor
     */
    public ExporterSchema() {
        map = new ExporterMap();
    }

    public String combine(String[] fields, String delimiter) {
        return StringUtils.join(Arrays.asList(fields), delimiter);
    }

    public String combine(ArrayList<String> fields) {
        return combine(fields.toArray(new String[0]), ",");
    }


    public String createVisitHeader() {
        // List all fields
        ArrayList<String> fields = new ArrayList<>();
        for (ParserMap.Field field : ExportConfig.visitMap) {
            fields.add(ExportConfig.exportMap.get(field));
        }
        return combine(fields);
    }

    /**
     * Create a formatted record from Visit to export.
     *
     * @param visit
     * @return
     */
    public String createVisit(Visit visit) {
        // List all fields
        ArrayList<String> fields = new ArrayList<>();
        for (ParserMap.Field field : ExportConfig.visitMap) {
            fields.add(map.get(visit, field));
        }
        // Combine output
        return combine(fields);
    }
}
