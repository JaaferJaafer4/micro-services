package tn.esprit.evaluationservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.evaluationservice.entite.evaluation;
import tn.esprit.evaluationservice.repository.EvaluationRepo;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EvaluationService implements IEvaluation{
    @Autowired
    EvaluationRepo evaluationRepo;
    // gettAllEvaluation pour afficher tout la liste des evaluation
    @Override
    public List<evaluation> GetAllEvaluation() {
        return evaluationRepo.findAll();
    }

    // AddEvaluation pour ajouter une evaluation
    @Override
    public evaluation AddEvaluation(evaluation e) {
        return evaluationRepo.save(e);
    }
   // getEvaluationBYId pour afficher l'evaluation with her id
    @Override
    public Optional<evaluation> getEvaluationById(Long idEvaluation) {
        return evaluationRepo.findById(idEvaluation);
    }
    // deleteEvaluation supprimer une évaluation par son ID
   @Override
    public void deleteEvaluation(Long idEvaluation) {
        evaluationRepo.deleteById(idEvaluation);
    }
    // Update (Mettre à jour une évaluation)
    @Override
    public evaluation updateEvaluation(Long idEvaluation, evaluation e) {
        if (evaluationRepo.existsById(idEvaluation)) {
            e.setIdEvaluation(idEvaluation);
            return evaluationRepo.save(e);
        } else {
            return null;
        }
    }

}
