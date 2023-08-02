package com.gap.sample.practice.annotations.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Iterator;

public class ApachePOIExcelRead {

    private static final String FILE_NAME = "/Users/yadlapallirakesh/Desktop/ACCs.xlsx";

    public static void main(String[] args) {

        try {

            FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();
            StringBuilder sb = new StringBuilder();
            int count = 0;
            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();

                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    //getCellTypeEnum shown as deprecated for version 3.15
                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
                    if (currentCell.getCellTypeEnum() == CellType.STRING) {
                       // System.out.print(currentCell.getStringCellValue() + "--");
                        sb.append("'"+currentCell.getStringCellValue()+"',");
                        count++;
                    } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                        System.out.print(currentCell.getNumericCellValue() + "--");
                    }

                }
                System.out.println();

            }
            System.out.print(sb);

            FileWriter fWriter = new FileWriter(
                    "/Users/yadlapallirakesh/Desktop/accsNumber.txt");

            // Write into the file
            // The content taken above inside the string
            fWriter.write(sb.toString());

            // Printing the contents of a file


            // Close the file writer object
            fWriter.close();



            System.out.print("Count is =>"+count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
