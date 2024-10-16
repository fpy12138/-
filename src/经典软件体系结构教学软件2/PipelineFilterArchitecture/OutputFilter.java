package 经典软件体系结构教学软件2.PipelineFilterArchitecture;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFilter extends Filter {
    private String outputFilePath;

    public OutputFilter(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    @Override
    public Document process(Document input) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (String line : input.getLines()) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}