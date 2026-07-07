import java.util.*;
class Cinema
{
    private int id;
    private String director;
    private int rating, budget;

    public Cinema(int id, String director, int rating, int budget) {
        this.id = id;
        this.director = director;
        this.rating = rating;
        this.budget = budget;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public int getRating() {
        return rating;
    }
    public void setRating(int rating) {
        this.rating = rating;
    }
    public int getBudget() {
        return budget;
    }
    public void setBudget(int budget) {
        this.budget = budget;
    }

    
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cinema[] cn = new Cinema[4];
        for (int i = 0; i < cn.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            int d = sc.nextInt();sc.nextLine();

            cn[i] = new Cinema(a, b, c, d);
        }
        String dir = sc.nextLine();
        int rate = sc.nextInt();sc.nextLine();
        int bud = sc.nextInt(); 
        int ans1=findAvg(cn,dir);
        if(ans1>0){
          System.out.println(ans1);
        }
        else{
          System.out.println("Sorry - The given director has not yet directed any movie");
        }
        int ans=getMovie(cn,rate,bud);
        if(ans>0){
          System.out.println(ans);

        }
        else{
          System.out.println("Sorry - No movie is available with the specified rating and budget requirement");
        }

    }
    public static int findAvg(Cinema[]c,String dir){
      int count=0;
      int sum=0;
      for(int i=0;i<c.length;i++){
        if(c[i].getDirector().equalsIgnoreCase(dir)){
          sum+=c[i].getBudget();
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
    public static int getMovie(Cinema[]c,int rate,int bud){
      for(int i=0;i<c.length;i++){
        if(c[i].getBudget()==bud && c[i].getRating()==rate && bud%rate==0 ){
          return c[i].getId();
        }
      }
      return 0;
    }
}
