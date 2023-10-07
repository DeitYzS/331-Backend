package se331.lab.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.service.OrganizerService;
import se331.lab.rest.util.LabMapper;


@RestController
@RequiredArgsConstructor
public class OrganizerController {
    final OrganizerService organizerService;

    @GetMapping("/organizers")
    ResponseEntity<?> getOrganizers() {
        System.out.println(LabMapper.INSTANCE.getOrganizerDto(organizerService.getAllOrganizer()));
       return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDto(organizerService.getAllOrganizer()));

    }

    @GetMapping("organizers/{id}")
    public ResponseEntity<?> getEvent(@PathVariable("id") Long id) {
        Organizer output = organizerService.getOrganizerById(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDto(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }
}
