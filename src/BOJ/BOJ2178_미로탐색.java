package BOJ;

import java.io.*;
import java.util.*;
public class BOJ2178_미로탐색 {
    static int n, m;
    static int [][] adj;
    static boolean [][] v;

    static int [][] d = new int[][]{{0, 0, 1, -1}, {1, -1, 0, 0}};
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);

        adj = new int[n][m];
        v = new boolean[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                adj[i][j] = str.charAt(j)-'0';
            }
        }

        bfs();

    }

    public static void bfs(){
        Deque<Integer[]> q = new ArrayDeque<Integer[]>();

        q.add(new Integer[]{0, 0, 1});
        v[0][0] = true;

        while(!q.isEmpty()){
            Integer [] arr = q.poll();

            int x = arr[0];
            int y = arr[1];

            if(x == n-1 && y == m-1){
                System.out.println(arr[2]);
                return;
            }

            for(int i=0; i<4; i++){
                int nx = x+d[0][i];
                int ny = y+d[1][i];

                if( nx < 0 || nx >= n || ny < 0 || ny >= m )
                    continue;
                if(!v[nx][ny] && adj[nx][ny]==1){
                    q.add(new Integer[]{nx, ny, arr[2]+1});
                    v[nx][ny] = true;
                }
            }
        }

    }
}
