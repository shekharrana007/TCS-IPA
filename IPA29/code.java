import java.util.*;
 class Newspaper{
    int regNo;
    String name;
    int publicationYear;
    int price;

    public Newspaper(int regNo, String name, int publicationYear, int price)
    {
        this.regNo = regNo;
        this.name = name;
        this.publicationYear = publicationYear;
        this.price = price;
    }

    public int getRegNo()
    {
        return regNo;
    }
    public void setRegno(int regNo)
    {
        this.regNo=regNo;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public int getPublicationYear()
    {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear)
    {
        this.publicationYear = publicationYear;
    }
    public int getPrice()
    {
        return price;
    }
    public void setPrice(int price)
    {
        this.price = price;
    }
}
class Main{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);
        Newspaper[] np = new Newspaper[4];

        for(int i=0; i<np.length; i++)
        {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            int d = sc.nextInt();

            np[i] = new Newspaper(a,b,c,d);
        }

        int x = sc.nextInt();sc.nextLine();
        String z = sc.nextLine();
        int ans=findPrice(np,x);
        if(ans!=0){
            System.out.println(ans);
        }
        else{
            System.out.println("Not found");
        }
        Newspaper ans1=search(np,z);
        if(ans1!=null){
            System.out.println("regNo-"+ans1.getRegNo());
            System.out.println("name-"+ans1.getName());
            System.out.println("publicationYear-"+ans1.getPublicationYear());
            System.out.println("price-"+ans1.getPrice());
        }
        else{
            System.out.println("Not found");
        }

    }
    public static int findPrice(Newspaper[]n,int x){
        int sum=0;
        for(int i=0;i<n.length;i++){
            if(n[i].getPublicationYear()==x){
                sum+=n[i].getPrice();
            }
        }
        if(sum==0)return 0;
        return sum;

    }
    public static Newspaper search(Newspaper[]n,String z){
        for(int i=0;i<n.length;i++){
            if(n[i].getName().equalsIgnoreCase(z)){
                return n[i];
            }
        }
        return null;
    }
}
