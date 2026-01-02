package com.example.car.services;

import com.example.car.entities.Car;
import com.example.car.entities.Client;
import com.example.car.models.CarResponse;
import com.example.car.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Service métier pour la gestion des voitures et l'intégration avec le service client.
 */
@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8888/SERVICE-CLIENT";

    /**
     * Récupère toutes les voitures et enrichit avec les informations client.
     * @return liste de CarResponse
     */
    public List<CarResponse> findAll() {
        List<Car> cars = carRepository.findAll();
        ResponseEntity<Client[]> response = restTemplate.getForEntity(this.URL + "/api/client", Client[].class);
        Client[] clients = response.getBody();
        return cars.stream().map((Car car) -> mapToCarResponse(car, clients)).toList();
    }

    /**
     * Convertit une entité Car en CarResponse enrichi du client associé.
     */
    private CarResponse mapToCarResponse(Car car, Client[] clients) {
        Client foundClient = Arrays.stream(clients)
                .filter(client -> client.getId().equals(car.getClient_id()))
                .findFirst()
                .orElse(null);

        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .client(foundClient)
                .matricue(car.getMatricule())
                .model(car.getModel())
                .build();
    }

    /**
     * Récupère une voiture par son id et enrichit avec le client associé.
     * @param id identifiant de la voiture
     * @return CarResponse
     * @throws Exception si la voiture n'existe pas
     */
    public CarResponse findById(Long id) throws Exception {
        Car car = carRepository.findById(id).orElseThrow(() -> new Exception("Id de voiture invalide"));
        Client client = restTemplate.getForObject(this.URL + "/api/client/" + car.getClient_id(), Client.class);
        return CarResponse.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .client(client)
                .matricue(car.getMatricule())
                .model(car.getModel())
                .build();
    }
}
