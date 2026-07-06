import java.util.*;
class Flower{
  private int fid;
  private String fname;
  private int price;
  private int rating;
  private String type;

  public Flower(int fid,String fname,int price,int rating,String type){
    this.fid=fid;
    this.fname=fname;
    this.price=price;
    this.rating=rating;
    this.type=type;
  }

  public int getfid(){
    return fid;
  }
  public String getfname(){
    return fname;
  }
  public int getprice(){
    return price;
  }
  public int getrating(){
    return rating;
  }
  public String gettype(){
    return type;
  }
  public void setfid(int fid){
    this.fid=fid;
  }
   public void setfname(String fname){
    this.fname=fname;
  }
   public void setprice(int price){
    this.price=price;
  }
   public void setrating(int rating){
    this.rating=rating;
  }
   public void settype(String type){
    this.type=type;
  }

}
class Main{
  public static void main( String []args){
    Scanner sc=new Scanner(System.in);
    Flower[] arr=new Flower[4];
    for(int i=0;i<arr.length;i++){
      int a=sc.nextInt();sc.nextLine();
      String b=sc.nextLine();
      int c=sc.nextInt();sc.nextLine();
      int d=sc.nextInt();sc.nextLine();
      String e=sc.nextLine();
      arr[i]=new Flower(a,b,c,d,e);
    }
    String x=sc.nextLine();
    int ans=findMin(arr,x);
    if(ans!=0){
      System.out.println(ans);
    }
    else{
      System.out.println("There is no flower with given type.");
    }
  }

  public static int findMin(Flower[] f, String x){
    Flower[] a=new Flower[0];
    for(int i=0;i<f.length;i++){
        if(f[i].gettype().equalsIgnoreCase(x) && f[i].getrating()>3){
          a=Arrays.copyOf(a,a.length+1);
          a[a.length-1]=f[i];
        }
    }
    if(a.length>0){
    Flower mini=a[0];
    for(int i=1;i<a.length;i++){
      if(a[i].getprice()<mini.getprice()){
        mini=a[i];
      }
    }
    return mini.getfid();
    }
    else{
      return 0;
    }
  }
}

