package ro.uvt.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

// Clasa de sus a ierarhiei: JPA are nevoie de o clasa (nu interfata) pe care sa puna @Inheritance
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class BaseElement implements Element {

    @Id
    @GeneratedValue
    private Integer id;

    public Integer getId() {
        return id;
    }

    // Implicit, un element nu are copii; Section le suprascrie
    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("elementul nu poate contine alte elemente");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("elementul nu poate contine alte elemente");
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException("elementul nu poate contine alte elemente");
    }
}
