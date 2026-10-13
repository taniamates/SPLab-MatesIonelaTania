public class Paragraph implements Element{
    private String text;
    private AlignStrategy textAlignment;

    public  Paragraph(String text)
    {this.text=text;
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy textAlignment) {
        this.textAlignment = textAlignment;
    }

    public void render(){
        if (textAlignment == null) {
            System.out.println("Paragraph: "+ text);
        } else {
            textAlignment.render(this, new Context(40));
        }
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
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
