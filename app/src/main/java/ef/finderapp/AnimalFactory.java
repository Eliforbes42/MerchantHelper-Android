package ef.finderapp;

public class AnimalFactory
{
    public AnimalFactory() { }
    public static Animal getAnimal(int caseNum)
    {
        if(caseNum == 1) return new Chicken();
        if(caseNum == 2) return new Pig();
        if(caseNum == 3) return new Snek();


        return null;//return null object if unsupported animal
    }
}
