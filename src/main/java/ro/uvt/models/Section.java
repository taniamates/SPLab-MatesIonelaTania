package ro.uvt.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderColumn;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Section extends BaseElement {
    private String title;

    // compozitie: copiii se salveaza si se sterg odata cu sectiunea
    @OneToMany(targetEntity = BaseElement.class, cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderColumn                     // pastreaza ordinea copiilor si in baza de date
    private List<Element> children = new ArrayList<>();

    protected Section() { }          // constructor gol, cerut de JPA

    public Section(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Element> getChildren() {
        return children;
    }

    public void render() {
        System.out.println(title);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Element element : children) {
            element.accept(visitor);
        }
    }

    @Override
    public void add(Element element) {
        children.add(element);
    }

    @Override
    public void remove(Element element) {
        children.remove(element);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }
}
