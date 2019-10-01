package com.sd.enseignantreferantservice.business.implementation;

import com.sd.enseignantreferantservice.business.Interface.DocumentService;
import com.sd.enseignantreferantservice.dao.DocumentRepository;
import com.sd.enseignantreferantservice.model.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    DocumentRepository documentRepository;

    @Override
    public Document addDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public void deleteDocument(Document document) {
        documentRepository.delete(document);
    }

    @Override
    public Document updateDocument(Document document) {
        return documentRepository.save(document);
    }


}
