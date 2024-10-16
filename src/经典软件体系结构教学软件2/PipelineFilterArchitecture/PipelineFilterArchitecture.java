package 经典软件体系结构教学软件2.PipelineFilterArchitecture;

import java.io.*;
import java.util.*;

public class PipelineFilterArchitecture {
    public void processFile(String inputFilePath, String outputFilePath) {
        Document document = new Document();
        InputFilter inputFilter = new InputFilter(inputFilePath);
        ShiftFilter shiftFilter = new ShiftFilter();
        AlphabetizerFilter alphabetizerFilter = new AlphabetizerFilter();
        OutputFilter outputFilter = new OutputFilter(outputFilePath);

        // 将输入文件的内容读入文档
        inputFilter.process(document);

        // 执行位移操作
        shiftFilter.process(document);

        // 执行排序操作
        alphabetizerFilter.process(document);

        // 将结果写入输出文件
        outputFilter.process(document);
    }
}

