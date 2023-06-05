import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva_347_The_RunRunAroundNumbers {
    public static void main(String[] args) throws IOException {
      // Scanner sc = new Scanner(new FileReader("input.txt"));
       Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n,testCases=0;
        while ((n=sc.nextInt())!=0) {
            testCases++;
           while (checkUniqueDigits(n)==false || isRoundAroundNumber(n)==false){
               n=n+1;
           }
           out.println("Case "+testCases+": "+n);
        }
        out.flush();
        out.close();
    }

    static boolean isRoundAroundNumber(int n){
        String num=String.valueOf(n);
        char[]chars=num.toCharArray();
        boolean[]visited=new boolean[chars.length];
        int i=0,visitedCount=0;
         while (true){
             i=((Integer.parseInt(String.valueOf(chars[i])))+i)%(chars.length);
             if (visited[i]&& visitedCount!=chars.length){
                 return false;
             } else if (visited[i]==true && visitedCount==chars.length) {
                 return true;
             } else if (!visited[i]){
                 visited[i]=true;
                 visitedCount++;
             }
         }
    }
 static boolean checkUniqueDigits(int num) {
        int[]n=new int[10];
        while(num>0){
            int temp=num%10;
            if (n[temp]!=0 && n[temp]==temp){
                return false;
            }else{
                n[temp]=temp;
                num/=10;
            }
        }
        return true;
 }

    static class Building{
        int l;
        int r;
        int h;

        public Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }

        @Override
        public String toString() {
            return "{"+
                    "l=" + l +
                    ", r=" + r +
                    ", h=" + h +
                    '}';
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
