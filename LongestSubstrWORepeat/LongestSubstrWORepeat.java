import java.lang.Math;

public class LongestSubstrWORepeat {

    public static void main(String[] args) {
        // If any character in the parameter is not a lowercase latin letter, expect an integer.
        for (int i = 0; i < args[0].length(); i++) {
            if (args[0].charAt(i) < 97 || args[0].charAt(i) > 122) {
                try {
                    int len = Integer.parseInt(args[0]);
                    if (len < 1) throw new NumberFormatException("The length entered: " + args[0] + "was less than 1.");
                    // TODO: Run algorithm with a random string of length len.
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Enter either a string of all lowercase latin letters or a positive integer.");
                }
            }
        }
        // TODO: Run algorithm with the input string.
    }

    /**
     * Generates a random lower-case latin letter from a to z.
     * 
     * @return a random lower-case latin letter.
     */
    public static char randomChar() {
        // 97 is ASCII value of 'a'. 26 letters in alphabet.
        return (char) (Math.floor(Math.random() * 26) + 97);
    }

    /**
     * Generates a string of random lower-case latin letters with length len
     * 
     * @param len the length of the random array
     * @return a string of length len of random lower-case latin letters.
     */
    public static String randomString(int len) {
        // Create a randomized character array of length n.
        char[] arr = new char[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = randomChar();
        }

        return String.valueOf(arr);
    }
}