package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

public class ReadFile {
    public static String read() {
        String data = "";
        try {
            String workingDir = System.getProperty("user.dir");
            String pathToFile = workingDir + "/src/sample/movies.json";
            File myObj = new File(pathToFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = data + "\n" + myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}