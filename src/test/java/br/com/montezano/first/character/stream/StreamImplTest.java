package br.com.montezano.first.character.stream;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class StreamImplTest {

    private static final String EMPTY_STRING = "";

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Stream stream;

    @Before
    public void setUp() {
        stream = new StreamImpl("aAbBABacafe");
    }

    @Test
    public void shouldValidateAllGetNext() {
        assertThat(stream.getNext(), is('a'));
        assertThat(stream.getNext(), is('A'));
        assertThat(stream.getNext(), is('b'));
        assertThat(stream.getNext(), is('B'));
        assertThat(stream.getNext(), is('A'));
        assertThat(stream.getNext(), is('B'));
        assertThat(stream.getNext(), is('a'));
        assertThat(stream.getNext(), is('c'));
        assertThat(stream.getNext(), is('a'));
        assertThat(stream.getNext(), is('f'));
        assertThat(stream.getNext(), is('e'));
    }

    @Test
    public void shouldValidateAllHasNext() {
        assertThat(stream.getNext(), is('a'));
        assertTrue(stream.hasNext());
        assertThat(stream.getNext(), is('A'));
        assertTrue(stream.hasNext());
        assertThat(stream.getNext(), is('b'));
        assertTrue(stream.hasNext());
        assertThat(stream.getNext(), is('B'));
        assertTrue(stream.hasNext());
        assertThat(stream.getNext(), is('A'));
        assertTrue(stream.hasNext());
        assertThat(stream.getNext(), is('B'));
        assertTrue(stream.hasNext());
        assertThat(stream.getNext(), is('a'));
        assertTrue(stream.hasNext());
        assertThat(stream.getNext(), is('c'));
        assertTrue(stream.hasNext());
        assertThat(stream.getNext(), is('a'));
        assertTrue(stream.hasNext());
        assertThat(stream.getNext(), is('f'));
        assertTrue(stream.hasNext());
        assertThat(stream.getNext(), is('e'));
        assertFalse(stream.hasNext());
    }

    @Test
    public void IndexOutOfBoundsExceptionBecauseEmptyString() {
        expectedException.expect(StringIndexOutOfBoundsException.class);
        final Stream emptyStream = new StreamImpl(EMPTY_STRING);
        assertFalse(emptyStream.hasNext());
        emptyStream.getNext();
    }


}