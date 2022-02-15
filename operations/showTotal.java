package operations;
import java.io.*;
import java.util.*;
import java.nio.file.*;
public class showTotal{
    public  void ShowTotalBooks(){


        try
        {
            String[] ids=IdsinArray();
            String[] books=booksinArray();
            String[] countsBks=CountsinArray();
            String[] catagories=CatagoriesinArray();
            String[] dates=DatesinArray();
            System.out.println("*******************************************************************************************");
            System.out.println("Ids\tBooks\t\t     Quantity\tCatagory\tDate&Time");
            System.out.println("*******************************************************************************************");
            if(books.length==0) {
               System.out.println("No Books Added Yet");
            }else{
                for (int i = 0; i < books.length; i++) {
                    System.out.println(ids[i] + "\t" + books[i] + "\t\t" + countsBks[i] + "\t" + catagories[i] + "\t" + dates[i]);
                }
            }
            System.out.println("*******************************************************************************************");
            System.out.println("*******************************************************************************************");


        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
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
