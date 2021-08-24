package Programmers;

import java.util.*;

class p84325 {
    public static void main(String[] a) {
        // solution(new String[] {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"}, 
        // new String[] {"PYTHON", "C++", "SQL"}, new int[] {7, 5, 5});

        solution(new String[] {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"}, 
        new String[] {"JAVA", "JAVASCRIPT"}, new int[] {7,5});
    }

    public static String solution(String[] table, String[] languages, int[] preference) {
        List<String[]> fields = new ArrayList<>();
        int[] score = new int[] {-1,5,4,3,2,1};
        int max = -1;
        int maxIndex = -1;

        for(String t : table) {
            fields.add(t.split(" "));
        }
        int[] result = new int[fields.size()];
        //스플릿 인덱스 번호 *  language 인덱스의 preference 값 = 총 가중치
        for(int i=0; i<fields.size(); i++) { //직업분야 인덱스
            for(int k=0; k<languages.length; k++){
                for(int j=1; j<fields.get(i).length; j++) {
                    if(languages[k].equals(fields.get(i)[j])) {
                        result[i] += preference[k] * score[j]; 
                        break;
                    }
                }
            }
        }
        
        for(int i=0; i<result.length; i++) {
            if(result[i]>max) {
                max = result[i];
                maxIndex = i;
            } else if(result[i]==max) {
                maxIndex = fields.get(i)[0].compareTo(fields.get(maxIndex)[0])<0?i:maxIndex;
            }
        }
        
        return fields.get(maxIndex)[0];
    }
}