import java.util.*;

public class Main {

    static Scanner sc;
    static int[] parents;
    private static int N;
    private static int M;
    private static int K;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        initParent();

        K = sc.nextInt();
        Set<Integer> knowers = new HashSet<>();
        findKnowers(knowers);

        List<List<Integer>> parties = new ArrayList<>();
        findParties(parties);

        canLieParty(parties, knowers);
    }

    private static void initParent() {
        parents = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parents[i] = i;
        }
    }

    private static void canLieParty(List<List<Integer>> parties, Set<Integer> knowers) {
        int result = 0;
        for (List<Integer> party : parties) {
            if (!truthParty(party, knowers)) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void findParties(List<List<Integer>> parties) {
        for (int i = 0; i < M; i++) {
            int partySize = sc.nextInt();
            List<Integer> party = new ArrayList<>();

            int firstPerson = sc.nextInt();
            party.add(firstPerson);

            for (int j = 1; j < partySize; j++) {
                int person = sc.nextInt();
                party.add(person);
                union(firstPerson, person);
            }
            parties.add(party);
        }
    }

    private static void findKnowers(Set<Integer> knowers) {
        if (K > 0) {
            int firstTruthPerson = sc.nextInt();
            knowers.add(firstTruthPerson);

            for (int i = 1; i < K; i++) {
                int truthPerson = sc.nextInt();
                union(firstTruthPerson, truthPerson);
                knowers.add(truthPerson);
            }
        }
    }

    private static boolean truthParty(List<Integer> party, Set<Integer> knowers) {
        for (int person : party) {
            for (int knower : knowers) {
                if (find(person) == find(knower)) {
                    return true;
                }
            }
        }
        return false;
    }

    static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x <= y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }

}