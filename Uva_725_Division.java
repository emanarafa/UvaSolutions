import java.io.*;
import java.util.StringTokenizer;

public class Uva_725_Division {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(System.out);

        int n;
        String s = "";
        while((n = sc.nextInt()) != 0){
            out.print(s);
            boolean printed = false;
            for(int fghij = 1234; fghij <= (98765 / n); ++fghij){
                int used = 0, abcde = fghij * n, tmp;
                if(fghij < 10000) used = 1;
                tmp = fghij;
                while(tmp > 0) {
                    used |= (1 << (tmp % 10));
                    tmp /= 10;
                }
                tmp = abcde; while(tmp > 0) { used |= (1 << (tmp % 10)); tmp /= 10; }
                if(used == (1 << 10) - 1){

                    out.println(String.format("%05d", abcde) + " / " + String.format("%05d", fghij) + " = " + n);
                    printed = true;
                }
            }
            if(!printed) out.println("There are no solutions for " + n + ".");
            s = "\n";
        }

        out.flush();
        out.close();
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

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException { return Double.parseDouble(next()); }

        public boolean ready() throws IOException {return br.ready();}
    }
}
