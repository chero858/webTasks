package by.epam.training.files.searching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

public class FileSearch {
    public static ArrayList<String> getFilesFromDir(File directory) throws FileNotFoundException {
        if (!directory.exists() || !directory.isDirectory()) {
            throw new FileNotFoundException(directory + " not found");
        }
        ArrayList<String> filesList = new ArrayList<>();
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isFile()) {
                filesList.add(file.getPath());
            }
            if (file.isDirectory()) {
                filesList.addAll(getFilesFromDir(file));
            }
        }
        return filesList;
    }
}
