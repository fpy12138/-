package 经典软件体系结构教学软件2.PipelineFilterArchitecture;

import java.util.ArrayList;
import java.util.StringTokenizer;

import java.io.*;
import java.util.*;

public class ShiftFilter extends Filter {
    @Override
    public Document process(Document input) {
        ArrayList<String> originalLines = input.getLines();
        ArrayList<String> shiftedLines = new ArrayList<>();

        for (String line : originalLines) {
            StringTokenizer tokenizer = new StringTokenizer(line);
            ArrayList<String> tokens = new ArrayList<>();
            while (tokenizer.hasMoreTokens()) {
                tokens.add(tokenizer.nextToken());
            }
            int count = tokens.size();
            for (int i = 0; i < count; i++) {
                StringBuffer lineBuffer = new StringBuffer();
                int index = i;
                for (int f = 0; f < count; f++) {
                    if (index >= count) index = 0;
                    lineBuffer.append(tokens.get(index));
                    lineBuffer.append(" ");
                    index++;
                }
                shiftedLines.add(lineBuffer.toString().trim());
            }
        }

        input.getLines().clear();
        input.getLines().addAll(shiftedLines);
        return input;
    }
}