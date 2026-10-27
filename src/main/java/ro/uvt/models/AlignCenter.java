package ro.uvt.models;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, Context context) {
        int spaces = (context.getLineWidth() - paragraph.getText().length()) / 2;
        System.out.println(" ".repeat(Math.max(0, spaces)) + paragraph.getText());
    }
}
