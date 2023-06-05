import java.io.*;
import java.util.StringTokenizer;

public class Uva_1237_ExpertEnough {
    public static void main(String[] args) throws IOException {
       // Scanner sc = new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases= sc.nextInt();
        while (testCases-->0){
            int D= sc.nextInt();
            int[]lowPrices=new int[D];
            String[]makes=new String[D];
            int[]highPrices=new int[D];
            for (int i=0;i<D;i++){
                String []s= sc.nextLine().split(" ");
                makes[i]=s[0];
                lowPrices[i]= Integer.parseInt(s[1]);
                highPrices[i]= Integer.parseInt(s[2]);
            }
            int queries= sc.nextInt();
            for (int i=0;i<queries;i++){
               int curr=  sc.nextInt();
               int matchCount=0;String match="";
                for (int j=0;j<D;j++){
                    if (curr>=lowPrices[j] && curr<=highPrices[j]){
                        matchCount++;
                        match=makes[j];
                    }
                }
                if (matchCount!=1){
                    out.println("UNDETERMINED");
                }else{
                    out.println(match);
                }
            }
            if (testCases!=0){
                out.println();
            }

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
