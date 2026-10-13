import java.util.concurrent.TimeUnit;

public class Image implements Element{
    private String url;

    public Image(String url) {
        this.url = url;
        try {
            TimeUnit.SECONDS.sleep(5);   // simuleaza incarcarea unei imagini mari
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void render(){
        System.out.println("image: "+ url);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
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
