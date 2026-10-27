package ro.uvt.models;

import jakarta.persistence.Entity;

@Entity
public class TableOfContents extends BaseElement {
    private String text;

    protected TableOfContents() { }  // constructor gol, cerut de JPA

    public TableOfContents(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void render() {
        System.out.println("Table of contents: \n" + text);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
