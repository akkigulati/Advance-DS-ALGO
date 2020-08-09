//https://leetcode.com/problems/combination-sum-ii/
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        combSum2(candidates,target,0,ans,new ArrayList<Integer>());
        return ans;
    }
    public static void combSum2(int cand[],int tar,int idx,List<List<Integer>> ans,List<Integer> temp){
        if(tar==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        // HashSet<Integer> unique=new HashSet<>();
        for(int i=idx;i<cand.length;i++){
            if(tar-cand[i]>=0&&(i==idx||cand[i]!=cand[i-1])){
            temp.add(cand[i]);
            combSum2(cand,tar-cand[i],i+1,ans,temp);
            temp.remove(temp.size()-1);
            // unique.add(cand[i]);
        }
            
       }
    }
}
