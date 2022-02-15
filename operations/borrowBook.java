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
public class borrowBook{
    public  void BorrowBooks(){
        String[] regnos=regnoinArray();
        String[] names =NamesinArray();
        String[] books= booksinArray();
        Scanner sc=new Scanner(System.in);
        System.out.println("BORROW BOOK");
        System.out.println("********************************************************************************************");
        System.out.println("ENTER THE NAME OF THE BOOK :: ");
        String bknm=sc.nextLine();
        int flag=0;
        String tempstr = bknm.replaceAll("\\s+", "").toLowerCase();
        for(int i=0;i<books.length;i++){
            String tempstr2=books[i].replaceAll("\\s+","").toLowerCase();
            if(tempstr.equals(tempstr2)){
                flag = 1;
                break;
            }
        }
        if(flag==1){
            System.out.println("NAME OF STUDENT :: ");
            String stnm=sc.nextLine();
            String t1=stnm.replaceAll("\\s+","").toLowerCase();
            System.out.println("STREAM OF STUDENT :: ");
            String stst=sc.nextLine();
            System.out.println("CONTACT NUMBER OF STUDENT :: ");
            String contct=sc.nextLine();
            System.out.println("REGISTRATION NUMBER OF STUDENT :: ");
            int regno=sc.nextInt();
            String t2=Integer.toString(regno).replaceAll("\\s+","").toLowerCase();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            int flags=0;
            for(int i=0;i<regnos.length;i++)
            {
                String t3=regnos[i].replaceAll("\\s+","").toLowerCase();
                String t4=names[i].replaceAll("\\s+","").toLowerCase();
                if(t2.equals(t3)){
                    if(!t1.equals(t4)){
                        flags=1;
                        break;
                    }
                }
            }
            if(flags==0) {
                File myObj = new File("borrowRecord.txt");
                try {
                    if (myObj.createNewFile()) {
                        try {
                            FileWriter fstream = new FileWriter("borrowRecord.txt", true);
                            BufferedWriter out = new BufferedWriter(fstream);
                            int borrowbookId = 1;
                            out.write(Integer.toString(borrowbookId) + "\n");
                            out.write(bknm + "\n");
                            out.write(stnm + "\n");
                            out.write(stst + "\n");
                            out.write(Integer.toString(regno) + "\n");
                            out.write(contct + "\n");
                            out.write(dtf.format(now) + "\n");
                            out.close();
                        } catch (IOException e) {
                            System.err.println("Caught IOException: " + e.getMessage());
                        }
                    } else {
                        try {
                            FileWriter fstream = new FileWriter("borrowRecord.txt", true);
                            BufferedWriter out = new BufferedWriter(fstream);
                            int borrowbookId = findMaxId() + 1;
                            out.write(Integer.toString(borrowbookId) + "\n");
                            out.write(bknm + "\n");
                            out.write(stnm + "\n");
                            out.write(stst + "\n");
                            out.write(Integer.toString(regno) + "\n");
                            out.write(contct + "\n");
                            out.write(dtf.format(now) + "\n");
                            out.close();
                        } catch (IOException e) {
                            System.err.println("Caught IOException: " + e.getMessage());
                        }

                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
                System.out.println("********************************************************************************************");
                System.out.println("BOOK NAME :: " + bknm + " BORROWED SUCCESSFULLY ON " + dtf.format(now));
                System.out.println("********************************************************************************************");
            }else{
                System.out.println("YOU HAVE ALREADY ADDED THIS REGISTRATION NUMBER WITH AN ANOTHER STUDENT NAME..\nPLEASE ENTER PROPER CREDENTIALS");
            }
        }
        else{
            System.out.println("THIS BOOK IS NOT PRESENT IN OUR LIBRARY !!!");
        }

    }
    public String[] NamesinArray(){
        String  Names[] = new String[0];
        try {
            for(int i=2,j=0;i<fileLength();i=i+7,j++) {
                String line = Files.readAllLines(Paths.get("borrowRecord.txt")).get(i);
                Names = Arrays.copyOf(Names, Names.length + 1);
                Names[j]=line;
            }
            return  Names;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return Names;
        }}
    public String[] booksinArray(){
        String  bkNames[] = new String[0];
        try {
            for(int i=1,j=0;i<fileLength2();i=i+7,j++) {
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

    private int findMaxId() {
        int count = 0;
        try{
            File file = new File("borrowRecord.txt");

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
            String line = Files.readAllLines(Paths.get("borrowRecord.txt")).get(n-7);
            System.out.println(line);
            int idno=Integer.parseInt(line);
            return idno;
        }
        catch(IOException e){
            System.out.println(e);
            return 0;
        }

    }
    public int fileLength2(){
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