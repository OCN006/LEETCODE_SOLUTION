class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : stones){
            maxHeap.offer(num);
        }
        while(maxHeap.size()>1){
            int max = maxHeap.poll();
            int sMax = maxHeap.poll();
            if(max==sMax) continue;
            else maxHeap.offer(max-sMax);
        }
        return  maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}