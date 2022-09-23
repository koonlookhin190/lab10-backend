package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import se331.rest.service.OrganizerService;
import se331.rest.service.ParticipantService;
import se331.rest.util.LabMapper;
@Controller
public class ParticipantController {
    @Autowired
    ParticipantService participantService;
    @GetMapping("/participants")
    ResponseEntity<?> getParticipants(){
        return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantDTO(participantService.getAllParticipant()));
    }
}
