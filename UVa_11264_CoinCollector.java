import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVa_11264_CoinCollector {
    public static void main(String[] args) throws IOException {
       // Scanner sc=new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int testCases= sc.nextInt();
        while (testCases-->0){
            int n= sc.nextInt();
            int[]coinValues=new int[n];
            for (int i=0;i<n;i++)coinValues[i]= sc.nextInt();
            Arrays.sort(coinValues);
            int res=calc(coinValues,n);
            out.println(res);
        }
        out.flush();
        out.close();
    }
    static int calc(int[]coinValues,int n){
        int latestSum=0;
        int count=1;
        for (int i=0;i<n-1;i++){
            int currSum=coinValues[i]+latestSum;
            if (currSum-coinValues[i+1]<0){
                latestSum=currSum;
                count++;
            }
        }
      return count;
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
