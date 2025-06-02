package com.example.travel.travel.services;
import org.springframework.stereotype.Service;
import com.example.travel.travel.repositories.TravelRepositories;
import com.example.travel.travel.models.Travel; // Import the Travel class
import java.util.List;

@Service
public class TravelService {
    private final TravelRepositories travelRepositories;

    public TravelService(TravelRepositories travelRepositories) {
        this.travelRepositories = travelRepositories;
    }

    public List<Travel> AllTravels() {
        return travelRepositories.findAll();
    }

    // public Travel getTravelById(Long id) {
    //     return travelRepositories.findById(id).orElse(null);
    // }

    public void saveTravel(Travel travel) {
        travelRepositories.save(travel);
    }
    public void updateTravel(Travel travel) {
        travelRepositories.save(travel);
    }

    public void createTravel(String travel, Travel travelDetails) {
        travelRepositories.save(travel);

    }
    public void deleteTravel(Long id) {
        travelRepositories.deleteById(id);
    }
    public void deleteAllTravels(Long id) {
        travelRepositories.deleteById(id);
    }
}