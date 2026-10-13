public class ImageProxy implements Element {
    private String url;
    private Image realImage;   // imaginea adevarata; null pana cand e nevoie de ea

    public ImageProxy(String url) {
        this.url = url;        // doar retinem numele, nu incarcam nimic
    }

    private Image loadImage() {
        if (realImage == null) {
            realImage = new Image(url);   // aici se face incarcarea lenta, o singura data
        }
        return realImage;
    }

    @Override
    public void print() {
        loadImage().print();
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("imaginea nu poate contine un element");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("imaginea nu poate contine un element");
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException("imaginea nu poate contine un element");
    }
}
