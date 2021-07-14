public class Calculator {

    public void add(int a, int b){
        System.out.println(a+b);
    }

    public void sub(int a, int b){
        System.out.println(a-b);
    }

    public int mul(int a , int b){
        return a*b;
    }
    public double div (double a , double b){
        return a/b;
    }

    public static void main(String[] args) {

        Calculator cal = new Calculator();
        cal.add(1,2);
        cal.sub(1,2);
        System.out.println(cal.mul(1,2));
        System.out.println(cal.div(1,2));

    }
}
