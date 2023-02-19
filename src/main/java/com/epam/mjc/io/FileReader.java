package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;

public class FileReader {

    static String directory = System.getProperty("user.dir");
    static String fileName = "Profile.txt";
    static String path = directory + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + fileName;

    static File file = new File(path);
    static HashMap<String, String> lineMap = new HashMap<>();

    public Profile getDataFromFile(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                parse(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Profile();
    }

    public void parse(String line) {
        String[] strings = line.split(" ");
        lineMap.put(strings[0], strings[1]);
    }

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        Profile profile = fileReader.getDataFromFile(file);
        profile.setName(lineMap.get("Name:"));
        profile.setEmail(lineMap.get("Email:"));
        profile.setAge(Integer.parseInt(lineMap.get("Age:")));
        profile.setPhone(Long.parseLong(lineMap.get("Phone:")));
    }
}
