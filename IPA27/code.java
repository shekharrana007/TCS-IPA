import java.util.*;
class Music
{
    int pNo, count;
    String type;
    double duration;
    
    public Music(int pNo, String type, int count, double duration)
    {
        this.pNo = pNo;
        this.type = type;
        this.count = count;
        this.duration = duration;
    }
    
    public int getPNo()
    {
        return pNo;
    }
    public void setPNo(int pNo)
    {
        this.pNo = pNo;
    }
    public String getType()
    {
        return type;
    }
    public void setType(String type)
    {
        this.type = type;
    }
    public int getCount()
    {
        return count;
    }
    public void setCount(int count)
    {
        this.count = count;
    }
    public double getDuration()
    {
        return duration;
    }
    public void setDuration(double duration)
    {
        this.duration = duration;
    }
}

class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Music[] m = new Music[4];
        for(int i=0; i<4; i++)
        {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            double d = sc.nextDouble();sc.nextLine();
            m[i] = new Music(a,b,c,d);
        }
        int x = sc.nextInt();sc.nextLine();
        double z = sc.nextDouble();  

        int ans=findAvg(m,x);
        if(ans!=0){
            System.out.println(ans);
        }
        else{
            System.out.println("No playlist found");
        }
        Music[] ans1=sortD(m,z);
        if(ans1!=null){
            for(int i=0;i<ans1.length;i++){
                System.out.println(ans1[i].getType());
            }
        }
        else{
            System.out.println("No playlist found with mentioned attribute");
        }

    }
    public static int findAvg(Music[]m,int x){
            int count=0;
            int sum=0;
            for(int i=0;i<m.length;i++){
                if(m[i].getCount()>x){
                    sum+=m[i].getCount();
                    count++;
                }
            }
            if(count==0)return 0;
            return sum/count;
    }
    public static Music[] sortD(Music[]m,double z){
        Music[]arr=new Music[0];
        for(int i=0;i<m.length;i++){
            if(m[i].getDuration()>z){
                arr=Arrays.copyOf(arr,arr.length+1);
                arr[arr.length-1]=m[i];
            }
        }
        if(arr.length==0)return null;
        Music temp;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i].getDuration()>arr[j].getDuration()){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }

}
