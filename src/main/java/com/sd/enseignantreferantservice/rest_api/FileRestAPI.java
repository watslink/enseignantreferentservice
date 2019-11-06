package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class FileRestAPI {

    @Autowired
    FileService fileService;


    @PostMapping(value = "/files")
    @ResponseStatus(HttpStatus.OK)
    public void handleFileUpload(@RequestParam("file") MultipartFile file,
                                 @RequestParam ("eleveDirectory") String eleveDirectory,
                                 @RequestParam("nomFichier") String nomFichier) throws IOException {
        System.out.println(nomFichier + "en cours");
        fileService.storeFile(file, eleveDirectory, nomFichier);
    }
}
