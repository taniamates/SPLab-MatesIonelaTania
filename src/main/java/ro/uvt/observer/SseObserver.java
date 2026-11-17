package ro.uvt.observer;

import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.models.Book;

// ConcreteObserver: unul pentru fiecare pagina deschisa; tine conexiunea ei
public class SseObserver implements Observer {
    private final SseEmitter emitter;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;
    }

    @Override
    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);   // trimite cartea ca JSON paginii
        } catch (IOException | IllegalStateException e) {
            // pagina s-a inchis sau conexiunea e deja terminata
            throw new IllegalStateException("Conexiunea SSE nu mai e deschisa", e);
        }
    }
}
