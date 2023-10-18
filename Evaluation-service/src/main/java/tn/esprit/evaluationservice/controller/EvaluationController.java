package tn.esprit.evaluationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.evaluationservice.entite.evaluation;
import tn.esprit.evaluationservice.service.EvaluationService;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
    @Autowired
     EvaluationService evaluationControl;

    //http://localhost:8095/evaluation/GetallEvaluation
    @GetMapping("/GetallEvaluation")
    List<evaluation> GetAllEvaluation() {
        return evaluationControl.GetAllEvaluation();
    }

    //http://localhost:8095/evaluation/AddEvaluation
    @PostMapping("/AddEvaluation")
    public ResponseEntity<evaluation> addEvaluation(@RequestBody evaluation e) {
        evaluation AddEvaluation = evaluationControl.AddEvaluation(e);
        return ResponseEntity.status(HttpStatus.CREATED).body(AddEvaluation);
    }

    //http://localhost:8095/evaluation/updateEvaluation/1
    @PutMapping("/updateEvaluation/{idEvaluation}")
    public void updateEvaluation(@RequestBody evaluation e , @PathVariable("idEvaluation") Long idEvaluation) {
        evaluationControl.updateEvaluation(idEvaluation, e);
    }

    //http://localhost:8095/evaluation/removeEvaluation/1
    @DeleteMapping("/removeEvaluation/{idEvaluation}")
    public void deleteEvaluation(@PathVariable("idEvaluation") Long idEvaluation) {
        evaluationControl.deleteEvaluation(idEvaluation);
    }


}
