package se331.lab.rest.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;


@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .organizer("CAMT").build());
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .organizer("CMU").build());
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .organizer("Chiang Mai").build());
        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .organizer("Chiang Mai Municipality").build());

        organizerRepository.save(Organizer.builder()
                .id(123L)
                .address("Meow Town")
                .organization_name("Kat Laydee")
                .build()
        );
        organizerRepository.save(Organizer.builder()
                .id(456L)
                .address("Flora City")
                .organization_name("Flora City")
                .build()
        );
        organizerRepository.save(Organizer.builder()
                .id(789L)
                .address("Playa Del Carmen")
                .organization_name("Carey Wales")
                .build()
        );
        organizerRepository.save(Organizer.builder()
                .id(1001L)
                .address("Woof Town")
                .organization_name("Dawg Dahd")
                .build()
        );
        organizerRepository.save(Organizer.builder()
                .id(1002L)
                .address("Tin City")
                .organization_name("Kahn Opiner")
                .build()
        );
        organizerRepository.save(Organizer.builder()
                .id(1003L)
                .address("Highway 50")
                .organization_name("Brody Kill")
                .build()
        );
    }



}
