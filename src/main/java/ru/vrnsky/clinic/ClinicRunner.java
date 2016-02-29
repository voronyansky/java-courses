package ru.vrnsky.clinic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: Egor
 * Date: 26.02.16
 * Time: 15:12
 * This is user menu of pet clinic
 */
public class ClinicRunner {

    public static void main(String[] args) throws Exception
    {
        Clinic clinic = new Clinic(10);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String answer = "";
        while(true)
        {
            guessUser();
            int command = Integer.parseInt(reader.readLine());
            System.out.println("If you want work with existing client type id of client.\nOtherwise type -1");
            int id = Integer.parseInt(reader.readLine());
            executeCommand(clinic,command,id);
            System.out.println();
            System.out.println("====================DATABASE UPDATE=======================");
            System.out.println();
            clinic.getTableClinic();
            System.out.println("====================DATABASE UPDATE=======================");
            Thread.sleep(3000);


        }


    }

    public static void guessUser()
    {
        System.out.println("Clinic command. Type number of command for execute");
        System.out.println("1.Add new client");
        System.out.println("2.Remove client");
        System.out.println("3.Set pet of existing client");
        System.out.println("4.Find client by name");
        System.out.println("5.Find client by pet name");
        System.out.println("6.Edit client name");
        System.out.println("7.Edit client\'s pet name");
        System.out.println("8.Remove client\'s pet");
        System.out.println("9.Remove client");
        System.out.println("10.Get table clinic");
        System.out.println("11.Exit");
    }

    public static void executeCommand(Clinic clinic, int command,int id)
    {
        switch(command)
        {
            case 1:
                clinic.addClient();
                break;
            case 2:
                clinic.removeClient(id);
                break;
            case 3:
                clinic.addClientsPet(id);
                break;
            case 4:
                clinic.findClientByName();
                break;
            case 5:
                clinic.findClientByPetName();
                break;
            case 6:
                clinic.editClientName(id);
                break;
            case 7:
                clinic.editClientPetName(id);
                break;
            case 8:
                clinic.removeClientPet(id);
                break;
            case 9:
                clinic.removeClient(id);
                break;
            case 10:
                clinic.getTableClinic();
                break;
            case 11:
                System.exit(0);
                break;
        }
    }

}