package ru.vrnsky.clinic;

import ru.vrnsky.collection.ArrayList;
import ru.vrnsky.exception.UserException;
import ru.vrnsky.io.Input;
import ru.vrnsky.io.Output;

import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: Egor
 * Date: 22.02.16
 * This is realization of clinic
 */
public class Clinic {

    private List<Client> clients; //In this array hold all clients
    private Output output = new Output();
    private Input input = new Input();


    /**
     * This is constructor for this class
     * @param client - count of all clients
     */
    public Clinic(int client)
    {
        clients = new ArrayList<Client>();
    }

    /**
     * This method type out in console table view
     * of clinic
     */
    public void getTableClinic()
    {
        String str = "str";
        output.sayUser("id\tName\tPet");
        if(clients != null)
        {
            for(int i=0;i<clients.size();i++)
            {
                Client client = clients.get(i);
                if (client != null)
                {
                    if (client.getPet() != null)
                    {
                        str = i + "\t" + client.getName() + "\t" + client.getPet();
                        System.out.println(str);
                    }
                    else
                    {
                        str = i + "\t" + client.getName() + "\t" + "NO PETS";
                        System.out.println(str);
                    }
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
     * @return Client instance at id position
     * @throws UserException if id > 0 && clients.length
     */
    public Client getClientById() throws UserException {

        output.sayUser("Type id of client");
        int id = input.getInt();
        if(id < 0 || id > clients.size()) throw new UserException("Id out of range");
        return clients.get(id);
    }

    /**
     * Search client by his pet name
     */
    public void findClientByPetName()
    {
        output.sayUser("Enter a name of pet for search");
        String petName = input.getString();
        Client client;
        for(int i=0;i<clients.size();i++)
        {
            client = clients.get(i);
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
        for(int i=0;i<clients.size();i++)
        {
            client = clients.get(i);
            //Search client with name and type it in console
            if(client != null && client.getName().equalsIgnoreCase(clientName))
                output.sayUser(i + " " + client.getName());
        }
    }

    /**
     * This method for edit client name
     * @throws UserException if client does not exist or user try to assign client empty string for name
     */
    public void editClientName() throws UserException
    {
        Client client = null;
        try {
            client = getClientById();
        } catch (UserException e) {
            e.printStackTrace();
        }
        if(client == null) { output.sayUser("Client not found"); return; }
        output.sayUser("Old client name: " + client.getName());
        output.sayUser("Enter new client name");
        String name = input.getString();
        if(name.isEmpty()) throw new UserException("User must have not empty name");
        client.setName(name);
    }

    /**
     * This method adding client to clients array
     * @throws UserException - if name of client is empty
     */
    public void addClient() throws UserException
    {
        output.sayUser("Enter a name of client");
        String name = input.getString();
        if(name.isEmpty()) throw new UserException("User must have name");
        Client client = new Client(name);
        clients.add(client);
    }

    /**
     * This method attach pet to instance of client
     * @throws UserException
     */
    public void addClientsPet() throws UserException
    {
        Client client = null;
        Pet pet = null;
        try {
            client = getClientById();
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

        client.setPet(pet); //TODO fix, this string may throw NullPointerException

    }


    /**
     * This method remove client in array by his id
     * @throws UserException
     */
    public void removeClient() throws UserException
    {
        getTableClinic();
        output.sayUser("Type id of client which you would to delete");
        int id = input.getInt();
        if(id < 0 || id > clients.size()) throw new UserException("Id out of range");
        clients.set(id,null);
    }

    /**
     *
     * @param clientId - id client in array
     * @return Pet instance of client
     */
    public Pet getClientsPet(int clientId)
    {
        return clients.get(clientId).getPet();
    }

    /**
     * This method edit clients pet name
     *
     */
    public void editClientPetName()
    {
        Client client = null;
        try {
            client = getClientById();
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
     *
     */
    public void removeClientPet() throws UserException {

        Client client = getClientById();
        client.setPet(null);

    }


}