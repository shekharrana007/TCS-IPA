import java.util.*;
class Player{
  private int pid;
  private String skill;
  private String level;
  private int points;

  public Player(int pid,String skill, String level,int points){
    this.pid=pid;
    this.skill=skill;
    this.level=level;
    this.points=points;
  }
  public int getpid(){
    return pid;
  }
  public void setpid(int pid){
    this.pid=pid;
  }
  public String getskill(){
    return skill;
  }
  public void setskill(String skill){
    this.skill=skill;
  }
  public String getlevel(){
    return level;
  }
  public void setlevel(String level){
    this.level=level;
  }
  public int getpoints(){
    return points;
  }
  public void setpoints(int points){
    this.points=points;
  }
}

class Main{
  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    Player[] arr=new Player[4];
    for(int i=0;i<arr.length;i++){
      int a=sc.nextInt();sc.nextLine();
      String b=sc.nextLine();
      String c=sc.nextLine();
      int d=sc.nextInt();sc.nextLine();
      arr[i]=new Player(a,b,c,d);
    }
    String x=sc.nextLine();
    String z=sc.nextLine();

    int ans1=findPoint(arr,x);
    Player[] ans2=getPlayer(arr,x,z);
    if(ans1 >0){
      System.out.println(ans1);
    }
    else{
      System.out.println("The given skill is not available");
    }
    if(ans2!=null){
      for(int i=0;i<ans2.length;i++){
        System.out.println(ans2[i].getpid());
      }
    }
    else{
      System.out.println("No player with level, skill, points");
    }

  }

  public static int findPoint(Player[] p,String x){
    int sum=0;
    for(int i=0;i<p.length;i++){
      if(p[i].getskill().equalsIgnoreCase(x)){
        sum+=p[i].getpoints();
      }
    }
    if(sum>0){
      return sum;
    }
    else{
      return 0;
    }
  }

  public static Player[] getPlayer(Player[] p,String x,String z){
    Player[] a=new Player[0];
    for(int i=0;i<p.length;i++){
      if(p[i].getskill().equalsIgnoreCase(x) && 
        p[i].getlevel().equalsIgnoreCase(z) &&
        p[i].getpoints()>20){
          a=Arrays.copyOf(a,a.length+1);
          a[a.length-1]=p[i];
        }
    }
    if(a.length>0){
      return a;
    }
    else{
      return null;
    }
  }

}
