import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentMap;

public class UVa_10249_TheGrandDinner {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(new FileReader("input.txt"));
        PrintWriter out=new PrintWriter(System.out);
        while (true){
            int m= sc.nextInt(); int n= sc.nextInt();
            if (m==0&&n==0)break;
            int[]teams=new int[m];
            Pair[]tables=new Pair[n];
            int largestTeam = Integer.MIN_VALUE;
            for (int i=0;i<m;i++){
                teams[i]=  sc.nextInt();
            largestTeam = Math.max(largestTeam,teams[i]);
            }
            for (int i=0;i<n;i++)tables[i]=new Pair(i+1, sc.nextInt());
            boolean invalidCase=false;
            if (n<largestTeam){
                invalidCase=true;
            }else {
                //apply greedy approach
                int[][]res=new int[m][n];
                Arrays.sort(tables);
                int j=0; int i;
                boolean notPossible=false;
                HashSet<Integer>set=new HashSet<>();
                while (j<tables.length) {
                    if (set.size()==teams.length)break;
                    for ( i = 0; i < teams.length; i++) {
                        if (j < tables.length) {
                            if (tables[j].size != 0) {
                                if (teams[i] != 0) {
                                    tables[j].size=tables[j].size-1;
                                    teams[i] = teams[i] - 1;
                                    res[i][tables[j].number-1]=1;
                                    if (teams[i]==0)set.add(i);
                                }else{
                                    set.add(i);
                                }
                            }else{
                                j++;
                                if (j< tables.length){
                                    if (teams[i] != 0) {
                                        tables[j].size=tables[j].size-1;
                                        teams[i] = teams[i] - 1;
                                        res[i][tables[j].number-1]=1;
                                        if (teams[i]==0)set.add(i);
                                    }else{
                                        set.add(i);
                                    }
                                }
                            }
                        }else{
                            if (set.size()!=teams.length){notPossible=true;
                            break;}
                        }
                    }

                }

                if (notPossible){
                    out.println(0);
                }else{
                    out.println(1);
                    String output="";
                    for (int x=0;x<teams.length;x++){
                         output="";
                        for (int y=0;y<tables.length;y++){
                            if (res[x][y]==1){
                                output+=(y+1+" ");
                            }
                        }
                        out.println(output.trim());
                    }

                }
            }
           if (invalidCase){
               out.println(0);
           }

        }

        out.flush();
        out.close();
    }
    static class Pair implements Comparable<Pair> {
        int number;
        int size;

        public Pair(int number,int size) {
            this.number = number;
            this.size=size;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "number=" + number +
                    ", size=" + size +
                    '}';
        }

        @Override
        public int compareTo(Pair o) {
            if (this.size==o.size)
                return Integer.compare(this.number,o.number);
            return Integer.compare(o.size,this.size);
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

        public int nextInt() throws IOException {
            return Integer.parseInt(next());

        }

        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}

        public double nextDouble() throws IOException { return Double.parseDouble(next()); }

        public boolean ready() throws IOException {return br.ready();}
    }
}
