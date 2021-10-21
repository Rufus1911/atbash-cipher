public class Main {
    public static void main(String []args){
        System.out.println(cipherFeed("Did you know that meat is an anagram for team?"));
        System.out.println(cipherFeed("The quick brown fox jumps over the lazy dog")); //a pangram used to test typefaces
        System.out.println(cipherFeed("Sphinx of black quartz, judge my vow")); //much more intense way to test a typeface
    }

    public static char cipherize(char c){
        boolean isLetter = Character.isAlphabetic(c);
        boolean isUpper = Character.isUpperCase(c);
        //boundaries
        int bottomBound;
        int topBound;
        //returned value if modified
        char cipher;
        int cipherInt;

        if (!isLetter){ //if not a letter in the alphabet
            return c; //do not alter it
        }

        //this code only executes if the character is a letter in the alphabet

        if (isUpper){ // if an uppercase letter specifically
            bottomBound = 64;
            topBound = 91;
        }
        else { //if a lowercase letter
            bottomBound = 96;
            topBound = 123;
        }

        //calculate and return the "cipherized" character
        cipherInt = (topBound - ((int)c - bottomBound));
        cipher = (char)cipherInt;
        return cipher;

    }

    //"Feeds" into the cipherize method and collects the result in a stringbuilder
    public static String cipherFeed(String s){
        StringBuilder cipherized = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            cipherized.append(cipherize(s.charAt(i)));
        }
        return cipherized.toString();
    }


}
