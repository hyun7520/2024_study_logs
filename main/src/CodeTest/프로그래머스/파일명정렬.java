package CodeTest.프로그래머스;

import java.util.Arrays;
import java.util.Comparator;

public class 파일명정렬 {
    public static void main(String[] args) {
        파일명정렬Solution sol = new 파일명정렬Solution();

        System.out.println(Arrays.toString(
                sol.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})
        ));
    }
}

class 파일명정렬Solution {
    public String[] solution(String[] files) {

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] fileO1 = separateFileName(o1.toLowerCase());
                String[] fileO2 = separateFileName(o2.toLowerCase());

                int compare = fileO1[0].compareTo(fileO2[0]);

                if(compare == 0) {
                    int numberO1 = Integer.parseInt(fileO1[1]);
                    int numberO2 = Integer.parseInt(fileO2[1]);
                    return numberO1 - numberO2;
                }

                return compare;
            }
        });

        return files;
    }

    public String[] separateFileName(String file) {

        String head = file.split("[0-9]")[0];
        String number = file.substring(head.length());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < number.length(); i++) {
            if(Character.isDigit(number.charAt(i)) && i < 5) {
                sb.append(number.charAt(i));
            } else {
                break;
            }
        }
        number = sb.toString();

        return new String[] {head, number};
    }
}