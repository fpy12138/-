package 经典软件体系结构教学软件2.ObjectOrientedArchitecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Alphabetizer {
    private ArrayList<String> kwicList;

    public Alphabetizer(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

    public ArrayList<String> getKwicList() {
        return kwicList;
    }

    public void sort() {
        Collections.sort(kwicList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.toLowerCase().charAt(0) - o2.toLowerCase().charAt(0);
            }
        });
    }
}
