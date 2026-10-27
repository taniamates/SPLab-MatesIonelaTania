package ro.uvt.models;

public class Context {
    private final int lineWidth;   // cate caractere are un rand

    public Context(int lineWidth) {
        this.lineWidth = lineWidth;
    }

    public int getLineWidth() {
        return lineWidth;
    }
}
