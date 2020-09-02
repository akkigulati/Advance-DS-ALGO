
class client{
    public static void main(String argv[])throws Exception{
        exper1();
    }
    public static void exper1() throws Exception{
        Dstack st=new Dstack();
        for(int i=0;i<20;i++){
            st.push((int)(Math.random()*100));
        }
        // st.pop();
        st.push(99);
        System.out.println(st);
    }
}