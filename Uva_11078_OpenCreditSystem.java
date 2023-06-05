import java.io.*;
import java.util.StringTokenizer;

public class Uva_11078_OpenCreditSystem {
    public static void main(String[] args) throws IOException {
      //  Scanner sc = new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases=sc.nextInt();
        while (testCases-->0){
            int n= sc.nextInt();
            int[]grades=new int[n];
            for (int i=0;i<n;i++){
               grades[i]= sc.nextInt();
            }
            int max=Integer.MIN_VALUE,max_diff=Integer.MIN_VALUE;
            for (int i=0;i<n-1;i++){
                max=Math.max(max,grades[i]);
                max_diff=Math.max(max_diff,max-grades[i+1]);
            }
          out.println(max_diff);
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
