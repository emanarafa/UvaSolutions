import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UVa_11292_TheDragonOfLooWater {
    public static void main(String[] args) throws IOException{
       // Scanner sc=new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int n,m;
        while ((n= sc.nextInt())!=0 & (m= sc.nextInt())!=0){
            boolean imPossible=false;
            int totalCoins=0, headsCut=0;
            int[]dragonHeads=new int[n];
            int[]knightHeights=new int[m];
            for (int i=0;i<n;i++)dragonHeads[i]=sc.nextInt();
            for (int i=0;i<m;i++)knightHeights[i]=sc.nextInt();
            if (m<n){
                imPossible=true;
            }else{
                Arrays.sort(dragonHeads);Arrays.sort(knightHeights);
                int i=0,j=0;
                while (i<n &&j<m){
                    if (dragonHeads[i]<=knightHeights[j]){
                        totalCoins+=knightHeights[j];
                        i++;
                        headsCut+=1;
                    }
                    j++;
                }
                if (headsCut<n)imPossible=true;
            }
            if (imPossible)out.println("Loowater is doomed!");else out.println(totalCoins);
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
