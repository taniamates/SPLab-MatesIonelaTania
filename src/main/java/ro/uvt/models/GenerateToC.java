package ro.uvt.models;

import java.util.ArrayList;
import java.util.List;

public class GenerateToC implements Visitor {
    private List<String> entries = new ArrayList<>();   // randurile cuprinsului
    private int pagesUsed = 0;                          // cate pagini au fost ocupate pana acum

    @Override
    public void visit(Book book) { }                    // cartea nu apare in cuprins

    @Override
    public void visit(Section section) {
        int startPage = pagesUsed + 1;                  // sectiunea incepe pe urmatoarea pagina libera
        entries.add(section.getTitle() + " ........ " + startPage);
    }

    @Override
    public void visit(TableOfContents tableOfContents) { }   // cuprinsul nu se numara

    @Override
    public void visit(Paragraph paragraph) { pagesUsed++; }

    @Override
    public void visit(ImageProxy imageProxy) { pagesUsed++; }

    @Override
    public void visit(Image image) { pagesUsed++; }

    @Override
    public void visit(Table table) { pagesUsed++; }

    public TableOfContents getToC() {
        return new TableOfContents(String.join("\n", entries));
    }
}
