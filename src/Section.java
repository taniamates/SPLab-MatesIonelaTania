import java.util.ArrayList;
import java.util.List;

public class Section implements Element{
    private String title;
    List<Element>list =new ArrayList<>();
    public Section(String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public void render(){
        System.out.println(title);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element element : list) {
            element.accept(visitor);
        }
    }

    @Override
    public void add(Element element){
        list.add(element);
    }
    @Override
    public void remove(Element element){
        list.remove(element);
    }
    @Override
    public Element get(int index){
       return list.get(index);
    }
}
