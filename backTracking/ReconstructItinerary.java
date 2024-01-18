package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 332
public class ReconstructItinerary {
    public List<String> result = new ArrayList<>();
    public List<String> re = new ArrayList<>();
    public boolean[] used;

    public boolean isLarger(String re, String s){
        for (int j = 0; j<3; j++){
            if (re.charAt(j) == s.charAt(j)){
                continue;
            }
            else if(re.charAt(j) < s.charAt(j)){
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
    public void helper(List<List<String>> tickets){
        if (re.size() == tickets.size()+1){
            // check lexical
            if (!result.isEmpty()){
                for (int j = 0; j<re.size(); j++){
                    if (result.get(j).equals(re.get(j))){
                        continue;
                    }
                    else if (isLarger(result.get(j),re.get(j))){
                        return;
                    }
                    else{
                        result = new ArrayList<>(re);
                        return;
                    }
                }
            }
            // no need
            result = new ArrayList<>(re);
            return;
        }
        for (int i = 0; i<tickets.size(); i++){
            // check connection
            if (used[i]){
                continue;
            }
            if (re.isEmpty() && !tickets.get(i).get(0).equals("JFK")){
                continue;
            }
            if (!re.isEmpty() && !tickets.get(i).get(0).equals(re.get(re.size()-1))){
                continue;
            }

            //backtracking
//            if (re.isEmpty()){
//                re.add(tickets.get(i).get(0));
//            }
//            re.add(tickets.get(i).get(0));
            re.add(tickets.get(i).get(1));
            used[i] = true;
            helper(tickets);
            re.remove(re.size()-1);
//            re.remove(re.size()-1);
//            if(re.size() == 1){
//                re.remove(re.size()-1);
//            }
            used[i] = false;
        }
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        used = new boolean[tickets.size()];
        re.add("JFK");
        helper(tickets);
        return result;
    }

    public static void main(String[] args) {
        ReconstructItinerary sol = new ReconstructItinerary();
        List<List<String>> tickets = new ArrayList<>();

        tickets.add(Arrays.asList(new String[]{"JFK","SFO"}));
        tickets.add(Arrays.asList(new String[]{"JFK","ATL"}));
        tickets.add(Arrays.asList(new String[]{"SFO","ATL"}));
        tickets.add(Arrays.asList(new String[]{"ATL","JFK"}));
        tickets.add(Arrays.asList(new String[]{"ATL","SFO"}));
        System.out.println(sol.findItinerary(tickets));
    }
}
