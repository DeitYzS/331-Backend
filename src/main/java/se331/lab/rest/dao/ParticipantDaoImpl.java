package se331.lab.rest.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.ParticipantRepository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ParticipantDaoImpl implements ParticipantDao{
    final ParticipantRepository participantRepository;


    @Override
    public Page<Participant> getParticipants(Pageable pageReq) {
        return ParticipantRepository.findAll(pageReq);
    }

    @Override
    public Optional<Participant> findById(Long id) {
        return participantRepository.findById(id);
    }
}
