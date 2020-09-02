class Dstack extends stack{
    
    Dstack(){
        super();
    }
    Dstack(int n){
        super(n);
    }
    Dstack(int[] arr){
        super(arr.length*2);
        for(int ele:arr){
            super.push_(ele);
        }
    }
    @Override
    public void push(int val) throws Exception{
        if(super.capacity()==super.size()){
            int temp[]=new int[super.size()];
            int i=super.size()-1;
            while(super.size()!=0) temp[i--]=super.pop_();

            super.setValues(2*temp.length);

            for(int ele:temp) super.push(ele);

        }
        super.push_(val);
    }
  
}