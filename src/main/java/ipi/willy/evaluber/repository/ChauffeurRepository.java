package ipi.willy.evaluber.repository;

import ipi.willy.evaluber.model.Chauffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ChauffeurRepository extends JpaRepository<Chauffeur, Long> {
    @Query("SELECT COUNT(c) FROM Chauffeur c WHERE c.vehicleType = ?1")
    long countByVehicleType(String vehicleType);
}