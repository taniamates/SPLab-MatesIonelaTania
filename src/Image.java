public class Image implements Element{
    private String url;

    public Image(String url) {
        this.url = url;
    }


    @Override
    public void print(){
        System.out.println("image: "+ url);
    }

    @Override
    public void add(Element element){
        throw new UnsupportedOperationException("  nu poate contine un element");
    }
    @Override
    public void remove(Element element){
        throw new UnsupportedOperationException(" nu poate contine un element");
    }
    @Override
    public Element get(int index){
        throw new UnsupportedOperationException(" nu poate contine un element");
    }
}
