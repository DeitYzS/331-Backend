package se331.lab.rest.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizerDaoImpl implements OrganizerDao{
        List<Organizer> eventList;

        @PostConstruct
        public void init() {
            eventList = new ArrayList<>();
            eventList.add(Organizer.builder()
                    .id(123L)
                    .address("Meow Town")
                    .organization_name("Kat Laydee")
                    .build()
            );

            eventList.add(Organizer.builder()
                    .id(456L)
                    .address("Flora City")
                    .organization_name("Flora City")
                    .build()
            );

            eventList.add(Organizer.builder()
                    .id(789L)
                    .address("Playa Del Carmen")
                    .organization_name("Carey Wales")
                    .build()
            );

            eventList.add(Organizer.builder()
                    .id(1001L)
                    .address("Woof Town")
                    .organization_name("Dawg Dahd")
                    .build()
            );

            eventList.add(Organizer.builder()
                    .id(1002L)
                    .address("Tin City")
                    .organization_name("Kahn Opiner")
                    .build()
            );

            eventList.add(Organizer.builder()
                    .id(1003L)
                    .address("Highway 50")
                    .organization_name("Brody Kill")
                    .build()
            );
        }

        @Override
        public Integer getOrganizerSize() {
            return eventList.size();
        }

        @Override
        public List<Organizer> getOrganizers(Integer pageSize, Integer page) {
            pageSize = pageSize == null ? eventList.size() : pageSize;
            page = page == null ? 1 : page;

            int firstIndex = (page - 1) * pageSize;
            return eventList.subList(firstIndex, firstIndex+pageSize);
        }

        @Override
        public Organizer getOrganizer(Long id) {
            return eventList.stream().filter(event ->
                            event.getId()
                                    .equals(id))
                    .findFirst()
                    .orElse(null);
        }
}
