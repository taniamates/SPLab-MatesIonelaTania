public class ImageProxy implements Element {
    private String url;
    private Image realImage;

    public ImageProxy(String url) {
        this.url = url;
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
