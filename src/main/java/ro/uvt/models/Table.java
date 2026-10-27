package ro.uvt.models;

import jakarta.persistence.Entity;

@Entity
public class Table extends BaseElement {
    private String something;

    protected Table() { }            // constructor gol, cerut de JPA

    public Table(String something) {
        this.something = something;
    }

    public String getSomething() {
        return something;
    }

    public void render() {
        System.out.println("table: " + something);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
