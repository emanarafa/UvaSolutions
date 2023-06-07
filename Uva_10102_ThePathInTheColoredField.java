import java.io.*;
import java.util.*;

public class Uva_10102_ThePathInTheColoredField {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(new FileReader("input.txt"));
       //Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
         String s;
        while ((s = sc.nextLine()) !=null) {
          int n=Integer.parseInt(s);
          int[][]grid=new int[n][n];
          HashMap<Pair,Integer>map=new HashMap<>();

          for (int i=0;i<n;i++){
              String row= sc.nextLine();
              for (int j=0;j<n;j++){
                  int x=Integer.parseInt(String.valueOf(row.charAt(j)));
                  grid[i][j]=x;
                  if (x==1){
                  map.put(new Pair(i,j),Integer.MAX_VALUE);
                  }
              }
          }
            int moves=0;
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    for (int z=0;z<n;z++){
                        for (int k=0;k<n;k++){
                            if (grid[i][j]==1 && grid [z][k]==3){
                                moves=Math.abs(z-i)+Math.abs(k-j);
                                int pairMoves=map.get(new Pair(i,j));
                                if (moves<pairMoves){
                                    map.replace(new Pair(i,j),moves);
                                }
                            }
                        }
                    }
                }
            }
            int res=Integer.MIN_VALUE;
            for (int x:map.values()) {
                res=Math.max(res,x);
            }
           out.println(res);
        }
        out.flush();
        out.close();
    }
    static class Pair {
        int i,j;
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;

        }

        @Override
        public String toString() {
            return "Pair{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public String next() throws IOException {


            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}
