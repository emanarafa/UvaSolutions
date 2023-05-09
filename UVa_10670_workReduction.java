import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVa_10670_workReduction {
    public static void main(String[] args) throws IOException {
       // Scanner sc=new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int testCases= sc.nextInt(),cases=0,m,n,l;
        while (testCases-->0){
            cases++;
            m= sc.nextInt();n= sc.nextInt();l= sc.nextInt();
            Price[]prices=new Price[l];
            for (int i=0;i<l;i++){
                String line= sc.nextLine();
                String[]lines=line.split(":");
                String agencyName=lines[0];
                int unitRate=Integer.parseInt(lines[1].split(",")[0]);
                int halfRate=Integer.parseInt(lines[1].split(",")[1]);
                int agencyPrice=getNumberOfTimes(m,n,halfRate,unitRate);
                prices[i]=new Price(agencyName,agencyPrice);
            }
            Arrays.sort(prices);
            out.println("Case "+cases);
            for (int i=0;i<l;i++){
              out.println(prices[i].agencyName +" "+prices[i].price);
            }
        }
      out.flush();
        out.close();
    }
    static int getNumberOfTimes(int m,int n,int p1,int p2){
        int count1=0;
        while (m!=n){
            int x= m/2;
            if (x>=n &&p1+(x-n)*p2<(m-n)*p2 ){
                m=m/2;
                count1+=p1;
            }else{
                count1+=(m-n)*p2;
                m=n;
            }
        }
        return count1;
    }
    static class Price implements Comparable<Price>{
        String agencyName;
        int price;

        public Price(String agencyName, int price) {
            this.agencyName = agencyName;
            this.price = price;
        }

        @Override
        public int compareTo(Price o) {
            if (price==o.price)
                return agencyName.compareTo(o.agencyName);
          return Integer.compare(this.price,o.price);
        }

        @Override
        public String toString() {
            return "Price{" +
                    "agencyName='" + agencyName + '\'' +
                    ", price=" + price +
                    '}';
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
