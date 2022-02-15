package operations;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
public class searchStudent{
    public  void SearchStudents(){
        try {
            String[] ids = IdsinArray();
            String[] books = booksinArray();
            String[] regnos = regnoinArray();
            String[] dates = DatesinArray();
            String[] names =NamesinArray();
            String[] contact =ConatctsinArray();
            Scanner sc = new Scanner(System.in);
            System.out.println("ENETER REGISTRATION NUMBER :: ");
            int regno = sc.nextInt();
            int flag=0;
            for (int i=0;i<regnos.length;i++){
                if(regno==Integer.parseInt(regnos[i])){
                    System.out.println("ID OF STUDENT :: "+ids[i]);
                    System.out.println("NAME OF STUDENT :: "+names[i]);
                    System.out.println("BORROWED BOOK OF THIS STUDENT :: "+books[i]);
                    System.out.println("CONTACT NO. OF STUDENT :: "+contact[i]);
                    System.out.println("DATE OF BORROWED :: "+dates[i]);
                    flag=1;
                    break;
                }

            }
            if(flag==0){
                System.out.println("STUDENT NOT FOUND!!!");
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public String[] ConatctsinArray(){
        String  contacs[] = new String[0];
        try {
            for(int i=5,j=0;i<fileLength();i=i+7,j++) {
                String line = Files.readAllLines(Paths.get("borrowRecord.txt")).get(i);
                contacs = Arrays.copyOf(contacs, contacs.length + 1);
                contacs[j]=line;
            }
            return  contacs;
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            return contacs;
        }}
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