// LeetCode 65 - Valid Number

class Solution {
    public boolean isNumber(String s) {

        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean exponentSeen = false;
        boolean digitAfterExponent = true;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                digitSeen = true;

                if (exponentSeen) {
                    digitAfterExponent = true;
                }
            }

            else if (ch == '+' || ch == '-') {

                // Sign is allowed only at the beginning
                // or immediately after e/E
                if (i > 0 && s.charAt(i - 1) != 'e'
                        && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }

            else if (ch == '.') {

                // Dot is not allowed after exponent
                // or if another dot already exists
                if (dotSeen || exponentSeen) {
                    return false;
                }

                dotSeen = true;
            }

            else if (ch == 'e' || ch == 'E') {

                // Exponent requires a digit before it
                // and can appear only once
                if (exponentSeen || !digitSeen) {
                    return false;
                }

                exponentSeen = true;
                digitAfterExponent = false;
            }

            else {
                return false;
            }
        }

        return digitSeen && digitAfterExponent;
    }
}
