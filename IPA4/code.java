import java.util.*;
class Employee{
  private int emp;
  private String name;
  private String branch;
  private double rating;
  private boolean ctrans;

  public Employee(int emp,String name,String branch, double rating,boolean ctrans){
    this.emp=emp;
    this.name=name;
    this.branch=branch;
    this.rating=rating;
    this.ctrans=ctrans;
  }

  public int getemp(){
    return emp;
  }
  public void setemp(int emp){
    this.emp=emp;
  }
  public String getname(){
    return name;
  }
  public void setname(String name){
    this.name=name;
  }
  public String getbranch(){
    return branch;
  }
  public void setbranch(String branch){
    this.branch=branch;
  }
  public double getrating(){
    return rating;
  }
  public void setrating(double rating){
    this.rating=rating;
  }
  public boolean getctrans(){
    return ctrans;
  }
  public void setctrans(boolean ctrans){
    this.ctrans=ctrans;
  }
}

class Main{
  public static void main(String []args){
      Scanner sc=new Scanner(System.in);
      Employee[] arr=new Employee[4];
      for(int i=0;i<arr.length;i++){
        int a=sc.nextInt();sc.nextLine();
        String b=sc.nextLine();
        String c=sc.nextLine();
        double d=sc.nextDouble();sc.nextLine();
        boolean e=sc.nextBoolean();sc.nextLine();
        arr[i]=new Employee(a,b,c,d,e);
      }
      String x=sc.nextLine();

      int ans1=findCount(arr,x);
      if(ans1>0){
        System.out.println(ans1);
      }
      else{
        System.out.println("NO SUCH EMPLOYEE");
      }
      Employee[] ans2=secHighest(arr);
      double h=ans2[0].getrating();
      if(ans2!=null){
        for(int i=1;i<ans2.length;i++){
          if(ans2[i].getrating() != h ){
            System.out.println(ans2[i].getemp());
            System.out.println(ans2[i].getname());
            break;
          }
        }
      }
      else{
        System.out.println("All employees using the transport");
      }

  }


  public static int findCount(Employee[]e,String x){
    int count=0;
    for(int i=0;i<e.length;i++){
      if(e[i].getbranch().equalsIgnoreCase(x)){
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
  public static Employee[] secHighest(Employee []e){
    Employee[] emp=new Employee[0];
    Employee temp;
    for(int i=0;i<e.length;i++){
      if(e[i].getctrans()==false){
        emp=Arrays.copyOf(emp,emp.length+1);
        emp[emp.length-1]=e[i];
      }
    }
    for(int i=0;i<emp.length;i++){
      for(int j=i;j<emp.length;j++){
        if(emp[i].getrating()<emp[j].getrating()){
        temp=emp[i];
        emp[i]=emp[j];
        emp[j]=temp;
        }
      }
    }
    if(emp.length>1){
      return emp;
    }
    else{
      return null;
    }
  }
}
