class Solution {
    public int[] twoSum(int[] nums, int target) {
        // //own code not good approach
        // int arr[] = new int[2]; 
        // for(int i = 0; i < nums.length; i++){
        //     int j = i+1;
        //     while(j < nums.length){
        //         if(nums[i] == target - nums[j]){
        //             arr[0] = i;
        //             arr[1] = j;
        //         }
        //         j++;
        //     }
        // }
        // return arr;
        int arr[] = new int[2];
        arr[0] = arr[1] = -1;
        HashMap<Integer, Integer> hp = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            int moreNeeded = target - x;
            if(hp.containsKey(moreNeeded)){
                arr[0] = hp.get(moreNeeded);
                arr[1] = i;
                return arr;
            }
            hp.put(nums[i], i);
        }
        return arr;
    }
}