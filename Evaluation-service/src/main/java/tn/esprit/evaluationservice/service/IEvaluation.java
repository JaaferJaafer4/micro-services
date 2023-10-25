package tn.esprit.evaluationservice.service;

import org.springframework.stereotype.Component;
import tn.esprit.evaluationservice.dto.EvaluationDescription;
import tn.esprit.evaluationservice.entite.evaluation;

import java.util.List;
import java.util.Optional;

@Component
public interface IEvaluation {
    List<evaluation> GetAllEvaluation();

    evaluation AddEvaluation(evaluation e);

    EvaluationDescription getEvaluationById(Long idEvaluation);

    // Delete (Supprimer une évaluation par son ID)
    void deleteEvaluation(Long idEvaluation);

    // Update (Mettre à jour une évaluation)
    evaluation updateEvaluation(Long idEvaluation, evaluation e);
}
