import java.util.*;
class L004{
    public static void main(String argv[]) {
        solver();
        // int a=0;
        // System.out.println(((char)a));
    }
    public static void solver(){
        // System.out.println(NqueenComb(new boolean[4][4],4,0,""));
        // System.out.println(Nqueen_best(new boolean[4][4],4,0,""));
        // suduko();
        // wordBreak();
        // isCryptoValid();
        crossWord();
    }
    public static int NqueenComb(boolean box[][],int tnq,int idx,String ans){
        if(tnq==0){
            System.out.println(ans);
            return 1;
        }
        int count=0;
        int n=box.length;
        int m=box[0].length;
        for(int i=idx;i<n*m;i++){
           int r=i/m;
            int c=i%m;
            if(isSafe(box,r,c)){
                box[r][c]=true;
                count+=NqueenComb(box,tnq-1,i+1,ans+r+","+c+" ");
                box[r][c]=false;
            }
        }
        return count;
    }
    public static boolean isSafe(boolean box[][],int r,int c){
        // int[][] dirP = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
        int[][] dirC = {{-1,0},{0,-1},{-1,1},{-1,-1}};
        for(int[] d:dirC){
            for(int rad=1;rad<=Math.max(box.length,box[0].length);rad++){
                int x=r+rad*d[0];
                int y=c+rad*d[1];
                if(x>=0&&x<box.length&&y>=0&&y<box[0].length){
                    if(box[x][y]) return false;
                }else break;
            }
        }
        return true;
    }
    public static int Nqueen_best(boolean[][] box,int tnq,int row,String ans){
        if(tnq==0||row==box.length){
            if(tnq==0){
                System.out.println(ans);
                return 1;
            }
            return 0;
        }
        int count=0;
        for(int i=0;i<box[0].length;i++){
            if(isSafe(box,row,i)){
                box[row][i]=true;
                count+=Nqueen_best(box,tnq-1,row+1,ans+row+","+i+" ");
                box[row][i]=false;
            }
        }
        return count;
    }
    /////SUDUKO leetcode 36 && 37

