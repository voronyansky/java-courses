package src.calculator;

/**
 * Created with IntelliJ IDEA.
 * User: Egor
 * Date: 22.02.16
 * This is dog realization.
 */

public class Dog implements Pet {

    private boolean isHungry = false; //Our dog always is not hungry
    private final String NOISE = "Auf!"; //Sometimes our dog is angry
    private String name;                 //Our dog have name

    /*
        Constructor for this class
        @param:String name  - name of our dog
        @return Dog class instance
     */
    public Dog(String name)
    {
        this.name = name;
    }

    /*
        Setter for field name
        @param: String name - name of our dog
        @return: void
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /*
        Getter for field name
        @param: void
        @return: String name  - name of our dog
     */
    public String getName()
    {
        return this.name;
    }

    /*
        When our dog is angry call this method
        It type in the console "Auf!"
        @param: void
        @return: void
     */
    @Override
    public void someNoise() {
        System.out.println(NOISE);
    }

    /*
        Getter for hungry field
        @param: void
        @return: void
     */
    @Override
    public boolean isHungry() {
        return this.isHungry;
    }
}
