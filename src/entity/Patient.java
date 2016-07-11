package entity;

import config.ParserConfig;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by mladen on 08/07/16.
 */
public class Patient {

    private String identifier;

    private Date dateOfBirth;

    private String gender;

    /**
     * Default constructor
     */
    public Patient() {

    }

    /**
     *
     * @param identifier
     * @param dateOfBirth
     * @param gender
     */
    public Patient(String identifier, String dateOfBirth, String gender) {
        setIdentifier(identifier);
        setDateOfBirth(dateOfBirth);
        setGender(gender);
    }

    /**
     *
     * @param identifier
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     *
     * @return
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     *
     * @param date
     * @param format
     */
    public void setDateOfBirth(String date, DateFormat format) {
        try {
            this.dateOfBirth = format.parse(date);
        } catch (ParseException e) {
            // TODO
        }
    }

    /**
     *
     * @param date
     * @param format
     */
    public void setDateOfBirth(String date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
        setDateOfBirth(date, dateFormat);
    }

    /**
     *
     * @param date
     */
    public void setDateOfBirth(String date) {
        setDateOfBirth(date, ParserConfig.DATE_FORMAT);
    }

    /**
     *
     * @return
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     */
    public String getGender() {
        return gender;
    }
}
