package 经典软件体系结构教学软件2.EventSystemArchitecture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

class ShiftObserver extends Observer {
    private ArrayList<String> kwicList = new ArrayList<>();
    private ArrayList<String> lineTxt;

    public void setLineTxt(ArrayList<String> lineTxt) {
        this.lineTxt = lineTxt;
    }

    @Override
    public void toDo() {
        for (String line : lineTxt) {
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
                kwicList.add(lineBuffer.toString().trim());
            }
        }
    }

    public ArrayList<String> getKwicList() {
        return kwicList;
    }
}