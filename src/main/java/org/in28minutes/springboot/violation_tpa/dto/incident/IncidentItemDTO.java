package org.in28minutes.springboot.violation_tpa.dto.incident;

public class IncidentItemDTO {


    private String category;


    private Long referenceId;


    private Integer quantity;


    private Boolean armed;



    public IncidentItemDTO() {
    }



    public String getCategory() {
        return category;
    }


    public void setCategory(String category) {
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