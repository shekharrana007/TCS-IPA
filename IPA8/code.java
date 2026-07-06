import java.util.*;
class Movie{
  private String name;
  private String comp;
  private String gen;
  private int bud;

  public Movie(String name,String comp,String gen,int bud){
    this.name=name;
    this.comp=comp;
    this.gen=gen;
    this.bud=bud;
  }

  public String getname(){
    return name;
  }
  public void setname(String name){
    this.name=name;
  }
  public String getcomp(){
    return comp;
  }
  public void setcomp(String comp){
    this.comp=comp;
  }
  public String getgen(){
    return gen;
  }
  public void setgen(String gen){
    this.gen=gen;
  }
  public int getbud(){
    return bud;
  }
  public void setbud(int bud){
    this.bud=bud;
  }
}
public class Main{

  public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    Movie[]arr=new Movie[4];
    for(int i=0;i<arr.length;i++){
      String a=sc.nextLine();
      String b=sc.nextLine();
      String c=sc.nextLine();
      int d=sc.nextInt();sc.nextLine();
      arr[i]=new Movie(a,b,c,d);
    }
    String x=sc.nextLine();
    Movie[] ans=getMovie(arr,x);
    if(ans!=null){
      for(int i=0;i<ans.length;i++){
        if(ans[i].getbud()>80000000){
          System.out.println("High budget movie");
        }
        else{
          System.out.println("Low budget movie");
        }
      }
    }
  }

  public static Movie[] getMovie(Movie[]m,String x){
    Movie[]mov=new Movie[0];
    for(int i=0;i<m.length;i++){
      if(m[i].getgen().equalsIgnoreCase(x)){
        mov=Arrays.copyOf(mov,mov.length+1);
        mov[mov.length-1]=m[i];
      }
    }
    if(mov.length>0){
      return mov;
    }
    else {
      return null;
    }
  }
}
