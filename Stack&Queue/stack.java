class stack{
    private int tos;
    private int arr[];
    private int size;
    private int maxSize;

    protected void setValues(int n){
        this.tos=-1;
        this.arr=new int[n];
        this.size=0;
        this.maxSize=n;
    }
    public stack(int n){
        setValues(n);
    }
    public stack(){
        setValues(10);
    }
    @Override
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=this.tos;i>=0;i--){
            sb.append(this.arr[i]);
            if(i!=0) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }

    public int size(){
        return this.size;
    }

    public int capacity(){
        return this.maxSize;
    }

    protected void push_(int val){
        this.arr[++this.tos]=val;
        this.size++;
    }
    public void push(int val) throws Exception{
        if(this.size==this.maxSize){
            throw new Exception("StackIsFull!!!!!!");
        }
        push_(val);
    }

    protected int top_(){
        return this.arr[this.tos];
    }
    public int top() throws Exception{
        if(this.size==0){
            throw new Exception("StackIsEmpty!!!!");
        }
        return top_();
    }
    protected int pop_(){
        int rv=this.arr[this.tos];
        this.arr[this.tos]=0;
        this.tos--;
        this.size--;
        return rv;

    }
    public int pop() throws Exception{
        if(this.size==0){
            throw new Exception("StackIsEmpty!!!!");
        }
        return pop_();
    }
}