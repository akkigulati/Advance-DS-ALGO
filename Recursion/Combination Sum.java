//https://leetcode.com/problems/combination-sum/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        combSum(candidates,target,0,ans,new ArrayList<Integer>());
        return ans;
    }
    public static void combSum(int[] cand,int tar,int idx,List<List<Integer>> ans,List<Integer> temp){
        if(tar==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<cand.length;i++){
            if(tar-cand[i]>=0){
                temp.add(cand[i]);
                combSum(cand,tar-cand[i],i,ans,temp);
                temp.remove(temp.size()-1);
            }
        }
    } 
}
