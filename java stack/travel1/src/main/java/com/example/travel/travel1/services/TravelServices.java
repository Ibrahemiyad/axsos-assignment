package com.example.travel.travel1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.travel.travel1.models.Travel;
import com.example.travel.travel1.repositories.TravelRepositories;

@Service
public class TravelServices {
    private final TravelRepositories travelRepositories;
    public TravelServices(TravelRepositories travelRepositories) {
        this.travelRepositories = travelRepositories;
    }

    public List<Travel> AllTravels() {
        return travelRepositories.findAll();
    }
    public void saveTravel(Travel travel) {
        travelRepositories.save(travel);
    }
    public void updateTravel(Travel travel) {
        travelRepositories.save(travel);
    }

    public void createTravel(Travel travel, String travelDetails) {
        travelRepositories.save(travel);

    }
    public void deleteTravel(Long id) {
        travelRepositories.deleteById(id);
    }
    public void deleteAllTravels(Long id) {
        travelRepositories.deleteById(id);

    }
    public Travel findTravelById(Long id) {
        return travelRepositories.findById(id).orElse(null);
    }
    

}
