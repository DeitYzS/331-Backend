package se331.lab.rest.entity;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartcipantDTO {
    Long id;
    String name;
    String telNo;
    List<ParticipantOwnEventDTO> eventHistory;
}
