package com.example.travel.travel.repositories;
import java.util.List;
import com.example.travel.travel.models.Travel;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;
@Repository

public interface TravelRepositories extends CrudRepository<Travel, Long> {
    List<Travel> findAll();
}
