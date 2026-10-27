package ro.uvt.persistence;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Component;
import ro.uvt.models.Book;

// Adapter: face ca BooksRepository (Spring Data) sa arate ca CrudRepository (al nostru)
@Component
public class BooksRepositoryAdapter implements CrudRepository<Book, Integer> {
    private final BooksRepository booksRepository;

    public BooksRepositoryAdapter(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Integer id) {
        return booksRepository.findById(id);
    }

    @Override
    public Book save(Book book) {
        return booksRepository.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        booksRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return booksRepository.existsById(id);
    }
}
