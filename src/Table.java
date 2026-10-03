public class Table implements Element{
private String something;

    public Table(String something) {
        this.something = something;
    }
    @Override
    public void print(){
        System.out.println("table: "+ something);
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
