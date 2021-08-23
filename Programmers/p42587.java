package Programmers;

import java.util.*;

class p42587 {
    public static void main(String[] a) {
        solution(new int[] {2,1,3,2}, 2);
    }

    public static int solution(int[] priorities, int location) {
        class Document{
            int prior, index;
            
            Document(int prior, int index) {
                this.prior = prior;
                this.index = index;
            }
        }

        int answer = 0;
        Queue<Document> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            queue.add(new Document(priorities[i],i));
        }

        Arrays.sort(priorities);

        for(int i=priorities.length-1; i>=0; i--) {
            while(queue.peek().prior!=priorities[i]) {
                Document doc = queue.poll();
                queue.add(doc);
            }

            ++answer;
            if(queue.poll().index==location) {
                break;
            }
        }

        return answer;
    }
}