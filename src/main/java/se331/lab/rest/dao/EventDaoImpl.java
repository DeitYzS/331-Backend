package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@Profile("manual")
public class EventDaoImpl implements EventDao {
    List<Event> eventList;
    final EventRepository eventRepository;

    @Override
    public Integer getEventSize() {
        return eventList.size();
    }

    @Override
    public Page<Event> getEvents(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? eventList.size() : pageSize;
        page = page == null ? 1 : page;

        int firstIndex = (page - 1) * pageSize;
        return new PageImpl<Event>(eventList.subList(firstIndex, firstIndex+pageSize), PageRequest.of(page, pageSize), eventList.size());
    }

    @Override
    public Event getEvent(Long id) {
        return eventList.stream().filter(event ->
                        event.getId()
                                .equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Event save(Event event) {
        event.setId(eventList.get(eventList.size()-1).getId()+1);
        eventList.add(event);
        return event;
    }

    @Override
    public Page<Event> getEvents (String title, String description, String organizerName, Pageable pageRequest)
    {
        return eventRepository.findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCaseOrOrganizer_NameIgnoreCaseContaining
                (title, description, organizerName, pageRequest);
    }


}
