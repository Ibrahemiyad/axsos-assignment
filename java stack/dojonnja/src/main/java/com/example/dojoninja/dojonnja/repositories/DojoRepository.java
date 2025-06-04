package com.example.dojoninja.dojonnja.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dojoninja.dojonnja.models.Dojo; 


@Repository
public interface DojoRepository  extends JpaRepository<Dojo, Long> {
	
}
