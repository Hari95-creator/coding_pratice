public class PivotInteger {


    public static int findPivotInteger(int n){


        int totalSum=n*(n+1)/2;

        for(int x=1;x<=n;x++){

            if(x*x==totalSum){

                return x;
            }
        }

        return -1;
    }

    public static void main(String args[]){

        int n=8;

        int pivotInteger=findPivotInteger(n);

        System.out.println(pivotInteger);
    }
    
}
