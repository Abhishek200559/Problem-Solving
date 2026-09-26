class Solution {
    class Pair{
        int capital; 
        int profit; 
        Pair(int capital, int profit){
            this.capital = capital; 
            this.profit = profit; 
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length; 
        List<Pair> projects = new ArrayList<>(); 
        for(int i = 0; i < n; i++){
            projects.add(new Pair(capital[i], profits[i])); 
        }

        Collections.sort(projects, (a, b) -> a.capital - b.capital); 

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); 
        int idx = 0; 
        while(k-- > 0){
            while(idx < n){
                if(projects.get(idx).capital > w) break; 
                maxHeap.add(projects.get(idx).profit); 
                idx++; 
            }

            if(maxHeap.isEmpty()) return w; 
            w += maxHeap.peek(); 
            maxHeap.poll(); 
        }
        return w; 
    }
}