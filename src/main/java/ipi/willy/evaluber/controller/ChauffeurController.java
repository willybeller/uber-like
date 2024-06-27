package ipi.willy.evaluber.controller;

import ipi.willy.evaluber.model.Chauffeur;
import ipi.willy.evaluber.service.ChauffeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chauffeurs")
public class ChauffeurController {
    @Autowired
    private ChauffeurService chauffeurService;

    @PostMapping
    public Chauffeur createChauffeur(@RequestBody Chauffeur chauffeur) {
        return chauffeurService.saveChauffeur(chauffeur);
    }

    @GetMapping
    public List<Chauffeur> getAllChauffeurs() {
        return chauffeurService.getAllChauffeurs();
    }

    @GetMapping("/{id}")
    public Chauffeur getChauffeurById(@PathVariable Long id) {
        return chauffeurService.getChauffeurById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteChauffeurById(@PathVariable Long id) {
        chauffeurService.deleteChauffeurById(id);
    }

    @GetMapping("/count/{vehicleType}")
    public long countChauffeursByVehicleType(@PathVariable String vehicleType) {
        return chauffeurService.countChauffeursByVehicleType(vehicleType);
    }
}