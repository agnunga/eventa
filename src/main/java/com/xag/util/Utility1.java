package com.xag.util;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by agunga
 */
public class Utility1 {

    private static final Logger log = LoggerFactory.getLogger(Utility1.class);

    public static LocalDateTime stringToLocalDateTime(String string) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(string, formatter);
    }


    /*ByteStream method that takes filenames as argument*/
    public static void byteStream(String input_filename, String output_filename) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(input_filename);
            fileOutputStream = new FileOutputStream(output_filename);

            int c;
            while ((c = fileInputStream.read()) != -1) {
                fileOutputStream.write(c);
            }
            log.info("ByteStream file coping success.");

        } finally {
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    /*CharacterStream method that takes filename as an argument*/
    public static void characterStream(String input_filename, String output_filename) throws IOException {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            fileReader = new FileReader(input_filename);
            fileWriter = new FileWriter(output_filename);

            int c;
            while ((c = fileReader.read()) != -1) {
                fileWriter.write(c);
            }
            log.info("CharacterStream file coping success.");

        } finally {
            if (fileReader != null) {
                fileReader.close();
            }

            if (fileWriter != null) {
                fileWriter.close();
            }
        }

    }

    public static void writeStringToFile(String text, String filename) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true))) {
            char[] chars = text.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                bufferedWriter.write(c);
            }

            log.info("Writing to file successful");

        } catch (IOException e) {
            log.error("PatientDetail detail saving failed.");
        }
    }

    public static String readFile(String filename) {

        String output = "";
        if (filename.equals("0")) {
        } else {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
                int i;
                while ((i = bufferedReader.read()) != -1) {
                    output += (char) i;
                }
                log.info("File read successful");

            } catch (IOException e) {
                log.error("The requested record could not be found.");
            }
        }
        return output;
    }

    public static long ParseLong(String s) {
        try {
            return Long.parseLong(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int ParseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static double ParseDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

}
