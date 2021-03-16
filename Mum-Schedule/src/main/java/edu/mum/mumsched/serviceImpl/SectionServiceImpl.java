package edu.mum.mumsched.serviceImpl;

import edu.mum.mumsched.dao.SectionDAO;
import edu.mum.mumsched.domain.Section;
import edu.mum.mumsched.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionServiceImpl implements SectionService {
    @Autowired
    SectionDAO sectionDao;
    @Override
    public Section findSectionById(Long id) {
        return sectionDao.findSectionById(id);
    }

    @Override
    public Section SaveSection(Section section) {

        return  sectionDao.save(section);
    }

    @Override
    public List<Section> getAllSection() {
        return sectionDao.findAll();
    }

    @Override
    public void deleteSectionById(Long id) {
        sectionDao.deleteById(id);
    }

    @Override
    public Section findSectionByClassRoom(String room) {
        return sectionDao.findSectionByClassRoom(room);
    }
}
