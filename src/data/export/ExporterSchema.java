package data.export;

import config.ExportConfig;
import data.ParserMap;
import entity.Visit;
import helper.StringHelper;

import java.util.ArrayList;

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

    public String createVisitHeader() {
        // List all fields
        ArrayList<String> fields = new ArrayList<>();
        for (ParserMap.Field field : ExportConfig.visitMap) {
            fields.add(ExportConfig.exportMap.get(field));
        }
        return StringHelper.combine(fields);
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
        return StringHelper.combine(fields);
    }
}
