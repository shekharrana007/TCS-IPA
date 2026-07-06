import java.util.*;
class Antenna
{
	private int id;
	private String name,lead;
	private double VSWR;
	public Antenna(int id, String name, String lead, double VSWR)
	{
		this.id = id;
		this.name = name;
		this.lead = lead;
		this.VSWR = VSWR;
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
	public String getLead()
	{
		return lead;
	}
	public void setLead(String lead)
	{
		this.lead = lead;
	}
	public double getVSWR()
	{
		return VSWR;
	}
	public void setVSWR()
	{
		this.VSWR=VSWR;
	}
}

class Main{
  public static void main(String[]args){
    Scanner sc = new Scanner(System.in);
		Antenna[] an = new Antenna[4];
		for(int i=0; i<4; i++)
		{
			int a = sc.nextInt();sc.nextLine();
			String b = sc.nextLine();
			String c = sc.nextLine();
			double d = sc.nextDouble();sc.nextLine();
			
			an[i]=new Antenna(a,b,c,d);
		}	
		String str = sc.nextLine();
		double num = sc.nextDouble();
    int ans1=search(an,str);
    if(ans1 !=0){
      System.out.println(ans1);
    }
    else{
      System.out.println("There is no antenna with given parameter");
    }
    Antenna[] ans2=sortAntenna(an,num);
    if(ans2!=null){
      for(int i=0;i<ans2.length;i++){
        System.out.println(ans2[i].getLead());
      }
    }
    else{
      System.out.println("No Antenna found");
    }
  }
  public static int  search(Antenna[]a,String str){
    for(int i=0;i<a.length;i++){
      if(a[i].getName().equalsIgnoreCase(str)){
        return a[i].getId();
      }
    }
    return 0;
  }
  public static Antenna[] sortAntenna(Antenna[]a,double num){
    Antenna[] arr=new Antenna[0];
    for(int i=0;i<a.length;i++){
      if(a[i].getVSWR()<num){
        arr=Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1]=a[i];
      }
    }
    Antenna temp;
    if(arr.length>0){
      for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++){
          if(arr[i].getVSWR()>arr[j].getVSWR()){
          temp=arr[i];
          arr[i]=arr[j];
          arr[j]=temp;
          }
        }
      }
      return arr;
    }
    else{
      return null;
    }
  }
}
