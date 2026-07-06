import java.util.*;
class Student{
  private int rollno;
  private String name;
  private String sub;
  private char grade;
  private String date;

  public Student(int rollno,String name,String sub,char grade,String date){
    this.rollno=rollno;
    this.name=name;
    this.sub=sub;
    this.grade=grade;
    this.date=date;
  }
  public int getrollno(){
    return rollno;
  }
  public String getname(){
    return name;
  }
  public String getsub(){
    return sub;
  }
  public char getgrade(){
    return grade;
  }
  public String getdate(){
    return date;
  }
  public void setrollno(int rollno){
    this.rollno=rollno;
  }
   public void setname(String name){
    this.name=name;
  }
   public void setsub(String sub){
    this.sub=sub;
  }
   public void setgarde(char grade){
    this.grade=grade;
  }
   public void setdate(String date){
    this.date=date;
  }
}

class Main{
  public static void main(String []args){
    Scanner sc=new Scanner(System.in);
    Student[] arr=new Student[4];
    for(int i=0;i<arr.length;i++){
      int a=sc.nextInt();sc.nextLine();
      String b=sc.nextLine();
      String c=sc.nextLine();
      char d=sc.nextLine().charAt(0);
      String e=sc.nextLine();
      arr[i]=new Student(a,b,c,d,e);
    }
    char x=sc.nextLine().charAt(0);
    int z=sc.nextInt();
    Student[] ans=findStud(arr,x,z);
    if(ans!=null){
      for(int i=0;i<ans.length;i++){
        System.out.println(ans[i].getname());
        System.out.println(ans[i].getsub());
      }
      System.out.println(ans.length);
    }
  }

  public static Student[]findStud(Student[]s,char x,int z){
      Student[] arr=new Student[0];
      for(int i=0;i<s.length;i++){
        String []a=s[i].getdate().split("/");
        if(s[i].getgrade()==x && Integer.parseInt(a[1])==z){
          arr=Arrays.copyOf(arr,arr.length+1);
          arr[arr.length-1]=s[i];
        }
      }
      Student temp;
      if(arr.length>0){
        for(int i=0;i<arr.length;i++){
          for(int j=i+1;j<arr.length;j++){
            if(arr[i].getrollno()>arr[j].getrollno()){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
          }
        }
        return arr;
      }
      else{
        return null;
      }
  }
}
