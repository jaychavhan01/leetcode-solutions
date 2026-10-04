class Solution {
    public int compress(char[] chars) {

        int i = 0;          // read pointer
        int index = 0;      // write pointer

        while (i < chars.length) {

            char current = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == current) {
                i++;
                count++;
            }

            // write character
            chars[index++] = current;

            // write count if > 1
            if (count > 1) {

                // convert count to string
                String cnt = String.valueOf(count);

                // write each digit
                for (char c : cnt.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}