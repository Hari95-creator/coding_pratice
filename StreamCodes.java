import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCodes {
    

    public static void main(String args[]){


        List<Integer> numbers=Arrays.asList(1,4,3,5,6,7,9,1,10);

        List<Integer> distinctNumbers=numbers.stream().distinct().toList(); // to remove duplicate from list

         System.out.println(distinctNumbers);

        //to get the average from list  first convert list of integer to instream  ( for any mathematical operation ) then use functional like average to find average 
        //to find min,max differnt methods available these all are provide optional values so it should have orElse() to provide default value if not present

        List<Integer> avgNum=Arrays.asList(5,10,15,20,25);

        double avg=avgNum.stream().mapToInt(Integer :: intValue).average().orElse(0.0);

        int max=avgNum.stream().mapToInt(Integer :: intValue).max().orElse(0);

        System.out.println(max);

        System.out.println(avg);

        List<Integer> nums=Arrays.asList(5,10,15,20,25,60,25,70);

        List<Integer> sortedNums=nums.stream().sorted().toList(); //natural way of sorting ( asc )

        List<Integer> descSorting=nums.stream().distinct().sorted(Comparator.reverseOrder()).toList(); //desc order with unique elements

        System.out.println(sortedNums);

        System.out.println(descSorting);


        List<String> filterData=Arrays.asList("Apple","Orange","Banana","Pineapple","Avacado");

        List<String> removedData=filterData.stream().filter( fr-> fr.startsWith("A")).toList();

        List<String> filterFromList=filterData.stream().filter(fr -> !fr.equalsIgnoreCase("apple")).toList();

        long countData=filterData.stream().filter( fr-> fr.startsWith("A")).count();

        System.out.println(removedData);

        System.out.println(filterFromList);

        System.out.println(countData);


        //joining strings ffrom list

        List<String> joiningdata=Arrays.asList("Apple","Orange","Banana","Pineapple","Avacado");

        String joinWithComma=joiningdata.stream().collect(Collectors.joining(",","{","}"));

        System.out.println(joinWithComma);

        // positive check

        List<Integer> numberData=Arrays.asList(10,20,15,45,90);

        boolean allArePositive=numberData.stream().allMatch(n -> n> 0);

        System.out.println(allArePositive);

        //any number divisible by 3

        List<Integer> numberDivisible=Arrays.asList(2,10,9,6);

        boolean divisible=numberDivisible.stream().anyMatch(n -> n%3==0);

        System.out.println(divisible);

        //flatten a list

        List<List<Integer>> listOfdata=Arrays.asList(Arrays.asList(1,2,3),Arrays.asList(2,6,7));

        List<Integer> flattendList=listOfdata.stream().flatMap(List :: stream).toList();

        System.out.println(flattendList);

        //find first non empty string

        List<String> stringdata=Arrays.asList("","","Banana","Pineapple","Avacado");

        String  findFirstNonEmpty= stringdata.stream().filter(fr -> !fr.isEmpty()).findFirst().orElse("Data Not Found");

        System.out.println(findFirstNonEmpty);



    }

}