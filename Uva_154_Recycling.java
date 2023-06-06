import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.SimpleFormatter;

public class Uva_154_Recycling {
    public static void main(String[] args) throws IOException {
       // Scanner sc = new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s;

        while(!(s= sc.nextLine()).equals("#")){
   String [][]listArr=new String[100][100];
   int citiesCount=-1;
           while (true){
               if (s.startsWith("e")){
                   break;
               }else{
                   String[]arr=s.split(",");
                   citiesCount++;

                   for (int i=0;i< arr.length;i++){
                       if (arr[i].startsWith("g")){
                           listArr[citiesCount][0]=arr[i];
                       } else if (arr[i].startsWith("o")) {
                           listArr[citiesCount][1]=arr[i];
                       } else if (arr[i].startsWith("r")) {
                           listArr[citiesCount][2]=arr[i];
                       } else if (arr[i].startsWith("y")) {
                           listArr[citiesCount][3]=arr[i];;
                       }else{
                           listArr[citiesCount][4]=arr[i];
                       }

                   }
                   s=sc.nextLine();
               }
           }

           int minMovesCity=0,minCost=Integer.MAX_VALUE;
           for (int i=0;i<citiesCount+1;i++){
               int cost=0;
               for (int j=0;j<citiesCount+1;j++){
                   for (int z=0;z<5;z++){
                     if (i!=j &&!listArr[i][z].equals(listArr[j][z])){
                         cost++;
                     }
                   }
               }
             if (cost<minCost){
                 minCost=cost;
                 minMovesCity=i;
             }
           }
           out.println(minMovesCity+1);

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
