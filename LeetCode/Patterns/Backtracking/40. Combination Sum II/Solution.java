class Solution {
    private void helper(int nums[], int i, int sum, int target, List<Integer> temp, Set<List<Integer>> set){
        if(i == nums.length){
            if(sum == target && !set.contains(temp)){
                List<Integer> result = new ArrayList<>(temp); 
                Collections.sort(result);
                set.add(new ArrayList<>(result)); 
            }
            return; 
        }

        sum += nums[i]; 
        temp.add(nums[i]); 
        helper(nums, i + 1, sum, target, temp, set);     
        sum -= nums[i]; 
        temp.remove(temp.size() - 1); 

        helper(nums, i + 1, sum, target, temp, set); 
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>(); 
        List<Integer> temp = new ArrayList<>(); 
        Set<List<Integer>> set = new HashSet<>(); 

        helper(candidates, 0, 0, target, temp, set);
        
        for(List<Integer> item : set){
            ans.add(item); 
        }

        return ans; 
    }
}