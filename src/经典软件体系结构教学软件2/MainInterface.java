package 经典软件体系结构教学软件2;

import 经典软件体系结构教学软件2.EventSystemArchitecture.EventSystemArchitecture;
import 经典软件体系结构教学软件2.MainProgramSubroutine.MainProgramSubroutine;
import 经典软件体系结构教学软件2.ObjectOrientedArchitecture.ObjectOrientedArchitecture;
import 经典软件体系结构教学软件2.PipelineFilterArchitecture.PipelineFilterArchitecture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.List;

public class MainInterface {
    private JFrame frame;
    private JTextArea resultTextArea;
    private JEditorPane infoEditorPane;
    private JTextField inputFilePathField, outputFilePathField;
    private JFileChooser fileChooser;
    private JComboBox<String> architectureComboBox;
    private JComboBox<String> infoComboBox;

    private final String[] architectures = {
            "主程序-子程序", "面向对象", "事件系统", "管道-过滤器"
    };
    private final Map<String, String> architectureInfo = new HashMap<>();

    public MainInterface() {
        // 初始化界面元素
        frame = new JFrame("软件体系结构教学软件");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);

        resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        infoEditorPane = new JEditorPane();
        infoEditorPane.setEditable(false);
        infoEditorPane.setContentType("text/html"); // 设置内容类型为HTML
        inputFilePathField = new JTextField(20);
        outputFilePathField = new JTextField(20);

        fileChooser = new JFileChooser();

        // 初始化下拉式列表
        architectureComboBox = new JComboBox<>(architectures);
        architectureComboBox.addActionListener(e -> processSelectedArchitecture());
        infoComboBox = new JComboBox<>(architectures);
        infoComboBox.addActionListener(e -> updateInfoDisplay());

