package com.sd.enseignantreferantservice.rest_api;

import com.sd.enseignantreferantservice.business.serviceInterface.FileService;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
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

    @PostMapping(value = "/filesDownload", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody byte[] getFile(@RequestParam("nomFichier") String nomFichier,
                                        @RequestParam("eleveDirectory") String eleveDirectory) throws IOException {
        InputStream in = new FileInputStream(fileService.getFile(eleveDirectory, nomFichier));
        byte[] data=IOUtils.toByteArray(in);
        in.close();
        return data;
    }
}
