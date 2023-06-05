import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva_102_EcologicalBinPacking {
    public static void main(String[] args) throws IOException {
        //Scanner sc = new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s;
        String []combinationCodes={"BCG","BGC","CBG","CGB","GBC","GCB"};

        while((s= sc.nextLine())!=null){
            String []arr=s.split(" ");
            int []costs=new int[arr.length];
            for(int i=0; i<arr.length; i++) {
                costs[i] = Integer.parseInt(arr[i]);
            }
            int BCG= costs[3]+costs[6]+costs[2]+costs[8]+costs[1]+costs[4];
            int BGC= costs[3]+costs[6]+costs[1]+costs[7]+costs[2]+costs[5];
            int CBG=costs[5]+costs[8]+costs[0]+costs[6]+costs[1]+costs[4];
            int CGB=costs[5]+costs[8]+costs[1]+costs[7]+costs[0]+costs[3];
            int GBC=costs[4]+costs[7]+costs[0]+costs[6]+costs[2]+costs[5];
            int GCB=costs[4]+costs[7]+costs[2]+costs[8]+costs[0]+costs[3];
            int[]combinationCosts={BCG,BGC,CBG,CGB,GBC,GCB};
            int min=Integer.MAX_VALUE,minIndex=0;
            for (int i=0;i<combinationCosts.length;i++){
               if (combinationCosts[i]<min){
                   minIndex=i;
                   min=combinationCosts[i];
               }
            }
           //System.out.println(Arrays.toString(combinationCosts));
           out.println(combinationCodes[minIndex]+" "+min);
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
