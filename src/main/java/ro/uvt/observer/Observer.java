package ro.uvt.observer;

import ro.uvt.models.Book;

// Cine vrea sa fie anuntat cand apare o carte noua
public interface Observer {
    void update(Book book);
}
