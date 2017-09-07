package cipher;

public class CaesarCipher {

    private short key;

    private final char UPPERCASE_START_POSITION = 'A';
    private final char UPPERCASE_END_POSITION   = 'Z';

    private final char LOWERCASE_START_POSITION = 'a';
    private final char LOWERCASE_END_POSITION   = 'z';


    public CaesarCipher(short key) {
        if (key > 25 || key < 1) {
            throw new IllegalArgumentException("key must be in the range [1; 25]");
        }
        this.key = key;
    }

    public String encrypt(String plainText) {
        return applyCipherKey(plainText, key);
    }

    public String decrypt(String plainText) {
        return applyCipherKey(plainText, (short) -key);
    }

    String applyCipherKey(String plainText, short key) {
        char[] plainChars = plainText.toCharArray();

        for(int i = 0; i < plainChars.length; i++) {
            if (Character.isUpperCase(plainChars[i])) {
                plainChars[i] = convertUppercaseChar(plainChars[i], key);
            } else if (Character.isLowerCase(plainChars[i])) {
                plainChars[i] = convertLowercaseChar(plainChars[i], key);
            }
        }

        return String.valueOf(plainChars);
    }

    char convertLowercaseChar(char character, short key) {
        char newCharacter = (char) (character + key);

        if (isLowerCase(newCharacter)) {
            return newCharacter;
        } else if (newCharacter > LOWERCASE_END_POSITION) {
            int overflow = newCharacter - LOWERCASE_END_POSITION - 1;
            return (char) (LOWERCASE_START_POSITION + overflow);
        } else {
            int overflow = LOWERCASE_START_POSITION - newCharacter - 1;
            return (char) (LOWERCASE_END_POSITION - overflow);
        }
    }

    char convertUppercaseChar(char character, short key) {
        char newCharacter = (char) (character + key);

        if (isUpperCase(newCharacter)) {
            return newCharacter;
        } else if (newCharacter > UPPERCASE_END_POSITION) {
            int overflow = newCharacter - UPPERCASE_END_POSITION - 1;
            return (char) (UPPERCASE_START_POSITION + overflow);
        } else {
            int overflow = UPPERCASE_START_POSITION - newCharacter - 1;
            return (char) (UPPERCASE_END_POSITION - overflow);
        }
    }

    boolean isUpperCase(char character) {
        return UPPERCASE_START_POSITION <= character && UPPERCASE_END_POSITION >= character;
    }

    boolean isLowerCase(char character) {
        return LOWERCASE_START_POSITION <= character && LOWERCASE_END_POSITION >= character;
    }
}
