package ru.vrnsky.clinic;

import ru.vrnsky.io.Input;
import ru.vrnsky.io.Output;

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

    private static final Input input = new Input();
    private static final Output output = new Output();

    public static void main(String[] args) throws Exception
    {
        Clinic clinic = new Clinic(10);

        while(true)
        {
            guessUser();
            int command = Integer.parseInt(input.getString());
            System.out.println("If you want work with existing client type id of client.\nOtherwise type -1");
            int id = Integer.parseInt(input.getString());
            executeCommand(clinic,command,id);
            output.sayUser("");
            output.sayUser("====================DATABASE UPDATE=======================");
            output.sayUser("");
            clinic.getTableClinic();
            output.sayUser("====================DATABASE UPDATE=======================");
            Thread.sleep(3000);

        }


    }

    /**
     * This method type out at the console all users command
     */
    public static void guessUser()
    {
        output.sayUser("Clinic command. Type number of command for execute");
        output.sayUser("0.LIST");
        output.sayUser("1.Add new client");
        output.sayUser("2.Remove client");
        output.sayUser("3.Set pet of existing client");
        output.sayUser("4.Find client by name");
        output.sayUser("5.Find client by pet name");
        output.sayUser("6.Edit client name");
        output.sayUser("7.Edit client\'s pet name");
        output.sayUser("8.Remove client\'s pet");
        output.sayUser("9.Remove client");
        output.sayUser("10.Exit");
    }

    /**
     *
     * @param clinic - instance of clinic class
     * @param command - number of command
     * @param id - id of clients for execute command
     */
    public static void executeCommand(Clinic clinic, int command,int id) throws Exception
    {
        if(command < 0 && command > 11) throw new IllegalArgumentException("Command must start from 0 to 10");
        switch(command)
        {
            case 0:
                clinic.getTableClinic();
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
                System.exit(0);
                break;

        }
    }

}