package tn.esprit.inscriptionservice.Service;

import tn.esprit.inscriptionservice.Entity.InscriptionRequest;
import tn.esprit.inscriptionservice.Interface.IServiceInscriptionRequest;
import tn.esprit.inscriptionservice.Repository.RepoInscriptionRequest;

import java.util.ArrayList;
import java.util.List;

public class ServiceInscriptionRequest implements IServiceInscriptionRequest {
    RepoInscriptionRequest riq;
    @Override
    public InscriptionRequest addInscriptionRequest(InscriptionRequest iq) {
        return riq.save(iq);
    }

    @Override
    public void DeleteInscriptionRequest(Long idiq) {
        riq.deleteById(idiq);

    }
    @Override
    public List<InscriptionRequest> getAllInscriptionRequest() {
        List<InscriptionRequest> InscriptionRequestList = new ArrayList<>();
        riq.findAll().forEach(InscriptionRequestList::add);
        return InscriptionRequestList;
    }
    @Override
    public InscriptionRequest findInscriptionRequest(long idInscriptionRequest) {
        return riq.findById(idInscriptionRequest).orElse(null);
    }
}
