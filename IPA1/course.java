import java.util.*;
class Course{
    private int cid;
    private String cname;
    private String cadmin;
    private int quiz;
    private int handson;
    
    public Course(int cid, String cname,String cadmin, int quiz,int handson ){
        this.cid=cid;
        this.cname=cname;
        this.cadmin=cadmin;
        this.quiz=quiz;
        this.handson=handson;
    }
    public int getcid(){
        return cid;
    }
    public void setcid(int cid){
        this.cid=cid;
    }
    public String getcname(){
        return cname;
    }
    public void setcname(String cname){
        this.cname=cname;
    }
    public String getcadmin(){
        return cadmin;
    }
    public void setcadmin(String cadmin){
        this.cadmin=cadmin;
    }
    public int getquiz(){
        return quiz;
    }
    public void setquiz(int quiz){
        this.quiz=quiz;
    }
    public int gethandson(){
        return handson;
    }
    public void sethandson(int handson){
        this.handson=handson;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Course[] arr=new Course[4];
        for(int i=0;i<arr.length;i++){
        int a=sc.nextInt();
        sc.nextLine();
        String b=sc.nextLine();
        String c=sc.nextLine();
        int d=sc.nextInt();  
        int e=sc.nextInt();  
        sc.nextLine();  
        arr[i]=new Course(a,b,c,d,e);
        }
          
        String x=sc.nextLine();
        int z=sc.nextInt(); 
        int ans1=findAvg(arr,x);
        if(ans1 != 0){
            System.out.println(ans1);
        }
        else{
            System.out.println("No Course Found");
        }
        Course[] ans2=sortcourse(arr,z);
        if(ans2!=null){
            for(int i=0;i<ans2.length;i++){
                System.out.println(ans2[i].getcname());
            }
        }
        else{
            System.out.println("no match");
        }
        
    }
    
public static int findAvg(Course[] arr,String x){
  int   count=0;
  int   sum=0;
  for(int i=0;i<arr.length;i++){
      if(arr[i].getcadmin().equalsIgnoreCase(x)){
          sum+=arr[i].getquiz();
          count++;
      }
      
  }
  int ans;
  if(count>0){
      ans=sum/count;
      return ans;
  }
  else{
      return 0;
  }
    
}

public static Course[] sortcourse(Course[] arr,int z){
    Course[] obj=new Course[0];
    for(int i=0;i<arr.length;i++){
        if(arr[i].gethandson()<z){
            obj=Arrays.copyOf(obj,obj.length+1);
            obj[obj.length-1]=arr[i];
        }
    }
    Course val;
    for(int i=0;i<obj.length;i++){
        for(int j=i+1;j<obj.length;j++){
            if(obj[i].gethandson()>obj[j].gethandson()){
            val=obj[i];
            obj[i]=obj[j];
            obj[j]=val;
        }
        }
    }
    if(obj.length>0){
        return obj;
    }
    else{
        return null;
    }
}

}
