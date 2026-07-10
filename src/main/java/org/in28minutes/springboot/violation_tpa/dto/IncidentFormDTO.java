package org.in28minutes.springboot.violation_tpa.dto;

import lombok.Getter;
import lombok.Setter;
import org.in28minutes.springboot.violation_tpa.dto.incident.IncidentItemDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class IncidentFormDTO {


    private LocalDate incidentDate;


    // ==========================
    // Incident Summary
    // ==========================

    private Integer sxhmatismoi;
    private Integer aircraft;
    private Integer oplaSxhmatismoi;
    private Integer oplaAircrafts;
    private Integer engagements;
    private Integer westTo25;
    private String itemsJson;

    // ==========================
    // Dynamic Incident Items
    // ==========================

    private List<IncidentItemDTO> items = new ArrayList<>();


    public IncidentFormDTO() {
    }
}

