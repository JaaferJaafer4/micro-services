package tn.esprit.inscriptionservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.inscriptionservice.Entity.InscriptionRequest;

public interface RepoInscriptionRequest extends JpaRepository<InscriptionRequest,Long> {
}
