package BOJ;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ1260_DFS와BFS {
    static int n, m, v;
    static int [][] adj;
    static boolean [] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String [] line = br.readLine().split(" ");

        n = Integer.parseInt(line[0]);
        m = Integer.parseInt(line[1]);
        v = Integer.parseInt(line[2]);

        adj = new int[n+1][n+1];

        for(int i=0; i<m; i++){
            line = br.readLine().split(" ");

            int p = Integer.parseInt(line[0]);
            int q = Integer.parseInt(line[1]);

            adj[p][q] = 1;
            adj[q][p] = 1;
        }

        visited = new boolean[n+1];
        dfs(v);
        sb.append("\n");
        visited = new boolean[n+1];
        bfs(v);
        System.out.println(sb);
    }

    public static void dfs(int start){
        sb.append(start+" ");
        visited[start] = true;
        for(int i=1; i<=n; i++){
            if(!visited[i] && adj[start][i] == 1){
                visited[i] = true;
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        Deque<Integer> q = new ArrayDeque<Integer>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int c = q.poll();
            sb.append(c+" ");
            for(int i=1; i<=n; i++){
                if(!visited[i] && adj[c][i] == 1){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
