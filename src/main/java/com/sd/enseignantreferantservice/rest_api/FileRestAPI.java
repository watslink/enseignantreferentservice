package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.FileService;
import com.sd.enseignantreferantservice.model.Document;
import com.sd.enseignantreferantservice.model.EleveDocumentInscriptionRequis;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;



@RestController
public class FileRestAPI {

    @Autowired
    FileService fileService;


    @PostMapping(value = "/files")
    @ResponseStatus(HttpStatus.OK)
    public Path handleFileUpload(@RequestParam("file") MultipartFile file,
                                 @RequestParam ("eleveDirectory") String eleveDirectory,
                                 @RequestParam("nomFichier") String nomFichier) throws IOException {

        return fileService.storeFile(file, eleveDirectory, nomFichier);
    }

    @GetMapping(value = "/filesInscription", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] getFileFromEleveDocumentInscriptionRequis(@RequestBody EleveDocumentInscriptionRequis edir) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream(fileService.getPathFile(edir.getEleve().getNom()+'-'+edir.getEleve().getPrenom(),
                        edir.getDocumentInscriptionRequis().getNom(), edir.getExtension()));
        return IOUtils.toByteArray(in);
    }

    @GetMapping(value = "/filesEleve", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] getFileFromDocument(@RequestBody Document doc) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream(fileService.getPathFile(doc.getEleve().getNom()+'-'+doc.getEleve().getPrenom(),
                        doc.getNom(), doc.getExtension()));
        return IOUtils.toByteArray(in);
    }
}
