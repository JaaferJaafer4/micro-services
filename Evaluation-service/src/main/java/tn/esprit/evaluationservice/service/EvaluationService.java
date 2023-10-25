package tn.esprit.evaluationservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import tn.esprit.evaluationservice.dto.Course;
import tn.esprit.evaluationservice.dto.EvaluationDescription;
import tn.esprit.evaluationservice.entite.evaluation;
import tn.esprit.evaluationservice.repository.EvaluationRepo;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EvaluationService implements IEvaluation{
    @Autowired
    EvaluationRepo evaluationRepo;
    @Autowired
    private WebClient.Builder webClientBuilder;

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
    public EvaluationDescription getEvaluationById(Long idEvaluation) {

        evaluation evaluation = evaluationRepo.findById(idEvaluation).orElse(null);
        System.out.println(evaluation);
        Course course = getCourseById(evaluation.getCourseId());

        return getDescription(evaluation,course);
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

    private Course getCourseById(long courseId)
    {
        System.out.println("===>" + courseId);
        return webClientBuilder.build().get()
                .uri("http://course-service/course/"+courseId)
                .retrieve()
                .bodyToMono(Course.class)
                .block();
    }

    private EvaluationDescription getDescription(evaluation e, Course c)
    {
        EvaluationDescription evaluationDescription = new EvaluationDescription();
        evaluationDescription.setTitle(c.getDescription());
        evaluationDescription.setDescription(c.getDescription());
        evaluationDescription.setDuration(c.getDuration());
        evaluationDescription.setResultat(e.getResultat());
        evaluationDescription.setCriteres(e.getCriteres());
        evaluationDescription.setResultat(e.getResultat());
        return evaluationDescription;
    }

}
