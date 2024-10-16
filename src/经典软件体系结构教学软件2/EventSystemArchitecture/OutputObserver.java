package 经典软件体系结构教学软件2.EventSystemArchitecture;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class OutputObserver extends Observer {
    private ArrayList<String> kwicList;
    private String outputFilePath;

    public OutputObserver(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public void setKwicList(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

    @Override
    public void toDo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String line : kwicList) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
