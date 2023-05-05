import java.io.*;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVa_410_StationBalance {
    public static void main(String[] args) throws IOException {
      //Scanner sc= new Scanner(System.in);
        Scanner sc= new Scanner(new FileReader("input.txt"));
        PrintWriter out = new PrintWriter(System.out);
        String line;
        DecimalFormat dc = new DecimalFormat("0.00000");
        int sets=0;
        while ((line=sc.nextLine())!=null){
            double avg=0; double imb=0;
           int c= Integer.parseInt(line.split(" ")[0]); int s= Integer.parseInt(line.split(" ")[1]);
           sets++;
           if (sets!=1)out.println();
           int []masses=new int[2*c];
           int[][]chambers=new int[c][2];
           for (int i=0;i<s;i++){
              masses[i]=Integer.parseInt(sc.next());
              avg+=masses[i];
           }
           Arrays.sort(masses);
           avg=avg/c;
           dc.format(avg);
           int k=0;
           for (int i=0;i<chambers.length;i++,k++)chambers[i][0]=masses[i];
           for (int i=chambers.length-1;i>=0;i--,k++)chambers[i][1]=masses[k];
            out.println("Set #"+sets);

           for (int i=0;i<chambers.length;i++){
               double currimb= Double.parseDouble(dc.format(0.0));
               out.print(i+":");
             for (int j=0;j<chambers[i].length;j++){
                 if (chambers[i][j]!=0){
                     currimb+=chambers[i][j];
                     out.print(" "+chambers[i][j]);
                 }
             }
             imb+=(Math.abs(currimb-avg));
             out.println();
           }
           dc.format(imb);
           out.println("IMBALANCE = "+ dc.format(imb));


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
