package org.in28minutes.springboot.violation_tpa.dto.incident;

import lombok.Getter;
import lombok.Setter;
import org.in28minutes.springboot.violation_tpa.entity.ItemCategory;


@Getter
@Setter
public class IncidentItemDTO {


    private ItemCategory category;


    private Long referenceId;


    private Integer quantity;


    private Boolean armed;

    public IncidentItemDTO() {
    }

}