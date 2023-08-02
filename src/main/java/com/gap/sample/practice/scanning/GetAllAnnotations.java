package com.gap.sample.practice.scanning;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GetAllAnnotations {

    static ArrayList<File> al = new ArrayList<>();
    static File fileLocation = null;
    static List<String> listOfFolders = new ArrayList<>();
    static Set<String> listOfAnnotations = new HashSet<>();
    static Set<String> setOfFiles = new HashSet<>();
    static Set<String> packages = new HashSet<>();


    public static void main(String[] args) throws IOException {

        UUID uuid = UUID.randomUUID();

        File filePath = new File("/Users/yadlapallirakesh/Documents/gitWorkspace/GlobalAssorted/assortment-service/assortment-service/src/main/java/com/gap/plan/assortmentservice");


       /* File[] listingAllFiles = filePath.listFiles();

        ArrayList<File> allFiles = iterateOverFiles(listingAllFiles);


        for (File file : allFiles) {
            if (file != null) {
                String fileName = file.getName();
System.out.println("FIle name is==>"+ fileName);
                String sourceFilepath = file.getAbsolutePath();
                File targetFilePath = new File("D:\\TestFiles");
                String targetPath = targetFilePath.getPath();

               // Files.move(Paths.get(sourceFilepath), Paths.get("D:\\TestFiles\\" + fileName));
            }

        }*/
        //listf("/Users/yadlapallirakesh/Documents/gitWorkspace/GlobalAssorted/assortment-service/assortment-service/src/main/java/com/gap/plan/assortmentservice");
        //listf("/Users/yadlapallirakesh/Documents/gitWorkspace/globalassortment-webapplication/src/main/java/com/gap/visualassortment");
        //listf("/Users/yadlapallirakesh/Documents/gitWorkspace/globalassortment-webapplication/src/main/webapp");
       // listf("/Users/yadlapallirakesh/Documents/gitWorkspace/globalassortment-webapplication/src/test/java/com/gap/visualassortment");
        /** assortment service */

       // listf("/Users/yadlapallirakesh/Documents/gitWorkspace/GlobalAssorted/assortment-service/assortment-service/src/main/java/com/gap/plan/assortmentservice");

        /** assortment service test package */
        //listf("/Users/yadlapallirakesh/Documents/gitWorkspace/GlobalAssorted/assortment-service/assortment-service/src/test/java/com/gap/plan/assortmentservice");
        /** PFI  */
        listf("/Users/yadlapallirakesh/Documents/gitWorkspace/GlobalAssortment-ProductFoundation-Integrator/src");


       // System.out.print("Folders are ==>" + listOfFolders);
        List<String> listOfFolderOnly = listOfFolders.stream()
                .filter(i -> !i.contains(".java")).collect(Collectors.toList());
        for (String files : listOfFolderOnly) {
            listAllFiles(files);
        }
        // System.out.print("These are annotations =>" + listOfAnnotations);
        Set<String> s = new LinkedHashSet<>(listOfAnnotations);


        PrintWriter out = new PrintWriter("/Users/yadlapallirakesh/Desktop/igpMarkets.txt"); // Step 2

        out.println(listOfAnnotations.toString() + "\n\n\n\n" +
                " Number of files are =>\n" + setOfFiles.toString() +
                "\n packages are =>\n" + packages.toString());

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
               // System.out.println(file.getAbsolutePath());
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
        //System.out.println("In listAllfiles(String path) method");
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
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String strLine;
            // Read lines from the file, returns null when end of stream
            // is reached
            int i = 0;
            if(file.toString().contains("assets")){
                return;
            }
            String packageName = "";
            while ((strLine = br.readLine()) != null) {
                // System.out.println("Line is - " + strLine);
                boolean isFalling =
                        checkWhetherIGPMarketExists(strLine);

                if (i == 0) {
                    packageName = strLine;
                }
                ++i;
                if (isFalling) {
                    String substring = file.toString()
                            .substring(file.toString().lastIndexOf('/') + 1);
                    listOfAnnotations.add(substring
                            + " -> " + strLine.trim() + " LN->" + i + " \n");
                    setOfFiles.add(substring + "\n");
                    packages.add(packageName + "\n");
                }
                /*if (strLine.contains("@")) {


                    listOfAnnotations.add(getExactAnnotation(strLine) + "\n");
                }*/
            }
        }
    }

    private static boolean checkWhetherDoWehaveAnyNumbersFallingBetween(String strLine) {
        return strLine.contains(" 9 ") || strLine.contains(" 12 ")
                || strLine.contains(" 6 ") || strLine.contains(" 9;") || strLine.contains(" 12;")
                || strLine.contains(" 6;") || strLine.contains(" 9,") || strLine.contains(" 12,")
                || strLine.contains(" 6,") ||
                strLine.toUpperCase().contains("SIX")
                || strLine.toUpperCase().contains("NINE")
                || strLine.toUpperCase().contains("TWELVE")
                || strLine.contains("hasNineDigit")
                || strLine.contains("hasTwelveDigit")
                || strLine.contains("hasSixDigit") || strLine.contains(" 99 ")
                || strLine.contains("99")
                /*|| strLine.contains("000") || strLine.contains(" 000 ")*/
              /*  strLine.contains(" 000 ") || strLine.contains(" 00 ") ||
                strLine.contains(" 9") || strLine.contains(" 12")
                || strLine.contains(" 6")*/;

    }
    private static boolean checkWhetherIGPMarketExists(String strLine) {
        return strLine.toLowerCase().contains("igp")
                /*|| strLine.contains("000") || strLine.contains(" 000 ")*/
              /*  strLine.contains(" 000 ") || strLine.contains(" 00 ") ||
                strLine.contains(" 9") || strLine.contains(" 12")
                || strLine.contains(" 6")*/;

    }

/*    private static boolean checkForDigits(String strLine) {
        return *//*strLine.contains("9")
                || strLine.contains("12")
                || strLine.contains("6") || *//*strLine.contains("length() != 6")
                || strLine.contains("length() != 9")
                || strLine.contains("length() != 12")
                || strLine.contains("length() !=6")
                || strLine.contains("length() !=9")
                || strLine.contains("length() !=12")
                || strLine.contains("length()!= 6")
                || strLine.contains("length()!= 9")
                || strLine.contains("length()!= 12");

    }*/

    private static boolean checkForDigits(String strLine) {
        return /*strLine.contains("length") || */
                strLine.contains("getNumber()") || strLine.toLowerCase().contains("programnumber")
                        || strLine.toLowerCase().contains("getstyle")
                        || strLine.toLowerCase().contains("number")

                ;
    }

    public static String getExactAnnotation(String ann) {
        int index = ann.indexOf('@');
        for (int i = index; i < ann.length(); i++) {
            if (ann.charAt(i) == '\n' || ann.charAt(i) == '(' || ann.charAt(i) == ' ') {
                return ann.substring(index, i).trim();
            }
        }
        return ann.trim();
    }
}
