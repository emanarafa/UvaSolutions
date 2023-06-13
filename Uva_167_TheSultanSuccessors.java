import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Uva_167_TheSultanSuccessors {
    public static int[][]board=new int[8][8];
    public static int[]rows=new int[8];
    static int maxScore=0;
    static ArrayList<int[]>possibleCombinations=new ArrayList<>();
    public static void main(String[] args) throws IOException {
      //  Scanner sc = new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int testCases= sc.nextInt();
        placeQueens(0);
        while(testCases-->0){
           for (int i=0;i<8;i++){
               for (int j=0;j<8;j++){
                   board[i][j]= sc.nextInt();
               }
           }
           for (int i=0;i<possibleCombinations.size();i++){
               int[]temp=possibleCombinations.get(i);
               int score=0;
              for (int j=0;j<temp.length;j++){
                  score+=board[temp[j]][j];
              }
              maxScore=Math.max(score,maxScore);
           }
           out.printf("%" + 5 + "d", maxScore);
           //out.printf("%d"+maxScore,5);
           out.println();
           maxScore=0;
        }
        out.flush();
        out.close();
        out.close();
    }

    public static boolean isSafe(int r, int c){
        for (int i=0;i<c;i++){
            if (rows[i]==r || (Math.abs(rows[i]-r)==Math.abs(i-c)))return false;
        }
        return true;
    }
    public static void placeQueens(int i){
        if (i==8){
            possibleCombinations.add(Arrays.copyOf(rows,rows.length));
            return;
        }
        for (int j=0;j<8;j++){
            if (isSafe(j,i)){
                rows[i]=j;
                placeQueens(i+1);
            }
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
