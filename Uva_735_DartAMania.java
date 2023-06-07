import java.io.*;
import java.util.*;

public class Uva_735_DartAMania {
    public static void main(String[] args) throws IOException {
       // Scanner sc = new Scanner(new FileReader("input.txt"));
       Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        String s;
        int[]possibleScores=new int[62];
        for (int i=1;i<=20;i++){
            possibleScores[i]=i;
            possibleScores[i*2]=i*2;
            possibleScores[i*3]=i*3;
        }
        possibleScores[50]=50;
        HashMap<Integer,HashSet<Triplet>>map=new HashMap<>();
        HashMap<Integer,HashSet<Triplet>>map1=new HashMap<>();
        HashSet<Triplet>set=new HashSet<>();
        HashSet<Triplet>set1=new HashSet<>();
        for (int i=0;i<possibleScores.length;i++){
            for (int j=0;j<possibleScores.length;j++){
                for (int z=0;z<possibleScores.length;z++){
                    int totalScores=possibleScores[i]+
                            possibleScores[j]+possibleScores[z];
                    if (map.containsKey(totalScores)){
                        map.get(totalScores).add(new Triplet(possibleScores[i] ,+possibleScores [j],+possibleScores[z]));
                    }else{
                        HashSet<Triplet>tmp=new HashSet<>();
                        map.put(totalScores,tmp);
                        map.get(totalScores).add(new Triplet(possibleScores[i] ,+possibleScores [j],+possibleScores[z]));
                    }
                        int []temp=new int[3];
                        temp[0]=possibleScores[i]; temp[1]=possibleScores[j];temp[2]=possibleScores[z];
                        Arrays.sort(temp);
                      if (map1.containsKey(totalScores)){
                          map1.get(totalScores).add(new Triplet(temp[0],temp[1],temp[2]));
                      }else{
                          map1.put(totalScores,new HashSet<>());
                          map1.get(totalScores).add(new Triplet(temp[0],temp[1],temp[2]));
                      }
                }
            }
        }
        while ((s = sc.nextLine()) !=null) {
            int n = Integer.parseInt(s);
            if (n<=0)break;

            if (map.get(n)==null){
                out.println("THE SCORE OF "+n+" CANNOT BE MADE WITH THREE DARTS.");
            }else{
                out.println("NUMBER OF COMBINATIONS THAT SCORES "+n+" IS "+map1.get(n).size()+".");
                out.println("NUMBER OF PERMUTATIONS THAT SCORES "+n+" IS "+map.get(n).size()+".");
            }
            out.println("**********************************************************************");
        }
        out.println("END OF OUTPUT");
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
        public String toString() {
            return "Triplet{" +
                    "i=" + i +
                    ", j=" + j +
                    ", z=" + z +
                    '}';
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplet triplet = (Triplet) o;
            return i == triplet.i && j == triplet.j && z == triplet.z;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, z);
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
