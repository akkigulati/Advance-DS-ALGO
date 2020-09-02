class questions{
    public static void main(String ags[]) throws Exception{
        stack st=new stack();
        int arr[]={
            5,2,6,3,2,1,4,7,6
        };
        int ngor[]=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(st.isEmpty()){
                st.push(0);
            }else{
                while(arr[i]>arr[st.top()]){
                    ngor[st.top()]=i;
                    st.pop();
                }
                st.push(i);
            }
        }
        while(st.size()!=0){
            ngor[st.pop()]=arr.length;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(ngor[i]);
        }
    }
    //next greater on right
    //maintaing strictly small stack from left..
    public int[] ngor(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        Arrays.fill(ans,n);
        for(int i=0;i<n;i++){
            while(st.size()!=0&&arr[st.peek()]<arr[i]){
                ans[st.peek()]=i;
            }
            st.push(i);
        }
        return ans;
    }


    //next grater on left
    public int[] ngol(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        Arrays.fill(ans,-1);
        for(int i=n-1;i>=0;i--){
            while(st.size()!=0&&arr[st.peek()]<arr[i]){
                ans[st.peek()]=i;
            }
            st.push(i);
        }
        return ans;
    }
      //next smaller on right
      public int[] nsor(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        Arrays.fill(ans,n);
        for(int i=0;i<n;i++){
            while(st.size()!=0&&arr[st.peek()]>arr[i]){
                ans[st.peek()]=i;
            }
            st.push(i);
        }
        return ans;
    }
    //next Smaller on left
    public int[] ngol(int[] arr){
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        Arrays.fill(ans,-1);
        for(int i=n-1;i>=0;i--){
            while(st.size()!=0&&arr[st.peek()]>arr[i]){
                ans[st.peek()]=i;
            }
            st.push(i);
        }
        return ans;
    }
}