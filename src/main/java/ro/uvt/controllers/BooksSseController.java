package ro.uvt.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.observer.AllBooksSubject;
import ro.uvt.observer.SseObserver;

@RestController
public class BooksSseController {
    private final AllBooksSubject allBooksSubject;

    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    // GET http://localhost:8080/books-sse  -> conexiunea ramane deschisa
    @GetMapping("/books-sse")
    public ResponseBodyEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter(0L);        // 0 = conexiunea nu expira
        final SseObserver observer = new SseObserver(emitter);
        allBooksSubject.attach(observer);                      // pagina e inscrisa in lista

        // cand pagina se inchide, o scoatem din lista
        emitter.onCompletion(() -> allBooksSubject.detach(observer));
        emitter.onError(e -> allBooksSubject.detach(observer));
        emitter.onTimeout(() -> allBooksSubject.detach(observer));

        return emitter;
    }
}
