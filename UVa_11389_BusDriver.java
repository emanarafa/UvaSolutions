import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVa_11389_BusDriver {
    static PrintWriter out=new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        //Scanner sc= new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        int n,d,r;
        while ((n= sc.nextInt())!=0&(d= sc.nextInt())!=0&(r= sc.nextInt())!=0){
            int[]morningRoutes=new int[n];
            int[]eveningRoutes=new int[n];
            for (int i=0;i<n;i++)morningRoutes[i]= sc.nextInt();
            for (int i=0;i<n;i++)eveningRoutes[i]= sc.nextInt();
            Arrays.sort(morningRoutes);Arrays.sort(eveningRoutes);
            int totalMoney=0;
            for (int i=0;i<n;i++){
                int sumRoutes=morningRoutes[i]+eveningRoutes[n-1-i];
                if (sumRoutes>d) {
                    int overTime = (sumRoutes - d) * r;
                    totalMoney += overTime;
                }
            }
         out.println(totalMoney);
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

        public int nextInt() throws IOException {
            return Integer.parseInt(next());

        }

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException { return Double.parseDouble(next()); }

        public boolean ready() throws IOException {return br.ready();}
    }
}
