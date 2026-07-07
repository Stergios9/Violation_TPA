package org.in28minutes.springboot.violation_tpa.dto.incident;

import java.time.LocalDate;
import java.util.List;


public class IncidentDTO {


    private LocalDate incidentDate;


    private Long countryId;



    // IncidentSummary fields

    private Integer formations;

    private Integer aircraft;


    private Integer armedFormations;

    private Integer armedAircraft;


    private Integer engagements;


    private Integer violKekFighter;

    private Integer violKekAfns;

    private Integer violKekHelicopter;

    private Integer violKekMea;

    private Integer violKekOther;


    private Integer violKekTotal;



    private String revelationArea;



    private List<IncidentItemDTO> items;



    public IncidentDTO(){
    }



    public LocalDate getIncidentDate() {
        return incidentDate;
    }


    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }


    public Long getCountryId() {
        return countryId;
    }


    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }


    public List<IncidentItemDTO> getItems() {
        return items;
    }


    public void setItems(List<IncidentItemDTO> items) {
        this.items = items;
    }

}