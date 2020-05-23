package by.epam.training.files;

import by.epam.training.files.packing.PackZip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Run {
    public static void main(String[] args) throws FileNotFoundException {
        PackZip pack = new PackZip("foo.zip");
        pack.pack(System.getProperty("user.dir") + "\\1");
    }

}
