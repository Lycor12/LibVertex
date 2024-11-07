package com.libvertex.math.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileHelper {
    public static List<String> readFile(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

    public static void writeFile(String path, List<String> lines) throws IOException {
        Files.write(Paths.get(path), lines);
    }
}
