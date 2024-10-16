package 经典软件体系结构教学软件2.EventSystemArchitecture;

import java.io.*;
import java.util.*;

public class EventSystemArchitecture {
    public void processFile(String inputFilePath, String outputFilePath) {
        KWICSubject kwicSubject = new KWICSubject();
        InputObserver input = new InputObserver(inputFilePath);
        ShiftObserver shift = new ShiftObserver();
        AlphabetizerObserver alphabetizer = new AlphabetizerObserver();
        OutputObserver output = new OutputObserver(outputFilePath);

        kwicSubject.addObserver(input);
        kwicSubject.addObserver(shift);
        kwicSubject.addObserver(alphabetizer);
        kwicSubject.addObserver(output);

        input.toDo(); // InputObserver reads the file and populates its lines
        shift.setLineTxt(input.getLineTxt()); // ShiftObserver gets the lines from InputObserver
        shift.toDo(); // ShiftObserver processes the lines
        alphabetizer.setKwicList(shift.getKwicList()); // AlphabetizerObserver gets the lines from ShiftObserver
        alphabetizer.toDo(); // AlphabetizerObserver sorts the lines
        output.setKwicList(alphabetizer.getKwicList()); // OutputObserver gets the sorted lines
        output.toDo(); // OutputObserver writes the lines to the output file
    }
}