        // 添加组件到框架
        frame.setLayout(new BorderLayout());
        JPanel topPanel = new JPanel(new GridLayout(1, 1, 4, 0));
        topPanel.add(new JLabel("输入文件路径:"));
        topPanel.add(inputFilePathField);
        JButton inputBrowseButton = new JButton("浏览...");
        inputBrowseButton.addActionListener(e -> browseFile(true));
        topPanel.add(inputBrowseButton);
        topPanel.add(new JLabel("输出文件路径:"));
        topPanel.add(outputFilePathField);
        JButton outputBrowseButton = new JButton("浏览...");
        outputBrowseButton.addActionListener(e -> browseFile(false));
        topPanel.add(outputBrowseButton);
        topPanel.add(new JLabel("选择体系结构风格:"));
        topPanel.add(architectureComboBox);
        topPanel.add(new JLabel("信息显示:"));
        topPanel.add(infoComboBox);
        frame.add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new GridLayout(1, 1, 0, 0));
        centerPanel.add(new JScrollPane(resultTextArea));
        centerPanel.add(new JScrollPane(infoEditorPane));
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setVisible(true);
        // 初始化体系结构对应的操作和信息
        initializeArchitectureInfo();
    }

    private void initializeArchitectureInfo() {
        architectureInfo.put("主程序-子程序",
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>主程序-子程序体系结构风格</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <h1>主程序-子程序体系结构风格</h1>\n" +
                        "    <p>主程序-子程序体系结构风格是一种经典的程序设计模式，它将程序分解为一个控制执行流程的主程序和多个执行具体任务的子程序。这种分层的方法有助于简化复杂程序的开发和维护。</p>\n" +
                        "    <img src=\"https://i-blog.csdnimg.cn/blog_migrate/fd424bdea6663927bfb75004aa35dfce.png\" alt=\"主程序-子程序体系结构图\" width=\"100px\" height=\"100px\">\n" +
                        "    <h2>源程序代码结构</h2>\n" +
                        "    <pre>\n" +
                        "        <code>\n" +
                        "// 主程序\n" +
                        "int main() {\n" +
                        "    // 调用子程序\n" +
                        "    subroutine1();\n" +
                        "    subroutine2();\n" +
                        "    return 0;\n" +
                        "}\n" +
                        "\n" +
                        "// 子程序1\n" +
                        "void subroutine1() {\n" +
                        "    // 功能实现\n" +
                        "}\n" +
                        "\n" +
                        "// 子程序2\n" +
                        "void subroutine2() {\n" +
                        "    // 功能实现\n" +
                        "}\n" +
                        "        </code>\n" +
                        "    </pre>\n" +
                        "<h2>特点</h2>"+
                        "<ul>"+
                        " <li>明确的程序入口点和执行流程。</li>"+
                        " <li>子程序的高内聚低耦合，易于理解和修改。</li>"+
                        "<li>支持并行处理，提高程序执行效率。</li>"+
                        " <li>便于单元测试和调试。</li>"+
                        "<li>适用于功能明确、流程固定的应用场景。</li>"+
                        "</ul>"+
                        "<h2>适用场景</h2>"+
                        "<p>主程序-子程序体系结构风格适用于需要清晰定义程序执行流程的场景，如科学计算、数据处理等。它也适用于那些需要将大问题分解为小问题并分别解决的场合。</p>"+
                        "</body>\n" +
                        "</html>");
        architectureInfo.put("面向对象",
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>面向对象体系结构风格</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <h1>面向对象体系结构风格</h1>\n" +
                        "    <p>面向对象体系结构风格强调使用对象和类来组织代码，每个对象都有自己的数据和方法。</p>\n" +
                        "    <img src=\"https://i-blog.csdnimg.cn/blog_migrate/0a23d838dadbc470e54623ce53db1a15.png\">\n" +
                        "    <h2>源程序代码结构</h2>\n" +
                        "    <pre>\n" +
                        "        <code>\n" +
                        "// 基类\n" +
                        "class Base {\n" +
                        "public:\n" +
                        "    virtual void operation() = 0;\n" +
                        "};\n" +
                        "\n" +
                        "// 派生类\n" +
                        "class Derived : public Base {\n" +
                        "public:\n" +
                        "    void operation() override {\n" +
                        "        // 功能实现\n" +
                        "    }\n" +
                        "};\n" +
                        "\n" +
                        "int main() {\n" +
                        "    Derived obj;\n" +
                        "    obj.operation();\n" +
                        "    return 0;\n" +
                        "}\n" +
                        "        </code>\n" +
                        "    </pre>\n" +
                        "</body>\n" +
                        "</html>");
        architectureInfo.put("事件系统",
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>事件系统体系结构风格</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <h1>事件系统体系结构风格</h1>\n" +
                        "    <p>事件系统体系结构风格是一种基于事件驱动的程序设计模式。在这种风格中，程序的执行流程由外部事件（如用户输入、传感器数据等）触发，而不是由程序内部的逻辑顺序控制。这种风格使得程序能够更加灵活地响应外部变化。</p>\n" +
                        "    <img src=\"https://i-blog.csdnimg.cn/blog_migrate/53585192567c4b517c0306d05b2ba11b.png\" alt=\"事件系统体系结构图\" width=\"500px\" height=\"300px\">\n" +
                        "    <h2>源程序代码结构</h2>\n" +
                        "    <pre>\n" +
                        "        <code>\n" +
                        "// 事件处理器\n" +
                        "void handleEvent(const Event& event) {\n" +
                        "    // 根据事件类型执行相应操作\n" +
                        "}\n" +
                        "\n" +
                        "int main() {\n" +
                        "    Event event;\n" +
                        "    // 模拟事件产生\n" +
                        "    handleEvent(event);\n" +
                        "    return 0;\n" +
                        "}\n" +
                        "        </code>\n" +
                        "    </pre>\n" +
                        "    <h2>特点</h2>\n" +
                        "    <ul>\n" +
                        "        <li>提高了程序的响应性和交互性。</li>\n" +
                        "        <li>解耦了事件的产生和处理，提高了代码的模块化。</li>\n" +
                        "        <li>易于扩展新的事件类型和处理器。</li>\n" +
                        "        <li>适用于需要处理大量异步事件的应用场景。</li>\n" +
                        "    </ul>\n" +
                        "    <h2>适用场景</h2>\n" +
                        "    <p>事件系统体系结构风格适用于需要实时响应用户操作或其他外部事件的场景，如交互式应用程序、游戏、嵌入式系统等。它也适用于需要处理大量并发事件的系统，如网络服务器。</p>\n" +
                        "</body>\n" +
                        "</html>");
        architectureInfo.put("管道-过滤器",
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>管道-过滤软件体系结构</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <h1>管道-过滤软件体系结构</h1>\n" +
                        "    <p>管道-过滤器体系结构风格是一种以数据流为中心的程序设计模式。在这种风格中，程序被组织为一系列过滤器，每个过滤器接收输入数据，对其进行处理，并将结果传递给下一个过滤器。这种风格使得数据处理流程可以灵活地组合和重用。</p>\n" +
                        "    <img src=\"https://i-blog.csdnimg.cn/blog_migrate/0ede4b22ba6baa0249e50dca465c497f.png\" alt=\"管道-过滤器体系结构图\" width=\"500px\" height=\"300px\">\n" +
                        "    <h2>源程序代码结构</h2>\n" +
                        "    <pre>\n" +
                        "        <code>\n" +
                        "// 过滤器基类\n" +
                        "class Filter {\n" +
                        "public:\n" +
                        "    virtual void process(std::string input) = 0;\n" +
                        "};\n" +
                        "\n" +
                        "// 具体过滤器\n" +
                        "class ConcreteFilter : public Filter {\n" +
                        "public:\n" +
                        "    void process(std::string input) override {\n" +
                        "        // 处理输入数据\n" +
                        "        std::string output = \"Processed: \" + input;\n" +
                        "        // 将输出传递给下一个过滤器\n" +
                        "        passToNextFilter(output);\n" +
                        "    }\n" +
                        "    \n" +
                        "    void passToNextFilter(std::string output) {\n" +
                        "        // 传递给下一个过滤器的逻辑\n" +
                        "    }\n" +
                        "};\n" +
                        "\n" +
                        "int main() {\n" +
                        "    ConcreteFilter filter;\n" +
                        "    filter.process(\"Input data\");\n" +
                        "    return 0;\n" +
                        "}\n" +
                        "        </code>\n" +
                        "    </pre>\n" +
                        "    <h2>特点</h2>\n" +
                        "    <ul>\n" +
                        "        <li>数据处理的模块化，每个过滤器只负责一部分数据处理。</li>\n" +
                        "        <li>易于扩展新的过滤器，提高了系统的可扩展性。</li>\n" +
                        "        <li>数据流的灵活性，可以轻松地改变数据流的方向和顺序。</li>\n" +
                        "        <li>适用于需要处理复杂数据流的应用场景。</li>\n" +
                        "    </ul>\n" +
                        "    <h2>适用场景</h2>\n" +
                        "    <p>管道-过滤器体系结构风格适用于需要处理大量数据流的场景，如文本处理、图像处理、网络数据包过滤等。它也适用于需要灵活组合数据处理步骤的系统，如数据分析。</p?" +
                        "</body>\n" +
                        "</html>");
    }

    private void updateInfoDisplay() {
        String selectedArchitecture = (String) infoComboBox.getSelectedItem();
        String info = architectureInfo.get(selectedArchitecture);
        infoEditorPane.setText(info);
    }

    private void browseFile(boolean input) {
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            if (input) {
                inputFilePathField.setText(file.getAbsolutePath());
            } else {
                outputFilePathField.setText(file.getAbsolutePath());
            }
        }
    }

    private void displayOutputFile(String filePath) {
        try {
            Path path = Paths.get(filePath);
            List<String> lines = Files.readAllLines(path);
            String content = String.join(System.lineSeparator(), lines);
            SwingUtilities.invokeLater(() -> resultTextArea.setText(content));
        } catch (IOException e) {
            e.printStackTrace();
            SwingUtilities.invokeLater(() -> resultTextArea.setText("无法读取输出文件。"));
        }
    }

    private void processWithMainProgramSubroutine() {
        String inputFilePath = inputFilePathField.getText();
        String outputFilePath = outputFilePathField.getText();
        new Thread(() -> {
            try {
                // 模拟主程序-子程序处理逻辑
                MainProgramSubroutine mp = new MainProgramSubroutine();
                mp.input(inputFilePath);
                mp.shift();
                mp.alphabetizer();
                mp.output(outputFilePath);
                SwingUtilities.invokeLater(() -> displayOutputFile(outputFilePath));
            } catch (IOException e) {
                e.printStackTrace();
                SwingUtilities.invokeLater(() -> resultTextArea.setText("处理过程中发生错误。"));
            }
        }).start();
    }

    private void processWithObjectOriented() {
        String inputFilePath = inputFilePathField.getText();
        String outputFilePath = outputFilePathField.getText();
        new Thread(() -> {
            // 模拟面向对象处理逻辑
            ObjectOrientedArchitecture oo = new ObjectOrientedArchitecture();
            oo.processFile(inputFilePath, outputFilePath);
            SwingUtilities.invokeLater(() -> displayOutputFile(outputFilePath));
        }).start();
    }

    private void processWithEventSystem() {
        String inputFilePath = inputFilePathField.getText();
        String outputFilePath = outputFilePathField.getText();
        new Thread(() -> {
            // 模拟事件系统处理逻辑
            EventSystemArchitecture es = new EventSystemArchitecture();
            es.processFile(inputFilePath, outputFilePath);
            SwingUtilities.invokeLater(() -> displayOutputFile(outputFilePath));
        }).start();
    }

    private void processWithPipelineFilter() {
        String inputFilePath = inputFilePathField.getText();
        String outputFilePath = outputFilePathField.getText();
        new Thread(() -> {
            // 模拟管道-过滤器处理逻辑
            PipelineFilterArchitecture pf = new PipelineFilterArchitecture();
            pf.processFile(inputFilePath, outputFilePath);
            SwingUtilities.invokeLater(() -> displayOutputFile(outputFilePath));
        }).start();
    }

    private void processSelectedArchitecture() {
        String selectedArchitecture = (String) architectureComboBox.getSelectedItem();
        switch (selectedArchitecture) {
            case "主程序-子程序":
                processWithMainProgramSubroutine();
                break;
            case "面向对象":
                processWithObjectOriented();
                break;
            case "事件系统":
                processWithEventSystem();
                break;
            case "管道-过滤器":
                processWithPipelineFilter();
                break;
        }
    }

    public static void main(String[] args) {
        new MainInterface();
    }
}