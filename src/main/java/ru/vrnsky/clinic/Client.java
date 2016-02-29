package ru.vrnsky.clinic;

/**
 * Created with IntelliJ IDEA.
 * User: Egor
 * Date: 22.02.16
 * This is client' realization.
 */
public class Client {

    private String name;
    private Pet pet;

    public Client(String name)
    {
        this.name = name;
    }

    public Client(String name, Pet pet)
    {
        this.name = name;
        this.pet = pet;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Pet getPet()
    {
        return this.pet;
    }

    public void setPet(Pet pet)
    {
        this.pet = pet;
    }
}