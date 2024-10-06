import java.util.*;

class Solution {
    Map<String, Person> people = new HashMap<>();

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        // 1. 조직 구조 생성
        for (int i = 0; i < enroll.length; i++) {
            people.put(enroll[i], new Person(enroll[i], i));
        }

        // 2. 추천인 설정
        for (int i = 0; i < referral.length; i++) {
            if (!referral[i].equals("-")) {
                people.get(enroll[i]).setReferrer(people.get(referral[i]));
            }
        }

        // 3. 판매 수익 분배
        for (int i = 0; i < seller.length; i++) {
            distribute(people.get(seller[i]), amount[i] * 100);
        }

        // 4. 결과 생성
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = people.get(enroll[i]).profit;
        }

        return answer;
    }

    private void distribute(Person person, int amount) {
        int fee = amount / 10;
        person.profit += amount - fee;

        if (fee >= 1 && person.referrer != null) {
            distribute(person.referrer, fee);
        }
    }

    class Person {
        String name;
        int id;
        int profit;
        Person referrer;

        Person(String name, int id) {
            this.name = name;
            this.id = id;
        }

        void setReferrer(Person referrer) {
            this.referrer = referrer;
        }
    }
}