package fileioexamples;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIOExamples {

    public static void main(String[] args) {

        try {
            PrintWriter outputFile = new PrintWriter(
                    new BufferedWriter(
                            // overwrite the existing file if it exists
                            // if it doesn't it creates a new file
                            new FileWriter("numbers.txt")));

            outputFile.println(420.69);
            outputFile.println(137);
            outputFile.println(5);
            outputFile.println(111);
            outputFile.println(666);

            outputFile.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }

        File inputFile = new File("numbers.txt");

        // better to check in code rather than waiting for an exception
        if (inputFile.exists()) {

            try {
                BufferedReader fileReader = new BufferedReader(
                        new FileReader(
                                inputFile));

                double sum = 0;

                String line = fileReader.readLine();
                while (line != null) {
                    sum += Double.parseDouble(line);
                    line = fileReader.readLine();
                }

                fileReader.close();

                System.out.println("The sum of the values in your file is: " + sum);

            } catch (IOException ex) {
                System.out.println(ex);
            }
        } else {
            System.out.println("Can't find that file");
        }

        try {
            // binary type files
            DataOutputStream binaryOutputFile = new DataOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream("numbers.bin")));

            binaryOutputFile.writeDouble(420.69);
            binaryOutputFile.writeDouble(137);
            binaryOutputFile.writeDouble(5);
            binaryOutputFile.writeDouble(111);
            binaryOutputFile.writeDouble(666);

            binaryOutputFile.close();

        } catch (IOException ex) {
            System.out.println(ex);
        }

        File binaryInputFile = new File("numbers.bin");

        if (binaryInputFile.exists()) {
            try {

                DataInputStream binaryInput = new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream(binaryInputFile)));

                double sum = 0;

                // available tells you how many bytes are left to read
                while (binaryInput.available() > 0) {
                    sum += binaryInput.readDouble();
                }

                binaryInput.close();

                System.out.println("The sum of the values in the binary are: " + sum);

            } catch (IOException ex) {
                System.out.println(ex);
            }
        }

    }

}
