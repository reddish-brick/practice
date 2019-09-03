package com.example.practice.DesignPattern.ObserverPattern.pullPattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {

  List<ReaderObserver> readerObservers = new ArrayList<>();

  void addReader(ReaderObserver reader) {
    readerObservers.add(reader);
  }

  void removeReader(ReaderObserver reader) {
    readerObservers.remove(reader);
  }

  void notifyObservers() {
    readerObservers.stream()
        .forEach(readerObserver -> readerObserver.update(this));
  }

}
