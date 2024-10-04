import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Solution {

    int[] discount = new int[]{40, 30, 20, 10};
    List<List<Integer>> combs = new ArrayList<>();

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(new ArrayList<>(), emoticons.length);

        int[] result = new int[]{0, 0};
        for (List<Integer> comb : combs) {
            int membership = 0;
            int sale = 0;
            for (int[] user : users) {
                int price = IntStream.range(0, emoticons.length)
                    .filter(i -> comb.get(i) >= user[0])
                    .map(i -> emoticons[i] * (100 - comb.get(i)) / 100)
                    .reduce(0, Integer::sum);

                if (price >= user[1]) {
                    membership++;
                    price = 0;
                }
                sale += price;
            }
//            System.out.println(comb +  " : " + sale + " : " + membership);
            if (result[0] < membership) {
                result[0] = membership;
                result[1] = sale;
            } else if (result[0] == membership) {
                result[1] = Math.max(result[1], sale);
            }
        }
        return result;
    }

    private void dfs(List<Integer> comb, int emoticonCount) {
        if (comb.size() == emoticonCount) {
            combs.add(new ArrayList<>(comb));
            return;
        }

        for (int i = 0; i < discount.length; i++) {
            comb.add(discount[i]);
            dfs(comb, emoticonCount);
            comb.remove(comb.size() - 1);
        }
    }
}