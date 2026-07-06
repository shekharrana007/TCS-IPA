import java.util.*;
class Naval{
  private int vid;
  private String vname;
  private int vplan;
  private int vcomp;
  private String purp;

  public Naval(int vid,String vname,int vplan,int vcomp,String purp){
    this.vid=vid;
    this.vname=vname;
    this.vplan=vplan;
    this.vcomp=vcomp;
    this.purp=purp;
  }
  public int getvid(){
    return vid;
  }
   public String getvname(){
    return vname;
  }
   public int getvplan(){
    return vplan;
  }
   public int getvcomp(){
    return vcomp;
  }
   public String getpurp(){
    return purp;
  }
  public void setvid(int vid){
    this.vid=vid;
  }
  public void setvname(String vname){
    this.vname=vname;
  }
  public void setvplan(int vplan){
    this.vplan=vplan;
  }
  public void setvcomp(int vcomp){
    this.vcomp=vcomp;
  }
  public void setpurp(String purp){
    this.purp=purp;
  }
}

class Main{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    Naval[]arr=new Naval[4];
    for(int i=0;i<arr.length;i++){
      int a=sc.nextInt();sc.nextLine();
      String b=sc.nextLine();
      int c=sc.nextInt();sc.nextLine();
      int d=sc.nextInt();sc.nextLine();
      String e=sc.nextLine();
      arr[i]=new Naval(a,b,c,d,e);
    }
    int x=sc.nextInt();sc.nextLine();
    String z=sc.nextLine();

    int ans1=findAvg(arr,x);
    if(ans1>0){
      System.out.println(ans1);
    }
    else{
      System.out.println("Not found");
    }
    Naval[] ans2=vessal(arr,z);
    if(ans2!=null){
      for(int i=0;i<ans2.length;i++){
        int per=(ans2[i].getvcomp()*100)/ans2[i].getvplan();
        if(per==100){
          System.out.println(ans2[i].getvname()+"%Star");
        }
        else if(per>=80 && per<=99){
          System.out.println(ans2[i].getvname()+"%Leader");
        }
        else if(per>=55 && per<=79){
          System.out.println(ans2[i].getvname()+"%Inspirer");
        }
        else {
          System.out.println(ans2[i].getvname()+"%Striver");
        }
      }
    }
    else {
          System.out.println( "No Naval Vessel is available with the specified purpose");
        }
     
  }

  public static Naval[] vessal(Naval[]n,String z){
    Naval[] arr=new Naval[0];
    for(int i=0;i<n.length;i++){
      if(n[i].getpurp().equalsIgnoreCase(z)){
        arr=Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1]=n[i];
      }

    }
    if(arr.length>0){
      return arr;
    }
    else{
      return null;
    }
  }
  public static int findAvg(Naval[] n,int x){
    int sum=0;
    int count=0;
    for(int i=0;i<n.length;i++){
      int per=(n[i].getvcomp()*100)/n[i].getvplan();
      if(per>=x){
        sum+=n[i].getvcomp();
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
