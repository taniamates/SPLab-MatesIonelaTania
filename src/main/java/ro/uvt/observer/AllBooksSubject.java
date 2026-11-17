package ro.uvt.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Component;
import ro.uvt.models.Book;

// ConcreteSubject: un singur obiect (singleton), comun pentru toata aplicatia
@Component
public class AllBooksSubject implements Subject {

    // lista sigura cand mai multe cereri o folosesc in acelasi timp
    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(Book book) {
        for (Observer observer : observers) {
            try {
                observer.update(book);
            } catch (Exception e) {
                // pagina acestui observer nu mai e deschisa (ex. dupa refresh): il scoatem din lista
                // si continuam cu ceilalti, ca o pagina inchisa sa nu-i blocheze pe restul
                detach(observer);
            }
        }
    }

    // apelat din BooksController cand se salveaza o carte noua
    public void add(Book book) {
        notifyObservers(book);
    }
}
