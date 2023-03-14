import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str,ch;
        int sz,l,i;
        int[] len = {1,1,2,6,24,120,720,5040,40320,362880,3628880};
        while((str=br.readLine())!=null) {
            StringTokenizer st = new StringTokenizer(str);
            ch = st.nextToken();
            sz = ch.length();
            l = Integer.parseInt(st.nextToken());
            sb.append(ch+" "+l+" = ");
            if(l>len[sz]) {
                sb.append("No permutation\n");
                continue;
            }
            ArrayList<Character> q = new ArrayList<Character>();
            for(i=0;i<sz;i++) q.add(ch.charAt(i));
            l--;
            for(i=sz-1;i>=0;) {
                sb.append(q.remove(l/len[i]));
                l %= len[i--];
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}