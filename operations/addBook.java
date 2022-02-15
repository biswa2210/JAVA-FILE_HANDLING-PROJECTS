package operations;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.io.FileReader;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.nio.file.*;

public class addBook{
    public void addBooks(){
        Scanner sc=new Scanner(System.in);
        System.out.println("NEW BOOK");
        System.out.println("********************************************************************************************");
        System.out.println("ENTER THE NAME OF THE BOOK :: ");
        String bknm=sc.nextLine();
        String tempstr = bknm.replaceAll("\\s+", "").toLowerCase();
        String tempstr2;
        String[] books=booksinArray();
        int flag=0;
        for(int i=0;i<books.length;i++)
        {
            tempstr2=books[i].replaceAll("\\s+", "").toLowerCase();
            if(tempstr.equals(tempstr2)){
                System.out.println("THIS BOOK IS ALREADY PRESENT...\nENTER DIFFERENT BOOK");
                flag=1;
                break;
            }
        }
        if(flag==0){
            System.out.println("NAME OF BOOK PUBLISHER :: ");
            String pbnm=sc.nextLine();
            System.out.println("CATAGORY OF BOOK :: ");
            String catagory=sc.nextLine();
            System.out.println("MARKET PRICE OF THE BOOK :: ");
            double mkpr=sc.nextDouble();
            System.out.println("NUMBER OF THE BOOK :: ");
            int countbk=sc.nextInt();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            File myObj=new File("record.txt");
            try{

                if(myObj.createNewFile()){
                    try {
                        FileWriter fstream = new FileWriter("record.txt", true);
                        BufferedWriter out = new BufferedWriter(fstream);
                        int bookId = 1;
                        out.write(Integer.toString(bookId) + "\n");
                        out.write(bknm + "\n");
                        out.write(pbnm + "\n");
                        out.write(catagory + "\n");
                        out.write(Double.toString(mkpr) + "\n");
                        out.write(Integer.toString(countbk) + "\n");
                        out.write(dtf.format(now)+"\n");
                        out.close();
                    }catch(IOException e){
                        System.err.println("Caught IOException: " + e.getMessage());
                    }
                }
                else{
                    try {
                        FileWriter fstream = new FileWriter("record.txt", true);
                        BufferedWriter out = new BufferedWriter(fstream);
                        int bookId = findMaxId()+1;
                        out.write(Integer.toString(bookId) + "\n");
                        out.write(bknm + "\n");
                        out.write(pbnm + "\n");
                        out.write(catagory + "\n");
                        out.write(Double.toString(mkpr) + "\n");
                        out.write(Integer.toString(countbk) + "\n");
                        out.write(dtf.format(now)+"\n");
                        out.close();
                    }catch(IOException e){
                        System.err.println("Caught IOException: " + e.getMessage());
                    }

                }
            }
            catch(IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println("********************************************************************************************");
            System.out.println("BOOK NAME :: "+bknm+" ADDED SUCCESSFULLY ON "+dtf.format(now));
            System.out.println("********************************************************************************************");

        }


    }
    public String[] booksinArray(){
        String  bkNames[] = new String[0];
        try {
            for(int i=1,j=0;i<fileLength();i=i+7,j++) {
                String line = Files.readAllLines(Paths.get("record.txt")).get(i);
                bkNames= Arrays.copyOf(bkNames,bkNames.length+1);
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
    private int findMaxId() {
        int count = 0;
        try{
            File file = new File("record.txt");

            // create an object of Scanner
            // associated with the file
            Scanner scc = new Scanner(file);

            // read each line and
            // count number of lines
            while(scc.hasNextLine()) {
                scc.nextLine();
                count++;
            }

            // close scanner
            scc.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
        int n = count; // The line number
        try{
            String line = Files.readAllLines(Paths.get("record.txt")).get(n-7);
            System.out.println(line);
            int idno=Integer.parseInt(line);
            return idno;
        }
        catch(IOException e){
            System.out.println(e);
            return 0;
        }

    }


}