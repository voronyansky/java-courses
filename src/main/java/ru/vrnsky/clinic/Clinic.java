package ru.vrnsky.clinic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Egor
 * Date: 22.02.16
 * This is realization of clinic
 */
public class Clinic {

    private Client[] clients; //In this array hold all clients
    private BufferedReader reader; //Need for reading data from console

    /*
        Constructor for this class
        @param: int client - amont of all client
     */
    public Clinic(int client)
    {
        clients = new Client[client];
    }

    public void getTableClinic()
    {
        //StringBuilder stringBuilder = new StringBuilder();
        String str = "";
        System.out.println("id\tName\tPet");
        if(clients != null)
        {
            for(int i=0;i<clients.length;i++)
            {
                if(clients[i] != null)
                {
                    if(clients[i].getPet() != null)
                    {
                        str = i + "\t" + clients[i].getName() + "\t" + clients[i].getPet().getName();
                    }
                    else
                    {
                        str = i + "\t" + clients[i].getName() + "\t" + "no pet yet";
                    }
                    System.out.println(str);
                }

            }
        }
        else
        {
            System.out.println("Clinic is empty. Please add new client");
        }
    }



    /*
        @param: int id - id client, number is array clients
        @return Client instance at id position
     */
    public Client getClientById(int id)
    {
        Client client = null;
        if(id >= 0 && id < clients.length)
            client = clients[id];
        else
            client = null;

        return client;
    }


    /*
       This method search client is clients array
       by name of client
       @param void
       @return void
     */
    public void findClientByName()
    {
        System.out.println("Enter a name for search client(s)");
        String clientName = getDataFromConsole();     //Reading from console
        Client client = null;
        for(int i=0;i<clients.length;i++)
        {
            client = clients[i];
            //Search client with name and type it in console
            if(client != null && client.getName().equalsIgnoreCase(clientName))
                System.out.println(i + " " + client.getName());
        }
    }

    /*
        Search client by pet name
        @param: void
        @return: void
     */
    public void findClientByPetName()
    {
        System.out.println("Enter a name of pet for search");
        String petName = getDataFromConsole();
        Client client = null;
        for(int i=0;i<clients.length;i++)
        {
            client = clients[i];
            //Check for client not null
            if(client != null)
            {
                if(client.getPet() != null)
                {
                    //Search client with pet which name is petName and type result in the console
                    if(client.getPet().getName().equalsIgnoreCase(petName))
                    {
                        System.out.println("Client with name " + client.getName() + "have a pet with name: " + petName);
                    }

                }
            }
        }
    }

    /*
        Edit the name of client
        @param: int id - id client in clients array
        @return:void
     */
    public void editClientName(int clientId)
    {
        Client client = getClientById(clientId);
        if(client == null) System.out.println("Client not found");
        System.out.println("Old client name: " + client.getName());
        System.out.println("Enter new client name");
        String name = getDataFromConsole();
        client.setName(name);
    }

    /*
       @param:void
       @return:void
       This method create new instance of Client class with
       name and push it to the clients array
     */
    public void addClient()
    {
        System.out.println("Enter a name of client");
        String name = getDataFromConsole();
        Client client = new Client(name);
        int id=0;
        for(int i=0;i<clients.length;i++)
        {
            if(clients[i] == null)
            {
                clients[i] = client;
                id = i;
                break;
            }
        }
    }

    /*
       It method add pet to client instance
       @param: int clientId - number of client in clients array
       @return: void
     */
    public void addClientsPet(int clientId)
    {
        Client client = getClientById(clientId);
        Pet pet = null;
        if(client == null) return;
        System.out.println("Type god for add god and type cat for add cat");
        String typePet = getDataFromConsole();
        if(typePet.equalsIgnoreCase("cat"))
        {
            System.out.println("Type a name of your cat");
            pet = new Cat(getDataFromConsole());
        }
        else if (typePet.equalsIgnoreCase("dog"))
        {
            System.out.println("Type a name of your dog");
            pet = new Dog(getDataFromConsole());
        }

        client.setPet(pet);

    }


    /*
        Delete client from our array of client
        @param: int clientId - number of client in our clients array
        @return: void
     */
    public void removeClient(int clientId)
    {
        if(clientId < 0 && clientId < clients.length)
        {
            System.out.println("Client not exist");
        }
        else
        {
            clients[clientId] = null;
            System.out.println("Client deleted");
        }
    }

    /*
      Getter for client pet
      @param: int clientId - number of client in clients array
      @return Pet instance of client pet
     */
    public Pet getClientsPet(int clientId)
    {
        return clients[clientId].getPet();
    }

    /*
        Edit client pet name
        @param: int clientId - id client in clients array
        @return: void
     */
    public void editClientPetName(int clientId)
    {
        Client client = getClientById(clientId);
        if(client != null)
        {
            System.out.println(client.getName() +  " have pet with name " + client.getPet().getName());
            System.out.println("Type new name for this pet");
            client.getPet().setName(getDataFromConsole());
        }
        else
        {
            System.out.println("Client not found");
        }
    }

    /*
        Delete pet from client
        @param:int clientId - number of client in our clients array
        @return: void
     */
    public void removeClientPet(int clientId)
    {
        if(clientId < 0 && clientId > clients.length)
        {
            System.out.println("Client not exist");
        }
        else
        {
            Client client = clients[clientId];
            client.setPet(null);
            System.out.println("Pet deleted");

        }
    }

    /*
        @param:void
        @return: String data
        This method read data from console and handled all exception
        and return String from console
     */
    private String getDataFromConsole()
    {
        reader = new BufferedReader(new InputStreamReader(System.in));
        String data = "";
        try
        {
            data = reader.readLine();
        }
        catch (Exception exp)
        {
            System.out.println(exp.getMessage());
        }

        return data;
    }
}