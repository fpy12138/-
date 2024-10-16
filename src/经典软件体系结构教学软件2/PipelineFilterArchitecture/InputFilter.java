package 经典软件体系结构教学软件2.PipelineFilterArchitecture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputFilter extends Filter {
    private String inputFilePath;

    public InputFilter(String inputFilePath) {
        this.inputFilePath = inputFilePath;
    }

    @Override
    public Document process(Document input) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                input.addLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }
}