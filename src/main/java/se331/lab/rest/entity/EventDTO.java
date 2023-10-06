package se331.lab.rest.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    Long id;
    String category;
    String  title;
    String description;
    String location;
    String date;
    String time;
    Boolean petAllowed;
    EventOrganizerDTO organizer;
}



