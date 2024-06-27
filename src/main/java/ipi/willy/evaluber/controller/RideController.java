package ipi.willy.evaluber.controller;

import ipi.willy.evaluber.model.Chauffeur;
import ipi.willy.evaluber.model.Ride;
import ipi.willy.evaluber.model.User;
import ipi.willy.evaluber.service.ChauffeurService;
import ipi.willy.evaluber.service.RideService;
import ipi.willy.evaluber.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rides")
public class RideController {
    @Autowired
    private RideService rideService;

    @Autowired
    private UserService userService;

    @Autowired
    private ChauffeurService chauffeurService;

    @PostMapping
    public Ride createRide(@RequestBody Ride ride) {
        User client = userService.getUserById(ride.getClient().getId());
        Chauffeur chauffeur = chauffeurService.getChauffeurById(ride.getChauffeur().getId());
        if (client == null || chauffeur == null) {
            throw new IllegalArgumentException("Client or Chauffeur not found");
        }

        ride.setClient(client);
        ride.setChauffeur(chauffeur);

        return rideService.saveRide(ride);
    }

    @GetMapping
    public List<Ride> getAllRides() {
        return rideService.getAllRides();
    }

    @GetMapping("/count/{clientId}")
    public long countRidesByClientId(@PathVariable Long clientId) {
        return rideService.countRidesByClientId(clientId);
    }

    @GetMapping("/distance/{clientId}")
    public double sumDistanceByClientId(@PathVariable Long clientId) {
        return rideService.sumDistanceByClientId(clientId);
    }

    @GetMapping("/statistics/{clientId}")
    public RideService.ClientStatistics getClientStatistics(@PathVariable Long clientId) {
        return rideService.getClientStatistics(clientId);
    }
}