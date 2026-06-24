package org.in28minutes.springboot.violation_tpa.dto;

public class IncomingAircraftDTO {

    private Long aircraftTypeId;
    private Integer quantity;

    public Long getAircraftTypeId() {
        return aircraftTypeId;
    }

    public void setAircraftTypeId(Long aircraftTypeId) {
        this.aircraftTypeId = aircraftTypeId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

// getters & setters
}