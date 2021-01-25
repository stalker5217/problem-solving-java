package PROGRAMMERS.LEVEL_1;

public class _72410 {
    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        Solution_72410 s = new Solution_72410();
        System.out.println(s.solution(new_id));
    }
}

class Solution_72410{
    public String solution(String new_id) {
        // Step 1
        new_id = new_id.toLowerCase();

        // Step 2
        StringBuilder temp = new StringBuilder();
        for(char cur : new_id.toCharArray()){
            if(isAlphabet(cur) || isNumber(cur) || cur == '-' || cur == '_' || cur == '.'){
                temp.append(cur);
            }
        }
        new_id = temp.toString();

        // Step 3
        temp = new StringBuilder();
        for(int i = 0 ; i < new_id.length() ; i++){
            if(i < new_id.length() - 1 && new_id.charAt(i) == '.' && new_id.charAt(i+1) == '.') continue;
            temp.append(new_id.charAt(i));
        }
        new_id = temp.toString();

        // Step 4
        if(new_id.equals(".") || new_id.equals("..")) new_id = "";
        else{
            if(new_id.charAt(0) == '.') new_id = new_id.substring(1);
            if(new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, new_id.length() - 1);
        }

        // Step 5
        if(new_id.equals("")) new_id = "a";

        // Step 6
        if(new_id.length() > 15){
            new_id = new_id.substring(0, 15);
            if(new_id.charAt(new_id.length() - 1) == '.') new_id = new_id.substring(0, 14);
        }

        // Step 7
        temp = new StringBuilder(new_id);
        while(temp.length() <= 2){
            temp.append(new_id.charAt(new_id.length() - 1));
        }
        new_id = temp.toString();

        return new_id;
    }

    private boolean isAlphabet(char c){
        return c >= 'a' && c <= 'z';
    }

    private boolean isNumber(char c){
        return c >= '0' && c <= '9';
    }
}
