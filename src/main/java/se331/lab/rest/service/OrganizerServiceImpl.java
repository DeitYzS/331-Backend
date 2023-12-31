package se331.lab.rest.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se331.lab.rest.dao.OrganizerDao;
import se331.lab.rest.entity.Organizer;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService{
    final OrganizerDao organizerDao;


    @Override
    public List<Organizer> getAllOrganizer() {
        return organizerDao.getOrganizer(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Organizer> getOrganizer(Integer page, Integer pageSize) {
        return organizerDao.getOrganizer(PageRequest.of(page, pageSize));
    }

    @Override
    public Organizer getOrganizerById(Long id) {
        return organizerDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Organizer save(Organizer organizer) {
        return organizerDao.save(organizer);
    }
}
