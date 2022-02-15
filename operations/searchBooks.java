package operations;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
public class searchBooks{
    public void SearchBook(){

        try{
            String[] ids=IdsinArray();
            String[] books=booksinArray();
            String[] pubs=pubsinArray();
            String[] mrps=mrpinArray();
            String[] countsBks=CountsinArray();
            String[] catagories=CatagoriesinArray();
            String[] dates=DatesinArray();
            Scanner sc = new Scanner(System.in);
            System.out.println("ENETER ID NUMBER OF BOOK :: ");
            int Id = sc.nextInt();
            int flag=0;
            for (int i=0;i<books.length;i++){
                if(Id==Integer.parseInt(ids[i])){
                    System.out.println("ID OF BOOK :: "+ids[i]);
                    System.out.println("NAME OF BOOK :: "+books[i]);
                    System.out.println("NAME OF PUBLISHER :: "+pubs[i]);
                    System.out.println("CATAGORY OF BOOK :: "+catagories[i]);
                    System.out.println("MARKET PRICE OF BOOK :: "+mrps[i]);
                    System.out.println("QUANTITY OF BOOK :: "+countsBks[i]);
                    System.out.println("DATE OF BORROWED :: "+dates[i]);
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                    System.out.println("BOOK NOT FOUND!!!");
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public String[] mrpinArray(){
        String  mrps[] = new String[0];
        try {
            for(int i=4,j=0;i<fileLength();i=i+7,j++) {
                String line = Files.readAllLines(Paths.get("record.txt")).get(i);
                mrps = Arrays.copyOf(mrps, mrps.length + 1);
                mrps[j]=line;
            }
            return  mrps;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return mrps;
        }}
    public String[] pubsinArray(){
        String  pubs[] = new String[0];
        try {
            for(int i=2,j=0;i<fileLength();i=i+7,j++) {
                String line = Files.readAllLines(Paths.get("record.txt")).get(i);
                pubs = Arrays.copyOf(pubs, pubs.length + 1);
                pubs[j]=line;
            }
            return  pubs;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return pubs;
        }}
    public String[] DatesinArray(){
        String  datetimes[] = new String[0];
        try {
            for(int i=6,j=0;i<fileLength();i=i+7,j++) {
                String line = Files.readAllLines(Paths.get("record.txt")).get(i);
                datetimes = Arrays.copyOf(datetimes, datetimes.length + 1);
                datetimes[j]=line;
            }
            return  datetimes;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return datetimes;
        }}
    public String[] IdsinArray(){
        String  ids[] = new String[0];
        try {
            for(int i=0,j=0;i<fileLength();i=i+7,j++) {
                String line = Files.readAllLines(Paths.get("record.txt")).get(i);
                ids = Arrays.copyOf(ids, ids.length + 1);
                ids[j]=line;
            }
            return  ids;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return ids;
        }}
    public String[] CatagoriesinArray(){
        String  bkCatagories[] = new String[0];
        try {
            for(int i=3,j=0;i<fileLength();i=i+7,j++) {
                String line = Files.readAllLines(Paths.get("record.txt")).get(i);
                bkCatagories = Arrays.copyOf(bkCatagories, bkCatagories.length + 1);
                bkCatagories[j]=line;
            }
            return  bkCatagories;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return bkCatagories;
        }}

    public String[] CountsinArray(){
        String  bkCounts[] = new String[0];
        try {
            for(int i=5,j=0;i<fileLength();i=i+7,j++) {
                String line = Files.readAllLines(Paths.get("record.txt")).get(i);
                bkCounts = Arrays.copyOf(bkCounts, bkCounts.length + 1);
                bkCounts[j]=line;
            }
            return  bkCounts;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return bkCounts;
        }}
    public String[] booksinArray(){
        String  bkNames[] = new String[0];
        try {
            for(int i=1,j=0;i<fileLength();i=i+7,j++) {
                String line = Files.readAllLines(Paths.get("record.txt")).get(i);
                bkNames=Arrays.copyOf(bkNames,bkNames.length+1);
                bkNames[j]=line;
            }

            return bkNames;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return bkNames;
        }}

    public int fileLength(){
        int countlen = 0;
        try{
            File file = new File("record.txt");

            // create an object of Scanner
            // associated with the file
            Scanner scc = new Scanner(file);

            // read each line and
            // count number of lines
            while(scc.hasNextLine()) {
                scc.nextLine();
                countlen++;
            }

            // close scanner
            scc.close();
            return countlen;
        } catch (Exception e) {
            e.getStackTrace();
            return 0;
        }
    }



}