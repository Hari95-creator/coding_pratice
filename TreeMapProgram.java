import java.util.Arrays;
import java.util.List;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapProgram {

    public static void showDataAfterKey(List<Integer> data, Integer key) {


        TreeMap<Integer,Integer> treeData=new TreeMap<>();
        for(int i=0;i<data.size();i++){
            treeData.put(i,data.get(i));
        }

        SortedMap<Integer,Integer> sortedMap=treeData.tailMap(key);
        NavigableMap<Integer,Integer> nvData=treeData.tailMap(key,false);

        System.out.println(sortedMap);
        System.out.println(nvData);

        

    }

    public static void main(String args[]) {

        List<Integer> numData=Arrays.asList(10,89,90,50,40);
        Integer key=1;
        showDataAfterKey(numData, key);
    }
}
