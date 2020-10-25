package base.annotation;

public class Cal {
    @Check({1,2})
    public int add(int a,int b){
        return a+b;
    }
    @Check({1,2})
    public int sub(int a,int b){
        return a-b;
    }
    @Check({1,2})
    public int mul(int a,int b){
        return a*b;
    }
    @Check({1,0})
    public int div(int a,int b){
        return a/b;
    }
}
