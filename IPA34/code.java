 
import java.util.*;
class HeadSets
{
    private String hname;
    private String brand;
    private int price;
    private boolean available;
    public HeadSets(String hname, String brand, int price,boolean available)
    {
        this.hname = hname;
        this.brand = brand;
        this.price = price;
        this.available = available;
    }
    public String getHname()
    {
        return hname;
    }
    public void setHname(String hname)
    {
        this.hname = hname;
    }
    public String getBrand()
    {
        return brand;
    }
    public void setBrand(String brand)
    {
        this.brand = brand;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public boolean getAvailable()
    {
        return available;
    }
    public void setAvailable(boolean available)
    {
        this.available = available;
    }
}
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HeadSets[] hs = new HeadSets[4];
        for (int i = 0; i < hs.length; i++) {
            String a = sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            boolean d = sc.nextBoolean();sc.nextLine();

            hs[i] = new HeadSets(a,b,c,d);
        }
        String br = sc.nextLine();
        int ans=findP(hs,br);
        if(ans>0){
            System.out.println(ans);
        }else{
            System.out.println("Not found");
        }
        HeadSets ans1=find(hs);
        if(ans1!=null){
            System.out.println(ans1.getHname());
            System.out.println(ans1.getPrice());
        }
        else{
            System.out.println("Not found");
        }
    }
    public static int findP(HeadSets[]h,String x){
        int sum=0;
        for(int i=0;i<h.length;i++){
            if(h[i].getBrand().equalsIgnoreCase(x)){
                sum+=h[i].getPrice();
            }
        }
        if(sum==0)return 0;
        return sum;
    }
    public static HeadSets find(HeadSets[]h){
        HeadSets[]arr=new HeadSets[0];
        for(int i=0;i<h.length;i++){
            if(h[i].getAvailable()==true){
                arr=Arrays.copyOf(arr,arr.length+1);
                arr[arr.length-1]=h[i];
            }
        }
        if(arr.length==0)return null;
        HeadSets temp;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i].getPrice()>arr[j].getPrice()){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr[1];
    }
}
