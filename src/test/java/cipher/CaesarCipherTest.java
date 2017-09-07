package cipher;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CaesarCipherTest {

    private CaesarCipher caesarCipher;

    @Before
    public void setup() {
        caesarCipher = new CaesarCipher((short) 12);
    }

    @Test
    public void testIsUpperCase() {
        assertThat(caesarCipher.isUpperCase('A'), equalTo(true));
    }

    @Test
    public void testIsUpperCaseWithLowerCase() {
        assertThat(caesarCipher.isUpperCase('z'), equalTo(false));
    }

    @Test
    public void testIsUpperCasePunctuation() {
        assertThat(caesarCipher.isUpperCase('.'), equalTo(false));
    }

    @Test
    public void testIsLowerCase() {
        assertThat(caesarCipher.isLowerCase('a'), equalTo(true));
    }

    @Test
    public void testIsLowerCaseWithUpperCase() {
        assertThat(caesarCipher.isLowerCase('Z'), equalTo(false));
    }

    @Test
    public void testIsLowerCasePunctuation() {
        assertThat(caesarCipher.isLowerCase('.'), equalTo(false));
    }

    @Test
    public void testConvertUppercaseChar() {
        assertThat(caesarCipher.convertUppercaseChar('A', (short) 25), equalTo('Z'));
    }

    @Test
    public void testConvertUppercaseCharWithOverflow() {
        assertThat(caesarCipher.convertUppercaseChar('B', (short) 25), equalTo('A'));
    }

    @Test
    public void testConvertUppercaseCharNegativeKey() {
        assertThat(caesarCipher.convertUppercaseChar('B', (short) -1), equalTo('A'));
    }

    @Test
    public void testConvertUppercaseCharWithOverflowNegativeKey() {
        assertThat(caesarCipher.convertUppercaseChar('A', (short) -1), equalTo('Z'));
    }

    @Test
    public void testConvertLowercaseChar() {
        assertThat(caesarCipher.convertLowercaseChar('a', (short) 25), equalTo('z'));
    }

    @Test
    public void testConvertLowercaseCharWithOverflow() {
        assertThat(caesarCipher.convertLowercaseChar('b', (short) 25), equalTo('a'));
    }

    @Test
    public void testConvertLowercaseCharNegativeKey() {
        assertThat(caesarCipher.convertLowercaseChar('b', (short) -1), equalTo('a'));
    }

    @Test
    public void testConvertLowercaseCharWithOverflowNegativeKey() {
        assertThat(caesarCipher.convertLowercaseChar('a', (short) -1), equalTo('z'));
    }

    @Test
    public void testApplyCipherKey() {
        assertThat(caesarCipher.applyCipherKey("abc", (short) 10), equalTo("klm"));
    }
    @Test
    public void testApplyCipherKeyReverse(){
        assertThat(caesarCipher.applyCipherKey("klm", (short) -10), equalTo("abc"));
    }

    @Test
    public void testEncrypt(){
        assertThat(caesarCipher.encrypt("I love cheese."), equalTo("U xahq otqqeq."));
    }

    @Test
    public void testDecrypt(){
        assertThat(caesarCipher.decrypt("U xahq otqqeq."), equalTo("I love cheese."));
    }
}