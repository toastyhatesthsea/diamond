import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {

        int totalSize = (howLargeIsDiamond(a) - 1) * 2 + 1;
        int middleSize = totalSize / 2;
        List answer = new ArrayList();
        Character currentLetter = 'A';


        for (int i = 0; i <= middleSize; i++)
        {
            answer.add(oneLine2(currentLetter, totalSize, middleSize));
            currentLetter = (char) (currentLetter + 1);
        }

        currentLetter = (char) (currentLetter - 2);

        for (int i = 0; i < middleSize; i++)
        {
            answer.add(oneLine2(currentLetter, totalSize, middleSize));
            currentLetter = (char) (currentLetter - 1);
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
                if ((int) a - 'A' + 1 == sizeOfDiamond) //In the middle of the diamond
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

    public String oneLine2(char a, int sizeOfDiamond, int middle)
    {
        String answer = getSpaces(sizeOfDiamond);
        char[] lineArray = answer.toCharArray();
        int distanceFromCharacterA = a - 'A';

        if (a == 'A')
        {
            lineArray[middle] = 'A';
        }
        else
        {
            lineArray[middle - distanceFromCharacterA] = a;
            lineArray[middle + distanceFromCharacterA] = a;
        }

        return charArrayToString(lineArray);
    }

    public String charArrayToString(char[] anArray)
    {
        String answer = "";

        for (Character aChar : anArray)
        {
            answer = answer.concat(Character.toString(aChar));
        }
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

        //List meow = dia.oneLine('A', 3);

        //System.out.println("A" + dia.getSpaces(3) + "A");

        dia.printToList('B');
    }


}
