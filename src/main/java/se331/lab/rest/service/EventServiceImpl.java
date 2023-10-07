package se331.lab.rest.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.dao.EventDao;
import se331.lab.rest.dao.OrganizerDao;
import se331.lab.rest.dao.ParticipantDao;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{
    final EventDao eventDao;
    final OrganizerDao organizerDao;
    final ParticipantDao participantDao;
    @Override
    public Integer getEventSize() {
        return eventDao.getEventSize();
    }

    @Override
    public Page<Event> getEvents (Integer pageSize, Integer page) {
        return eventDao.getEvents(pageSize, page);
    }

    @Override
    public Event getEvent(Long id) {
        return eventDao.getEvent(id);
    }

    @Override
    @Transactional
    public Event save(Event event) {
        Organizer organizer = organizerDao.findById(event.getOrganizer().getId()).orElse(null);
        Participant participant = participantDao.findById(event.getOrganizer().getId()).orElse(null);
        event.setOrganizer(organizer);
        organizer.getOwnEvents().add(event);
        participant.getEventHistory().add(event);

        return eventDao.save(event);
    }

    @Override
    public Page<Event> getEvents(String title, String description, String organizerName, Pageable pageRequest)
    {
        return eventDao.getEvents(title, description, organizerName, pageRequest);
    }



}
