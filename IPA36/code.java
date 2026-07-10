 
import java.util.*;
class College
{
    int id, contactNo, pin;
    String name, address;

    public College(int id, String name, int contactNo, String address, int pin)
    {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.pin = pin;
    }

    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getContactNo()
    {
        return contactNo;
    }
    public void setContactNo(int contactNo)
    {
        this.contactNo = contactNo;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public int getPin()
    {
        return pin;
    }
    public void setPin(int pin)
    {
        this.pin= pin;
    }
}
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();sc.nextLine();
        College[] ct = new College[n];

        for (int i=0; i<n; i++)
        {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            String d = sc.nextLine();
            int e = sc.nextInt();sc.nextLine();

            ct[i]= new College(a,b,c,d,e);
        }

        String x = sc.nextLine();
        College ans=pin(ct);
        if(ans!=null){
            System.out.println("id-"+ans.getId());
            System.out.println("name-"+ans.getName());
            System.out.println("contactNo-"+ans.getContactNo());
            System.out.println("address-"+ans.getAddress());
            System.out.println("pincode-"+ans.getPin());
            
        }
        College ans1=search(ct,x);
        if(ans1!=null){
            System.out.println("id-"+ans1.getId());
            System.out.println("name-"+ans1.getName());
            System.out.println("contactNo-"+ans1.getContactNo());
            System.out.println("address-"+ans1.getAddress());
            System.out.println("pincode-"+ans1.getPin());
            
        }
    }
    public static College pin(College[]c){
        int maxi=0;
        for(int i=0;i<c.length;i++){
            if(c[i].getPin()>maxi){
                maxi=c[i].getPin();
            }
        }
        for(int i=0;i<c.length;i++){
            if(c[i].getPin()==maxi){
                return c[i];
            }
        }
        return null;
    }
    public static College search(College[]c,String x){
        for(int i=0;i<c.length;i++){
            if(c[i].getAddress().equalsIgnoreCase(x)){
                return c[i];
            }
        }
        return null;
    }

}
