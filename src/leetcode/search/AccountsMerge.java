package leetcode.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AccountsMerge {
    private ArrayList<Integer>[] adj;

    public void accountsMerge(List<List<String>> accounts){
        int point =0;
        adj = new ArrayList[accounts.size()];
        HashMap<String,Integer> hashmap = new HashMap<>();
        for(int j = 0;j<accounts.size();j++){
            List<String> temp = accounts.get(j);
            for(int i = 1;i<temp.size();i++){
                if(!hashmap.containsKey(temp.get(i))) {
                    hashmap.put(temp.get(i),point);
                    adj[j].add(point);
                    point++;
                }
                adj[j].add(hashmap.get(temp.get(i)));
            }
        }
    }
}
