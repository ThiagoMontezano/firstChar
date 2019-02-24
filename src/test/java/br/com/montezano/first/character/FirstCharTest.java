package br.com.montezano.first.character;

import br.com.montezano.first.character.exceptions.FirstUniqueVowelNotFoundException;
import br.com.montezano.first.character.stream.StreamImpl;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.security.InvalidParameterException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnit4.class)
public class FirstCharTest {

    private static final String EMPTY_STRING = "";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldFoundFirstCharSuccessfully() {
        assertThat(FirstChar.firstChar(new StreamImpl("aAbBABacafe")), is('e'));
        assertThat(FirstChar.firstChar(new StreamImpl("oUviu")), is('i'));
        assertThat(FirstChar.firstChar(new StreamImpl("iTA")), is('A'));
        assertThat(FirstChar.firstChar(new StreamImpl("aAbBABacafucafe")), is('u'));
        assertThat(FirstChar.firstChar(new StreamImpl("BbiABoAcacafucafe")), is('o'));
    }

    @Test()
    public void shouldValidateThatUniqueVowelWasNotFound() {
        expectedException.expect(FirstUniqueVowelNotFoundException.class);
        expectedException.expectMessage("Unique vowel not found in stream!");
        FirstChar.firstChar(new StreamImpl("aAbBABacafee"));
    }

    @Test
    public void shouldValidateInvalidParameter(){
        expectedException.expect(InvalidParameterException.class);
        expectedException.expectMessage("Please enter a valid stream!");
        FirstChar.firstChar(new StreamImpl(EMPTY_STRING));

    }
}