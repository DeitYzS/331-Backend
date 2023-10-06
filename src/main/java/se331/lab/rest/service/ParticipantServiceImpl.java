package se331.lab.rest.service;

import jakarta.servlet.http.Part;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.OrganizerDao;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;

import java.util.List;

@Service
@NoArgsConstructor
public class ParticipantServiceImpl implements ParticipantService{
    final ParticipantDao participantDao;


    @Override
    public List<Participant> getAllParticipant() {
        return ParticipantDao.getOrganizer(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Participant> getParticipant(Integer page, Integer pageSize) {
        return participantDao.getParticipant(PageRequest.of(page, pageSize));
    }
}
