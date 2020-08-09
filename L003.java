class L003{
    public static void main(String[] argv){
        solver();
    }
    public static void solver(){
        // int[] coins={2,3,5,7};
        // int tar=10;
        // System.out.println(coinChangeInfinitePermutations(coins,0,tar,""));
        // System.out.println("-------1");
        // System.out.println(coinChangeInfitePerm_Subseq(coins,0,tar,""));
        // System.out.println("-------1");
        // System.out.println(coinChangeInfiniteComb(coins,0,tar,""));
        // System.out.println("-------2");
        // System.out.println(coinChangeInfiteComb_Subseq(coins,0,tar,""));
        // System.out.println("-------2");
        // System.out.println(coinChangeSingleComb(coins,0,tar,""));
        // System.out.println("-------3");
        // System.out.println(coinChangeSingleComb_Subseq(coins,0,tar,""));
        // System.out.println("-------3");
        // System.out.println(coinChangeSinglePerm(coins,0,tar,""));
        // System.out.println("-------4");
        // System.out.println(coinChangeSinglePerm_Subseq(coins,0,tar,""));
        // System.out.println("-------4");
        // System.out.println(boxQueenComb(6,3,""));
        // System.out.println(oneDqueenComb(new boolean[6],0,3,0,""));
        // System.out.println(oneDqueenPerm(new boolean[6],0,3,0,""));
        
        // System.out.println(twoDqueenComb(new boolean[4][4],0,0,4,""));
        
        // System.out.println(twoDqueenPerm(new boolean[4][4],0,0,4,""));
        System.out.println(twoDqueenFloorwise(new boolean[4][4],0,0,4,""));
    }

    public static int coinChangeInfinitePermutations(int arr[],int idx,int tar,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=idx;i<arr.length;i++){
            if(tar-arr[i]>=0){
                count += coinChangeInfinitePermutations(arr,0,tar-arr[i],ans+arr[i]);
            }
        }
        return count;
    }

    public static int coinChangeInfiniteComb(int arr[],int idx,int tar,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=idx;i<arr.length;i++){
            if(tar-arr[i]>=0){
                count += coinChangeInfiniteComb(arr,i,tar-arr[i],ans+arr[i]);
            }
        }
        return count;
    }
    public static int coinChangeSingleComb(int arr[],int idx,int tar,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=idx;i<arr.length;i++){
            if(tar-arr[i]>=0){
                //i+1 because cannot use previous coins in combination
                count += coinChangeSingleComb(arr,i+1,tar-arr[i],ans+arr[i]);
            }
        }
        return count;
    }
    public static int coinChangeSinglePerm(int arr[],int idx,int tar,String ans){
        if(tar==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        for(int i=idx;i<arr.length;i++){
            if(arr[i]>0&&tar-arr[i]>=0){
                int temp=arr[i];
                arr[i]=-arr[i]; //cannot use this coin So marking it -ve.
                count += coinChangeSinglePerm(arr,0,tar-temp,ans+temp);
                arr[i]=-arr[i];
            }
        }
        return count;
    }
    public static int coinChangeSingleComb_Subseq(int arr[],int idx,int tar,String ans){
        //Solution for same ques coinChangeSingleComb
        if(tar==0||idx==arr.length)
        {
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
            if(tar-arr[idx]>=0){
                //i+1 because cannot use previous coins in combination
                count += coinChangeSingleComb_Subseq(arr,idx+1,tar-arr[idx],ans+arr[idx]);
            }
            count += coinChangeSingleComb(arr,idx+1,tar,ans);
        return count;
    }
    public static int coinChangeInfiteComb_Subseq(int arr[],int idx,int tar,String ans){
        //Solution for same ques coinChangeSingleComb
        if(tar==0||idx==arr.length)
        {
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
            if(tar-arr[idx]>=0){
                //i+1 because cannot use previous coins in combination
                count += coinChangeInfiteComb_Subseq(arr,idx,tar-arr[idx],ans+arr[idx]);
            }
            count += coinChangeInfiteComb_Subseq(arr,idx+1,tar,ans);
        return count;
    }
    public static int coinChangeInfitePerm_Subseq(int arr[],int idx,int tar,String ans){
        //Solution for same ques coinChangeSingleComb
        if(tar==0||idx==arr.length)
        {
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
            if(tar-arr[idx]>=0){
                //i+1 because cannot use previous coins in combination
                count += coinChangeInfitePerm_Subseq(arr,0,tar-arr[idx],ans+arr[idx]);
            }
            count += coinChangeInfitePerm_Subseq(arr,idx+1,tar,ans);
        return count;
    }
    public static int coinChangeSinglePerm_Subseq(int arr[],int idx,int tar,String ans){
        //Solution for same ques coinChangeSingleComb
        if(tar==0||idx==arr.length)
        {
            if(tar==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
        if(arr[idx]>0&&tar-arr[idx]>=0){
            int temp=arr[idx];
            arr[idx]=-arr[idx]; //cannot use this coin So marking it -ve.
            count += coinChangeSinglePerm_Subseq(arr,0,tar-temp,ans+temp);
            arr[idx]=-arr[idx];
        }
            count += coinChangeSinglePerm_Subseq(arr,idx+1,tar,ans);
        return count;
    }


//     public static int boxQueenComb(int b,int q,String ans){

//             if(b==0&&q==0){
//                 System.out.println(ans);
//                 return 1;
//             }
//             int count=0;
//             if(b-1>=0){
//                 if(q-1>=0)
//                 count+= boxQueenComb(b-1,q-1,ans+"b"+b+"q"+q);
//                 count+= boxQueenComb(b,q-1,ans);
//             }
//            return count;
//     }
//     public static int boxQueenPerm(int b,int q,String ans,boolean box[]){

//         if(b==0&&q==0){
//             System.out.println(ans);
//             return 1;
//         }
//         int count=0;
//         if(b-1>=0){
//             if(q-1>=0&&box[b-1]==false)
//             {
//                 box[b-1]=true;
//                 count+= boxQueenPerm(b,q-1,ans+"b"+b+"q"+q,box);
//                 box[b-1]=false;
//             }
//             if(q-1>=0)
//             count+= boxQueenPerm(b-1,q,ans,box);
//         }
//        return count;
// }

public static int oneDqueenComb(boolean[] box,int idx,int nq,int qpsk,String ans){
    if(qpsk==nq){
        System.out.println(ans);
        return 1;
    }
    int count=0;
    for(int i=idx;i<box.length;i++){
        count+=oneDqueenComb(box,i+1,nq,qpsk+1,ans+"b"+i+"q"+qpsk+" ");
    }
    return count;
}
public static int oneDqueenPerm(boolean[] box,int idx,int nq,int qpsk,String ans){
    if(qpsk==nq){
        System.out.println(ans);
        return 1;
    }
    int count=0;
    for(int i=idx;i<box.length;i++){
        if(!box[i]){
            box[i]=true;
            count+=oneDqueenPerm(box,0,nq,qpsk+1,ans+"b"+i+"q"+qpsk+" ");
            box[i]=false;
        }
    }
    return count;
}

    public static int twoDqueenComb(boolean box[][],int idx,int iq,int tnq,String ans){
        if(iq==tnq){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        int n=box.length;
        int m=box[0].length;
        for(int i=idx;i<n*m;i++){
            int r=i/(m);
            int c=i%(m);
            count+=twoDqueenComb(box,i+1,iq+1,tnq,ans+"("+r+","+c+")"+" ");
        }
        return count;
    }
    public static int twoDqueenPerm(boolean box[][],int idx,int iq,int tnq,String ans){
        if(iq==tnq){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        int n=box.length;
        int m=box[0].length;
        for(int i=idx;i<n*m;i++){
            int r=i/(m);
            int c=i%(m);
            if(!box[r][c]){
                box[r][c]=true;
                count+=twoDqueenPerm(box,0,iq+1,tnq,ans+"("+r+","+c+")"+" ");
                box[r][c]=false;
            }
        }
        return count;
    }
    public static int twoDqueenFloorwise(boolean box[][],int row,int iq,int tnq,String ans){
        if(iq==tnq||row==box.length){
            if(iq==tnq){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
        int m=box[0].length;
        for(int i=0;i<m;i++){
            int r=i/(m);
            int c=i%(m);
           
            count+=twoDqueenFloorwise(box,r+1,iq+1,tnq,ans+"("+r+","+c+")"+" ");
            
        }
        return count;
    }
}