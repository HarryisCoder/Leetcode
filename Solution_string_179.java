import java.util.Arrays;
import java.util.Comparator;

public class Solution_string_179 {
    public String largestNumber(int[] nums) {
        
        String result = new String("");
        int num = nums.length;
        if(num > 0){
            String[] strings = new String[num];
            for(int i = 0; i < num; i++){
                strings[i] = String.valueOf(nums[i]);
                System.out.println(strings[i]);
            } 
            Arrays.sort(strings, new IntStringComparator());
            
            for(int i = 0; i < num; i++){
                result = result + strings[i];
            }

            System.out.println("result.charAt(0): " + result.charAt(0));
            if(result.charAt(0) == '0'){
                return "0";
            }
        }
        return result;
    }
}

class IntStringComparator implements Comparator<String>{
    public int compare(String a, String b){
        
        //int lenA = a.length();
        //int lenB = b.length();
        int maxLen = a.length() + b.length();
        String ab = a + b;
        String ba = b + a;
        System.out.println("ab " + ab);
        System.out.println("ba " + ba);

        int i = 0;
        while(i < maxLen && ab.charAt(i) == ba.charAt(i)){
            i++;
        }
        if(i < maxLen){
            System.out.println("a.charAt(i) " + ab.charAt(i));
            System.out.println("b.charAt(i) " + ba.charAt(i));
            System.out.println();
            return(ba.charAt(i) - ab.charAt(i));
        }
        return 0;
    }

}