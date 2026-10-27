package ro.uvt.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.uvt.models.Author;
import ro.uvt.models.Book;
import ro.uvt.models.ImageProxy;
import ro.uvt.models.Paragraph;
import ro.uvt.models.Section;
import ro.uvt.models.Table;
import ro.uvt.persistence.CrudRepository;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final CrudRepository<Book, Integer> booksRepository;

    // Spring injecteaza adapter-ul (singura clasa care implementeaza CrudRepository<Book, Integer>)
    public BooksController(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }

    // GET http://localhost:8080/books
    @GetMapping
    public List<Book> getAll() {
        return booksRepository.findAll();
    }

    // GET http://localhost:8080/books/1
    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") Integer id) {
        return booksRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST http://localhost:8080/books   body: {"title": "...", "authors": ["..."]}
    @PostMapping
    public ResponseEntity<Book> create(@RequestBody BookRequest request) {
        Book book = new Book(request.title());
        if (request.authors() != null) {
            for (String name : request.authors()) {
                book.addAuthor(new Author(name));
            }
        }
        book = booksRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    // PUT http://localhost:8080/books/1   body: {"title": "Titlu nou"}
    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable("id") Integer id, @RequestBody BookRequest request) {
        return booksRepository.findById(id)
                .map(book -> {
                    book.setTitle(request.title());
                    return ResponseEntity.ok(booksRepository.save(book));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE http://localhost:8080/books/1
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        if (!booksRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        booksRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // POST http://localhost:8080/books/sample  -> o carte cu capitole, ca sa vezi relatiile in baza de date
    @PostMapping("/sample")
    public ResponseEntity<Book> createSample() {
        Book book = new Book("Carte de test");
        book.addAuthor(new Author("Radu Pavel"));

        Section cap1 = new Section("Capitolul 1");
        cap1.add(new Paragraph("Paragraph 1"));
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Table("Table 1"));
        book.addContent(cap1);

        Section cap2 = new Section("Capitolul 2");
        cap2.add(new Paragraph("Introducere capitol 2"));
        Section cap21 = new Section("Capitolul 2.1");
        cap21.add(new Paragraph("Text 2.1"));
        cap2.add(cap21);
        book.addContent(cap2);

        book = booksRepository.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }
}
