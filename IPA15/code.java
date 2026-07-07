import java.util.*;
class Footwear
{
	private int id;
	private String name;
	private String type;
	private int price;

	public Footwear(int id, String name, String type, int price)
	{
		this.id=id;
		this.name = name;
		this.type = type;
		this.price = price;
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
		this.name=name;
	}
	public String getType()
	{
		return type;
	}
	public void setType(String type)
	{
		this.type = type;
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
public class Main
{
	public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		Footwear[] ft = new Footwear[5];
		for(int i=0; i<5; i++)
		{
			int a = sc.nextInt();sc.nextLine();
			String b = sc.nextLine();
			String c = sc.nextLine();
			int d = sc.nextInt();sc.nextLine();

			ft[i]=new Footwear(a,b,c,d);
		}
	
		String x = sc.nextLine();
		String z = sc.nextLine();
    int ans1=getCount(ft,x);
    if(ans1>0){
      System.out.println(ans1);
    }
    else{
      System.out.println("Footwear not available");
    }
    Footwear ans2=second(ft,z);
    if(ans2!=null){
      
      System.out.println(ans2.getId());
      System.out.println(ans2.getName());
      System.out.println(ans2.getPrice());
     
    }
    else{
      System.out.println("Brand not available");
    }
  }
  public static int getCount(Footwear[]f,String x){
    int count=0;
    for(int i=0;i<f.length;i++){
      if(f[i].getType().equalsIgnoreCase(x)){
        count++;
      }
    }
    if(count>0){
      return count;
    }
    else{
      return 0;
    }
    
  }
  public static Footwear second(Footwear[]f,String z){
    Footwear[] arr=new Footwear[0];
    for(int i=0;i<f.length;i++){
      if(f[i].getName().equalsIgnoreCase(z)){
        arr=Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1]=f[i];
      }
    }
    if(arr.length>0){
      int maxi=Integer.MIN_VALUE;
      int sec=Integer.MIN_VALUE;
      for(int i=0;i<arr.length;i++){
          int sal=arr[i].getPrice();
          if(sal>maxi){
            sec=maxi;
            maxi=sal;
          }
          else if(sal>sec && sal !=maxi){
            sec=sal;
          }
      }
      for(int i=0;i<arr.length;i++){
      if(arr[i].getPrice()==sec){
        return arr[i];
      }
    }
       
    }
    
     return null;
  }
}
