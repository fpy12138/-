package 经典软件体系结构教学软件2.PipelineFilterArchitecture;

import java.util.ArrayList;
import java.util.Collections;

public class AlphabetizerFilter extends Filter {
    @Override
    public Document process(Document input) {
        ArrayList<String> lines = new ArrayList<>(input.getLines());
        Collections.sort(lines, String.CASE_INSENSITIVE_ORDER);
        input.getLines().clear();
        input.getLines().addAll(lines);
        return input;
    }
}
