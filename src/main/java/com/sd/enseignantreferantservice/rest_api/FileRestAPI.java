package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Observable;

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
}
