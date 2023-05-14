import java.io.*;
import java.lang.reflect.AnnotatedArrayType;
import java.util.*;

public class UVa_10785_TheMadNumerologist {
    public static void main(String[] args) throws IOException{
        //Scanner sc=new Scanner(new FileReader("input.txt"));
        Scanner sc=new Scanner(System.in);
        PrintWriter out=new PrintWriter(System.out);
        int testCases= sc.nextInt(); int cases=0;
        HashSet<Character>vowelSet=new HashSet<>();
        vowelSet.add('A');
        vowelSet.add('E');vowelSet.add('I');vowelSet.add('O');vowelSet.add('U');
        while (testCases-->0){
            cases++;
            int n= sc.nextInt();
            StringBuilder res=new StringBuilder();
            int cCounter=0; int vCounter=0;
            Letter[]constants=new Letter[21];
            Letter[]vowels=new Letter[5];
            for (int i=0;i<26;i++){
                char c= (char) (i+65);
                if (vowelSet.contains(c)){
                    vowels[vCounter]=new Letter(c,0,((vCounter+cCounter)%9)+1);
                    vCounter++;
                }else{
                    constants[cCounter]=new Letter(c,0,((cCounter+vCounter)%9)+1);
                    cCounter++;
                }
            }
            Arrays.sort(vowels);Arrays.sort(constants);
            int v,c;
            ArrayList<Character>cons=new ArrayList<>();
            ArrayList<Character>vows=new ArrayList<>();
            if (n%2==0){
                v=n/2;c=n/2;
            }else{
                v=(n/2)+1;
                c=n-v;
            }
            int counter=0;
            if (c>5){
                while (c>0){
                    if (constants[counter].useCount<5){
                        cons.add(constants[counter].letter);
                        constants[counter].useCount= constants[counter].useCount+1;
                    }else{
                        counter++;
                            cons.add(constants[counter].letter);
                            constants[counter].useCount= constants[counter].useCount+1;
                    }
                    c-=1;
                }
            }else{
               for (int i=0;i<c;i++)cons.add(constants[counter].letter);
            }
            counter=0;
            if (v>21){
                while (v>0){
                    if (vowels[counter].useCount<21){
                        vows.add(vowels[counter].letter);
                        vowels[counter].useCount= vowels[counter].useCount+1;
                    }else{
                        counter++;
                        vows.add(vowels[counter].letter);
                        vowels[counter].useCount= vowels[counter].useCount+1;
                    }
                    v-=1;
                }
            }else{
                for (int i=0;i<v;i++)vows.add(vowels[counter].letter);
            }
            Collections.sort(cons); Collections.sort(vows);

            int i=0,j=0;
            while (i<vows.size()&&j<cons.size()){
                res.append(vows.get(i)).append(cons.get(j));
                i++;j++;
            }
            while (i<vows.size()){
                res.append(vows.get(i));
                i++;
            }
            out.println("Case "+cases+": "+ res);
        }
        out.flush();
        out.close();
    }
    static class Letter implements Comparable<Letter>{
        char letter;
        int useCount;
        int value;

        public Letter(char letter, int useCount ,int value) {
            this.letter = letter;
            this.useCount = useCount;
            this.value=value;
        }

        @Override
        public String toString() {
            return letter+"";
        }


        @Override
        public int compareTo(Letter o) {
            if (value==o.value)
                return Character.compare(letter,this.letter);
            return Integer.compare(this.value,o.value);
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
