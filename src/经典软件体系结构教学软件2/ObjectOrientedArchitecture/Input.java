package 经典软件体系结构教学软件2.ObjectOrientedArchitecture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Input {
    private ArrayList<String> lineTxt = new ArrayList<>();

    public ArrayList<String> getLineTxt() {
        return lineTxt;
    }

    public void input(String fileName) throws IOException {
        BufferedReader inputFile = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = inputFile.readLine()) != null) {
            lineTxt.add(line);
        }
        inputFile.close();
    }
}
