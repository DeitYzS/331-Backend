//package se331.lab.rest.dao;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Profile;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//import se331.lab.rest.entity.Organizer;
//import se331.lab.rest.repository.OrganizerRepository;
//
//
//@Repository
//@RequiredArgsConstructor
//@Profile("db")
//public class OrganizerDaoDbImpl implements OrganizerDao {
//    final OrganizerRepository organizerRepository ;
//
//    @Override
//    public Page<Organizer> getOrganizer(Pageable pageRequest) {
//        return organizerRepository.findAll(pageRequest);
//    }
//
//}
