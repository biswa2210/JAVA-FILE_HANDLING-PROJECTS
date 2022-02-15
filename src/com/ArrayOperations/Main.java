package com.ArrayOperations;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.*;
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
        System.out.print("ENTER STUDENT NAME  :: ");
        String stnm=sc.nextLine();
        System.out.print("ENTER STUDENT'S ENROLLMENT NO   :: ");
        String sten=sc.nextLine();
        System.out.print("ENTER STUDENT'S REGISTRATION NO :: ");
        String streg=sc.nextLine();
        System.out.print("STREAM OF THE STUDENT           :: ");
        String stream=sc.nextLine();
        System.out.print("YEAR OF THE STUDENT          :: ");
        String year=sc.nextLine();
        System.out.print("PHONE NUMBER OF STUDENT    :: ");
        String phno=sc.nextLine();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now=LocalDateTime.now();
        File myObj=new File("record.txt");
        try{
            if(myObj.createNewFile()){
                try {
                    FileWriter fstream = new FileWriter("record.txt",true);
                    BufferedWriter out = new BufferedWriter(fstream);
                    out.write(sten+"\n");
                    out.write(stnm+"\n");
                    out.write(streg+"\n");
                    out.write(stream+"\n");
                    out.write(year+"\n");
                    out.write(phno+"\n");
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
                out.write(sten+"\n");
                out.write(stnm+"\n");
                out.write(streg+"\n");
                out.write(stream+"\n");
                out.write(year+"\n");
                out.write(phno+"\n");
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
        String[] stens=l.sten();
        String[] stNms=l.stnms();
        String[] stSteam=l.stream();
        if(stens.length>0){
            System.out.println("<---------------------------------------------------------->");
            System.out.println("Total "+stens.length+" students added");
            System.out.println("<---------------------------------------------------------->");
            for(int i=0;i< stens.length;i++){
                System.out.println("STUDENT'S ENROLLMENT  NUMBER   => "+stens[i]);
                System.out.println("STUDENT'S NAME     => "+stNms[i]);
                System.out.println("STUDENT'S STREAM   => "+stSteam[i]);
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
        String[] stens=l.sten();
        String[] stNms=l.stnms();
        String[] stSteam=l.stream();
        String[] stPhs=l.Phons();
        String[] stReg=l.streg();
        String[] date=l.Dates();
        String[] years=l.Years();

        Scanner sc=new Scanner(System.in);
        System.out.println("<---------------------------------------------------------->");
        System.out.println("ENTER THE ENROLLMENT NO. OF STUDENT :: ");
        String input=sc.nextLine();
        input=input.replaceAll("\\s+","").toLowerCase();
        System.out.println("<---------------------------------------------------------->");
        int flag=0;
        for(int i=0;i< stens.length;i++){
            String temp=stens[i].replaceAll("\\s+","").toLowerCase();
            if(temp.equals(input)){
                System.out.println("STUDENT'S ENROLLMENT  NUMBER   => "+stens[i]);
                System.out.println("STUDENT'S NAME     => "+stNms[i]);
                System.out.println("STUDENT'S STREAM   => "+stSteam[i]);
                System.out.println("STUDENT'S PHONE    => "+stPhs[i]);
                System.out.println("STUDENT'S REGISTRATION NUMBER  => "+stReg[i]);
                System.out.println("YEAR OF STUDENT    => "+years[i]);
                System.out.println("DATE OF ADD RECORD     => "+date[i]);
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
            Scanner sc=new Scanner(System.in);
            System.out.println("<---------------------------------------------------------->");
            System.out.println("ENTER THE ENROLLMENT NO. OF STUDENT :: ");
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
        int input;
        do {
            System.out.println("*************************************************************************************************************************");
            System.out.println("STUDENTS RECORD ADMIN PANEL");
            System.out.println("*************************************************************************************************************************");
            System.out.println("PRESS 1 : ADD STUDENT");
            System.out.println("PRESS 2 : SHOW ALL STUDENTS");
            System.out.println("PRESS 3 : FIND STUDENT");
            System.out.println("PRESS 4 : DELETE STUDENT");
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
    public String[] sten(){ String  ens[] = new String[0];
        try { for(int i=0,j=0;i<fileLength();i=i+7,j++) {
            String line = Files.readAllLines(Paths.get("record.txt")).get(i);
            ens=Arrays.copyOf(ens,ens.length+1);
            ens[j]=line; }
            return ens; }
        catch(IOException e){ System.out.println(e.getMessage());
            return ens; }}
    /*--------------------| ARRAY-2 |-----------------------------*/
    public String[] streg(){ String  regs[] = new String[0];
        try { for(int i=2,j=0;i<fileLength();i=i+7,j++) {
            String line = Files.readAllLines(Paths.get("record.txt")).get(i);
            regs=Arrays.copyOf(regs,regs.length+1);
            regs[j]=line; }
            return regs; }
        catch(IOException e){ System.out.println(e.getMessage());
            return regs; }}
    /*--------------------| ARRAY-3 |-----------------------------*/
    public String[] stnms(){ String  nms[] = new String[0];
        try { for(int i=1,j=0;i<fileLength();i=i+7,j++) {
            String line = Files.readAllLines(Paths.get("record.txt")).get(i);
            nms=Arrays.copyOf(nms,nms.length+1);
            nms[j]=line; }
            return nms; }
        catch(IOException e){ System.out.println(e.getMessage());
            return nms; }}
    /*--------------------| ARRAY- 4 |-----------------------------*/
    public String[] Years(){ String  yrs[] = new String[0];
        try { for(int i=4,j=0;i<fileLength();i=i+7,j++) {
            String line = Files.readAllLines(Paths.get("record.txt")).get(i);
            yrs=Arrays.copyOf(yrs,yrs.length+1);
            yrs[j]=line; }
            return yrs; }
        catch(IOException e){ System.out.println(e.getMessage());
            return yrs; }}
    /*--------------------| ARRAY- 5 |-----------------------------*/
    public String[] stream(){ String  strms[] = new String[0];
        try { for(int i=3,j=0;i<fileLength();i=i+7,j++) {
            String line = Files.readAllLines(Paths.get("record.txt")).get(i);
            strms=Arrays.copyOf(strms,strms.length+1);
            strms[j]=line; }
            return strms; }
        catch(IOException e){ System.out.println(e.getMessage());
            return strms; }}
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
    public String[] Phons(){ String  phnos[] = new String[0];
        try { for(int i=5,j=0;i<fileLength();i=i+7,j++) {
            String line = Files.readAllLines(Paths.get("record.txt")).get(i);
            phnos=Arrays.copyOf(phnos,phnos.length+1);
            phnos[j]=line; }
            return phnos; }
        catch(IOException e){ System.out.println(e.getMessage());
            return phnos; }}
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
