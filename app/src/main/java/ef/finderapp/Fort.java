package ef.finderapp;

public class Fort
{
    public int row;
    public int col;
    public char rowChar;
    public String fullRowCol;
    public String name;

    public Fort(char nRow, int nCol, String nName)
    {
        rowChar = nRow;
        row = (rowChar - 'A');
        col = nCol;
        name = nName;
        fullRowCol = (Character.toString(rowChar) + Integer.toString(col));
    }
}
