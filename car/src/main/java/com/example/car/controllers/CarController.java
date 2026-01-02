package com.example.car.controllers;

import com.example.car.models.CarResponse;
import com.example.car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Contrôleur REST pour la gestion des voitures.
 */
@RestController
@RequestMapping("api/car")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * Récupère la liste de toutes les voitures.
     * @return liste des réponses de voitures
     */
    @GetMapping
    public List<CarResponse> findAll() {
        return carService.findAll();
    }

    /**
     * Récupère une voiture par son identifiant.
     * @param id identifiant de la voiture
     * @return réponse de la voiture
     * @throws Exception si l'id est invalide
     */
    @GetMapping("/{id}")
    public CarResponse findById(@PathVariable Long id) throws Exception {
        return carService.findById(id);
    }
}
