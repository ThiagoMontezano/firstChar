package br.com.montezano.first.character;

import br.com.montezano.first.character.exceptions.FirstUniqueVowelNotFoundException;
import br.com.montezano.first.character.stream.Stream;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FirstChar {

    private static final String VOWELS = "aáàãâAÁÀÃÂeéêEÉÊiíIÍoóõôOÓÕÔuúUÚ";

    public static char firstChar(final Stream input) {
        validate(input);
        final List<Character> uniqueVowels = getUniqueVowels(input);
        return getFirstUniqueVowels(uniqueVowels);
    }

    private static void validate(Stream input) {
        if (!input.hasNext()){
            throw new InvalidParameterException("Please enter a valid stream!");
        }
    }

    private static List<Character> getUniqueVowels(final Stream input) {
        Set<Character> allVowels = new HashSet<>();
        List<Character> uniqueVowels = new ArrayList<>();

        Character actual = input.getNext();
        Character predecessorOne = actual;
        Character predecessorTwo = actual;

        while (input.hasNext()) {
            actual = input.getNext();
            if (isVowel(actual)) {
                if (allVowels.add(actual)) {
                    if (verifyPredecessorsRule(predecessorOne, predecessorTwo)) {
                        uniqueVowels.add(actual);
                    }
                } else {
                    uniqueVowels.remove(actual);
                }
            }
            predecessorOne = predecessorTwo;
            predecessorTwo = actual;
        }
        return uniqueVowels;
    }

    private static boolean isVowel(final Character character) {
        return VOWELS.contains(character.toString());
    }

    private static boolean verifyPredecessorsRule(Character predecessorOne, Character predecessorTwo ) {
        return isVowel(predecessorOne) && !isVowel(predecessorTwo);
    }

    private static Character getFirstUniqueVowels(List<Character> uniqueVowels) {
        return uniqueVowels
                .stream()
                .findFirst()
                .orElseThrow(() -> new FirstUniqueVowelNotFoundException());
    }

}
