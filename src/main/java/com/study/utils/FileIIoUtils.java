package com.study.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileIIoUtils {
    public byte[] loadFileFromClassPath(String filePath) throws IOException, URISyntaxException {
        Path path = Paths.get(FileIIoUtils.class.getClassLoader().getResource(filePath).toURI());
        return Files.readAllBytes(path);
    }
}
