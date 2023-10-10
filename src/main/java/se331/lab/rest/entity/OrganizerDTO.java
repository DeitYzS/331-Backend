package se331.lab.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizerDTO {
    Long id;
    String name;
    String address;
    List<OrganizerEventDTO> ownEvents = new ArrayList<>();
    List<String> images;

}

