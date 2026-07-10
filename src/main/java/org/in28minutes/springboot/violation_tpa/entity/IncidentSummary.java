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


    // first form-group -- ΕΙΣΕΡΧΟΜΕΝΑ Α/Φ
    private Integer formations;

    private Integer aircraft;


    private Integer armedFormations;

    private Integer armedAircraft;


    private Integer engagements;

    private Integer west25;

    // *************************************************************** //


    // third form-group(center of the page) -- ΣΥΝΟΛΑ ΠΑΡΑΒΑΣΕΩΝ - ΠΑΡΑΒΙΑΣΕΩΝ<
    private Integer violKekFighter;

    private Integer violKekAfns;

    private Integer violKekHelicopter;

    private Integer violKekMea;

    private Integer violKekOther;

    private Integer violKekTotal;

    // ΠΑΡΑΒΑΣΕΙΣ ΤΜΑ(πορτοκαλί)
    private Integer violTma;

    // *************************************************************** //

    // ΠΑΡΑΒΑΣΕΙΣ ΕΕΧ(πράσινο -- στο κέντρο)
    private Integer violEexFighter;

    private Integer violEexAfns;

    private Integer violEexHelicopter;

    private Integer violEexMea;

    private Integer violEexOther;

    private Integer violEexTotal;

    // *************************************************************** //

    // ΕΩΣ 6 ΝΜ
    private Integer minus6nm;
    // ΠΑΝΩ ΑΠΟ 6 ΝΜ
    private Integer greater6nm;

    // *************************************************************** //

    // ΥΠΕΡΠΤΗΣΕΙΣ ΑΝΩ ΗΠΕΙΡΩΤΙΚΟΥ ΕΔΑΦΟΥΣ-ΝΗΣΩΝ
    private Integer flightsGround;
    // ΥΠΕΡΠΤΗΣΕΙΣ ΑΝΩ Μ/Ν-Β/Ν
    private Integer flightsMnBn;
    // ΣΥΝΟΛΟ ΥΠΕΡΠΤΗΣΕΩΝ
    private Integer flightsTotal;

    // *************************************************************** //

    // ΣΥΝΟΛΟ ΥΠΕΡΠΤΗΣΕΩΝ
    private Integer recognizedTotal;

    // *************************************************************** //

    // ΑΝΑΓΝΩΡΙΣΕΙΣ ΑΠΟ ΕΛΛΗΝΙΚΑ Α/Φ (πάνω δεξιά)
    // ΣΥΝΟΛΟ ΑΝΑΓΝΩΡΙΣΕΩΝ ΑΠΟ ΜΑΧΗΤΙΚΑ
    private Integer totalRecognizedFromFighters;
    // ΣΧΗΜΑΤΙΣΜΟΙ-ΙΧΝΗ Α/Φ ΑΝΑΓΝΩΡΙΣΗΣ
    private Integer identificationAircraftFormations;

    // *************************************************************** //

    // ΜΗ ΑΝΑΓΝΩΡΙΣΜΕΝΑ ΜΑΧΗΤΙΚΑ(κόκκινο)
    private Integer unrecognizedFighter;
    // ΜΗ ΑΝΑΓΝΩΡΙΣΜΕΝΑ ΑΛΛΑ Α/Φ-Ε/Π-ΜΕΑ
    private Integer unrecognizedOther;


    // *************************************************************** //

    // ΑΠΟΚΑΛΥΨΗ ΕΝΤΟΣ ATHINAI FIR
    private Integer athinaiFir;
    // ΠΕΡΙΟΧΗ ΑΠΟΚΑΛΥΨΗΣ
    private String revelationArea;

    public IncidentSummary() {
    }

    public Long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(Long incidentId) {
        this.incidentId = incidentId;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public Integer getFormations() {
        return formations;
    }

    public void setFormations(Integer formations) {
        this.formations = formations;
    }

    public Integer getAircraft() {
        return aircraft;
    }

    public void setAircraft(Integer aircraft) {
        this.aircraft = aircraft;
    }

    public Integer getArmedFormations() {
        return armedFormations;
    }

    public void setArmedFormations(Integer armedFormations) {
        this.armedFormations = armedFormations;
    }

    public Integer getArmedAircraft() {
        return armedAircraft;
    }

    public void setArmedAircraft(Integer armedAircraft) {
        this.armedAircraft = armedAircraft;
    }

    public Integer getEngagements() {
        return engagements;
    }

    public void setEngagements(Integer engagements) {
        this.engagements = engagements;
    }

    public Integer getWest25() {
        return west25;
    }

    public void setWest25(Integer west25) {
        this.west25 = west25;
    }

    public Integer getViolKekFighter() {
        return violKekFighter;
    }

    public void setViolKekFighter(Integer violKekFighter) {
        this.violKekFighter = violKekFighter;
    }

    public Integer getViolKekAfns() {
        return violKekAfns;
    }

    public void setViolKekAfns(Integer violKekAfns) {
        this.violKekAfns = violKekAfns;
    }

    public Integer getViolKekHelicopter() {
        return violKekHelicopter;
    }

    public void setViolKekHelicopter(Integer violKekHelicopter) {
        this.violKekHelicopter = violKekHelicopter;
    }

    public Integer getViolKekMea() {
        return violKekMea;
    }

    public void setViolKekMea(Integer violKekMea) {
        this.violKekMea = violKekMea;
    }

    public Integer getViolKekOther() {
        return violKekOther;
    }

    public void setViolKekOther(Integer violKekOther) {
        this.violKekOther = violKekOther;
    }

    public Integer getViolKekTotal() {
        return violKekTotal;
    }

    public void setViolKekTotal(Integer violKekTotal) {
        this.violKekTotal = violKekTotal;
    }

    public Integer getViolTma() {
        return violTma;
    }

    public void setViolTma(Integer violTma) {
        this.violTma = violTma;
    }

    public Integer getViolEexFighter() {
        return violEexFighter;
    }

    public void setViolEexFighter(Integer violEexFighter) {
        this.violEexFighter = violEexFighter;
    }

    public Integer getViolEexAfns() {
        return violEexAfns;
    }

    public void setViolEexAfns(Integer violEexAfns) {
        this.violEexAfns = violEexAfns;
    }

    public Integer getViolEexHelicopter() {
        return violEexHelicopter;
    }

    public void setViolEexHelicopter(Integer violEexHelicopter) {
        this.violEexHelicopter = violEexHelicopter;
    }

    public Integer getViolEexMea() {
        return violEexMea;
    }

    public void setViolEexMea(Integer violEexMea) {
        this.violEexMea = violEexMea;
    }

    public Integer getViolEexOther() {
        return violEexOther;
    }

    public void setViolEexOther(Integer violEexOther) {
        this.violEexOther = violEexOther;
    }

    public Integer getViolEexTotal() {
        return violEexTotal;
    }

    public void setViolEexTotal(Integer violEexTotal) {
        this.violEexTotal = violEexTotal;
    }

    public Integer getMinus6nm() {
        return minus6nm;
    }

    public void setMinus6nm(Integer minus6nm) {
        this.minus6nm = minus6nm;
    }

    public Integer getGreater6nm() {
        return greater6nm;
    }

    public void setGreater6nm(Integer greater6nm) {
        this.greater6nm = greater6nm;
    }

    public Integer getFlightsGround() {
        return flightsGround;
    }

    public void setFlightsGround(Integer flightsGround) {
        this.flightsGround = flightsGround;
    }

    public Integer getFlightsMnBn() {
        return flightsMnBn;
    }

    public void setFlightsMnBn(Integer flightsMnBn) {
        this.flightsMnBn = flightsMnBn;
    }

    public Integer getFlightsTotal() {
        return flightsTotal;
    }

    public void setFlightsTotal(Integer flightsTotal) {
        this.flightsTotal = flightsTotal;
    }

    public Integer getRecognizedTotal() {
        return recognizedTotal;
    }

    public void setRecognizedTotal(Integer recognizedTotal) {
        this.recognizedTotal = recognizedTotal;
    }

    public Integer getTotalRecognizedFromFighters() {
        return totalRecognizedFromFighters;
    }

    public void setTotalRecognizedFromFighters(Integer totalRecognizedFromFighters) {
        this.totalRecognizedFromFighters = totalRecognizedFromFighters;
    }

    public Integer getIdentificationAircraftFormations() {
        return identificationAircraftFormations;
    }

    public void setIdentificationAircraftFormations(Integer identificationAircraftFormations) {
        this.identificationAircraftFormations = identificationAircraftFormations;
    }

    public Integer getUnrecognizedOther() {
        return unrecognizedOther;
    }

    public void setUnrecognizedOther(Integer unrecognizedOther) {
        this.unrecognizedOther = unrecognizedOther;
    }

    public Integer getAthinaiFir() {
        return athinaiFir;
    }

    public void setAthinaiFir(Integer athinaiFir) {
        this.athinaiFir = athinaiFir;
    }

    public String getRevelationArea() {
        return revelationArea;
    }

    public void setRevelationArea(String revelationArea) {
        this.revelationArea = revelationArea;
    }
}