    public static boolean isValid(int[][] board,int r,int c,int num){
        //check row i.e row fixed col change
        for(int i=0;i<9;i++){
            if(board[r][i]==num) return false;
        }
        //check col i.e, col fixed not row..
        for(int i=0;i<9;i++){
            if(board[i][c]==num) return false;
        }
        r=(r/3)*3;
        c=(c/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[r+i][c+j]==num) return false;
            }
        }
        return true;
    }
    public static void print(int board[][]){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static int sudukoSolver(int[][] board,int vidx){
        if(vidx==81){
            print(board);
            System.out.println();
            return 1;
        }
        
        int r=vidx/9;
        int c=vidx%9;
        if(board[r][c]!=0) return sudukoSolver(board,vidx+1);
        int count=0;
        for(int num=1;num<=9;num++){
            if(isValid(board,r,c,num)) {
                board[r][c]=num;
                count+=sudukoSolver(board,vidx+1);
                board[r][c]=0;
            }
        }
        return count;
    } 
    public static int sudukoSolver02(int[][] board,int vidx,ArrayList<Integer> zeroLocation){
        // if(vidx==81){
        //     return 1;
        // }
        if(vidx==zeroLocation.size()){
            print(board);
            System.out.println();
            return 1;
        }
        int zeroIdx=zeroLocation.get(vidx);
        int r=zeroIdx/9;
        int c=zeroIdx%9;
        // if(board[r][c]!=0) return sudukoSolver(board,vidx+1);
        int count=0;
        for(int num=1;num<=9;num++){
            if(isValid(board,r,c,num)) {
                board[r][c]=num;
                count+=sudukoSolver02(board,vidx+1,zeroLocation);
                board[r][c]=0;
            }
        }
        return count;
    } 
    public static void suduko(){
        int[][] board = {{3, 0, 0, 6, 0, 0, 0, 9, 2},  
                      {5, 2, 0, 0, 0, 0, 4, 0, 8},  
                      {0, 8, 7, 0, 0, 0, 0, 3, 1},  
                      {0, 0, 3, 0, 1, 0, 0, 8, 0},  
                      {9, 0, 0, 8, 6, 3, 0, 0, 5},  
                      {0, 5, 0, 0, 9, 0, 6, 0, 0},  
                      {1, 3, 0, 0, 0, 0, 2, 5, 0},  
                      {0, 0, 0, 0, 0, 0, 0, 7, 4},  
                      {0, 0, 5, 2, 0, 6, 3, 0, 0}};


        ArrayList<Integer> zeroes=new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                //2d to 1d
                if(board[i][j]==0) zeroes.add(i*9+j);
            }
        }
        System.out.println(sudukoSolver(board,0));
        // System.out.println(sudukoSolver02(board,0,zeroes));
    }
    // wordBreak ================================================================>
    public static int wordBreak_solve(String ques,int idx,String ans,int maxLenWord,HashSet<String> words){
        if(idx==ques.length()){
            System.out.println(ans);
            return 1;

        }
        int count=0;
        for(int i=idx+1;i<=(maxLenWord+idx+1) && i<=ques.length();i++){
            String str=ques.substring(idx,i);
            if(words.contains(str)){
                count+=wordBreak_solve(ques,i,ans+str+" ",maxLenWord,words);
            }
        }
        return count;
    }
    public static void wordBreak(){
        String ques="ilikesamsungandmango";
        String dictionary[]={
            "i","like","sam","sung","samsung","man","go","mango","mobile","ice","cream","icecream","ilike","and"
        };
        HashSet<String> words=new HashSet<>();
        int max=0;
        for(String str:dictionary){
            if(max<str.length()){
                max=str.length();
            }
            words.add(str);

        }
        System.out.println(wordBreak_solve(ques,0,"",max,words));
    }


 //Cryptoo
    static String a="send";
    static String b="more";
    static String c="money";
    static int[] charToNumber=new int[26];
    static boolean[] numberUsed=new boolean[10];

    public static int stringToNumber(String str){
        int num=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int val = charToNumber[ch-'a'];

            num = num * 10 + val;
        }

        return num;
    }
    public static int cryptoSolver(String str,int idx){
        if(idx == str.length()){
            int x = stringToNumber(a);
            int y = stringToNumber(b);
            int z = stringToNumber(c);

            if(x + y == z && charToNumber[a.charAt(0)-'a']!=0 && charToNumber[b.charAt(0)-'a']!=0 && charToNumber[c.charAt(0)-'a']!=0){
               System.out.println(x + "\n+" + y + "\n" + "----\n" + z + '\n');
                return 1;
            }

            return 0;
        }


        char ch=str.charAt(idx);
        int count = 0;
        for(int num = 0; num <= 9;num++){
            if(!numberUsed[num]){
                
                numberUsed[num] = true;
                charToNumber[ch-'a'] = num;
            
                count+=cryptoSolver(str,idx+1);
            
                charToNumber[ch-'a'] = 0;
                numberUsed[num] = false;
            }
        }

        return  count;
    }
    public static void isCryptoValid(){
        String str=a+b+c;

        int[] freq=new int[26];
        for(int i=0;i<str.length();i++) freq[str.charAt(i)-'a']++;

        str="";
        for(int i=0;i<26;i++) if(freq[i] > 0) str+=(char)(i + 'a');
        // System.out.println(str);

        System.out.println(cryptoSolver(str,0));
    }



    //CrossWord...................................................................................................
    public static void dislayCrossWord(char[][] board){
        for(char[] bo: board){
            for(char b: bo){
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    public static boolean canPlaceH(char[][] board,int r,int c,String word){
        for(int i=0;i<word.length();i++){
            if(r+i<board.length&&(board[r+i][c]=='-'||board[r+i][c]==word.charAt(i))){

            }else{
                return false;
            }
        }
        return true;
    }

    public static boolean[] PlaceH(char[][] board,int r,int c,String word){
        boolean[] loc=new boolean[word.length()];
        for(int i=0;i<word.length();i++){
            if(c+i<board[0].length&&board[r][c+i]=='-'){
                loc[i]=true;
                board[r][c+i]=word.charAt(i);
            }
        }

        return loc;
    }

    public static void unPlaceH(char[][] board,int r,int c,String word,boolean[] loc){
        for(int i=0;i<loc.length;i++){
            if(loc[i]){
                board[r][c+i]='-';
            }
        }
    }

    public static boolean canPlaceV(char[][] board,int r,int c,String word){

            for(int i=0;i<word.length();i++){
                if(r+i<board.length&&(board[r][c+i]=='-'||board[r][c+i]==word.charAt(i))){

                }else{
                    return false;
                }
            }
            return true;
    }

    public static boolean[] PlaceV(char[][] board,int r,int c,String word){
        boolean[] loc=new boolean[word.length()];
        for(int i=0;i<word.length();i++){
            if(r+i<board.length&&board[r+i][c]=='-'){
                loc[i]=true;
                board[r+i][c]=word.charAt(i);
            }
        }

        return loc;
    }

    public static void unPlaceV(char[][] board,int r,int c,String word,boolean[] loc){
        for(int i=0;i<loc.length;i++){
            if(loc[i]){
                board[r+i][c]='-';
            }
        }
    }


    public static int crossWord_(char[][] board,String[] words,int vidx){
        if(vidx == words.length){
            dislayCrossWord(board);
            System.out.println();
            return 1;
        }


        String word = words[vidx];
        int count=0;

        for(int i=0;i<board.length; i++){
            for(int j=0;j<board[0].length; j++){
                if(board[i][j]=='-' || board[i][j]==word.charAt(0)){
                    if(canPlaceH(board,i,j,word)){
                        boolean[] loc = PlaceH(board,i,j,word);
                        count+=crossWord_(board,words,vidx + 1);
                        unPlaceH(board,i,j,word,loc);
                    }

                    if(canPlaceV(board,i,j,word)){
                        boolean[] loc = PlaceV(board,i,j,word);
                        count+=crossWord_(board,words,vidx + 1);
                        unPlaceV(board,i,j,word,loc);
                    }
                }
            }
        }
        return count;
    }

    public static void crossWord(){
    char[][] board = {
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '-', '-', '-', '-', '-', '-', '+', '+'},
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '+', '+', '+', '+', '+', '+', '+', '+'},
        {'+', '-', '-', '-', '-', '-', '-', '+', '+', '+'},
        {'+', '-', '+', '+', '+', '-', '+', '+', '+', '+'},
        {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
        {'+', '+', '+', '+', '+', '-', '+', '+', '+', '+'},
        {'+', '+', '+', '+', '+', '+', '+', '+', '+', '+'}};

    String[] words = {"agra", "norway", "england", "gwalior"};
    System.out.println(crossWord_(board, words, 0));
}

}