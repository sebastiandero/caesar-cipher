import cipher.CaesarCipher;

import java.util.Scanner;

public class Main {

    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welome to caesar-cipher!");
        short key = getKey();
        String text = getText();
        System.out.println(key + ", " + text);

        doOperation(key, text);
    }

    private static void doOperation(short key, String text) {
        CaesarCipher cipher = new CaesarCipher(key);
        while (true) {
            System.out.println(
                    "What do you want to do?(" + Operation.ENCRYPT + ", " + Operation.DECRYPT + ", " + Operation.EXIT +
                    "):");
            Operation operation = Operation.fromString(in.nextLine());
            if (operation != null) {
                switch (operation) {
                    case ENCRYPT:
                        System.out.println("Encryped: " + cipher.encrypt(text));
                        return;
                    case DECRYPT:
                        System.out.println("Decryped: " + cipher.decrypt(text));
                        return;
                    case EXIT:
                        System.out.println("Goodbye!");
                        return;
                }
            }
            System.out.println("Not a valid option!");
        }
    }

    private static short getKey() {
        short key;
        while (true) {
            System.out.println("Enter a key for the cipher(1-25):");
            key = in.nextShort();
            if (key <= 25 && key >= 1) {
                return key;
            } else {
                System.out.println("Please enter a number between(including) 1 and 25");
            }
        }
    }

    private static String getText() {
        String text;
        while (true) {
            System.out.println("Enter your text that you want to process:");
            text = in.nextLine();
            if (text == null || text.trim().equals("")) {
                System.out.println("Please enter a valid string.");
            } else {
                return text;
            }
        }
    }

    enum Operation {
        ENCRYPT("encrypt"), DECRYPT("decrypt"), EXIT("exit");

        private String character;

        Operation(String s) {
            character = s;
        }

        public static Operation fromString(String s) {
            if (s.equals(ENCRYPT.toString())) {
                return ENCRYPT;
            } else if (s.equals(DECRYPT.toString())) {
                return DECRYPT;
            } else if (s.equals(EXIT.toString())) {
                return EXIT;
            }
            return null;
        }

        @Override
        public String toString() {
            return character;
        }
    }
}
