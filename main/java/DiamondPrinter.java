import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {

        int totalSize = howLargeIsDiamond(a);
        List answer = new ArrayList();
        Character starterLetter = 'A';


        for (int i = 1; i <= totalSize; i++)
        {
            answer.add(oneLine(starterLetter, totalSize - i, totalSize));
            starterLetter = (char) (starterLetter + 1);
        }

        starterLetter = (char) (starterLetter - 2);

        for (int i = 1; i <= totalSize; i++)
        {
            answer.add(oneLine(starterLetter, i, totalSize));
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
    public String oneLine(char a, int padding, int sizeOfDiamond)
    {
        String aString = "";

        if (padding > 0 || a != 'A')
        {
            String totalSpaces = getSpaces(padding);
            aString = aString.concat(totalSpaces);
            aString = aString.concat(Character.toString(a));
            if (a != 'A')
            {
                String inBetweenSpaces = "";
                //int totalSpacesBetweenChars = a - 'A';
                if ((int) a == sizeOfDiamond) //In the middle of the diamond
                {
                    inBetweenSpaces = getSpaces(howLargeIsDiamond(a));
                }
                else
                {
                    inBetweenSpaces = getSpaces(sizeOfDiamond - howLargeIsDiamond(a));
                }

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

        return aString;
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

        //List meow = dia.oneLine('A', 3);

        //System.out.println("A" + dia.getSpaces(3) + "A");

        dia.printToList('B');
    }


}
