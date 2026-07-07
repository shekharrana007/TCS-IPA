import java.util.*;
class Sim2
{
    private int id;
    private String company;
    private int balance;
    private double rps;
    private String circle;
    public Sim2(int id, String company, int balance, double rps, String circle) {
        this.id = id;
        this.company = company;
        this.balance = balance;
        this.rps = rps;
        this.circle = circle;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public int getBalance() {
        return balance;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public double getRps() {
        return rps;
    }
    public void setRps(double rps) {
        this.rps = rps;
    }
    public String getCircle() {
        return circle;
    }
    public void setCircle(String circle) {
        this.circle = circle;
    }

    
}
class Main{
  public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Sim2[] s = new Sim2[4];
        for (int i = 0; i < s.length; i++) {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            double d = sc.nextDouble();sc.nextLine();
            String e = sc.nextLine();

            s[i] = new Sim2(a,b,c,d,e);
        }
        String x = sc.nextLine();
        double y = sc.nextDouble(); 
        Sim2[] ans=getMatch(s,x,y);
        if(ans!=null){
          for(int i=0;i<ans.length;i++){
            System.out.println(ans[i].getId());
          }
        }
         
  }
  public static Sim2[] getMatch(Sim2[] s,String x,double y){
    Sim2[] arr=new Sim2[0];
    for(int i=0;i<s.length;i++){
      if(s[i].getCircle().equalsIgnoreCase(x) && y>s[i].getRps()){
        arr=Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1]=s[i];
      }
    }
    if(arr.length>0){
      Sim2 temp;
      for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++){
            if(arr[i].getBalance()<arr[j].getBalance()){
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
