import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    List<String> printToList(char a) {

        int totalSize = (howLargeIsDiamond(a) - 1) * 2 + 1;
        int middleSize = totalSize / 2;
        List answer = new ArrayList();
        Character currentLetter = 'A';


        for (int i = 0; i <= middleSize; i++)
        {
            answer.add(oneLine(currentLetter, totalSize, middleSize));
            currentLetter = (char) (currentLetter + 1);
        }

        currentLetter = (char) (currentLetter - 2);

        for (int i = 0; i < middleSize; i++)
        {
            answer.add(oneLine(currentLetter, totalSize, middleSize));
            currentLetter = (char) (currentLetter - 1);
        }

        return answer;
    }

    /**
     * Creates one line for the diamond shape
     * @param a char
     * @param sizeOfDiamond int
     * @param middle int
     * @return String
     */
    public String oneLine(char a, int sizeOfDiamond, int middle)
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

    /**
     * Creates a string with specified number of spaces
     * @param num int
     * @return String
     */
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
     * Determines the size of the diamond based on the character input
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


        //System.out.println("A" + dia.getSpaces(3) + "A");

        dia.printToList('B');
    }


}
