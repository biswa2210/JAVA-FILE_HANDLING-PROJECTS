package operations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class updateCatagory{
    public void updateCatagories(){

        try {
            Scanner sc = new Scanner(System.in);
            String[] books = booksinArray();
            String[] ids = IdsinArray();
            System.out.print("Enter Updated Catagory :: ");
            String cat = sc.nextLine();
            System.out.print("Enter The Id of the Book :: ");
            int id = sc.nextInt();
            int flag = 0;
            for (int i = 0; i < books.length; i++) {
                if (id == Integer.parseInt(ids[i])) {
                    System.out.println("NAME OF BOOK :: " + books[i]);
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                int temp;
                for (int i = 0; i < fileLength(); i = i + 7) {
                    temp = i;
                    String idfrmFl = Files.readAllLines(Paths.get("record.txt")).get(i);
                    if (id == Integer.parseInt(idfrmFl)) {
                        for (int j = 0; j < fileLength(); j++) {
                            String templine = Files.readAllLines(Paths.get("record.txt")).get(j);
                            FileWriter fstream = new FileWriter("temp.txt", true);
                            BufferedWriter out = new BufferedWriter(fstream);
                            if (j == (temp + 3)) {
                                out.write(cat + "\n");
                                out.close();
                            } else {
                                out.write(templine + "\n");
                                out.close();
                            }

                        }


                    }
                }
                File myObj = new File("record.txt");
                if (myObj.delete()) {
                    File oldName = new File("temp.txt");
                    File newFile = new File("record.txt");
                    if (oldName.renameTo(newFile))
                        System.out.println("Updated successfully");
                    else
                        System.out.println("Error");
                } else {
                    System.out.println("Error");
                }

            }else {
                System.out.println("NOT FOUND ANY BOOK ACCORDING YOUR GIVEN ID");
                System.out.println("TRY AGAIN!!!");
            }
        }
        catch(Exception e)
            {
                System.out.println(e.getMessage());
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
