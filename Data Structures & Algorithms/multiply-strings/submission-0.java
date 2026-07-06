class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        if(num1.length() < num2.length()){
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        String ans = "";
        int zeroes = 0;
        for(int i = num2.length() - 1; i >= 0; i--){
            String product = mult(num1, num2.charAt(i), zeroes);
            ans = add(ans, product);
            zeroes++;
        }
        return ans;
    }
    public String mult(String num, char digitChar, int zeroes){
        int i = num.length() - 1;
        int digit = digitChar - '0';
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while(i >= 0 || carry > 0){
            int digitInNum = i >= 0 ? num.charAt(i--)-'0' : 0;
            int result = digitInNum * digit + carry;
            ans.append(result%10);
            carry = result / 10;
        }
        return ans.reverse().toString() + "0".repeat(zeroes);
    }
    public String add(String num1, String num2){
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while(i >= 0 || j >= 0 || carry > 0){
            int a = i >= 0 ? num1.charAt(i)-'0' : 0;
            int b = j >= 0 ? num2.charAt(j)-'0' : 0;
            int here = (a + b + carry) % 10;
            ans.append(here);
            carry = (a + b + carry) / 10;
            i--;
            j--;
        }
        return ans.reverse().toString();
    }
}
