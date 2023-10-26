package tn.esprit.evaluationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.esprit.evaluationservice.dto.EvaluationDescription;
import tn.esprit.evaluationservice.entite.evaluation;
import tn.esprit.evaluationservice.service.EvaluationService;

import java.util.List;

@RestController
@CrossOrigin(origins ="*")
public class EvaluationController {
    @Autowired
     EvaluationService evaluationControl;

    //http://localhost:8095/evaluation/GetallEvaluation
    @GetMapping
    @CrossOrigin
   // @PreAuthorize("hasRole('admin')")
    List<evaluation> GetAllEvaluation() {
        return evaluationControl.GetAllEvaluation();
    }

    @GetMapping("{id}")
        // @PreAuthorize("hasRole('admin')")
    EvaluationDescription getById(@PathVariable("id") long id) {
        return evaluationControl.getEvaluationById(id);
    }

    //http://localhost:8095/evaluation/AddEvaluation
    @PostMapping("add")
    @CrossOrigin
    public evaluation addEvaluation(@RequestBody evaluation e) {
        return evaluationControl.AddEvaluation(e);
    }

    //http://localhost:8095/evaluation/updateEvaluation/1
    @PutMapping("/update")
    public void updateEvaluation(@RequestBody evaluation e , @PathVariable("idEvaluation") Long idEvaluation) {
        evaluationControl.updateEvaluation(idEvaluation, e);
    }

    //http://localhost:8095/evaluation/removeEvaluation/1
    @DeleteMapping("{idEvaluation}")
    public void deleteEvaluation(@PathVariable("idEvaluation") Long idEvaluation) {
        evaluationControl.deleteEvaluation(idEvaluation);
    }


}
