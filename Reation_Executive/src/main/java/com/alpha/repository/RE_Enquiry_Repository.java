package com.alpha.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alpha.model.Enquiry;
@Repository
public interface RE_Enquiry_Repository extends JpaRepository<Enquiry, Integer>{

}
