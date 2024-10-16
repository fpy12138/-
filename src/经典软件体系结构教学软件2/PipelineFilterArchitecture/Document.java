package 经典软件体系结构教学软件2.PipelineFilterArchitecture;

import java.util.ArrayList;

public class Document {
    private ArrayList<String> lines;

    public Document() {
        lines = new ArrayList<>();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public ArrayList<String> getLines() {
        return lines;
    }
}