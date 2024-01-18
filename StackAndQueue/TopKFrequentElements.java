package StackAndQueue;

import java.util.*;

// 347
public class TopKFrequentElements {
    private static HashMap<Integer,Integer> sortByValue(HashMap<Integer, Integer> hm){
        List<Map.Entry<Integer,Integer>> list = new LinkedList<Map.Entry<Integer,Integer>>(hm.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue().compareTo(o2.getValue()));
            }
        });

        HashMap<Integer,Integer> tmp = new HashMap<>();
        for (Map.Entry<Integer, Integer> a: list){
            tmp.put(a.getKey(),a.getValue());
        }
        return tmp;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
//            if (hm.containsKey(nums[i])){
//                hm.put(nums[i], hm.get(nums[i])+1);
//            }
//            else{
//                hm.put(nums[i],1);
//            }
        }
        // how to sort?
            // iterated by key
//        HashMap<Integer, Integer> newHm= sortByValue(hm);
//        Iterator<Integer> itr = newHm.keySet().iterator();
//        for (int i = 0; i<k; i++){
//            result[i] = itr.next();
//        }

            // priority queue
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());
        for (Map.Entry<Integer,Integer> entry: hm.entrySet()){
            pq.offer(entry);
            if (pq.size() > k){
                pq.poll();
            }
        }

        int i = 0;
        while (!pq.isEmpty()){
            result[i++] = pq.poll().getKey();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,-1,2,-1,2,3};
        int[] result = topKFrequent(nums,2);
        for (int i : result){
            System.out.println(i);
        }

    }
}
