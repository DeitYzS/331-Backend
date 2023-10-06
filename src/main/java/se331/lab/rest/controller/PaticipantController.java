package se331.lab.rest.controller;

import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.service.ParticipantService;

@RestController
@NoArgsConstructor
public class PaticipantController {
    final ParticipantService participantService;

}
