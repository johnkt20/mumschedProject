package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;



public interface SectionDAO extends JpaRepository<Section ,Long> {

    Section findSectionById(Long id);
    Section findSectionByClassRoom(String room);
    void deleteSectionById(Long id);
}
