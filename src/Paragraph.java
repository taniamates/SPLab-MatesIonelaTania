public class Paragraph implements Element{
    private String text;
    public  Paragraph(String text)
    {this.text=text;
    }

    @Override
    public void print(){
        System.out.println("Paragraph: "+ text);
    }

    @Override
    public void add(Element element){
        throw new UnsupportedOperationException(" paragraful nu poate contine un element");
    }
    @Override
    public void remove(Element element){
        throw new UnsupportedOperationException("paragraful nu poate contine un element");
    }
    @Override
    public Element get(int index){
        throw new UnsupportedOperationException("paragraful nu poate contine un element");
    }

}
