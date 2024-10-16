package 经典软件体系结构教学软件2.EventSystemArchitecture;

import java.util.ArrayList;
import java.util.List;

class KWICSubject {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.toDo();
        }
    }
}
