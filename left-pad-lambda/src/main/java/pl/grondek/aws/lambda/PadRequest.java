package pl.grondek.aws.lambda;

public class PadRequest {
    private String string;
    private int size;
    private char character;

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }
}
