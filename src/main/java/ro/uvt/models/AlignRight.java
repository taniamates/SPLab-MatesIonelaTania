package ro.uvt.models;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph paragraph, Context context) {
        int spaces = context.getLineWidth() - paragraph.getText().length();
        System.out.println(" ".repeat(Math.max(0, spaces)) + paragraph.getText());
    }
}
