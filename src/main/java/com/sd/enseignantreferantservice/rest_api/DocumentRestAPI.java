package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.DocumentService;
import com.sd.enseignantreferantservice.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DocumentRestAPI {


    @Autowired
    private DocumentService documentService;


    @PostMapping("/document")
    public Document addDocument(@RequestBody Document document){
        return documentService.addDocument(document);
    }

    @PutMapping("/document")
    public Document updateDocument(@RequestBody Document document){
        return documentService.updateDocument(document);
    }

    @DeleteMapping("/document")
    public void deleteDocument(@RequestBody Document document){
        documentService.deleteDocument(document);
    }
}

