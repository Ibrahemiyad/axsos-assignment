package com.example.dojoninja.dojonnja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dojoninja.dojonnja.models.Ninja;
import com.example.dojoninja.dojonnja.repositories.NinjaRepository;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    public Ninja createNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
}
