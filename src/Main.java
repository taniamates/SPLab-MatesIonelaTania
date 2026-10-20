public class Main {
    public static void main(String[] args) throws Exception {
        Section cap1 = new Section("Capitolul 1");
        Paragraph p1 = new Paragraph("Paragraph 1");
        cap1.add(p1);
        Paragraph p2 = new Paragraph("Paragraph 2");
        cap1.add(p2);
        Paragraph p3 = new Paragraph("Paragraph 3");
        cap1.add(p3);
        Paragraph p4 = new Paragraph("Paragraph 4");
        cap1.add(p4);
        cap1.add(new ImageProxy("ImageOne"));
        cap1.add(new Image("ImageTwo"));
        cap1.add(new Paragraph("Some text"));
        cap1.add(new Table("Table 1"));

        BookStatistics stats = new BookStatistics();
        cap1.accept(stats);
        stats.printStatistics();

        // O carte intreaga, pentru render si cuprins
        Book book = new Book("Carte de test");
        book.addAuthor(new Author("Radu Pavel"));
        book.addContent(cap1);

        Section cap2 = new Section("Capitolul 2");
        cap2.add(new Paragraph("Introducere capitol 2"));
        Section cap21 = new Section("Capitolul 2.1");
        cap21.add(new Paragraph("Text 2.1 a"));
        cap21.add(new Paragraph("Text 2.1 b"));
        cap2.add(cap21);
        cap2.add(new Table("Table 2"));
        book.addContent(cap2);

        System.out.println();
        System.out.println("Render:");
        book.accept(new RenderContentVisitor());

        System.out.println();
        GenerateToC tocVisitor = new GenerateToC();
        book.accept(tocVisitor);
        tocVisitor.getToC().render();
    }
}
