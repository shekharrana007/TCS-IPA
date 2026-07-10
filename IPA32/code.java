 
import java.util.*;
class MobileDetails
{
    private int id;
    private int price;
    private String brand;
    private boolean isFlagShip;
    
    public MobileDetails(int id, int price, String brand, boolean isFlagShip) {
        this.id = id;
        this.price = price;
        this.brand = brand;
        this.isFlagShip = isFlagShip;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public boolean isFlagShip() {
        return isFlagShip;
    }
    public void setFlagShip(boolean isFlagShip) {
        this.isFlagShip = isFlagShip;
    }
    
}
class Main{
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        MobileDetails[] mb = new MobileDetails[5];
        for (int i = 0; i < mb.length; i++) 
        {
            int a = sc.nextInt();sc.nextLine();
            int b = sc.nextInt();sc.nextLine();
            String c = sc.nextLine();
            boolean d = sc.nextBoolean();sc.nextLine();

            mb[i] = new MobileDetails(a, b, c, d);
        }
        String br = sc.nextLine();

        int ans=getsum(mb,br);
        if(ans>0){
            System.out.println(ans);
        }
        else{
            System.out.println("Not found");
        }

    MobileDetails[] ans1=sec(mb);
    if(ans1!=null){
        for(int i=0;i<ans1.length;i++){
            System.out.println(ans1[i].getBrand()+" : "+ans1[i].getPrice());
        }
    }
    else{
        System.out.println("Not found");
    }
    }
    public static int getsum(MobileDetails[]m,String x){
            int sum=0;
            for(int i=0;i<m.length;i++){
                if(m[i].getBrand().equalsIgnoreCase(x)){
                    sum+=m[i].getPrice();
                }
            }
            if(sum>0){
                return sum;
            }
            return 0;
    }

    public static MobileDetails[] sec(MobileDetails[]m){
        MobileDetails temp;
        for(int i=0;i<m.length;i++){
            for(int j=i+1;j<m.length;j++){
                if(m[i].getPrice()>m[j].getPrice()){
                    temp=m[i];
                    m[i]=m[j];
                    m[j]=temp;
                }
            }
        }
        MobileDetails[]arr=new MobileDetails[0];
        for(int i=1;i<m.length;i++){
            if(m[i].getPrice()>m[0].getPrice()){
                arr=Arrays.copyOf(arr,arr.length+1);
                arr[arr.length-1]=m[i];
                break;
            }
        }
        for(int i=0;i<m.length;i++){
            if(arr[0].getPrice()==m[i].getPrice() && arr[0].getId()!=m[i].getId()){
                arr=Arrays.copyOf(arr,arr.length+1);
                arr[arr.length-1]=m[i];
            }
        }
        if(arr.length==0)return null;
        return arr;


    }
    }
