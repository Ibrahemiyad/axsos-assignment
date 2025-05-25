package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;

    // Constructor
    public AdminUser(Integer id, String role) {
        super(id); // Initializes inherited 'id'
        this.employeeID = id;
        this.role = role;
        this.securityIncidents = new ArrayList<String>();
    }

    // Implement HIPAACompliantUser
    @Override
    public boolean assignPin(int pin) {
        // Require a 6-digit PIN
        if (String.valueOf(pin).length() == 6) {
            this.pin = pin;
            return true;
        }
        return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        if (this.id.equals(confirmedAuthID)) {
            return true;
        } else {
            this.authIncident(); // Log failed authorization attempt
            return false;
        }
    }

    // Implement HIPAACompliantAdmin
    @Override
    public ArrayList<String> reportSecurityIncidents() {
        return this.securityIncidents;
    }

    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s\nReported By ID: %s\nNotes: %s\n",
            new Date(), this.id, notes
        );
        this.securityIncidents.add(report);
    }

    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s\nID: %s\nNotes: %s\n",
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        this.securityIncidents.add(report);
    }

    // Getters & Setters
    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public ArrayList<String> getSecurityIncidents() {
        return securityIncidents;
    }

    public void setSecurityIncidents(ArrayList<String> securityIncidents) {
        this.securityIncidents = securityIncidents;
    }
}
