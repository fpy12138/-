package 经典软件体系结构教学软件2.ObjectOrientedArchitecture;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Output {
    private ArrayList<String> kwicList;
    private BufferedWriter outputFile;

    public Output(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

    public void output(String filename) throws IOException {
        Iterator<String> it = kwicList.iterator();
        outputFile = new BufferedWriter(new FileWriter(filename));
        while (it.hasNext()) {
            outputFile.write(it.next() + "\n");
        }
        outputFile.close();
    }
}
