package com.sd.enseignantreferantservice.business.serviceInterface;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String storeFile(MultipartFile file, String eleveDirectory, String nomFichier) throws IOException;
}
