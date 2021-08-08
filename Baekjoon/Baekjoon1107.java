package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1107 { //bf
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String[] input = new String[m];

        if(m>0) {input = br.readLine().split(" ");}
        Boolean[] broken = new Boolean[10];

        for(int i=0; i<10; i++) {
            broken[i] = false;
        }

        if(input.length!=0) {
            while (m-- > 0) {
                broken[Integer.parseInt(input[m])] = true;
            }
        }

        int ans = Math.abs(n-100); //초기값에서 +- 버튼으로만 움직이는 횟수

        for(int i=0; i<1000000; i++) {
            int c = 0;
            //i번 채널로 이동할 수 있는지 체크

            //i번 채널로 이동 + +- 버튼 누른 횟수와 ans 비교
            //ans 에 최소값 대입
            c = checker(broken, i); //체커에서 나온 길이에
            if(c>0) {
                c += Math.abs(n-i);
                if(ans>c) {
                    ans = c;
                }
            } //현재 i 값-> n 값으로 이동하는데 드는 이동버튼 횟수를 추가
        }

        System.out.println(ans);

    }

    static int checker (Boolean[] broken, int n) {
        if (n==0) {
            if(!broken[0]) {
                return 1;
            } else return 0;
        }
        int c = 0;
        while (n > 0) {
            int i =n%10;
            n = n/10;
            if (broken[i]) {
                return 0;
            } else c++;
        }
        return c;
    }
}
