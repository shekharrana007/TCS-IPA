
import java.util.*;
class Employee{
  private int eid;
  private String ename;
  private int age;
  private char gen;
  private double sal;

  public  Employee(int eid,String ename,int age, char gen, double sal){
    this.eid=eid;
    this.ename=ename;
    this.age=age;
    this.gen=gen;
    this.sal=sal;
  }

  public int geteid(){
    return eid;
  }
  public void seteid(int eid){
    this.eid=eid;
  }
  public String getename(){
    return ename;
  }
  public void setename(String ename){
    this.ename=ename;
  }
  public int getage(){
    return age;
  }
  public void setage(int age){
    this.age=age;
  }
  public char getgen(){
    return gen;
  }
  public void setgen(char gen){
    this.gen=gen;
  }
  public double getsal(){
    return sal;
  }
  public void setsal(double sal){
    this.sal=sal;
  }
}

class Main{
  public  static void main(String [] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    Employee[] arr=new Employee[n];
    for(int i=0;i<arr.length;i++){
      int a= sc.nextInt();sc.nextLine();
      String b=sc.nextLine();
      int c=sc.nextInt();sc.nextLine();
      char d=sc.next().charAt(0);sc.nextLine();
      double e= sc.nextDouble();sc.nextLine();
      arr[i]=new Employee(a,b,c,d,e);
    }
    int x=sc.nextInt();
  Employee[] ans1=secondSal(arr);
  if(ans1!=null){
    for(int i=0;i<ans1.length;i++){
      System.out.println(ans1[i].geteid()+"#"+ans1[i].getename());
    }
  }
  else{
    System.out.println("Null");
  }


  int ans2=countAge(arr,x);
  if(ans2!=0){
    System.out.println(ans2);
  }else{
    System.out.println("No employee found at the given age");
  }
  }
   public static Employee[]  secondSal(Employee[] arr){
      double first=Double.MIN_VALUE;
      double second=Double.MIN_VALUE;
      for(int i=0;i<arr.length;i++){
       double sal=arr[i].getsal();
        if(sal>first){
          second=first;
          first=sal;
        }
        else if(sal>second && sal !=first){
          second=sal;
        }
      }
      if(second==Double.MIN_VALUE){
        return null;
      }
      Employee [] res=new Employee[0];
      for(int i=0;i<arr.length;i++){
        if(arr[i].getsal()==second){
          res=Arrays.copyOf(res,res.length+1);
          res[res.length-1]=arr[i];
        }
      }
      return res;
  }
    public static int countAge(Employee [] arr,int x){
      int count=0;
      for(int i=0;i<arr.length;i++){
        if(x==arr[i].getage()){
          count++;
        }
      }
      if(count>0){
        return count;
      }
      else{
        return 0;
      }
    }


}
