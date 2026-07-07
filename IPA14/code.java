import java.util.*;
class Engine{
  private int eid;
  private String ename;
  private String etype;
  private double eprice;

  public Engine(int eid,String ename,String etype,double eprice){
    this.eid=eid;
    this.ename=ename;
    this.etype=etype;
    this.eprice=eprice;
  }

  public int geteid(){
    return eid;
  }
  public String getename(){
    return ename;
  }
  public String getetype(){
    return etype;
  }
  public double geteprice(){
    return eprice;
  }
  public void seteid(int eid){
    this.eid=eid;
  }
  public void setename(String ename){
    this.ename=ename;
  }
  public void setetype(String etype){
    this.etype=etype;
  }
  public void seteprice(double eprice){
    this.eprice=eprice;
  }
}

class Main{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    Engine[] arr=new Engine[4];
    for(int i=0;i<arr.length;i++){
        int a=sc.nextInt();sc.nextLine();
        String b=sc.nextLine();
        String c=sc.nextLine();
        double d=sc.nextDouble();sc.nextLine();
        arr[i]=new Engine(a,b,c,d);
    }
    String x=sc.nextLine();
    String z=sc.nextLine();
    int ans1=findAvg(arr,x);
    if(ans1>0){
      System.out.println(ans1);
    }
    else{
      System.out.println("There are no engine with given type");
    }
    Engine[] ans2=search(arr,z);
    if(ans2!=null){
      for(int i=0;i<ans2.length;i++){
        System.out.println(ans2[i].geteid());
      }
    }
    else{
      System.out.println("There are no engine with the given name");
    }
    
  }

  public static Engine[] search(Engine[]e,String z){
    Engine [] arr=new Engine[0];
    for(int i=0;i<e.length;i++){
      if(e[i].getename().equalsIgnoreCase(z)){
        arr=Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1]=e[i];
      }
    }
    Engine temp;
    if(arr.length>0){
      for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++){
          temp=arr[i];
          arr[i]=arr[j];
          arr[j]=temp;
        }
      }
      return arr;
    }
    else{
      return null;
    }
  }
  public static int findAvg(Engine[]e, String x){
    int sum=0;
    int count=0;
    for(int i=0;i<e.length;i++){
      if(e[i].getetype().equalsIgnoreCase(x)){
        sum+=e[i].geteprice();
        count++;
      }
    }
    if(count>0){
      return sum/count;
    }
    else{
      return 0;
    }
  }
}
