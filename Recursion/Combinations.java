//https://leetcode.com/problems/combinations/submissions/
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        
        comb(ans,1,n,k,new ArrayList<>());
        return ans;
    }
    public static void comb(List<List<Integer>> ans,int idx,int n,int k,List<Integer> temp){
        if(k==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx;i<=n;i++){
            temp.add(i);
            comb(ans,i+1,n,k-1,temp);
            temp.remove(temp.size()-1);    
        }
    }
}
