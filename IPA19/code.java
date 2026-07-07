import java.util.*;
class Inv{
  private String id;
  private int mq;
  private int cq;
  private int th;

  public Inv(String id,int mq, int cq, int th){
    this.id=id;
    this.mq=mq;
    this.cq=cq;
    this.th=th;
  }

  public String getid(){
    return id;
  }
  public int getmq(){
    return mq;
  }
  public int getcq(){
    return cq;
  }
  public int getth(){
    return th;
  }

  public void setid(String id){
    this.id=id;
  }
  public void setmq(int mq){
    this.mq=mq;
  }
  public void setcq(int cq){
    this.cq=cq;
  }
  public void setth(int th){
    this.th=th;
  }
}

class Main{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    Inv[] arr=new Inv[4];
    for(int i=0;i<arr.length;i++){
      String a=sc.nextLine();
      int b=sc.nextInt();sc.nextLine();
      int c=sc.nextInt();sc.nextLine();
      int d=sc.nextInt();sc.nextLine();
      arr[i]=new Inv(a,b,c,d);
    }

    int x=sc.nextInt(); 
    Inv[] ans=rep(arr,x);
    if(ans!=null){
      for(int i=0;i<ans.length;i++){
        if(ans[i].getth()>75){
          System.out.println(ans[i].getid()+" Critical Filling");
        }
        else if(ans[i].getth()<75 && ans[i].getth()>50){
          System.out.println(ans[i].getid()+" Moderate Filling");
        }
        else {
          System.out.println(ans[i].getid()+" Non-Critical Filling");
        }
      }
    }
  }


  public static Inv[]rep(Inv[] a,int x){
    Inv[] arr=new Inv[0];
    for(int i=0;i<a.length;i++){
      if(a[i].getth()<=x){
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
}
