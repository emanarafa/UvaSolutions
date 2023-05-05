
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVa_1193_RadarInstallation {
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(new FileReader("input.txt"));
       // Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n,d,cases=0;
        while ((n= sc.nextInt())!=0 & (d= sc.nextInt())!=0){
           cases++;
           Pair[]islands=new Pair[n];
           boolean invalidInput=false;
           for (int i=0;i<n;i++){
               int x= sc.nextInt();int y= sc.nextInt();
               if (y>d)invalidInput=true;
               double dis=Math.sqrt(d*d-y*y);
               islands[i]=new Pair(x,y,(x+dis-(x-dis)));
           }
            if(invalidInput)
                out.println("Case " + cases + ": " + -1);
            else{
                int radarCount=1;
                Arrays.sort(islands);
                int y=islands[0].y;
                double dis=Math.sqrt((d*d)-(y*y));
                double lx=islands[0].x-dis;
                double rx=islands[0].x+dis;
                //ystem.out.println("last radar "+islands[0].x + " " +islands[0].y +" ry "+rx);
                for (int i=1;i<islands.length;i++){
                    //System.out.println("next island "+islands[i].x + " " +islands[i].y);
                   if (!isCovered(rx,0,islands[i].x,islands[i].y,d))
                   // System.out.println("ldist "+lDist +" rdist "+rDist);
                        radarCount++;
                      double newD=Math.sqrt((d*d)-(islands[i].y*islands[i].y));
                      rx=islands[i].x+newD;
                }
                out.println("Case "+cases+": "+radarCount);
            }
            sc.nextLine();
        }
out.flush();out.close();

    }

    static class Pair implements Comparable<Pair>{
        int x;
        int y;
         double d;
        public Pair(int x, int y,double d) {
            this.x = x;
            this.y = y;
            this.d=d;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x!=o.x)
            return Integer.compare(this.x,o.x);
            return Double.compare(o.d,this.d);
        }
    }
    public static boolean isCovered(double x1,double y1,double x2,double y2, int r){
        double x=  Math.pow(x1-x2,2); double y=Math.pow(y1-y2,2);
        double d=Math.sqrt(x+y);
        //System.out.println(d);
        if (d<=r)return true; else return false;
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
