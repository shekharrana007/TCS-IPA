 
import java.util.*;
class Song
{
    int id;
    String title;
    String artist;
    double duration;
    public Song(int id, String title, String artist, double duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public double getDuration() {
        return duration;
    }
    public void setDuration(double duration) {
        this.duration = duration;
    }
    
}
class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Song[] s = new Song[5];
        for (int i = 0; i < s.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();sc.nextLine();

            s[i] = new Song(a,b,c,d);
        }
        String ar = sc.nextLine();
        String arr = sc.nextLine();
        int ans=dur(s,ar);
        if(ans!=0){
            System.out.println(ans);
        }
        else{
            System.out.println("Not Found");
        }
        Song [] ans1=asc(s,arr);
        if(ans1!=null){
            for(int i=0;i<ans1.length;i++){
                System.out.println(ans1[i].getId());
                System.out.println(ans1[i].getTitle());
            }
        }
        else{
            System.out.println("Not Found");
        }
    }
    public static int dur(Song[]s,String x){
        int sum=0;
        for(int i=0;i<s.length;i++){
            if(s[i].getArtist().equalsIgnoreCase(x)){
                sum+=s[i].getDuration();
            }
        }
        if(sum==0)return 0;
        return sum;
    }
    public static Song[] asc(Song[]s,String z){
        Song []arr=new Song[0];
        for(int i=0;i<s.length;i++){
            if(s[i].getArtist().equalsIgnoreCase(z)){
                arr=Arrays.copyOf(arr,arr.length+1);
                arr[arr.length-1]=s[i];
            }
        }
        Song temp;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i].getDuration()>arr[j].getDuration()){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        if(arr.length==0)return null;
        return arr;
    }
}
