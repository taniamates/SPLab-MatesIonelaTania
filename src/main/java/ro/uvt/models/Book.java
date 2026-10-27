package ro.uvt.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book extends Section {

    // agregare: autorii exista si fara carte, deci nu se sterg odata cu ea
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Author> authors = new ArrayList<>();

    protected Book() { }             // constructor gol, cerut de JPA

    public Book(String title) {
        super(title);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addContent(Element element) {
        add(element);
    }

    @Override
    public void render() {
        System.out.println(getTitle());
        for (Author author : authors) {
            author.print();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);          // visit(Book), nu visit(Section)
        for (Element element : getChildren()) {
            element.accept(visitor);
        }
    }
}
