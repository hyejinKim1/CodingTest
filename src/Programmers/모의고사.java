package Programmers;
import java.util.*;

class 모의고사 {
    static int [][] p = new int [][] {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    public int[] solution(int[] answers) {
        int [] cnt = new int[3];

        for(int i=0; i<answers.length; i++){
            for(int u=0; u<3; u++){
                if(answers[i] == p[u][i%(p[u].length)])
                    cnt[u]++;
            }
        }

        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i=1; i<=3; i++){
            if(cnt[i-1] == max)
                arr.add(i);
        }

        int[] answer = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            answer[i] = arr.get(i);
        }

        return answer;
    }
}