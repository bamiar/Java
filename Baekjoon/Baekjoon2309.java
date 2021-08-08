package Baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class Baekjoon2309 { //bf
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 9;
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;

        for(int i=0; i<n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        for(int i : arr) {
            sum += i;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if (i==j) break;
                if (sum - arr.get(i) - arr.get(j)==100 ) {
                    arr.remove(i);
                    arr.remove(j);
                    break;
                }
            }
            if (arr.size()!=9)
                break;
        }
        arr.sort(Comparator.naturalOrder());

        for(int i : arr) {
            bw.write(i + "\n");
        }
        bw.flush();
    }
}
