package com.example.travel.travel1.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.travel.travel1.models.Travel;

@Repository
public interface TravelRepositories extends CrudRepository<Travel,Long> {
    List<Travel> findAll();
    

}
