
// LeetCode 443 - String Compression

class Solution {
    public int compress(char[] chars) {

        int write = 0;
        int read = 0;

        while (read < chars.length) {

            char currentChar = chars[read];
            int count = 0;

            // Count consecutive repeating characters
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = currentChar;

            // Write the count if greater than 1
            if (count > 1) {
                String countStr = String.valueOf(count);

                for (int i = 0; i < countStr.length(); i++) {
                    chars[write++] = countStr.charAt(i);
                }
            }
        }

        return write;
    }
}
