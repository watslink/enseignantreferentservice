package com.sd.enseignantreferantservice.business.Interface;

import com.sd.enseignantreferantservice.model.Document;

import java.util.List;

public interface DocumentService {

    Document addDocument(Document document);
    void deleteDocument (Document document);
    Document updateDocument (Document document);

}
