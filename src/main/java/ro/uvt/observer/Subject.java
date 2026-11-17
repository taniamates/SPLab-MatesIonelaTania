package ro.uvt.observer;

import ro.uvt.models.Book;

// Cine tine lista de observeri si ii anunta
public interface Subject {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers(Book book);
}
