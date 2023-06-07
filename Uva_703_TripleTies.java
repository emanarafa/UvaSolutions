import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Uva_703_TripleTies {
    public static void main(String[] args) throws IOException {
       // Scanner sc = new Scanner(new FileReader("input.txt"));
       Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s;

        while ((s = sc.nextLine()) != null) {
            int n = Integer.parseInt(s);
            ArrayList<Triplet> res = new ArrayList<>();
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int solnCount = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int z = j + 1; z < n; z++) {
                        if (matrix[i][j] == 1 && matrix[j][z] == 1 && matrix[z][i] == 1) {
                            res.add(new Triplet(i+1,j+1,z+1));
                            solnCount++;
                        }
                        if (matrix[z][j] == 1 && matrix[j][i] == 1 && matrix[i][z] == 1){
                            res.add(new Triplet(z+1,j+1,i+1));
                            solnCount++;
                        }
                        if (matrix[i][j]==0 && matrix[j][i]==0 && matrix[j][z]==0 &&matrix[z][j]==0 && matrix[z][i]==0 &&matrix[i][z]==0){
                            res.add(new Triplet(i+1,j+1,z+1));
                            solnCount++;
                        }
                    }
                }
            }
            Collections.sort(res);
            out.println(solnCount);
            for (int i=0;i< res.size();i++){
                Triplet triplet =res.get(i);
                out.println(triplet.i+" "+triplet.j+" "+triplet.z);
            }
        }
        out.flush();
        out.close();
    }
    static class Triplet implements Comparable<Triplet>{
        int i,j,z;

        public Triplet(int i, int j, int z) {
            this.i = i;
            this.j = j;
            this.z = z;
        }

        @Override
        public int compareTo(Triplet o) {
            if (i!=o.i){
                return Integer.compare(i,o.i);
            }else{
                if (j!=o.j){
                    return Integer.compare(j,o.j);
                }else{
                    return Integer.compare(z,o.z);
                }
            }
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
