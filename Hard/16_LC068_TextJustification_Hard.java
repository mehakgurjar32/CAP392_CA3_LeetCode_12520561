
// LeetCode 68 - Text Justification

import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;

        while (i < n) {

            int j = i;
            int letters = 0;

            // Find maximum words that fit in the current line
            while (j < n && letters + words[j].length() + (j - i) <= maxWidth) {
                letters += words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            int spaces = maxWidth - letters;

            StringBuilder line = new StringBuilder();

            // Last line or line containing only one word
            if (j == n || gaps == 0) {

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        line.append(" ");
                    }
                }

                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }

            // Fully justify the line
            else {

                int spacePerGap = spaces / gaps;
                int extraSpaces = spaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);

                    if (k < j - 1) {
                        int count = spacePerGap;

                        if (extraSpaces > 0) {
                            count++;
                            extraSpaces--;
                        }

                        for (int x = 0; x < count; x++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}
