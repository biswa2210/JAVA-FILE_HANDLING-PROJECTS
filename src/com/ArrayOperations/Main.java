package com.ArrayOperations;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.*;
/*
CREATED BY BISWARUP BHATTACHARJEE
EMAIL    : bbiswa471@gmail.com
PHONE NO : 6290272740
*/
import java.time.format.DateTimeFormatter;
import java.util.*;
/* ****************************************************** MAIN CLASS ************************************************** */
public class Main {
    /*----------------------------------------------------| MAIN |---------------------------------------------------------*/
    public static void main(String[] args) {
        menu m=new menu();
        m.menu();
    }
    /*---------------------------------------------------------------------------------------------------------------------*/
    /*------------------------------------------------| OPERATION ----> 1 |------------------------------------------------*/
    public void addBooks() {
        Scanner sc=new Scanner(System.in);
        System.out.print("ENTER CUSTOMER NAME  :: ");
        String ctnm=sc.nextLine();
        System.out.print("ENTER CAR's MODEL    :: ");
        String carnm=sc.nextLine();
        System.out.print("ENTER NUMBER OF CAR  :: ");
        String carno=sc.nextLine();
        System.out.print("CUSTOMER ADDRESS     :: ");
        String ctadd=sc.nextLine();
        System.out.print("CUSTOMER PHONE NUMBER:: ");
        String phno=sc.nextLine();
        System.out.print("ENTER TIME FOR REPAIR (IN DAYS) :: ");
        String time=sc.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        File myObj=new File("record.txt");
        try{
            if(myObj.createNewFile()){
                try {
                    FileWriter fstream = new FileWriter("record.txt",true);
                    BufferedWriter out = new BufferedWriter(fstream);
                    out.write(carno+"\n");
                    out.write(ctnm+"\n");
                    out.write(carnm+"\n");
                    out.write(ctadd+"\n");
                    out.write(phno+"\n");
                    out.write(time+"\n");
                    out.write(dtf.format(now)+"\n");
                    out.close();
                    System.out.println("RECORD ADDED IN OUR DATABASE!!!!");
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }

            }else{
                FileWriter fstream = new FileWriter("record.txt",true);
                BufferedWriter out = new BufferedWriter(fstream);
                out.write(carno+"\n");
                out.write(ctnm+"\n");
                out.write(carnm+"\n");
                out.write(ctadd+"\n");
                out.write(phno+"\n");
                out.write(time+"\n");
                out.write(dtf.format(now)+"\n");
                out.close();
                System.out.println("RECORD ADDED IN OUR DATABASE!!!!");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    /*---------------------------------------------------------------------------------------------------------------------*/
    /*------------------------------------------------| OPERATION ----> 2 |------------------------------------------------*/
    public void show(){
        logic l=new logic();
        String[] carNos=l.carnos();
        String[] carNms=l.carnms();
        String[] cusNms=l.cusnms();
        String[] date=l.Dates();
        String[] time=l.Times();
        if(carNos.length>0){
            System.out.println("<---------------------------------------------------------->");
            System.out.println("Total "+carNos.length+" cars added");
            System.out.println("<---------------------------------------------------------->");
            for(int i=0;i< carNos.length;i++){
                System.out.println("CAR'S NUMBER       => "+carNos[i]);
                System.out.println("CAR'S MODEL        => "+carNms[i]);
                System.out.println("CUSTOMERS'S NAME   => "+cusNms[i]);
                System.out.println("DATE OF REPAIR     => "+date[i]);
                System.out.println("TIME FOR REPAIR    => "+time[i]+" DAYS");
                System.out.println("<---------------------------------------------------------->");
            }}
        else{
            System.out.println("NO RECORDS ADDED YET !!!");
        }

    }
    /*---------------------------------------------------------------------------------------------------------------------*/
    /*------------------------------------------------| OPERATION ----> 3 |------------------------------------------------*/
    public void search(){
        logic l=new logic();
        String[] carNos=l.carnos();
        String[] carNms=l.carnms();
        String[] cusNms=l.cusnms();
        String[] cusPhs=l.cusPHs();
        String[] cusAds=l.cusADs();
        String[] date=l.Dates();
        String[] time=l.Times();

        Scanner sc=new Scanner(System.in);
        System.out.println("<---------------------------------------------------------->");
        System.out.println("ENTER THE NUMBER OF CAR :: ");
        String input=sc.nextLine();
        input=input.replaceAll("\\s+","").toLowerCase();
        System.out.println("<---------------------------------------------------------->");
        int flag=0;
        for(int i=0;i< carNos.length;i++){
            String temp=carNos[i].replaceAll("\\s+","").toLowerCase();
            if(temp.equals(input)){
                System.out.println("CAR'S NUMBER       => "+carNos[i]);
                System.out.println("CAR'S MODEL        => "+carNms[i]);
                System.out.println("CUSTOMERS'S NAME   => "+cusNms[i]);
                System.out.println("CUSTOMER'S PHONE   => "+cusPhs[i]);
                System.out.println("CUSTOMER'S ADDRESS => "+cusAds[i]);
                System.out.println("DATE OF REPAIR     => "+date[i]);
                System.out.println("TIME FOR REPAIR    => "+time[i]+" DAYS");
                System.out.println("<---------------------------------------------------------->");
                flag=1;
            }

        }
        if(flag==0){
            System.out.println("RECORD NOT FOUND !!! ");
        }
    }
    /*---------------------------------------------------------------------------------------------------------------------*/
    /*------------------------------------------------| OPERATION ----> 4 |------------------------------------------------*/
    public void delete(){
        try{
            logic l=new logic();
            String[] carNos=l.carnos();
            Scanner sc=new Scanner(System.in);
            System.out.println("<---------------------------------------------------------->");
            System.out.println("ENTER THE NUMBER OF CAR :: ");
            String input=sc.nextLine();
            input=input.replaceAll("\\s+","").toLowerCase();
            System.out.println("<---------------------------------------------------------->");
            int flag=0;
            int temp=0;
            for(int i=0;i< l.fileLength();i=i+7){
                temp=i;
                String line=Files.readAllLines(Paths.get("record.txt")).get(i);
                String templine=line.replaceAll("\\s+","").toLowerCase();
                if(templine.equals(input)){
                    for(int j=0;j< l.fileLength();j++){
                        String tempStr=Files.readAllLines(Paths.get("record.txt")).get(j);
                        FileWriter fstream=new FileWriter("newrecord.txt",true);
                        flag=1;
                        BufferedWriter out=new BufferedWriter(fstream);
                        if (j == temp || j == (temp + 1) || j == (temp + 2) || j == (temp + 3) || j == (temp + 4) || j == (temp + 5) || j == (temp + 6)) {
                            out.close();
                        } else {
                            out.write(tempStr+"\n");
                            out.close();
                        }
                    }

                }
            }
            if(flag==1){
                File myObj = new File("record.txt");
                if (myObj.delete()) {
                    File oldNamebr = new File("newrecord.txt");
                    File newFilebr = new File("record.txt");
                    if (oldNamebr.renameTo(newFilebr))
                        System.out.println("Deleted successfully");
                    else
                        System.out.println("Error");
                } else {
                    System.out.println("Error");
                }
            }
            else{
                System.out.println("THIS RECORD IS NOT FOUND");
            }

            System.out.println("DATABASE UP TO DATE SUCCESSFULLY!!!");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    /*---------------------------------------------------------------------------------------------------------------------*/
}
/* ******************************************************************************************************************** */




/* ****************************************************** MENU CLASS ************************************************** */
/*------------------------------------------------| MENU |-------------------------------------------------------------*/
class menu extends Main{
    public void menu(){
        System.out.println("CAR RENTAL SYSTEM");
        int input;
        do {
            System.out.println("*************************************************************************************************************************");
            System.out.println("AUTO REPAIR ADMIN PANEL");
            System.out.println("*************************************************************************************************************************");
            System.out.println("PRESS 1 : ADD CUSTOMER");
            System.out.println("PRESS 2 : SHOW ALL CUSTOMERS");
            System.out.println("PRESS 3 : FIND CUSTOMER");
            System.out.println("PRESS 4 : DELETE CUSTOMER");
            System.out.println("PRESS 5 : EXIT");
            System.out.println("*************************************************************************************************************************");
            Scanner sc = new Scanner(System.in);
            System.out.print("ENTER YOUR CHOICE :: ");
            input = sc.nextInt();
            switch (input) {
                case 1: addBooks();
                    break;
                case 2: show();
                    break;
                case 3: search();
                    break;
                case 4:delete();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.print("The entered value is unrecognized!\n");
                    break;
            }
        } while (true);
    }
}
/*---------------------------------------------------------------------------------------------------------------------*/
/* ******************************************************************************************************************** */
/*---------------------------------------------------| IMPORTANTS LOGIC |----------------------------------------------*/
class logic{
    /*--------------------| ARRAY-1 |-----------------------------*/
    public String[] carnos(){ String  carsnos[] = new String[0];
        try { for(int i=0,j=0;i<fileLength();i=i+7,j++) {
            String line = Files.readAllLines(Paths.get("record.txt")).get(i);
            carsnos=Arrays.copyOf(carsnos,carsnos.length+1);
            carsnos[j]=line; }
            return carsnos; }
        catch(IOException e){ System.out.println(e.getMessage());
            return carsnos; }}
    /*--------------------| ARRAY-2 |-----------------------------*/
    public String[] carnms(){ String  arr[] = new String[0];
        try { for(int i=2,j=0;i<fileLength();i=i+7,j++) {
            String line = Files.readAllLines(Paths.get("record.txt")).get(i);
            arr=Arrays.copyOf(arr,arr.length+1);
            arr[j]=line; }
            return arr; }
        catch(IOException e){ System.out.println(e.getMessage());
            return arr; }}
    /*--------------------| ARRAY-3 |-----------------------------*/
    public String[] cusnms(){ String  arr[] = new String[0];
        try { for(int i=1,j=0;i<fileLength();i=i+7,j++) {
            String line = Files.readAllLines(Paths.get("record.txt")).get(i);
            arr=Arrays.copyOf(arr,arr.length+1);
            arr[j]=line; }
            return arr; }
        catch(IOException e){ System.out.println(e.getMessage());
            return arr; }}
    /*--------------------| ARRAY- 4 |-----------------------------*/
    public String[] cusPHs(){ String  arr[] = new String[0];
        try { for(int i=4,j=0;i<fileLength();i=i+7,j++) {
            String line = Files.readAllLines(Paths.get("record.txt")).get(i);
            arr=Arrays.copyOf(arr,arr.length+1);
            arr[j]=line; }
            return arr; }
        catch(IOException e){ System.out.println(e.getMessage());
            return arr; }}
    /*--------------------| ARRAY- 5 |-----------------------------*/
    public String[] cusADs(){ String  arr[] = new String[0];
        try { for(int i=3,j=0;i<fileLength();i=i+7,j++) {
            String line = Files.readAllLines(Paths.get("record.txt")).get(i);
            arr=Arrays.copyOf(arr,arr.length+1);
            arr[j]=line; }
            return arr; }
        catch(IOException e){ System.out.println(e.getMessage());
            return arr; }}
    /*--------------------| ARRAY- 6 |-----------------------------*/
    public String[] Dates(){ String  arr[] = new String[0];
        try { for(int i=6,j=0;i<fileLength();i=i+7,j++) {
            String line = Files.readAllLines(Paths.get("record.txt")).get(i);
            arr=Arrays.copyOf(arr,arr.length+1);
            arr[j]=line; }
            return arr; }
        catch(IOException e){ System.out.println(e.getMessage());
            return arr; }}
    /*--------------------| ARRAY- 7 |-----------------------------*/
    public String[] Times(){ String  arr[] = new String[0];
        try { for(int i=5,j=0;i<fileLength();i=i+7,j++) {
            String line = Files.readAllLines(Paths.get("record.txt")).get(i);
            arr=Arrays.copyOf(arr,arr.length+1);
            arr[j]=line; }
            return arr; }
        catch(IOException e){ System.out.println(e.getMessage());
            return arr; }}
    /*--------------------| File Length |--------------------------*/
    public int fileLength(){
        int countlen = 0;
        try{
            File file = new File("record.txt");
            Scanner scc = new Scanner(file);
            while(scc.hasNextLine()) {
                scc.nextLine();
                countlen++;
            }
            scc.close();
            return countlen;
        } catch (Exception e) {
            e.getStackTrace();
            return 0;
        }
    }
}
/*---------------------------------------------------------------------------------------------------------------------*/
