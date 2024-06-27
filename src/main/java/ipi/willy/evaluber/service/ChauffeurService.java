package ipi.willy.evaluber.service;

import ipi.willy.evaluber.model.Chauffeur;
import ipi.willy.evaluber.repository.ChauffeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChauffeurService {
    @Autowired
    private ChauffeurRepository chauffeurRepository;

    public Chauffeur saveChauffeur(Chauffeur chauffeur) {
        return chauffeurRepository.save(chauffeur);
    }

    public List<Chauffeur> getAllChauffeurs() {
        return chauffeurRepository.findAll();
    }

    public Chauffeur getChauffeurById(Long id) {
        return chauffeurRepository.findById(id).orElse(null);
    }

    public void deleteChauffeurById(Long id) {
        chauffeurRepository.deleteById(id);
    }

    public long countChauffeursByVehicleType(String vehicleType) {
        return chauffeurRepository.countByVehicleType(vehicleType);
    }
}