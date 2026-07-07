import java.util.*;
class Fruits
{
	private int id;
	private String name;
	private int price;
	private int rating;

	public Fruits(int id, String name, int price, int rating)
	{
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
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
	public int getPrice()
	{
		return price;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public int getRating()
	{
		return rating;
	}
	public void setRating(int rating)
	{
		this.rating = rating;
	}
}
public class Main{
  public static void main(String[]args)
	{
		Scanner sc = new Scanner(System.in);
		Fruits[] ft = new Fruits[4];
		for(int i=0; i<4; i++)
		{
			int a = sc.nextInt();sc.nextLine();
			String b = sc.nextLine();
			int c = sc.nextInt();sc.nextLine();
			int d = sc.nextInt();sc.nextLine();
	
			ft[i] = new Fruits(a,b,c,d);
		}
		int rate = sc.nextInt(); 
    Fruits ans=findmax(ft,rate);
    if(ans!=null){
      System.out.println(ans.getId());

    }
    else{
      System.out.println("No such Fruit");
    }
  }
  public static Fruits findmax(Fruits []f,int r){
    Fruits[]arr=new Fruits[0];
    for(int i=0;i<f.length;i++){
      if(f[i].getRating()>r){
        arr=Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1]=f[i];
      }
    }
    if(arr.length>0){
    Fruits maxi=arr[0];
    for(int i=1;i<arr.length;i++){
      if(maxi.getPrice()<arr[i].getPrice()){
        maxi=arr[i];
      }
    }
    return maxi;
    }
    else{
      return null;
    }
  }
}
