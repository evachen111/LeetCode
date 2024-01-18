package backTracking;

import java.util.*;

public class ReconstructItinerary2 {
    public List<String> result;
    public LinkedList<String> re = new LinkedList<>();
    public boolean[] used;

    public boolean helper(ArrayList<List<String>> tickets){
        if (re.size() == tickets.size()+1){
            result = new LinkedList<>(re);
            return true;
        }
        for (int i = 0; i<tickets.size(); i++){
            // check connection
            if (!used[i] && tickets.get(i).get(0).equals(re.get(re.size()-1))){
                re.add(tickets.get(i).get(1));
                used[i] = true;
                if (helper(tickets)){       // 处理递归返回值
                    return true;
                }
                re.removeLast();
                used[i] = false;
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a,b) -> a.get(1).compareTo(b.get(1)));
        used = new boolean[tickets.size()];
        re.add("JFK");
        helper((ArrayList) tickets);
        return result;
    }

    public static void main(String[] args) {
        ReconstructItinerary2 sol = new ReconstructItinerary2();
        List<List<String>> tickets = new ArrayList<>();

        tickets.add(Arrays.asList(new String[]{"JFK","SFO"}));
        tickets.add(Arrays.asList(new String[]{"JFK","ATL"}));
        tickets.add(Arrays.asList(new String[]{"SFO","ATL"}));
        tickets.add(Arrays.asList(new String[]{"ATL","JFK"}));
        tickets.add(Arrays.asList(new String[]{"ATL","SFO"}));
        System.out.println(sol.findItinerary(tickets));

//        System.out.println("afc".compareTo("cdf")); // -2
    }
}
