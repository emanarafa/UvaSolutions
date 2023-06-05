import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Uva_10976_FractionsAgain {
    public static void main(String[] args) throws IOException {
       // Scanner sc = new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s;
        ArrayList<pairs>list=new ArrayList<>();
        while ((s= sc.nextLine())!=null){
            int n=Integer.parseInt(s);
            for (int i=n+1;i<=2*n;i++){
                int num=i*n; int den=i-n;
                if (num%den==0) {
                   list.add(new pairs(i,num/den));
                }
            }
            out.println(list.size());
            for (int i=0;i<list.size();i++){

                        out.printf( "1/%d = 1/%d + 1/%d\n",n,list.get(i).den2,list.get(i).den1);
            }
            list.clear();

        }
        out.flush();
        out.close();
    }
  static class pairs{
            int den1;
             int den2;

      public pairs(int den1, int den2) {
          this.den1 = den1;
          this.den2 = den2;
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

        public int nextInt() throws IOException {return Integer.parseInt(next());}

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException { return Double.parseDouble(next()); }

        public boolean ready() throws IOException {return br.ready();}
    }
}
