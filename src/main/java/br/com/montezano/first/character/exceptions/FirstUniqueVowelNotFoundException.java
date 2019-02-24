package br.com.montezano.first.character.exceptions;

public class FirstUniqueVowelNotFoundException extends RuntimeException {

    public FirstUniqueVowelNotFoundException() {
        super("Unique vowel not found in stream!");
    }

}
