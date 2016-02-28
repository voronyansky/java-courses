package src.calculator;

/**
 * Created with IntelliJ IDEA.
 * User: Egor
 * Date: 22.02.16
 * This is realization of cat
 */
public class Cat implements Pet {

    private boolean isHungry = true;  //Our cat always if hungry and eat food in anytime
    private final String NOISE = "Meow"; //Cat may speak with us, but it know one word - "Meow"
    private String name;                 //Our cat have name

    /*
       Constructor of this class
       @param: String name - name of our cat
       @return Cat instance
     */
    public Cat(String name)
    {
        this.name = name;
    }


    /*
        Setter for name field
        @param:String name - new name for out cat
        @return void
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /*
        Getter for name field
        @return: String name - name of our cat
     */
    public String getName()
    {
        return this.name;
    }

    /*
        Method for speak with us
        @param:void
        @return:void
     */
    @Override
    public void someNoise() {
       System.out.println(NOISE);
    }

    /*
        Method for check our cat is hungry?
        @return true if our cat is hungry and false if it isn't hungry
     */
    @Override
    public boolean isHungry() {
        return isHungry;
    }
}
