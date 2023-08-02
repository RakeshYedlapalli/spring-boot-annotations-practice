package com.gap.sample.practice.scanning;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductFoundationGetAllAnnotations {

    static ArrayList<File> al = new ArrayList<File>();
    static File fileLocation = null;
    static List<String> listOfFolders = new ArrayList<>();
    static List<String> listOfAnnotations = new ArrayList<>();

    public static void main(String[] args) throws IOException {/*
        File filePath = new File("/Users/yadlapallirakesh/Documents/gitWorkspace/GlobalAssorted/assortment-service/assortment-service/src/main/java/com/gap/plan/assortmentservice");

        File[] listingAllFiles = filePath.listFiles();

        ArrayList<File> allFiles = iterateOverFiles(listingAllFiles);


        for (File file : allFiles) {
            if (file != null) {
                String fileName = file.getName();
System.out.println("FIle name is==>"+ fileName);
             *//*   String sourceFilepath = file.getAbsolutePath();
                File targetFilePath = new File("D:\\TestFiles");
                String targetPath = targetFilePath.getPath();*//*

               // Files.move(Paths.get(sourceFilepath), Paths.get("D:\\TestFiles\\" + fileName));
            }

        }*/
        //listf("/Users/yadlapallirakesh/Documents/gitWorkspace/GlobalAssorted/assortment-service/assortment-service/src/main/java/com/gap/plan/assortmentservice");
        //listf("/Users/yadlapallirakesh/Documents/gitWorkspace/product-foundation/domain");
        listf("/Users/yadlapallirakesh/Documents/gitWorkspace/product-foundation");

       // System.out.print("Folders are ==>" + listOfFolders);
        List<String> listOfFolderOnly = listOfFolders.stream()
                .filter(i -> !i.contains(".java")).collect(Collectors.toList());

        for (String files : listOfFolderOnly) {
            listAllFiles(files);
        }
        // System.out.print("These are annotations =>" + listOfAnnotations);
        Set<String> s = new LinkedHashSet<>(listOfAnnotations);

        File file = new File("/Users/yadlapallirakesh/Desktop/productFoundationDomainAnnotations.txt");
        if(!file.exists()){
            file.createNewFile();
        }

        PrintWriter out = new PrintWriter(file); // Step 2

        out.println(s);

        // Close the file.
        out.close();  // Step 4
    }

    public static List<String> listf(String directoryName) {

        // .............list file
        File directory = new File(directoryName);

        // get all the files from a directory
        File[] fList = directory.listFiles();
        addListOfFolderNames(fList);
        for (File file : fList) {
            if (file.isFile()) {
                //System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath());
            }
        }
        return listOfFolders;
    }


    public static void addListOfFolderNames(File[] folderName) {
        for (File files : folderName) {
            listOfFolders.add(files.getAbsolutePath());
        }

    }

    public static void listAllFiles(String path) {
       // System.out.println("In listAllfiles(String path) method");
        try (Stream<Path> paths = Files.walk(Paths.get(path))) {
            paths.forEach(filePath -> {
                if (Files.isRegularFile(filePath)) {
                    try {
                        readContent(filePath.toFile());
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void readContent(File file) throws IOException {
       // System.out.println("read file " + file.getCanonicalPath());
        if(file.toString().endsWith(".java")) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String strLine;
                // Read lines from the file, returns null when end of stream
                // is reached
                while ((strLine = br.readLine()) != null) {
                    // System.out.println("Line is - " + strLine);
                    if (strLine.contains("@")) {

                        listOfAnnotations.add(getExactAnnotation(strLine) + "\n");
                    }
                }
            }
        }
    }

    public static String getExactAnnotation(String ann) {
        int index = ann.indexOf('@');
        for (int i = index; i < ann.length(); i++) {
            if (ann.charAt(i) == '\n' || ann.charAt(i) == '(' || ann.charAt(i) == ' ') {
                return ann.substring(index,i).trim();
            }
        }
        return ann.trim();
    }
}
