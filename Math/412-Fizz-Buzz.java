import java.util.ArrayList;
import java.util.List;
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> set = new ArrayList<>();
        for(int i = 1;i<=n;i++) {
            if(i%3==0&&i%5==0) {
                set.add("FizzBuzz");
            }
            else if(i%3==0) {
                set.add("Fizz");
            }
            else if(i%5==0) {
                set.add("Buzz");
            }
            else {
                String str = (String.valueOf(i));
                set.add(str);
            }
        }
        return set;
    }
}