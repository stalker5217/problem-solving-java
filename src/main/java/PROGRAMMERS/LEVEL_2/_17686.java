package PROGRAMMERS.LEVEL_2;

import java.util.ArrayList;
import java.util.List;

/**
 * [3차] 파일명 정렬
 */

public class _17686 {
    public static void main(String[] args) {
        Solution_17686 s = new Solution_17686();
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        for(String cur : s.solution(files)) System.out.println(cur);
    }
}

class Solution_17686 {
    public String[] solution(String[] files) {
        List<File> fileList = new ArrayList<>();
        for(String filename : files) fileList.add(getFile(filename));
        fileList.sort((a, b) -> {
            if(a.head.toLowerCase().compareTo(b.head.toLowerCase()) != 0) return a.head.toLowerCase().compareTo(b.head.toLowerCase());
            if(Integer.parseInt(a.number) != Integer.parseInt(b.number)) return Integer.parseInt(a.number) - Integer.parseInt(b.number);
            return 0;
        });

        String[] ret = new String[fileList.size()];
        for(int i = 0 ; i < ret.length ; i++){
            ret[i] = fileList.get(i).head + fileList.get(i).number + fileList.get(i).tail;
        }

        return ret;
    }

    private File getFile(String filename){
        int numStart = 0;
        for(int i = 0 ; i < filename.length() ; i++){
            if(filename.charAt(i) >= '0' && filename.charAt(i) <= '9'){
                numStart = i;
                break;
            }
        }

        int numEnd = filename.length();
        for(int i = numStart ; i < filename.length() ; i++){
            if(!(filename.charAt(i) >= '0' && filename.charAt(i) <= '9')){
                numEnd = i;
                break;
            }
        }

        String head = filename.substring(0, numStart);
        String number = filename.substring(numStart, numEnd);
        String tail = filename.substring(numEnd);

        return new File(head, number, tail);
    }
}

class File{
    public String head;
    public String number;
    public String tail;

    public File(String head, String number, String tail){
        this.head = head;
        this.number = number;
        this.tail = tail;
    }
}