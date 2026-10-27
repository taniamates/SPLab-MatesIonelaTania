package ro.uvt.models;

import jakarta.persistence.Entity;
import java.util.concurrent.TimeUnit;

@Entity
public class Image extends BaseElement {
    private String url;

    protected Image() { }            // constructor gol, cerut de JPA (fara asteptare)

    public Image(String url) {
        this.url = url;
        try {
            TimeUnit.SECONDS.sleep(5);   // simuleaza incarcarea unei imagini mari
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getUrl() {
        return url;
    }

    public void render() {
        System.out.println("image: " + url);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
