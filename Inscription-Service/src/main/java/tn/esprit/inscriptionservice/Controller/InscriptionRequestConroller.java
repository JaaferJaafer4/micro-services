package tn.esprit.inscriptionservice.Controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.inscriptionservice.Entity.InscriptionRequest;
import tn.esprit.inscriptionservice.Service.ServiceInscriptionRequest;

import java.util.List;

public class InscriptionRequestConroller {
    ServiceInscriptionRequest siq;
    @PostMapping("/add")
    public InscriptionRequest addInscriptionRequest (@RequestBody InscriptionRequest ir) {
        return siq.addInscriptionRequest(ir);
    }
    @PutMapping("/update")
    public InscriptionRequest updateInscriptionRequest(@RequestBody InscriptionRequest ir) {
        return siq.addInscriptionRequest(ir);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteInscriptionRequest(@PathVariable("id") long idInscriptionRequest)
    {
        siq.DeleteInscriptionRequest(idInscriptionRequest);
    }

    @GetMapping("/all")
    public List<InscriptionRequest> getAllInscriptionRequest() {
        return siq.getAllInscriptionRequest();
    }

    @GetMapping("get/{id}")
    public InscriptionRequest getInscriptionRequest(@PathVariable("id") Integer idInscription)
    {
        return siq.findInscriptionRequest(idInscription);
    }


}
