package 经典软件体系结构教学软件2.EventSystemArchitecture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class InputObserver extends Observer {
    private ArrayList<String> lineTxt = new ArrayList<>();
    private String fileName;

    public InputObserver(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void toDo() {
        try (BufferedReader inputFile = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = inputFile.readLine()) != null) {
                lineTxt.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> getLineTxt() {
        return lineTxt;
    }
}