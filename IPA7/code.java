import java.util.*;

class Autono{
  private int cid;
  private String brand;
  private int testcon;
  private int testpass;
  private String evn;

  public Autono(int cid,String brand, int testcon,int testpass, String evn){
    this.cid=cid;
    this.brand=brand;
    this.testcon=testcon;
    this.testpass=testpass;
    this.evn=evn;
  }

public int getcid(){
  return cid;
}
public void  setcid(int cid){
  this.cid=cid;
}
public String getbrand(){
  return brand;
}
public void setbrand(String brand){
  this.brand=brand;
}
public int gettestcon(){
  return testcon;
}
public void settestcon(int testcon){
  this.testcon=testcon;
}
public int gettestpass(){
  return testpass;
}
public void settestpass(int testpass){
  this.testpass=testpass;
}
public String getenv(){
  return evn;
}
public void setevn(String evn){
  this.evn=evn;
}
}

class Main{
  public static void main(String [] args){

    Scanner sc=new Scanner(System.in);
    Autono[] arr=new Autono[4];
    for(int i=0;i<arr.length;i++){
      int a=sc.nextInt();sc.nextLine();
      String b=sc.nextLine();
      int c=sc.nextInt();sc.nextLine();
      int d=sc.nextInt();sc.nextLine();
      String e=sc.nextLine();
      arr[i]=new Autono(a,b,c,d,e);
    }
    String x=sc.nextLine();
    String z=sc.nextLine();

    int ans1=findPass(arr,x);
    if(ans1>0){
      System.out.println(ans1);
    }
    else{
      System.out.println("NO test passed in the particular evn");
    }

    Autono[] ans2=updategrade(arr,z);
    if(ans2 !=null){
    for(int i=0;i<ans2.length;i++){
     int rate=(ans2[i].gettestpass()*100)/ans2[i].gettestcon();
     if(rate>=80){
      System.out.println(ans2[i].getbrand()+":: A1");
     }
     else{
      System.out.println(ans2[i].getbrand()+":: B2");
     }
    }
    }
    else{
      System.out.println("No car available with specific brand");
    }
  }

  public static Autono[] updategrade(Autono[] a, String z){
    Autono[] arr=new Autono[0];
    for(int i=0;i<a.length;i++){
      if(a[i].getbrand().equalsIgnoreCase(z)){
        arr=Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1]=a[i];
      }
    }
    if(arr.length>0){
      return arr;
    }
    else{
      return null;
    }
  }

  public static int findPass(Autono[] a,String x){
    int sum=0;
    for(int i=0;i<a.length;i++){
      if(a[i].getenv().equalsIgnoreCase(x)){
        sum+=a[i].gettestpass();
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
