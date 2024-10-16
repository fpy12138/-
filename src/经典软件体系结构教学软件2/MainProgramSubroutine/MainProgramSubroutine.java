package 经典软件体系结构教学软件2.MainProgramSubroutine;

import java.io.*;
import java.util.*;

public class MainProgramSubroutine {
    private ArrayList<String> kwicList = new ArrayList<>();
    private ArrayList<String> lineTxt = new ArrayList<>();
    private BufferedReader inputFile;
    private BufferedWriter outputFile;

    public void input(String fileName) throws IOException {
        inputFile = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = inputFile.readLine()) != null) {
            lineTxt.add(line);
        }
        inputFile.close();
    }

    public void output(String filename) throws IOException {
        Iterator<String> it = kwicList.iterator();
        outputFile = new BufferedWriter(new FileWriter(filename));
        while (it.hasNext()) {
            outputFile.write(it.next() + "\n");
        }
        outputFile.close();
    }

    public void shift() {
        Iterator<String> it = lineTxt.iterator();
        while (it.hasNext()) {
            StringTokenizer token = new StringTokenizer(it.next());
            ArrayList<String> tokens = new ArrayList<>();
            int i = 0;
            int count = token.countTokens();
            while (i < count) {
                tokens.add(token.nextToken());
                i++;
            }

            for (i = 0; i < count; i++) {
                StringBuffer lineBuffer = new StringBuffer();
                int index = i;
                for (int f = 0; f < count; f++) {
                    if (index >= count)
                        index = 0;
                    lineBuffer.append(tokens.get(index));
                    lineBuffer.append(" ");
                    index++;
                }
                kwicList.add(lineBuffer.toString());
            }
        }
    }

    public void alphabetizer() {
        Collections.sort(kwicList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toLowerCase().charAt(0) - o2.toLowerCase().charAt(0);
            }
        });
    }

    public void processFile(String inputFilePath, String outputFilePath) {
        try {
            input(inputFilePath);
            shift();
            alphabetizer();
            output(outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
