import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int[] nums = new int[3];
            nums[0] = sc.nextInt();
            nums[1] = sc.nextInt();
            nums[2] = sc.nextInt();

            if (nums[0] == 0 && nums[1] == 0 && nums[2] == 0) {
                break;
            }

            Arrays.sort(nums);
            if (nums[0] * nums[0] + nums[1] * nums[1] == nums[2] * nums[2]) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }
    }
}