import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Uva_12321_GasStations {
    public static void main(String[] args) throws IOException{
       // Scanner sc= new Scanner(System.in);
        Scanner sc=new Scanner(new FileReader("input.txt"));
        int l;int g;
        while (true){
            l= sc.nextInt();g= sc.nextInt();
            if (l==0 && g==0)break;
            Pair[]stations=new Pair[g];
            for (int i=0;i<g;i++){
                int x= sc.nextInt(); int r= sc.nextInt();
                stations[i]=new Pair(x-r,x+r);
            }
            Arrays.sort(stations);
            System.out.println(Arrays.toString(stations));
            int furthest=0;

        }
    }
    static class Pair implements Comparable<Pair>{
       int start;
       int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.start,o.start);
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
