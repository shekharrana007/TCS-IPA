import java.util.*;
class Document
{
    int id; 
    String title; 
    String folderName; 
    int pages;
    
    public Document(int id, String title, String folderName, int pages)
    {
        this.id = id;
        this.title = title;
        this.folderName = folderName;
        this.pages = pages;
    }
    
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public String getTitle()
    {
        return title;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }
    public String getFolderName()
    {
        return folderName;
    }
    public void setFolderName(String folderName)
    {
        this.folderName = folderName;
    }
    public int getPages()
    {
        return pages;
    }
    public void setPages(int pages)
    {
        this.pages = pages;
    }
}
class Main{
    public static void main(String args[] ){
        Scanner sc = new Scanner(System.in);
        Document[] doc = new Document[4];
        for(int i =0; i<4; i++)
        {
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();
            
            doc[i] = new Document(a,b,c,d);
        }
        Document[] ans=docs(doc);
        if(ans!=null){
            for(int i=0;i<ans.length;i++){
                System.out.println(ans[i].getId()+" "+ans[i].getTitle()+" exams "+ans[i].getPages());
            }
        }
        else{
            System.out.println("Not found");
        }
    }
    public static Document[] docs(Document[] d){
        Document[] arr=new Document[0];
        for(int i=0;i<d.length;i++){
            if(d[i].getPages()%2 != 0){
                arr=Arrays.copyOf(arr,arr.length+1);
                arr[arr.length-1]=d[i];
            }
        }
        if(arr.length==0)return null;
        Document temp;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i].getId()>arr[j].getId()){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
}
