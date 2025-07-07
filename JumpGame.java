public class JumpGame {

    public static boolean CanItJump(int[] num) {

        int maxReach = 0;
        int maxLength = num.length - 1;

        for (int i = 0; i < num.length; i++) {

            // here not updatin the postion just check max reach
            maxReach = (maxLength > i + num[i]) ? maxLength : i + num[i];

            if (maxReach >= maxLength - 1) {

                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {

        int[] nums = { 2, 3, 1, 1, 4 };

        boolean canJump = CanItJump(nums);

        if (canJump) {

            System.out.println("Reached Max :" + canJump);
        } else {
            System.out.println("Did not Reach  Max :" + canJump);
        }
    }
}
