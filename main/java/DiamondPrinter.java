import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {



        return null;
    }

    public List<String> oneLine(char a, int padding)
    {
        String aString = "";

        if (padding > 0)
        {
            String totalSpaces = getSpaces(padding);
            aString = aString.concat(totalSpaces);
            aString = aString.concat(Character.toString(a));
            aString = aString.concat(totalSpaces);
        }
        else
        {
            aString = aString.concat(Character.toString(a));
        }

        List answer = new ArrayList<String>();
        answer.add(aString);

        return answer;
    }

    public String getSpaces(int num)
    {
        String answer = "";

        for (int i = 0; i < num; i++)
        {
            answer = answer.concat(" ");
        }
        return answer;
    }


    /**
     * Determines the size of the diamond based ont he character input
     * @param a char
     * @return int
     */
    public int howLargeIsDiamond(char a)
    {
        a = Character.toUpperCase(a);

        return a - 'A' + 1;
    }



}

class DiamondTesters
{
    public static void main(String[] argsdgsg)
    {
        DiamondPrinter dia = new DiamondPrinter();

        int size = dia.howLargeIsDiamond('Z');
    }


}
