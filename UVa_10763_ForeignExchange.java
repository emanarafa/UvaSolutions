import java.io.*;
import java.util.*;

public class UVa_10763_ForeignExchange {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        Scanner sc = new Scanner(new FileReader("input.txt"));
        // Scanner sc=new Scanner(System.in);
        int n;
        while (true) {
            HashMap<Pair, Integer> map = new HashMap<>();
            n = sc.nextInt();
            if (n == 0) break;
            for (int i = 0; i < n; i++) {
                int src = sc.nextInt(), des = sc.nextInt();

                if (!map.containsKey(new Pair(src, des))) {
                    map.put(new Pair(src, des), 1);
                } else {
                    map.replace(new Pair(src, des), map.get(new Pair(src, des)) + 1);
                }
            }
            for (Pair pair : map.keySet()) {
                if (map.get(pair) > 0) {
                    Pair secPair = new Pair(pair.des, pair.src);

                    if (map.containsKey(secPair)) {
                        if (map.get(secPair) > 0) {
                            if (map.get(pair)>map.get(secPair)){
                                map.replace(pair, map.get(pair)-map.get(secPair));
                            map.replace(secPair,0);
                            } else if (map.get(pair)==map.get(secPair)) {
                                map.replace(pair,0);
                                map.replace(secPair,0);
                            } else{
                                map.replace(secPair, map.get(secPair)-map.get(pair));
                                map.replace(pair,0);
                            }
                        }
                    }
                }
            }
            boolean invalid=false;
            for (int x:map.values()) {
                if (x>0){
                    invalid=true; break;
                }
            }
            if (invalid)out.println("NO");else out.println("YES");

        }

        out.flush();
        out.close();
    }
    static class Pair{
        int src;
        int des;

        public Pair(int src, int des) {
            this.src = src;
            this.des = des;

        }

        @Override
        public String toString() {
            return "Pair{" +
                    "src=" + src +
                    ", des=" + des +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return src == pair.src && des == pair.des;
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, des);
        }
    }
    static class Scanner{
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public Scanner(FileReader r){	br = new BufferedReader(r);}

        public String next() throws IOException
        {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());

        }

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException { return Double.parseDouble(next()); }

        public boolean ready() throws IOException {return br.ready();}
    }
}
