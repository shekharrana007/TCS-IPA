import java.util.*;

class Phone{
  private int pid;
  private String os;
  private String brand;
  private int price;

  public Phone(int pid,String os,String brand,int price){
    this.pid=pid;
    this.os=os;
    this.brand=brand;
    this.price=price;
  }
  public int getpid(){
    return pid;
  }
  public void setpid(int pid){
    this.pid=pid;
  }
  public String getos(){
    return os;
  }
  public void setos(String os){
    this.os=os;
  }
  public String getbrand(){
    return brand;
  }
  public void setbrand(String brand){
    this.brand=brand;
  }
  public int getprice(){
    return price;
  }
  public void setprice(int price){
    this.price=price;
  }
}

class Main{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    Phone[] arr=new Phone[4];
    for(int i=0;i<arr.length;i++){
      int a=sc.nextInt();sc.nextLine();
      String b=sc.nextLine();
      String c=sc.nextLine();
      int d=sc.nextInt();sc.nextLine();
      arr[i]=new Phone(a,b,c,d);
    }
    String x=sc.nextLine();
    String z=sc.nextLine();

    int ans1=findPrice(arr,x);
    if(ans1>0){
      System.out.println(ans1);
    }
    else{
      System.out.println("The given brand is not avaliable");
    }

    Phone[] ans2=getPhone(arr,z);
    if(ans2 !=null){
      for(int i=0;i<ans2.length;i++){
        if(ans2[i].getprice()>=50000){
          System.out.println(ans2[i].getpid());
        }
      }
      
    }
    else{
      System.out.println("No such brand");
    }

  }
  public static Phone[]getPhone(Phone[]p,String z){
    Phone[]ph=new Phone[0];
    for(int i=0;i<p.length;i++){
      if(p[i].getos().equalsIgnoreCase(z)){
        ph=Arrays.copyOf(ph,ph.length+1);
        ph[ph.length-1]=p[i];
      }
    }
    if(ph.length>0){
      return ph;
    }
    else{
      return null;
    }
  }

  public static int findPrice(Phone[]p,String x){
    int sum=0;
    for(int i=0;i<p.length;i++){
      if(p[i].getbrand().equalsIgnoreCase(x)){
        sum+=p[i].getprice();
      }
    }
    if(sum>0){
      return sum;
    }
    else{
      return 0;
    }
  }
}
