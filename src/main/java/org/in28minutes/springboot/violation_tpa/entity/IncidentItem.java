package org.in28minutes.springboot.violation_tpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "incident_item")
public class IncidentItem {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incident_id", nullable = false)
    private Incident incident;



    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ItemCategory category;



    @Column(nullable = false)
    private Long referenceId;



    private Integer quantity;



    private Boolean armed;



    public IncidentItem() {
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Incident getIncident() {
        return incident;
    }


    public void setIncident(Incident incident) {
        this.incident = incident;
    }


    public ItemCategory getCategory() {
        return category;
    }


    public void setCategory(ItemCategory category) {
        this.category = category;
    }


    public Long getReferenceId() {
        return referenceId;
    }


    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }


    public Integer getQuantity() {
        return quantity;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public Boolean getArmed() {
        return armed;
    }


    public void setArmed(Boolean armed) {
        this.armed = armed;
    }
}
