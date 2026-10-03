import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
   private List<Author> authors=new ArrayList<>();
    private List<Element> elements=new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author name){
        authors.add(name);
    }
    public void addContent(Element element){

        elements.add(element);
    }

    public void print() {
        System.out.println(title);
        for(Author author : authors)
        {
            author.print();

        }
        for(Element element : elements)
        {
            element.print();
        }


    }
}
