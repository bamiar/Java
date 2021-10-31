package Test;


public class pPFRS4_1 {

    public static void main(String[] arg) {
        solution(new int[] {1, 5, 8, 2, 10, 5, 4, 6, 4, 8}); //효율성 0..
    }

    public static int[] solution(int[] waiting) {
        String list2 = "";

        for(int i=0; i<waiting.length; i++) {
            String user = "["+waiting[i]+"]";
            if(!list2.contains(user)) {
                list2 = list2.concat(user+",");
            }
        }

        list2 = list2.replace("[", "");
        list2 = list2.replace("]", "");

        String[] rst = list2.split(",");
        int[] answer = new int[rst.length];

        for(int i=0; i<rst.length; i++) {
            answer[i] = Integer.parseInt(rst[i]);
        }

        return answer;
    }
}
