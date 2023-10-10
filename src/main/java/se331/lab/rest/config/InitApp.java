package se331.lab.rest.config;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.entity.Event;
import se331.lab.rest.entity.Organizer;
import se331.lab.rest.entity.Participant;
import se331.lab.rest.repository.EventRepository;
import se331.lab.rest.repository.OrganizerRepository;
import se331.lab.rest.repository.ParticipantRepository;
import se331.lab.rest.security.user.Role;
import se331.lab.rest.security.user.User;
import se331.lab.rest.security.user.UserRepository;

import java.time.ZoneId;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;
    final UserRepository userRepository;

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
        Participant p4 = participantRepository.save(Participant.builder()
                .id(4L)
                .name("Luxi")
                .telNo("09-15645646")
                .build());
        participantList.add(p4);
        Participant p5 = participantRepository.save(Participant.builder()
                .id(5L)
                .name("Pos")
                .telNo("09-1165161")
                .build());
        participantList.add(p5);



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
                .participants(participantList)
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
        addUser();
            org1.setUser(user1);
            user1.setOrganizer(org1);
            org2.setUser(user2);
            user2.setOrganizer(org2);
            org3.setUser(user3);
            user3.setOrganizer(org3);
    }
    User user1, user2, user3;
    private void addUser() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        user1 = User.builder()
                .username("admin")
                .password(encoder.encode("admin"))
                .firstname("admin")
                .lastname("admin")
                .email("admin@admin.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user2 = User.builder()
                .username("user")
                .password(encoder.encode("user"))
                .firstname("user")
                .lastname("user")
                .email("enabled@user.com")
                .enabled(true)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();

        user3 = User.builder()
                .username("disableUser")
                .password(encoder.encode("disableUser"))
                .firstname("disableUser")
                .lastname("disableUser")
                .email("disableUser@user.com")
                .enabled(false)
                .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();


        user1.getRoles().add(Role.ROLE_ADMIN);
        user2.getRoles().add(Role.ROLE_DISTRIBUTOR);
        user3.getRoles().add(Role.ROLE_DISTRIBUTOR);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);


    }
}
