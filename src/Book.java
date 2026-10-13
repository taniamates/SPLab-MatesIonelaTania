import java.util.ArrayList;
import java.util.List;

public class Book extends Section {
    private List<Author> authors=new ArrayList<>();

    public Book(String title) {
        super(title);
    }

    public void addAuthor(Author name){
        authors.add(name);
    }

    public void addContent(Element element){
        add(element);
    }

    @Override
    public void render() {
        System.out.println(getTitle());
        for(Author author : authors)
        {
            author.print();
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);          // visit(Book), nu visit(Section)
        for (Element element : list) {
            element.accept(visitor);
        }
    }
}
