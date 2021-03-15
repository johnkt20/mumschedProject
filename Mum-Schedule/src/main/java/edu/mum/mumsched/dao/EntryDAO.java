package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntryDAO extends JpaRepository<Entry,Long> {
    Entry findEntryById(Long id);
    Entry findEntryByEntryName(String name);
    //Entry findEntryByEntryName
    //Entry findEntryByEntryName
}
