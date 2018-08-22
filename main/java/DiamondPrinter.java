import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {

        int totalSize = howLargeIsDiamond(a);
        List answer = new ArrayList();
        Character starterLetter = 'A';


        for (int i = 0; i <= totalSize; i++)
        {
            answer.add(oneLine(starterLetter, totalSize - i));
            starterLetter = (char) (starterLetter + 1);
        }

        starterLetter = (char) (starterLetter - 1);

        for (int i = 1; i <= totalSize; i++)
        {
            answer.add(oneLine(starterLetter, i));
            starterLetter = (char) (starterLetter - 1);
        }

        return answer;
    }

    /**
     * Prints one line for the Diamond shape
     * @param a char
     * @param padding int
     * @return List
     */
    public List<String> oneLine(char a, int padding)
    {
        String aString = "";

        if (padding > 0)
        {
            String totalSpaces = getSpaces(padding);
            aString = aString.concat(totalSpaces);
            aString = aString.concat(Character.toString(a));
            if (a != 'a')
            {
                int totalSpacesBetweenChars = a - 'A';
                String inBetweenSpaces = getSpaces(totalSpacesBetweenChars);

                aString = aString.concat(inBetweenSpaces);
                aString = aString.concat(Character.toString(a));
            }

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

        return a - 'A';
    }



}

class DiamondTesters
{
    public static void main(String[] argsdgsg)
    {
        DiamondPrinter dia = new DiamondPrinter();

        int size = dia.howLargeIsDiamond('Z');

        List meow = dia.oneLine('A', 3);

        //System.out.println("A" + dia.getSpaces(3) + "A");

        dia.printToList('B');
    }


}
