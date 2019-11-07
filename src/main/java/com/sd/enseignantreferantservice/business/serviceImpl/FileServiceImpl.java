package com.sd.enseignantreferantservice.business.serviceImpl;

import com.sd.enseignantreferantservice.business.serviceInterface.FileService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Observable;

@Service
public class FileServiceImpl implements FileService {

    private static final String FILE_DIRECTORY = System.getProperty("catalina.base")+"/files";

    public Path storeFile(MultipartFile file, String eleveDirectory, String nomFichier) throws IOException {

        Path filePath = Paths.get(FILE_DIRECTORY + "/" + eleveDirectory + "/" + nomFichier +"."+ FilenameUtils.getExtension(file.getOriginalFilename()));

        File directory = new File(FILE_DIRECTORY + "/" + eleveDirectory + "/" );
        if (! directory.exists()){
            directory.mkdirs();
        }

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return filePath.toRealPath();
    }
}
