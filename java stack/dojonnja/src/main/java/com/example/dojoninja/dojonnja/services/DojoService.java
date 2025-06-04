package com.example.dojoninja.dojonnja.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dojoninja.dojonnja.models.Dojo;
import com.example.dojoninja.dojonnja.repositories.DojoRepository;

@Service
public class DojoService {
    private final DojoRepository dojoRepository;

    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    public Dojo createDojo(Dojo dojo) {
        return dojoRepository.save(dojo);
    }
    public Dojo findDojo(Long id) {
        return dojoRepository.findById(id).orElse(null);
    }

}
