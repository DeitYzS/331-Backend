package se331.lab.rest.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.service.OrganizerService;

import java.util.List;

@Controller
public class OrganizerController {
    final OrganizerService organizerService;

    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @GetMapping("organizers")
    public ResponseEntity<?> getEventLists (@RequestParam(value = "_limit",
            required = false) Integer perPage
            , @RequestParam(value = "_page", required = false) Integer page){

        List<Organizer> outputOrganizer = null;
        Integer organizerSize = organizerService.getOrganizerSize();
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(organizerSize));

        try {
            outputOrganizer = organizerService.getOrganizers(perPage, page);
            return new ResponseEntity<>(outputOrganizer, responseHeader, HttpStatus.OK);
        } catch (IndexOutOfBoundsException ex) {
            return new ResponseEntity<>(outputOrganizer, responseHeader, HttpStatus.OK);
        }
    }
}
