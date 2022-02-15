package operations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class deleteStudent{
    public  void deleteStudents(){
        int idStore=0;
        try {
            Scanner sc = new Scanner(System.in);
            String[] regnos = regnoinArray();
            String[] names = NamesinArray();
            String[] ids = IdsinArray();
            System.out.print("Enter The Registration Number of the Student :: ");
            int regno = sc.nextInt();
            int flag = 0;
            for (int i = 0; i < names.length; i++) {
                if (regno == Integer.parseInt(regnos[i])) {
                    idStore = Integer.parseInt(ids[i]);
                    System.out.println("ID OF STUDENT :: " + idStore);
                    System.out.println("NAME OF STUDENT :: " + names[i]);
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                int temp;
                for (int i = 0; i < fileLength(); i = i + 7) {
                    temp = i;
                    String idfrmFl = Files.readAllLines(Paths.get("borrowRecord.txt")).get(i);
                    if (idStore == Integer.parseInt(idfrmFl)) {
                        for (int j = 0; j < fileLength(); j++) {
                            String templine = Files.readAllLines(Paths.get("borrowRecord.txt")).get(j);
                            FileWriter fstream = new FileWriter("tempborrow.txt", true);
                            BufferedWriter out = new BufferedWriter(fstream);
                            if (j == temp || j == (temp + 1) || j == (temp + 2) || j == (temp + 3) || j == (temp + 4) || j == (temp + 5) || j == (temp + 6)) {
                                out.close();
                            } else {
                                out.write(templine + "\n");
                                out.close();
                            }

                        }


                    }
                }
                File myObj = new File("borrowRecord.txt");
                if (myObj.delete()) {
                    File oldNamebr = new File("tempborrow.txt");
                    File newFilebr = new File("borrowRecord.txt");
                    if (oldNamebr.renameTo(newFilebr)){
                        System.out.println("Deleted successfully");
                        updateid();
                    }
                    else
                        System.out.println("Error");
                } else {
                    System.out.println("Error");
                }

            } else {
                System.out.println("STUDENT RECORD IS NOT PRESENT!!!");
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
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
                    System.out.println("AFTER REFRESHING....");
                else
                    System.out.println("Error");
            } else {
                System.out.println("Error");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

}
