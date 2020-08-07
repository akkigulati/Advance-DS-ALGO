import java.io.*;
import java.util.*;

class L002{
    public static int printPerm(String str,String asf){
        if(str.length()==0){
            System.out.println(asf);
            return 1;
        }
        int count=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String newS=str.substring(0,i)+str.substring(i+1);
           count+= printPerm(newS,asf+ch);
        }
        return count;
    }
    public static int printPermNoDupli(String str,String asf){
        if(str.length()==0){
            System.out.println(asf);
            return 1;
        }
        int count=0;
        boolean visited[]=new boolean[26];
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            String newS=str.substring(0,i)+str.substring(i+1);
            if(!visited[ch-'a'])
            count+= printPermNoDupli(newS,asf+ch);
            visited[ch-'a']=true;
        }
        return count;
    }
        
    public static int letterCombinations_set2(String digits,int idx,String[] codes,List<String> ans,String res){
        if(idx==digits.length()){
            ans.add(res);
            return 1;
        }

        int cidx=digits.charAt(idx)-'0';
        String code=codes[cidx];
        int count=0;
        for(int i=0;i<code.length();i++){
            count+=letterCombinations_set2(digits,idx+1,codes,ans,res+code.charAt(i));
        }
        //checking double digits too
        if(idx<digits.length()-1){
            cidx=cidx*10+digits.charAt(idx+1)-'0';
            if(cidx>=10&&cidx<=11){
                code=codes[cidx];
                for(int i=0;i<code.length();i++){
                    count+=letterCombinations_set2(digits,idx+2,codes,ans,res+code.charAt(i));
                }
            }
        }
        return count;
    }
    public static void Keypad(String digits){
         String codes[]={
            ",./",
            "[]",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz","&^%","!@#"
        };
        List<String> ans=new ArrayList<>();
        letterCombinations_set2(digits,0,codes,ans,"");
        System.out.println(ans);
    }
    
      static  public int numDecodings(String s) {
        if(s.length()==0) return 0;
        return numDecodings(s, 0 ,"");
    
     }
      static  public int numDecodings(String s,int idx,String ans){
        if(idx==s.length()){
            System.out.println(ans);
            return 1;
        }
         char ch=s.charAt(idx);
        int cidx=ch-'0';
        if(cidx==0) return 0;
    
        int count=0;
        count+=numDecodings(s,idx+1,ans+(char)(cidx+'a'-1));
    
        if(idx<s.length()-1){
            cidx= cidx*10 + (s.charAt(idx+1)-'0');
            if(cidx>=10 && cidx<=26){
             count+=numDecodings(s,idx+2,ans+(char)(cidx+'a'-1));
            }
        }
         
        return count;
     }
    
    public static void main(String[] argv){
        // ArrayList<String> ans=new ArrayList<>();
        // printPermNoDupli("ABAB","",ans);
        // System.out.println(ans);
        // System.out.println(printPermNoDupli("abad",""));
        // Keypad("");
        System.out.println(numDecodings("226"));
    }
}