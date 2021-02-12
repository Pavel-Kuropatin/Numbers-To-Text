package com.kuropatin.numberstotext;

import java.io.*;

/**
 * Add some numbers to "input.data" file
 * Numbers should be within range of int (between -2 147 483 648 and 2 147 483 647)
 * Textual representation of number will be written to "output.data" file
 * If numbers does not match allowed input values an error message will be written
 * You can comment lines in "input.data" file by using "//" at the beginning of the line
 */
public class ReaderWriter {

    private static final String ERR_MSG = "#Error: Number should be between -2 147 483 648 and 2 147 483 647.";

    public static void main(String[] args) {
        File inputFile = new File("input.data");
        File outputFile = new File("output.data");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
            String readedString;
            while ((readedString = bufferedReader.readLine()) != null) {
                if (!readedString.startsWith("//")) {
                    try {
                        int number = Integer.parseInt(readedString);
                        bufferedWriter.write(NumbersToText.convertNumberToText(number));
                        bufferedWriter.write(System.lineSeparator());
                    } catch (NumberFormatException e) {
                        bufferedWriter.write(ERR_MSG);
                        bufferedWriter.write(System.lineSeparator());
                    }
                }
            }
        } catch (IOException e) {
        }
    }
}