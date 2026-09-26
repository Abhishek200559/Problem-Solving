class Solution {
    class Pair{
        int freq; 
        char c; 
        Pair(int freq, char c){
            this.freq = freq;
            this.c = c; 
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length; 

        Map<Character, Integer> map = new HashMap<>(); 
        Map<Character, Integer> free = new HashMap<>(); 

        for(int i = 0; i < m; i++){
            map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
            free.put(tasks[i], 1);  
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq
        ); 
        for(Map.Entry<Character, Integer> item : map.entrySet()){
            maxHeap.add(new Pair(item.getValue(), item.getKey())); 
        }

        // List<Character> list = new ArrayList<>(); 

        int i = 1; 
        while(!maxHeap.isEmpty()){
            List<Pair> wait = new ArrayList<>(); 
            while(!maxHeap.isEmpty()){
                Pair node = maxHeap.poll(); 
                int freq = node.freq; 
                char c = node.c;

                if(i >= free.get(c)){
                    freq--; 
                    if (freq > 0) {
                        maxHeap.add(new Pair(freq, c));
                    }
                    free.put(c, i + n + 1); 
                    break; 
                }
                else {
                    wait.add(node); 
                }
            }
            for(Pair p : wait){
                maxHeap.add(p); 
            }
            i++; 
        }
        return i - 1; 
    }
}