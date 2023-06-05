import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Uva_105_The_Skyline_Problem {
    public static void main(String[] args) throws IOException {
       //Scanner sc = new Scanner(new FileReader("input.txt"));
       Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s;
        int[]heights=new int[10001];
        int leftMost=Integer.MAX_VALUE,rightMost=Integer.MIN_VALUE;
        while ((s=sc.nextLine())!=null) {
            String[] arr = s.split(" ");
            int l = Integer.parseInt(arr[0]);
            int h = Integer.parseInt(arr[1]);
            int r = Integer.parseInt(arr[2]);
            for (int i=l;i<r;i++){
                if (heights[i]<h){
                    heights[i]=h;
                }
            }
            if (l<leftMost){
                leftMost=l;
            }
            if (r>rightMost){
                rightMost=r;
            }
        }
        int currHeight=heights[leftMost];
        StringBuilder sb=new StringBuilder();
        sb.append(leftMost).append(" ").append(heights[leftMost]).append(" ");
        for (int i=leftMost;i<=rightMost;i++){
            if (currHeight!=heights[i]){
                sb.append(i).append(" ").append(heights[i]);
                if (i!=rightMost){
                    sb.append(" ");
                }
                currHeight=heights[i];
            }
        }
        System.out.println(sb);
        out.flush();
        out.close();
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
