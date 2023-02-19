package com.epam.mjc.io;

import java.io.*;

public class FileReader {

    static String directory = System.getProperty("user.dir");
    static String fileName = "Profile.txt";
    static String path = directory + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + fileName;

    public Profile getDataFromFile(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(path))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Exception IO");
        }
        return new Profile();
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        File file = new File(path);
        fileReader.getDataFromFile(file);
    }
}
