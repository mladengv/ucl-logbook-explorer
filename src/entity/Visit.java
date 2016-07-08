package entity;

import entity.type.Diagnosis;
import entity.type.History;
import entity.type.Outcome;
import entity.type.Treatment;

import java.util.Date;

/**
 * Created by mladen on 08/07/16.
 */
public class Visit {

    // Time of appointment.
    private Date appointmentDate;

    // Type of appointment.
    private String appointmentType;

    /**
     * Contents of the Visit.
     */
    private History history;
    private Diagnosis diagnosis;
    private Treatment treatment;
    private Outcome outcome;
}
