public interface Element {
    public void accept(Visitor visitor);
    public void add(Element element);
    public void remove(Element element);
    public Element get(int index);

}
