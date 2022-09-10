//This is a java program for a small structural engineering company that helps with the many projects
//They want to manage

import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class poised {
    public static void main (String[]args) throws FileNotFoundException, IOException {

        NewProject[] pobj = new NewProject[5];
        int projNum = 0;

        Architect[] aobj = new Architect[5];
        int anum = 0;

        Contractor[] cobj = new Contractor[5];
        int cnum = 0;

        String timestamp = new SimpleDateFormat("yyyMMdd").format(Calendar.getInstance().getTime());
        char option = JOptionPane.showInputDialog("MAIN MENU,Please choose an option from below: \n A) Add a project \n" +
                "B) Add an Architect \n C) Add a Contractor\n D) Finalize a project \n E) Edit \n X) Exit").toLowerCase().charAt(0);

        //Create a loop for the menu to keep showing as long as the user has not exited
        while(option != 'x'){

            if(option == 'a'){
                if(projNum > 4){
                    System.out.println("You cannot add any more projects.Please complete the projects and try again");
                }
                else{
                    NewProject plink = new NewProject();
                    pobj[projNum] = new NewProject(plink.projNum, plink.projName, plink.building, plink.custAdress, plink.erfnum, plink.totalCost,plink.paid,plink.date,plink.custname,plink.custnum,plink.custEmail,plink.custAdress);
                    System.out.println("Your project has been added and your project number is" + projNum);
                    projNum++;
                }
            }

            if(option == 'b'){
                if(anum > 4){
                    System.out.println("You cannot add any more Architects");
                }
                else{
                    Architect alink = new Architect();
                    aobj[anum] = new Architect(alink.name,alink.num,alink.email,alink.address);
                    anum++;
                }
            }

            if(option == 'c'){
                if(cnum > 4){
                    System.out.println("You cannot add any more Contactors");
                }
                else{
                    Contractor clink = new Contractor();
                    cobj[cnum] = new Contractor(clink.name,clink.num,clink.email,clink.address);
                    cnum++;
                }
            }
            if(option == 'd'){
                PrintWriter writer = new PrintWriter("Finished Projects.txt");

                        int projnum = Integer.parseInt(JOptionPane.showInputDialog("Please enter the project you would like to finalize:"));
                if (pobj[projnum].getTotalCost() > 0.00) {

                    System.out.println("You have an outstanding balance of R"+ pobj[projnum].getTotalCost());
                    writer.write("You have an outstanding balance of R"+ pobj[projnum].getTotalCost() + "\n");
                    writer.write("Name: " + pobj[projnum].custname + "\n");
                    writer.write("Email: "+ pobj[projnum].custEmail + "\n");
                    writer.write("Phone Number: " + pobj[projnum].custnum + "\n");
                    writer.write("Address: " + pobj[projnum].custAdress + "\n");
                    writer.write("Project Number: " + pobj[projnum].projNum + "\n");
                    writer.write("Project Name: " + pobj[projnum].projName + "\n");
                    writer.write("Building Type: " + pobj[projnum].building + "\n");
                    writer.write(" ERF Number: " + pobj[projnum].erfnum + "\n");
                    writer.write("Total Cost: " + pobj[projnum].totalCost + "\n");
                    writer.write("Deadline: " + pobj[projnum].date + "\n");
                    writer.write(timestamp); // YYYYMMDD format
                    System.out.println(" ");
                    writer.close();
                }
                else{
                    writer.write("You have an outstanding balance of R"+ pobj[projnum].getTotalCost() + "\n");
                    writer.write("Name: " + pobj[projnum].custname + "\n");
                    writer.write("Email: "+ pobj[projnum].custEmail + "\n");
                    writer.write("Phone Number: " + pobj[projnum].custnum + "\n");
                    writer.write("Address: " + pobj[projnum].custAdress + "\n");
                    writer.write("Project Number: " + pobj[projnum].projNum + "\n");
                    writer.write("Project Name: " + pobj[projnum].projName + "\n");
                    writer.write("Building Type: " + pobj[projnum].building + "\n");
                    writer.write(" ERF Number: " + pobj[projnum].erfnum + "\n");
                    writer.write("Total Cost: " + pobj[projnum].totalCost + "\n");
                    writer.write("Deadline: " + pobj[projnum].date + "\n");
                    writer.write(timestamp); // YYYYMMDD format
                    System.out.println(" ");
                    writer.close();
                }
            }

            if(option == 'e'){
                char option2 = JOptionPane.showInputDialog("What would you like to edit?" + "\nA) Project Due Date" + "\nB) Total cost of the project" + "\nC) Contractors information" + "\nE) Exit").toLowerCase().charAt(0);

                while(option2 != 'e'){
                    int projnum2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the project you want to edit"));
                    if(option2 == 'a'){
                        if(pobj[projnum2].date.isEmpty()){
                            System.out.println("This project does not exist");
                        }
                        else{
                            String change = JOptionPane.showInputDialog("Please enter the new due date YYYY/MM/DD");
                            System.out.println("The project due date has been changed");
                            System.out.println("Old due date: " + pobj[projnum2].date);
                            pobj[projnum2].date = change;
                            System.out.println("New Due Date: " + pobj[projnum2].date);
                        }
                    }
                    if (option2 == 'b'){
                        double change = Double.parseDouble(JOptionPane.showInputDialog("Enter the new amount"));

                        System.out.println("The total cost of the project has been changed");
                        System.out.println("Old cost R " +pobj[projnum2].totalCost);
                        pobj[projnum2].totalCost = change;
                        System.out.println("New cost R " + pobj[projnum2].totalCost);
                    }

                    if(option2 == 'c'){
                        cobj[projnum2].name = JOptionPane.showInputDialog("Enter new Contractor name");
                        cobj[projnum2].num = Integer.parseInt(JOptionPane.showInputDialog("Enter new Contractor phone number"));
                        cobj[projnum2].email = JOptionPane.showInputDialog("Enter new Contractor email address");
                        cobj[projnum2].address = JOptionPane.showInputDialog("Enter new Contractor physical address");
                    }
                }
            }
            option = JOptionPane.showInputDialog("MAIN MENU:" + "\nA) Add project" + "\nB) Add Architect" + "\nC) Add Contractor" + "\nD) Finalize a project" + "\nE) Edit" + "\nX) Exit").toLowerCase().charAt(0);
        }
    }
}
