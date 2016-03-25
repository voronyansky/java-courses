package ru.vrnsky.clinic;

import ru.vrnsky.io.Input;
import ru.vrnsky.io.Output;

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
    private Output output = new Output();
    private Input input = new Input();


    /**
     * This is constructor for this class
     * @param client - count of all clients
     */
    public Clinic(int client)
    {
        clients = new Client[client];
    }

    /**
     * This method type out in console table view
     * of clinic
     */
    public void getTableClinic()
    {
        //StringBuilder stringBuilder = new StringBuilder();
        String str;
        output.sayUser("id\tName\tPet");
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
                    output.sayUser(str);
                }

            }
        }
        else
        {
            output.sayUser("Clinic is empty. Please add new client");
        }
    }


    /**
     *
     * @param id - number of our client in array clients
     * @return Client instance at id position
     * @throws UserException if id > 0 && clients.length
     */
    public Client getClientById(int id) throws UserException {
       if(id < 0 || id > clients.length) throw new UserException("Client not exist");
        return clients[id];
    }

    /**
     * Search client by his pet name
     */
    public void findClientByPetName()
    {
        output.sayUser("Enter a name of pet for search");
        String petName = input.getString();
        Client client;
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
                        output.sayUser("Client with name " + client.getName() + "have a pet with name: " + petName);
                    }

                }
                else
                {
                    output.sayUser("Client with name " + client.getName() + " not have pet");
                }
            }
        }
    }

    /**
     *  This method search client is clients array
     *  by name of client
     */
    public void findClientByName()
    {
        output.sayUser("Enter a name for search client(s)");
        String clientName = input.getString();  //Reading from console
        Client client;
        for(int i=0;i<clients.length;i++)
        {
            client = clients[i];
            //Search client with name and type it in console
            if(client != null && client.getName().equalsIgnoreCase(clientName))
                output.sayUser(i + " " + client.getName());
        }
    }

    /**
     * This method for edit client name
     * @param clientId - number of client in array
     */
    public void editClientName(int clientId) throws UserException
    {
        Client client = null;
        try {
            client = getClientById(clientId);
        } catch (UserException e) {
            e.printStackTrace();
        }
        if(client == null) output.sayUser("Client not found");
        output.sayUser("Old client name: " + client.getName());
        output.sayUser("Enter new client name");
        String name = input.getString();
        if(name.isEmpty()) throw new UserException("User must have not empty name");
        client.setName(name);
    }

    /**
     * This method adding client to clients array
     */
    public void addClient() throws UserException
    {
        output.sayUser("Enter a name of client");
        String name = input.getString();
        if(name.isEmpty()) throw new UserException("User must have name");
        Client client = new Client(name);
        for(int i=0;i<clients.length;i++)
        {
            if(clients[i] == null)
            {
                clients[i] = client;
                break;
            }
        }
    }

    /**
     * This method add pet to the client
     * @param clientId - number in clients array
     */
    public void addClientsPet(int clientId) throws UserException
    {
        Client client = null;
        Pet pet = null;
        try {
            client = getClientById(clientId);
        } catch (UserException e) {
            e.printStackTrace();
        }
        output.sayUser("Type god for add god and type cat for add cat");
        String typePet = input.getString();
        if(typePet.equalsIgnoreCase("cat"))
        {
            output.sayUser("Type a name of your cat");
            pet = new Cat(input.getString());
        }
        else if (typePet.equalsIgnoreCase("dog"))
        {
            output.sayUser("Type a name of your dog");
            pet = new Dog(input.getString());
        }
        else if(typePet.isEmpty()) throw new UserException("Field dog/cat may not empty");

        client.setPet(pet);

    }


    /**
     * This method remove client in array by his id
     * @param clientId
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
            output.sayUser("Client deleted");
        }
    }

    /**
     *
     * @param clientId - id client in array
     * @return Pet instance of client
     */
    public Pet getClientsPet(int clientId)
    {
        return clients[clientId].getPet();
    }

    /**
     * This method edit clients pet name
     * @param clientId - number of client in clients array
     */
    public void editClientPetName(int clientId)
    {
        Client client = null;
        try {
            client = getClientById(clientId);
        } catch (UserException e) {
            e.printStackTrace();
        }
        if(client != null)
        {
            output.sayUser(client.getName() +  " have pet with name " + client.getPet().getName());
            output.sayUser("Type new name for this pet");
            client.getPet().setName(input.getString());
        }
        else
        {
            System.out.println("Client not found");
        }
    }

    /**
     * This method remove pet in the client instance
     * @param clientId - number of client in clients array
     */
    public void removeClientPet(int clientId)
    {
        if(clientId < 0 && clientId > clients.length)
        {
            output.sayUser("Client does not exist");
        }
        else
        {
            Client client = clients[clientId];
            client.setPet(null);
            output.sayUser("Pet was deleted");

        }
    }


}