package Baekjoon;

//  연산자 a << b 정수 a의 2진수 값을 왼쪽으로 b만큼 이동시키고 나머지는 0으로 채움
//        a >> b 정수 a의 2진수 값을 오른쪽으로 b만큼 이동시키고 나머지를 양수는 0으로 음수는 1로 채움

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon11723 {
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{

        int bitset = 0;
        int m = Integer.parseInt(br.readLine());

        while(m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            int num;

            switch (op) {
                case "add" :
                    num = Integer.parseInt(st.nextToken());
                    bitset |= (1 << (num - 1));
                    break;

                case "remove" :
                    num = Integer.parseInt(st.nextToken());
                    bitset = bitset & ~ (1 << num-1);
                    break;
                case "check" :
                    num = Integer.parseInt(st.nextToken());
                    sb.append( (bitset & (1<<num-1)) !=0 ? "1\n" : "0\n");
                    break;
                case "toggle" :
                    num = Integer.parseInt(st.nextToken());
                    bitset ^= (1 << num-1);
                    break;
                case "all" :
                    bitset |= (~0);
                    break;
                case "empty" :
                    bitset &= 0;
                    break;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

}
