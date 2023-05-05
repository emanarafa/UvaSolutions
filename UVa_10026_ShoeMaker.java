import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVa_10026_ShoeMaker {
    static PrintWriter out=new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
      Scanner sc=new Scanner(new FileReader("input.txt"));
      //Scanner sc=new Scanner(System.in);
        int testCases= sc.nextInt();
        while (testCases-->0){
            sc.nextLine();
            int n= sc.nextInt();
            Job[]jobs=new Job[n];
            for (int i=0;i<n;i++){
                int time= sc.nextInt();  int fine= sc.nextInt();
                jobs[i]=new Job(i+1,time,fine);
            }
            Arrays.sort(jobs);
            for (int i=0;i<n;i++){
                if (i==n-1)out.print(jobs[i].jobId);
                else out.print(jobs[i].jobId+" ");
            }
            out.println();
            if (testCases!=0)out.println();
        }
        out.flush();
        out.close();

    }
    static class Job implements Comparable<Job>{
        int jobId;
        int time;
        int fine;

        public Job(int jobId, int time, int fine) {
            this.jobId = jobId;
            this.time = time;
            this.fine = fine;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "jobId=" + jobId +
                    ", time=" + time +
                    ", fine=" + fine +
                    '}';
        }

        @Override
        public int compareTo(Job o) {
            if (Double.compare((time*1.0)/fine,(o.time*1.0)/o.fine)==0){
                return Integer.compare(jobId,o.jobId);
            }
           return Double.compare((time*1.0)/fine,(o.time*1.0)/o.fine);
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
