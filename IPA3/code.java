
import java.util.*;

class Employee{
  private int id;
  private String name;
  private String desi;
  private double sal;

  public Employee(int id, String name, String desi, double sal){
    this.id=id;
    this.name=name;
    this.desi=desi;
    this.sal=sal;
  }
  public int getid(){
    return id;
  }
  public void setid(int id){
    this.id=id;
  }
  public String getname(){
    return name;
  }
  public void setname(String name){
    this.name=name;
  }
  public String getdesi(){
    return desi;
  }
  public void setdesi(String desi){
    this.desi=desi;
  }
  public double getsal(){
    return sal;
  }
  public void setsal(double sal){
    this.sal=sal;
  }

}
class Company{
  private String cname;
  private Employee[] emp;
  private int numemp;

  public Company(String cname,Employee[] emp,int numemp ){
    this.cname=cname;
    this.emp=emp;
    this.numemp=numemp;
  }
  public double getAvg(Employee[] e){
    double sum=0;
    for(int i=0;i<e.length;i++){
      sum+=e[i].getsal();
    }
    if(sum>0){
      return sum/e.length;
    }
    return 0;
  }
  public double getMax(Employee[] e){
    double m=e[0].getsal();
    for(int i=0;i<e.length;i++){
      if(e[i].getsal()>m){
        m=e[i].getsal();
      }
    }
    return m;
  }
  public Employee[] getEmp(Employee[] e,String x){
    Employee[] arr=new Employee[0];
    for(int i=0;i<e.length;i++){
      if(e[i].getdesi().equalsIgnoreCase(x)){
        arr=Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1]=e[i];
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


class Main{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter company name: ");
    String cname=sc.nextLine();
    System.out.println("Enter number of employees: ");
    int num=sc.nextInt();sc.nextLine();
    Employee[]emp=new Employee[num];
    System.out.println("Enter employee details:");
     for(int i=0;i<emp.length;i++){
      System.out.println("Employee "+(i+1)+":");
      System.out.println("Enter id: ");
      int a=sc.nextInt();sc.nextLine();
      System.out.println("Employee name: ");
      String b=sc.nextLine();
      System.out.println("Employee designation: ");
      String c=sc.nextLine();
      System.out.println("Enter Salary: ");
      double d=sc.nextDouble();sc.nextLine();
      emp[i]=new Employee(a,b,c,d);
     }
     Company com=new Company(cname,emp,num);
     System.out.println("Average Salary: "+com.getAvg(emp));
     System.out.println("Max Salary: "+com.getMax(emp));
     System.out.println("Employees with designation: ");
     String x=sc.nextLine();
     Employee[] ans=com.getEmp(emp,x);
      if(ans !=null){
        for(int i=0;i<ans.length;i++){
        System.out.println("ID: "+ans[i].getid()+", Name: "+ans[i].getname()+", Designation: "+ans[i].getdesi()+
        ", Salary: "+ans[i].getsal());
        }
      }

     }
  
}
