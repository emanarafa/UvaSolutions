import java.io.*;
import java.util.StringTokenizer;

public class Uva_471_MagicNumbers {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases= sc.nextInt();
        while (testCases-->0){
            sc.nextLine();
            long n= Long.parseLong(sc.nextLine());
            long limit=9876543210L;
            for (long i=1;limit>=n*i;i++){
                long s1=i;
                long s2=n*i;
                if (checkUniqueDigits(s1)&&checkUniqueDigits(s2))
                    out.println( s2 + " / " +  s1 + " = " + n);
            }
            if (testCases!=0)out.println();
        }
        out.flush();
        out.close();
    }
    static boolean checkUniqueDigits(long num) {
        boolean[]n=new boolean[10];
        while(num>0){
            int temp= (int) (num%10);
            if (n[temp]==true){
                return false;
            }else{
                n[temp]=true;
                num/=10;
            }
        }
        return true;
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
