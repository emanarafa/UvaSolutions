import javax.sound.midi.MidiFileFormat;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Uva_617_NonStopTravel {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        //Scanner sc=new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n, cases = 0;
        while ((n = sc.nextInt()) != -1) {
            Triplet[] signs = new Triplet[n];
            cases++;
            if (n == 0) {
                out.println("Case " + cases + ": " + "30-60");
            } else {
                for (int i = 0; i < n; i++) {
                    double loc = sc.nextDouble();
                    int green = sc.nextInt();
                    int yellow = sc.nextInt();
                    int red = sc.nextInt();
                    int passRange = green + yellow;
                    int stopRange = passRange + red;
                    signs[i] = new Triplet(passRange, stopRange, loc);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Case " + cases + ": ");
                ArrayList<Integer> res = new ArrayList<>();

                for (int i = 30; i <= 60; i++) {
                    boolean check = canPass(signs, i);
                    if (check) {
                        res.add(i);
                    }
                }

                int f=0;
                for (int i=0;i<res.size()-1;i++){
                    System.out.println(i +" at i "+res.get(i));
                    if (res.get(i)!=res.get(i+1)-1 || i==res.size()-2){
                        if (i==res.get(res.size())-2){

                        }
                        if (f==i){
                            sb.append(res.get(i)+", ");
                        }else{
                            sb.append(res.get(f)+"-"+res.get(i)+", ");
                        }
                        f=i+1;
                    }

                }

                if (res.size() == 0) {
                    sb.append("No acceptable speeds.");
                    out.println(sb);
                } else {
                    out.println(sb);
                }
            }
            sc.nextLine();
        }
        out.flush();
        out.close();
    }

    static boolean canPass(Triplet[] signs, int speed) {
        for (int i = 0; i < signs.length; i++) {
            double seconds = (3600 * signs[i].loc) / speed;
            double timeSlot = seconds % signs[i].stopRange;
            if (timeSlot >= 0 && timeSlot <= signs[i].passRange) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    static class Triplet {
        int passRange;
        int stopRange;
        double loc;

        public Triplet(int passRange, int stopRange, double loc) {
            this.passRange = passRange;
            this.stopRange = stopRange;
            this.loc = loc;
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
