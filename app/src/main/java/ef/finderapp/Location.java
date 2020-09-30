package ef.finderapp;

import java.util.ArrayList;


public class Location
{
    public int row;
    public int col;
    public char rowChar;
    public String fullRowCol;
    public String name;
    public ArrayList<Animal> animals = new ArrayList<Animal>();

    public Location(char nRow, int nCol, String nName, ArrayList<Animal> nAnimals)
    {
        rowChar = nRow;
        row = (int)(rowChar - 'A');
        col = nCol;
        name = nName;
        fullRowCol = (Character.toString(rowChar) + Integer.toString(col));
        animals = nAnimals;
    }
    public Boolean HasAnimal(Animal animal)
    { //use object type to support anything/everything
        if (animal instanceof Chicken) //use is to check type of object
        {
            for (Animal a : animals)
                if (a instanceof Chicken) //search animals for chicken
                    return true;
            return false;
        }
        else if (animal instanceof Pig)
        {
            for (Animal a : animals)
                if (a instanceof Pig) //search animals for pig
                    return true;
            return false;
        }
        else if (animal instanceof Snek)
        {
            for (Animal a : animals)
                if (a instanceof Snek) //search animals for snek
                    return true;
            return false;
        }
        return false; //unsupported animal
    }
}


