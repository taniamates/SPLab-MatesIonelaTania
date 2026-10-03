public class TableOfContents implements Element{
   private String text;
    public TableOfContents(String text)
    {
        this.text=text;
    }

@Override
    public void print(){
        System.out.println("Table of contents: /n"+text);
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
