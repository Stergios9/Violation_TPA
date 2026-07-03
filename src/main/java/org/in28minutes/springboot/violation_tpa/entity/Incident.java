package org.in28minutes.springboot.violation_tpa.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "incident")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate incidentDate;

    @ManyToOne
    @JoinColumn(name = "entry_area_id")
    private EntryArea entryArea;


    public Incident() {
    }

    public Long getId() {
        return id;
    }

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public EntryArea getEntryArea() {
        return entryArea;
    }

    public void setEntryArea(EntryArea entryArea) {
        this.entryArea = entryArea;
    }


}
