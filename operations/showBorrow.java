package operations;
import java.util.*;
import java.io.FileReader;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.nio.file.*;
public class showBorrow{
    public  void ShowBorrows(){

        try
        {
            updateid();
            String[] ids=IdsinArray();
            String[] books=booksinArray();
            String[] regnos=regnoinArray();
            String[] dates=DatesinArray();
            System.out.println("*******************************************************************************************");
            System.out.println("Ids\tBooks\t\t     Reg.No.\tDate&Time");
            System.out.println("*******************************************************************************************");
            if(regnos.length==0){
                System.out.println("NO RECORDS ADDED YET..");
            }else{
            for(int i=0;i<books.length;i++)
            {
                System.out.println(ids[i]+"\t"+books[i]+"\t\t"+regnos[i]+"\t"+dates[i]);
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
    private void updateid(){
        int c=1;
        try {

            for (int i=0;i<fileLength();i++){
                String temp = Files.readAllLines(Paths.get("borrowRecord.txt")).get(i);
                FileWriter fstream = new FileWriter("temp.txt", true);
                BufferedWriter out = new BufferedWriter(fstream);
                if(i%7==0){
                    out.write(Integer.toString(c)+"\n");
                    c++;
                    out.close();

                }else{
                    out.write(temp+"\n");
                    out.close();
                }

            }
           File myObj = new File("borrowRecord.txt");
                if (myObj.delete()) {
                    File oldNamebr = new File("temp.txt");
                    File newFilebr = new File("borrowRecord.txt");
                    if (oldNamebr.renameTo(newFilebr))
                        System.out.println("REFRESHING....UP TO DATE DATABASE...");
                    else
                        System.out.println("Error");
                } else {
                    System.out.println("Error");
                }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public String[] DatesinArray(){
        String  datetimes[] = new String[0];
        try {
            for(int i=6,j=0;i<fileLength();i=i+7,j++) {
                String line = Files.readAllLines(Paths.get("borrowRecord.txt")).get(i);
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
                String line = Files.readAllLines(Paths.get("borrowRecord.txt")).get(i);
                ids = Arrays.copyOf(ids, ids.length + 1);
                ids[j]=line;
            }
            return  ids;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return ids;
        }}
    public String[] regnoinArray(){
        String  regnos[] = new String[0];
        try {
            for(int i=4,j=0;i<fileLength();i=i+7,j++) {
                String line = Files.readAllLines(Paths.get("borrowRecord.txt")).get(i);
                regnos = Arrays.copyOf(regnos, regnos.length + 1);
                regnos[j]=line;
            }
            return  regnos;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return regnos;
        }}


    public String[] booksinArray(){
        String  bkNames[] = new String[0];
        try {
            for(int i=1,j=0;i<fileLength();i=i+7,j++) {
                String line = Files.readAllLines(Paths.get("borrowRecord.txt")).get(i);
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
            File file = new File("borrowRecord.txt");

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
