public class JumpGame {

    //till to end
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

    public static void minimumJump(int num[]){


        int jump=0;
        int currentEnd=0;
        int farthest=0;
    

        for(int i=0;i<num.length-1;i++){

            int reach=i+num[i];

            if(reach > farthest){
                farthest=reach;
            }

            if(i== currentEnd){
                jump++;
                currentEnd=farthest;
            }

        }

        System.out.println("Minimum Jump : "+jump);



    }

    public static void main(String args[]) {

        int[] nums = { 2, 3, 1, 1, 4 };

        boolean canJump = CanItJump(nums);

        minimumJump(nums);

        if (canJump) {

            System.out.println("Reached Max :" + canJump);
        } else {
            System.out.println("Did not Reach  Max :" + canJump);
        }
    }
}
