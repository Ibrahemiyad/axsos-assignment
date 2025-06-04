package com.example.dojoninja.dojonnja.repositories;

import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.dojoninja.dojonnja.models.Ninja;


@Repository
public interface NinjaRepository extends JpaRepository<Ninja, Long> {}
