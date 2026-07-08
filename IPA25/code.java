import java.util.*;
class Student
{
    private int rollNo;
    private String name;
    private String branch;
    private double score;
    private boolean dayScholar;

// constructor   

    public Student(int rollNo, String name, String branch, double score, boolean dayScholar)
    {
        this.rollNo = rollNo;
        this.name = name;
        this.branch = branch;
        this.score = score;
        this.dayScholar = dayScholar;
    }

// getter and setter to access by main method

    public int getRollNo()
    {
        return rollNo;
    }
    public void setRollNo(int rollNo)
    {
        this.rollNo = rollNo;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name= name;
    }
    public String getBranch()
    {
        return branch;
    }
    public void setBranch(String branch)
    {
        this.branch = branch;
    }
    public double getScore()
    {
        return score;
    }
    public void setScore(double score)
    {
        this.score = score;
    }
    public boolean getDayScholar()
    {
        return dayScholar;
    }
    public void setDayScholar(boolean dayScholar)
    {
        this.dayScholar = dayScholar;
    }

}
class Main{
     public static void main(String[] args) {
        Student[] student = new Student[4];
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<student.length; i++)
        {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();sc.nextLine();
            boolean e = sc.nextBoolean(); 

            student[i] = new Student(a,b,c,d,e);
        }
        int ans=countS(student);
        if(ans>0){
            System.out.println(ans);
        }
        else{
            System.out.println("There are no such dayscholar students");
        }
        Student ans1=second(student);
        if(ans1!=null){
            System.out.println(ans1.getRollNo()+"#"+ans1.getName()+"#"+ans1.getScore());
        }
        else{
            System.out.println("There are no student from non day scholar");
        }
     }
        public static int countS(Student[]s){
            int count=0;
            for(int i=0;i<s.length;i++){
                if(s[i].getDayScholar()==true && s[i].getScore()>80){
                    count++;
                }
            }
            if(count==0)return 0;
            return count;
        }

        public static Student second(Student[]s){
            Student[] arr=new Student[0];
            for(int i=0;i<s.length;i++){
                if(s[i].getDayScholar()==false){
                    arr=Arrays.copyOf(arr,arr.length+1);
                    arr[arr.length-1]=s[i];
                }
            }
            if(arr.length==0)return null;
            Student temp;
            
            for(int  i=0;i<arr.length;i++){
                for(int j=i+1;j<arr.length;j++){
                    if(arr[i].getScore()<arr[j].getScore()){
                        temp=arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
            return arr[1];
        }

     
}
