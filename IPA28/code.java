import java.util.*;
class TravelAgencies
{
    int regno;
    String agencyName;
    String packageType;
    int price;
    boolean flightFacility;
// constructor
    public TravelAgencies(int regno, String agencyName, String packageType, int price, boolean flightFacility)
    {
        this.regno = regno;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }
// getter method, setter method
    public int getRegno()
    {
        return regno;
    }
    public void setRegno(int regno)
    {
        this.regno = regno;
    }
    public String getAgencyName()
    {
        return agencyName;
    }
    public void setAgencyName(String agencyName)
    {
        this.agencyName = agencyName;
    }
    public String getPackageType()
    {
        return packageType;
    }
    public void setPackageType(String packageType)
    {
        this.packageType = packageType;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
    public boolean getFlightFacility()
    {
        return flightFacility;
    }
    public void setFlightFacility(boolean flightFacility)
    {
        this.flightFacility = flightFacility;
    }
}
class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TravelAgencies[] ta = new TravelAgencies[4];
        for(int i =0; i<4; i++)
        {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();sc.nextLine();
            boolean e = sc.nextBoolean();

            ta[i] = new TravelAgencies(a,b,c,d,e);
        }
        int x = sc.nextInt();sc.nextLine();
        String z = sc.nextLine();
        int ans=high(ta);
            System.out.println(ans);
            TravelAgencies[] ans1=agency(ta,x,z);
            for(int i=0;i<ans1.length;i++){
            System.out.println(ans1[i].getAgencyName()+":"+ans1[i].getPrice());
            }

    }
    public static int high(TravelAgencies[]t){
        int x=t[0].getPrice();
        for(int i=1;i<t.length;i++){
            if(t[i].getPrice()>x){
                x=t[i].getPrice();
            }
        }
        if(x==0)return 0;
        return x;
    }
    public static TravelAgencies[] agency(TravelAgencies[]t,int x,String z){
        TravelAgencies[]arr=new TravelAgencies[0];
        for(int i=0;i<t.length;i++){
            if(t[i].getFlightFacility()==true && t[i].getRegno()==x && t[i].getPackageType().equalsIgnoreCase(z)){
                arr=Arrays.copyOf(arr,arr.length+1);
                arr[arr.length-1]=t[i];
            }
        }
        return arr;
    }

}
