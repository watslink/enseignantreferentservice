package com.sd.enseignantreferantservice.business.serviceInterface;

import com.sd.enseignantreferantservice.model.Document;


public interface DocumentService {

    Document addDocument(Document document);
    void deleteDocument (int id);
    Document updateDocument (Document document);

}
