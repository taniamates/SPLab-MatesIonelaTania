package ro.uvt.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class ImageProxy extends BaseElement {
    private String url;

    @Transient                       // imaginea reala nu se salveaza, se incarca la nevoie
    private Image realImage;

    protected ImageProxy() { }       // constructor gol, cerut de JPA

    public ImageProxy(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    private Image loadImage() {
        if (realImage == null) {
            realImage = new Image(url);
        }
        return realImage;
    }

    public void render() {
        loadImage().render();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
