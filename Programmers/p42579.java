package Programmers;

import java.util.*;

public class p42579 {
    public static void main(String[] a) {
        solution(new String[] {"classic","classic","classic","classic","pop"},
                new int[] {400,150,800,800,2000});
//        solution(new String[] {"classic", "pop", "classic", "classic", "pop"},
//                new int[] {500, 600, 150, 800, 2500});
//        solution(new String[] {"A", "A", "B", "A", "B", "B", "A", "A", "A", "A"},
//                new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Map.Entry<String, Integer>> entries = new LinkedList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        List<Integer> result = new ArrayList<>();
        for(int i=entries.size()-1; i>=0; i--) {
            Map<Integer, Integer> songs= new HashMap<>();
            for(int j=0; j<genres.length; j++) {
                if(entries.get(i).getKey().equals(genres[j])) {
                    songs.put(j, plays[j]);
                }
            }

            List<Map.Entry<Integer, Integer>> list = new LinkedList<>(songs.entrySet());

            if(list.size()==1) {
                result.add(list.get(0).getKey());
                continue;
            }

            list.sort(Map.Entry.comparingByValue());

            int song1 = list.size()-1;
            int song2 = list.size()-2;

            if(list.get(song1).getValue().equals(list.get(song2).getValue()) ) {
                List<Integer> mostPlayed = new ArrayList<>();
                int most = list.get(song1).getValue();
                while(most==list.get(song1).getValue()) {
                    mostPlayed.add(list.get(song1).getKey());
                    --song1;
                    if (song1<0) {break;}
                }
                Collections.sort(mostPlayed);
                result.add(mostPlayed.get(0));
                result.add(mostPlayed.get(1));

            } else {
                result.add(list.get(song1).getKey());
                result.add(list.get(song2).getKey());
            }
        }

        answer = result.stream().mapToInt(a -> Integer.valueOf(a)).toArray();
        return answer;
    }
}
