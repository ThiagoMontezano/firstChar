package br.com.montezano.first.character.stream;

public class StreamImpl implements Stream {

    private final String input;
    private final Integer size;
    private Integer nextCharIndex;

    public StreamImpl(String input) {
        this.input = input;
        this.size = input.length();
        this.nextCharIndex = 0;
    }

    @Override
    public char getNext() {
        return input.charAt(this.nextCharIndex++);
    }

    @Override
    public boolean hasNext() {
        return this.nextCharIndex < this.size;
    }

}
