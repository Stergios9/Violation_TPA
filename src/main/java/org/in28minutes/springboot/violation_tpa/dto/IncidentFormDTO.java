package org.in28minutes.springboot.violation_tpa.dto;

import java.time.LocalDate;
import java.util.List;

public class IncidentFormDTO {

    private LocalDate incidentDate;

    private Long entryAreaId;

    private Long friendlyAircraftId;

    private List<IncomingAircraftDTO> incomingAircraft;

    public LocalDate getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(LocalDate incidentDate) {
        this.incidentDate = incidentDate;
    }

    public Long getEntryAreaId() {
        return entryAreaId;
    }

    public void setEntryAreaId(Long entryAreaId) {
        this.entryAreaId = entryAreaId;
    }

    public Long getFriendlyAircraftId() {
        return friendlyAircraftId;
    }

    public void setFriendlyAircraftId(Long friendlyAircraftId) {
        this.friendlyAircraftId = friendlyAircraftId;
    }

    public List<IncomingAircraftDTO> getIncomingAircraft() {
        return incomingAircraft;
    }

    public void setIncomingAircraft(List<IncomingAircraftDTO> incomingAircraft) {
        this.incomingAircraft = incomingAircraft;
    }
}
