package com.sd.enseignantreferantservice.business.serviceInterface;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public interface FileService {

    Path storeFile(MultipartFile file, String eleveDirectory, String nomFichier) throws IOException;

    File getFile(String eleveDirectory, String nomFichier) throws IOException;

    boolean deleteFile(String eleveDirectory, String nomFichier) throws IOException;
}
