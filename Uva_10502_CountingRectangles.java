import java.io.*;
import java.util.StringTokenizer;

public class Uva_10502_CountingRectangles {
    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(new FileReader("input.txt"));
       // Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s;

        while(true){
           s= sc.nextLine();
           int n=Integer.parseInt(s);
           if (n==0)break;
           int m= sc.nextInt();
           int[][]grid=new int[n][m];
           for (int i=0;i<n;i++){
               String row = sc.nextLine();
               for (int j=0;j<m;j++){
                   grid[i][j]=Integer.parseInt(String.valueOf(row.charAt(j)));
               }
           }
         int recCount=0;
           for (int i=0;i<n;i++){
               for (int j=0;j<n;j++){
                   if (grid[i][j]==1)recCount++;
                   for (int z=0;z<n;z++){
                       for (int k=0;k<m;k++){
                           if (grid[i][j]==1 && grid[z][k]==1)recCount++;
                           for (int l=0;l<m;l++){
                               for (int y=0;y<m;y++){
                                   System.out.println("i: "+i +" j: "+j+ " z: "+z+" k: "+k +" l: "+l+" y: "+y);
                               }
                           }
                       }
                   }

               }
           }
            System.out.println(recCount);
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
