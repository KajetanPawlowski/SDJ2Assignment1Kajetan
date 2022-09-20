package com.example.sdj2assignment1;

public interface Subject {
    void attachObserver( Observer observer );

    void detachObserver( Observer observer);

    void notifyObservers();
}
