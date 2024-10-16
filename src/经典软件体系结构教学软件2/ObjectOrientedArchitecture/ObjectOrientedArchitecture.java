package 经典软件体系结构教学软件2.ObjectOrientedArchitecture;

import java.io.*;
import java.util.*;

public class ObjectOrientedArchitecture {
    public void processFile(String inputFilePath, String outputFilePath) {
        try {
            Input input = new Input();
            input.input(inputFilePath);
            Shift shift = new Shift(input.getLineTxt());
            shift.shift();
            Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
            alphabetizer.sort();
            Output output = new Output(alphabetizer.getKwicList());
            output.output(outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}