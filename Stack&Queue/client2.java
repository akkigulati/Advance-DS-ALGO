class client2{
    public static void main(String argv[]) throws Exception{
        queue qu=new queue();
        for(int i=0;i<10;i++){
            qu.push(i);
        }
        qu.remove();
        //  qu.push(99);
        System.out.println(qu);
    }
}