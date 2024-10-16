package 经典软件体系结构教学软件2.EventSystemArchitecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class AlphabetizerObserver extends Observer {
    private ArrayList<String> kwicList;

    public void setKwicList(ArrayList<String> kwicList) {
        this.kwicList = kwicList;
    }

    @Override
    public void toDo() {
        Collections.sort(kwicList, String.CASE_INSENSITIVE_ORDER);
    }

    public ArrayList<String> getKwicList() {
        return kwicList;
    }
}