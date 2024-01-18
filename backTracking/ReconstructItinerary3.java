package backTracking;

import java.util.*;

public class ReconstructItinerary3 {
    public LinkedList<String> result = new LinkedList<>();
    public Map<String, Map<String, Integer>> map = new HashMap<>();

    public boolean helper(int numT){
        if (result.size() == numT+1){
            return true;
        }

        String last = result.getLast();
        if (map.containsKey(last)){
            for (Map.Entry<String, Integer> en : map.get(last).entrySet()){
                if (en.getValue()>0){
                    int cnt = en.getValue();
                    result.add(en.getKey());
                    en.setValue(cnt-1);
                    if (helper(numT)){
                        return true;
                    }
                    en.setValue(cnt);
                    result.removeLast();
                }
            }
        }
        return false;
    }

    // Map<from, Map<to, times>> map = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> li : tickets){
            Map<String,Integer> tmp;
            // old "from"
            if (map.containsKey(li.get(0))){
                tmp =map.get(li.get(0));
                tmp.put(li.get(1), tmp.getOrDefault(li.get(1),0) +1);
            }
            // new "from"
            else{
                tmp = new TreeMap<>();        ///  ascending map 
                tmp.put(li.get(1),1);
            }
            map.put(li.get(0),tmp);
        }
        result.add("JFK");
        helper(tickets.size());
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
//        Map<String, Integer> nm = new HashMap<>();
//
//        nm.put("JFK", 123);
//        nm.put("ALT", 1234);
//        nm.put("AAC", 12);
//
//        // guarantees any order? No for HashMap<>()!!!
//        for(Map.Entry<String, Integer> target : nm.entrySet()) {
//            System.out.println(target.getKey() + "---" + target.getValue());
//        }
        ReconstructItinerary3 sol = new ReconstructItinerary3();
        List<List<String>> tickets = new ArrayList<>();

        tickets.add(Arrays.asList(new String[]{"JFK","SFO"}));
        tickets.add(Arrays.asList(new String[]{"JFK","ATL"}));
        tickets.add(Arrays.asList(new String[]{"SFO","ATL"}));
        tickets.add(Arrays.asList(new String[]{"ATL","JFK"}));
        tickets.add(Arrays.asList(new String[]{"ATL","SFO"}));
        System.out.println(sol.findItinerary(tickets));
    }
}
