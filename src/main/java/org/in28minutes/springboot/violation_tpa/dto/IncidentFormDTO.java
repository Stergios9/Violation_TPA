package org.in28minutes.springboot.violation_tpa.dto;

import java.time.LocalDate;
import java.util.List;

public class IncidentFormDTO {

    private LocalDate incidentDate;

    private Integer sxhmatismoi;
    private Integer aircraft;
    private Integer OplaSxhmatismoi;
    private Integer OplaAircrafts;
    private Integer engagements;
    private Integer westTo25;

    public IncidentFormDTO() {
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public Integer getSxhmatismoi() {
        return sxhmatismoi;
    }

    public void setSxhmatismoi(Integer sxhmatismoi) {
        this.sxhmatismoi = sxhmatismoi;
    }

    public Integer getAircraft() {
        return aircraft;
    }

    public void setAircraft(Integer aircraft) {
        this.aircraft = aircraft;
    }

    public Integer getOplaSxhmatismoi() {
        return OplaSxhmatismoi;
    }

    public void setOplaSxhmatismoi(Integer oplaSxhmatismoi) {
        OplaSxhmatismoi = oplaSxhmatismoi;
    }

    public Integer getOplaAircrafts() {
        return OplaAircrafts;
    }

    public void setOplaAircrafts(Integer oplaAircrafts) {
        OplaAircrafts = oplaAircrafts;
    }

    public Integer getEngagements() {
        return engagements;
    }

    public void setEngagements(Integer engagements) {
        this.engagements = engagements;
    }

    public Integer getWestTo25() {
        return westTo25;
    }

    public void setWestTo25(Integer westTo25) {
        this.westTo25 = westTo25;
    }
}
