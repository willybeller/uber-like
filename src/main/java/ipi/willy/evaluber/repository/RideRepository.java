package ipi.willy.evaluber.repository;

import ipi.willy.evaluber.model.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RideRepository extends JpaRepository<Ride, Long> {
    @Query("SELECT COUNT(r) FROM Ride r WHERE r.client.id = ?1")
    long countByClientId(Long clientId);

    @Query("SELECT SUM(r.distance) FROM Ride r WHERE r.client.id = ?1")
    double sumDistanceByClientId(Long clientId);
}