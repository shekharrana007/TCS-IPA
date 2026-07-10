 
import java.util.*;
class Car
{
    private String make;
    private String model;
    private int year;
    private double price;
    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
}
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Car[] car = new Car[4];
        for (int i = 0; i < car.length; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            double d = sc.nextDouble();sc.nextLine();

            car[i] = new Car(a,b,c,d);
        }
        String x = sc.nextLine();
        String z = sc.nextLine();
        Car ans=find(car);
        if(ans!=null){
            System.out.println(ans.getMake());
            System.out.println(ans.getModel());
            System.out.println(ans.getPrice());
            System.out.println(ans.getYear());
        }else{
            System.out.println("Not found");
        }
        Car ans1=make(car,x,z);
        if(ans1!=null){
            System.out.println(ans1.getYear());
            System.out.println(ans1.getPrice());
        }
        else{
            System.out.println("Not found");
        }

    }
    public static Car find(Car[]c){
        double max=0;
        for(int i=0;i<c.length;i++){
            if(c[i].getPrice()>max){
                max=c[i].getPrice();
            }
        }
        for(int i=0;i<c.length;i++){
            if(c[i].getPrice()==max){
                return c[i];
            }
        }
        return null;
    }
    public static Car make(Car[]c,String x,String z){
        for(int i=0;i<c.length;i++){
            if(c[i].getMake().equalsIgnoreCase(x)&& c[i].getModel().equalsIgnoreCase(z)){
                return c[i];
            }
        }
        return null;
    }
}
