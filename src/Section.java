import java.util.ArrayList;
import java.util.List;

public class Section implements Element{
    private String title;
    List<Element>list =new ArrayList<>();
    public Section(String title){
        this.title=title;
    }

    @Override
    public void print(){
        System.out.println( title);
        for(Element element : list)
        {
            element.print();
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
