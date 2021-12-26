package org.example.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StringUtil {
    public static String readFileFromResources(String filename) throws URISyntaxException, IOException {
        URL resource = StringUtil.class.getClassLoader().getResource(filename);
        byte[] bytes = Files.readAllBytes(Paths.get(resource.toURI()));
        return new String(bytes);
    }
}
