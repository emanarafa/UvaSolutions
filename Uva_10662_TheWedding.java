import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Uva_10662_TheWedding {
    public static void main(String[] args) throws IOException {
       // Scanner sc = new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s;

        while (true) {
            s= sc.nextLine();
            if (s==null)break;
            String[]arr=s.split(" ");
            int t= Integer.parseInt(arr[0]);
            int r= Integer.parseInt(arr[1]);
            int h= Integer.parseInt(arr[2]);
            int[]tPrices=new int[t];
            int[]rPrices=new int[r];
            int[]hPrices=new int[h];
            int[][]gridTR=new int[t][r];
            int[][]gridRH=new int[r][h];
            int[][]gridHT=new int[h][t];
            for (int i=0;i<t;i++){
                for (int j=0;j<r+1;j++){
                    int x= sc.nextInt();
                    if (j==0){
                        tPrices[i]= x;
                    }else {
                        gridTR[i][j-1]= x;
                    }

                }
            }
            for (int i=0;i<r;i++){
                for (int j=0;j<h+1;j++){
                    if (j==0){
                        rPrices[i]= sc.nextInt();
                    }else {
                        gridRH[i][j-1]= sc.nextInt();
                    }

                }
            }
            for (int i=0;i<h;i++){
                for (int j=0;j<t+1;j++){
                    int x= sc.nextInt();
                    if (j==0){
                        hPrices[i]= x;
                    }else {
                        gridHT[i][j-1]= x;

                    }

                }
            }
            boolean possible=false; int cheapestCost=Integer.MAX_VALUE;int x=0,y=0,k=0;
            for (int i=0;i<gridTR.length;i++){
                for (int j=0;j<gridTR[i].length;j++){
                    if (gridTR[i][j]==0){
                        for (int z=0;z<h;z++){
                            if (gridRH[j][z]==0 && gridHT[z][i]==0){
                                possible=true;
                               if (tPrices[i]+rPrices[j]+hPrices[z]<cheapestCost){
                                   cheapestCost=tPrices[i]+rPrices[j]+hPrices[z];
                                     x=i;
                                     y=j;
                                     k=z;
                               }
                            }
                        }
                    }
                }
            }


            if (!possible){
                out.println("Don't get married!");
            }else{
                out.println(x+" "+y+" "+k+":"+cheapestCost);
            }


        }
        out.flush();
        out.close();
    }
    static class Triplet implements Comparable<Triplet>{
        int i,j,z;

        public Triplet(int i, int j, int z) {
            this.i = i;
            this.j = j;
            this.z = z;
        }

        @Override
        public int compareTo(Triplet o) {
            if (i!=o.i){
                return Integer.compare(i,o.i);
            }else{
                if (j!=o.j){
                    return Integer.compare(j,o.j);
                }else{
                    return Integer.compare(z,o.z);
                }
            }
        }
    }
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader r) {
            br = new BufferedReader(r);
        }

        public String next() throws IOException {


            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}
