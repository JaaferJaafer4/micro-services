package tn.esprit.evaluationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.evaluationservice.entite.evaluation;

@Repository
public interface EvaluationRepo extends JpaRepository <evaluation, Long > {

}
