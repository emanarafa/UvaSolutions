import java.io.*;
import java.util.StringTokenizer;

public class Uva_256_QuirkSomeSquares {
    public static void main(String[] args) throws IOException {
       // Scanner sc = new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s;
        while ((s = sc.nextLine()) != null) {
            int n=Integer.parseInt(s);

            for (int i=0;i<10000;i++){if (String.valueOf(i*i).length()>n){
                    break;}
                String formatted = String.format("%0"+n+"d", i*i);
                if (isQuirkSome(formatted,n))out.println(formatted);
            }
        }
        out.flush();
        out.close();
    }

    static boolean isQuirkSome(String num,int digits){
        int a=Integer.parseInt(num.substring(0,num.length()/2));
        int b=Integer.parseInt(num.substring(num.length()/2,num.length()));
        String sum = String.format("%0"+digits+"d", (a+b)*(a+b));
        return sum.equals(num);
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
