package by.epam.training.files.packing;

import by.epam.training.files.searching.FileSearch;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.zip.Deflater;

public class PackZip {
    private String zipFileName;
    public final int BUFFER = 2_048;

    public PackZip(String zipFileName) {
        this.zipFileName = zipFileName;
    }

    public void pack(String dirName) throws FileNotFoundException {
        ArrayList<String> listFilesToZip = FileSearch.getFilesFromDir(new File(dirName));
        String[] temp = {};
        String[] filesToZip = listFilesToZip.toArray(temp);

        try (FileOutputStream fos = new FileOutputStream(zipFileName);
             ZipOutputStream jos = new ZipOutputStream(fos)) {
            byte[] buffer = new byte[BUFFER];

            jos.setLevel(Deflater.DEFAULT_COMPRESSION);
            for (String s : filesToZip) {
                jos.putNextEntry(new ZipEntry(s));
                try (FileInputStream in = new FileInputStream(s)) {
                    int len;
                    while ((len = in.read(buffer)) > 0) {
                        jos.write(buffer, 0, len);
                    }
                    jos.closeEntry();
                } catch (FileNotFoundException e) {
                    System.err.println("Файл не найден" + e);
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e + "Некорректный аргумент" + e);
        } catch (IOException e) {
            System.err.println("Ошибка доступа" + e);
        }
    }
}