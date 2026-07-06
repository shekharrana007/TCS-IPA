import java.util.*;

class Medicine{
  private String mname;
  private String batch;
  private String dis;
  private int price;

  public Medicine(String mname,String batch, String dis, int price){
    this.mname=mname;
    this.batch=batch;
    this.dis=dis;
    this.price=price;

  }

  public String getmname(){
    return mname;
  }
  public void setmname(String mname){
    this.mname=mname;
  }
  public String getbatch(){
    return batch;
  }
  public void setbatch(String batch){
    this.batch=batch;
  }
  public String getdis(){
    return dis;
  }
  public void setdis(String dis){
    this.dis=dis;
  }
  public int getprice(){
    return price;
  }
  public void setprice(int price){
    this.price=price;
  }
}
class Main{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    Medicine[] arr=new Medicine[4];
    for(int i=0;i<arr.length;i++){
      String a=sc.nextLine();
      String b=sc.nextLine();
      String c=sc.nextLine();
      int d=sc.nextInt();sc.nextLine();
      arr[i]=new Medicine(a,b,c,d);
    }
    String x=sc.nextLine();
    int[] ans=getPrice(arr,x);
    if(ans != null){
      for(int i=0;i<ans.length;i++){
        System.out.println(ans[i]);
      }
    }
     

  }


  public static int[] getPrice(Medicine[] m,String x){
    int[]med=new int[0];
    for(int i=0;i<m.length;i++){
      if(m[i].getdis().equalsIgnoreCase(x)){
        med=Arrays.copyOf(med,med.length+1);
        med[med.length-1]=m[i].getprice();
        Arrays.sort(med);
      }
    }
    if(med.length>0){
      return med;
    }
    else{
      return null;
    }
  }
}
