package org.in28minutes.springboot.violation_tpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "incident_summary")
public class IncidentSummary {

    @Id
    private Long incidentId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "incident_id")
    private Incident incident;


    private Integer formations;

    private Integer aircraft;


    private Integer armedFormations;

    private Integer armedAircraft;


    private Integer engagements;

    private Integer west25;


    private Integer violKekFighter;

    private Integer violKekAfns;

    private Integer violKekHelicopter;

    private Integer violKekMea;

    private Integer violKekOther;

    private Integer violKekTotal;


    private Integer violTma;


    private Integer violEexFighter;

    private Integer violEexAfns;

    private Integer violEexHelicopter;

    private Integer violEexMea;

    private Integer violEexOther;

    private Integer violEexTotal;


    private Integer minus6nm;

    private Integer greater6nm;


    private Integer flightsGround;

    private Integer flightsMnBn;

    private Integer flightsTotal;


    private Integer recognizedTotal;

    private Integer recognizedFormations;


    private Integer unrecognizedFighters;

    private Integer unrecognizedOther;


    private Boolean athinaiFir;


    private String revelationArea;



    public IncidentSummary() {
    }



    public Incident getIncident() {
        return incident;
    }


    public void setIncident(Incident incident) {
        this.incident = incident;
    }


    public Long getIncidentId() {
        return incidentId;
    }


    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
    }

}