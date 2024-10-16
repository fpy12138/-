package 经典软件体系结构教学软件2.ObjectOrientedArchitecture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Shift {
    private ArrayList<String> kwicList = new ArrayList<>();
    private ArrayList<String> lineTxt;

    public Shift(ArrayList<String> lineTxt) {
        this.lineTxt = lineTxt;
    }

    public ArrayList<String> getKwicList() {
        return kwicList;
    }

    public void shift() {
        Iterator<String> it = lineTxt.iterator();
        while (it.hasNext()) {
            StringTokenizer token = new StringTokenizer(it.next());
            ArrayList<String> tokens = new ArrayList<>();
            int i = 0;
            int count = token.countTokens();
            while (i < count) {
                tokens.add(token.nextToken());
                i++;
            }

            for (i = 0; i < count; i++) {
                StringBuffer lineBuffer = new StringBuffer();
                int index = i;
                for (int f = 0; f < count; f++) {
                    if (index >= count)
                        index = 0;
                    lineBuffer.append(tokens.get(index));
                    lineBuffer.append(" ");
                    index++;
                }
                kwicList.add(lineBuffer.toString());
            }
        }
    }
}
