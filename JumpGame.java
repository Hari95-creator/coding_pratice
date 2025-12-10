public class JumpGame {

    public static boolean CanItJump(int[] num) {

        int maxReach =0;
        
        for(int i=0;i<num.length;i++){

            if(i > maxReach){

                return false;
            }

            int possibleReach=i+num[i];
            if(possibleReach > maxReach){

                maxReach=possibleReach;
            }

        }


        return true;





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
