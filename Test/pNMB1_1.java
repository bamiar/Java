package Test;

public class pNMB1_1 {
    public static int[] solution(int day ,int k) { //day=1월1일 요일 k=관리비내는날(2일)
        int[] answer = new int[12];

        boolean[] isWeekend = new boolean[7];
        isWeekend[5] = true;
        isWeekend[6] = true;

        int[] maxDay = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};

        // 12달 for문으로 돌기
        for(int i=0; i< maxDay.length; i++) {
            int today = 1;
            while(k>today) {
                today += 7;
            }

            //관리비 내는 날 계산
            if(today==k) {
                answer[i] = isWeekend[day]?1:0;
            } else if(today>k) {
                int temp = today-k;
                temp = day+temp>6? temp-1:temp;
                answer[i] = isWeekend[temp]?1:0;
            }

            //다음달 시작 날짜 day // 다음 1일은 화요일
            int weekSum= (maxDay[i] /7) * 7;
            int lastday = maxDay[i] - weekSum+1;
            day = day+lastday>6? lastday-1:day+lastday;
        }

        return answer;
    }
}
