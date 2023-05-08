import java.io.*;
import java.util.*;

public class UVa_10037_Bridge {
    static  PrintWriter out=new PrintWriter(System.out);
    public static void main(String[] args) throws IOException {
        //Scanner sc= new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        int testCases= sc.nextInt();
        while (testCases-->0){
            StringBuilder res = new StringBuilder();
            sc.nextLine();
            int n= sc.nextInt();
            ArrayList<Integer>rightAsc=new ArrayList<>();
            for (int i=0;i<n;i++){
                rightAsc.add(sc.nextInt());
            }
            Collections.sort(rightAsc);
            if (n==1){
                out.println(rightAsc.get(0));
                out.println(rightAsc.get(0));
            }else if (n==2){
                out.println(rightAsc.get(1));
                out.println(rightAsc.get(0)+" "+rightAsc.get(1));
            }else {
                    int f1=rightAsc.get(0),f2=rightAsc.get(1),s1=rightAsc.get(n-1),s2;
                if (n>3)
                     s2=rightAsc.get(n-2);
               else s2=-1;
               int t=0, k=n-3;
                StringBuilder sb = new StringBuilder();
               while (s2!=-1){
                   if (f1+s2<(2*f2)){
                       sb.append(f1 + " " + s2 + "\n");
                       sb.append(f1 + "\n");
                       sb.append(f1 + " " + s1 + "\n");
                       sb.append(f1 + "\n");
                       t+=(2*f1)+s1+s2;
                       if (k>=2) s1=rightAsc.get(k--);else s1=-1;
                       if (k>=2)s2=rightAsc.get(k--);else s2=-1;
                   }else{

                       t += s1 +( 2 * f2) + f1;
                       sb.append(f1 + " " + f2 + "\n");
                       sb.append(f1 + "\n");
                       sb.append(s2 + " " + s1 + "\n");
                       sb.append(f2 + "\n");
                       if(k >= 2) s1 = rightAsc.get(k--); else s1 = -1;
                       if(k >= 2) s2 = rightAsc.get(k--); else s2 = -1;
                   }
               }
               if (s1==-1){
                   t+=f2;
                   sb.append(f1 + " " + f2 + "\n");
               }else{
                   sb.append(f1 + " " + f2 + "\n");
                   sb.append(f1 + "\n");
                   sb.append(f1 + " " + s1 + "\n");
                   t+= f2 + f1 + s1;
               }
              out.println(t);
               out.print(sb);
            }
            if(testCases!=0) out.println();

        }
        out.flush();
        out.close();
    }

    static  class group{
        int p1;

        public group(int p1, int p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        int p2;

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
