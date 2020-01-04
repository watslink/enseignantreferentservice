package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.DocumentInscriptionRequisService;
import com.sd.enseignantreferantservice.model.DocumentInscriptionRequis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentInscriptionRequisRestAPI {


    @Autowired
    private DocumentInscriptionRequisService documentInscriptionRequisService;

    @GetMapping("/documentInscriptionRequis/{id}")
    public DocumentInscriptionRequis getDocumentInscriptionRequis(@PathVariable int id) {
        return documentInscriptionRequisService.getDocumentInscriptionRequis(id);
    }

    @GetMapping("/documentInscriptionRequiss/{ensRefId}")
    public List<DocumentInscriptionRequis> getListDocumentInscriptionRequis(@PathVariable int ensRefId) {
        return documentInscriptionRequisService.getAllDocumentInscriptionRequis(ensRefId);
    }


    @PostMapping("/documentInscriptionRequis")
    public DocumentInscriptionRequis addDocumentInscriptionRequis(@RequestBody DocumentInscriptionRequis documentInscriptionRequis) {
        return documentInscriptionRequisService.addDocumentInscriptionRequis(documentInscriptionRequis);
    }

    @PutMapping("/documentInscriptionRequis")
    public DocumentInscriptionRequis updateDocumentInscriptionRequis(@RequestBody DocumentInscriptionRequis documentInscriptionRequis) {
        return documentInscriptionRequisService.updateDocumentInscriptionRequis(documentInscriptionRequis);
    }

    @DeleteMapping("/documentInscriptionRequis/{id}")
    public void deleteDocumentInscriptionRequis(@PathVariable int id) {
        documentInscriptionRequisService.deleteDocumentInscriptionRequis(id);
    }
}


