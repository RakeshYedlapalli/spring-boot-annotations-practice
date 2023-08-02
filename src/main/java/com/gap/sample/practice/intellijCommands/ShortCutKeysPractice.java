package com.gap.sample.practice.intellijCommands;

import java.io.InputStream;
import java.util.stream.IntStream;

public class ShortCutKeysPractice {
    public static void main(String[] args) {

        int  duration = (1000/1000)%60;
        System.out.println("Time is =>"+duration);
        //searchColorsWithUserInput("","White 84884 82 dsklsd dslksd");

        IntStream.rangeClosed(0,5).forEach(i-> System.out.println("This is Range closed ->"+i));

        IntStream.range(0,3).forEach(i-> System.out.println("This is Range ->"+i));
    }

    public static void searchColorsWithUserInput(String brandId, String userInput) {
        String colorCode = null;
        StringBuilder desc = new StringBuilder();
        String[] split = userInput.split("\\s+");
        for (String str : split) {
            if(str.matches("[0-9]+")) {
                colorCode = str;
            } else {
                desc = desc.length() == 0 ? desc.append(str) : desc.append(" ").append(str);
            }
        }

        if (colorCode == null || desc.length() == 0) {
            if (colorCode == null) {
                //return searchColorsWithDescription(brandId, userInput);
            } else {
                //	return searchColorsWithColorCode(brandId, colorCode);
            }
        } else {
            //return searchWithColorCodeAndDescription(brandId, colorCode, desc.toString());
        }
    }



}
