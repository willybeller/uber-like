package ipi.willy.evaluber.service;

import ipi.willy.evaluber.model.Ride;
import ipi.willy.evaluber.model.User;
import ipi.willy.evaluber.repository.RideRepository;
import ipi.willy.evaluber.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RideService {
    @Autowired
    private RideRepository rideRepository;

    @Autowired
    private UserRepository userRepository;

    public Ride saveRide(Ride ride) {
        return rideRepository.save(ride);
    }

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    public long countRidesByClientId(Long clientId) {
        return rideRepository.countByClientId(clientId);
    }

    public double sumDistanceByClientId(Long clientId) {
        return rideRepository.sumDistanceByClientId(clientId);
    }

    public ClientStatistics getClientStatistics(Long clientId) {
        User client = userRepository.findById(clientId).orElse(null);
        if (client == null) {
            throw new IllegalArgumentException("Client not found");
        }

        long nbCourse = countRidesByClientId(clientId);
        double distanceTotal = sumDistanceByClientId(clientId);

        return new ClientStatistics(client.getFirstName(), client.getLastName(),nbCourse, distanceTotal);
    }

    public static class ClientStatistics {
        private String firstName;
        private String lastName;
        private long nbCourse;
        private double distanceTotal;

        public ClientStatistics(String firstName, String lastName,long nbCourse, double distanceTotal) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.nbCourse = nbCourse;
            this.distanceTotal = distanceTotal;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public long getNbCourse() {
            return nbCourse;
        }

        public double getDistanceTotal() {
            return distanceTotal;
        }
    }
}
