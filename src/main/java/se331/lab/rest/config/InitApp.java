package se331.lab.rest.config;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;

import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

    @Override
     @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1,org2,org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT").build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU").build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai").build());

        List<Participant> participantList = new ArrayList<>();
        Participant p1 = participantRepository.save(Participant.builder()
                .id(1L)
                .name("Macus")
                .telNo("09-1551")
                .build());
        participantList.add(p1);
        Participant p2 = participantRepository.save(Participant.builder()
                .id(2L)
                .name("Shion")
                .telNo("09-021541")
                .build());
        participantList.add(p2);
        Participant p3 = participantRepository.save(Participant.builder()
                .id(3L)
                .name("Maxics")
                .telNo("09-12315164")
                .build());
        participantList.add(p3);



        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .organizer(org1)
//                .participants()
                .build());
        tempEvent.setOrganizer(org1);
        p1.getEventHistory().add(tempEvent);
        org1.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .organizer(org1)
                .participants(participantList)
                .build());

        tempEvent.setOrganizer(org1);
        tempEvent.setParticipants(participantList);
        org1.getOwnEvents().add(tempEvent);


        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .organizer(org2)
                .participants(participantList)
                .build());
        tempEvent.setOrganizer(org2);
        tempEvent.setParticipants(participantList);
        org2.getOwnEvents().add(tempEvent);

        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .organizer(org3)
                .participants(participantList)
                .build());
        tempEvent.setOrganizer(org3);
        tempEvent.setParticipants(participantList);
        org3.getOwnEvents().add(tempEvent);

//        organizerRepository.save(Organizer.builder()
//                .id(123L)
//                .address("Meow Town")
//                .organization_name("Kat Laydee")
//                .build()
//        );
//        organizerRepository.save(Organizer.builder()
//                .id(456L)
//                .address("Flora City")
//                .organization_name("Flora City")
//                .build()
//        );
//        organizerRepository.save(Organizer.builder()
//                .id(789L)
//                .address("Playa Del Carmen")
//                .organization_name("Carey Wales")
//                .build()
//        );
//        organizerRepository.save(Organizer.builder()
//                .id(1001L)
//                .address("Woof Town")
//                .organization_name("Dawg Dahd")
//                .build()
//        );
//        organizerRepository.save(Organizer.builder()
//                .id(1002L)
//                .address("Tin City")
//                .organization_name("Kahn Opiner")
//                .build()
//        );
//        organizerRepository.save(Organizer.builder()
//                .id(1003L)
//                .address("Highway 50")
//                .organization_name("Brody Kill")
//                .build()
//        );

    }
}
