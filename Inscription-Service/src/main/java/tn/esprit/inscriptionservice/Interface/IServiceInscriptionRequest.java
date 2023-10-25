package tn.esprit.inscriptionservice.Interface;

import tn.esprit.inscriptionservice.Entity.InscriptionRequest;
import tn.esprit.inscriptionservice.Service.ServiceInscriptionRequest;

import java.util.List;

public interface IServiceInscriptionRequest {


    InscriptionRequest addInscriptionRequest(InscriptionRequest iq);

    void DeleteInscriptionRequest(Long idiq);

    List<InscriptionRequest> getAllInscriptionRequest();

    InscriptionRequest findInscriptionRequest(long idInscriptionRequest);
}
