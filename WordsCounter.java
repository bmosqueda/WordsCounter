import java.util.HashMap;
import java.util.Map;

public class WordsCounter
{
    private String text;
    
    public WordsCounter(String text)
    {
        this.text = text.toLowerCase();
    }
    
    public int getWords()
    {
        int length = this.text.length();
        int words = 0;
        
        for (int i = 0; i < length; i++) 
        {
            int beforeI = i;
            
            while(i < length && Character.isLetter(this.text.charAt(i)))
                i++;
            
            if(beforeI < i)
                words++;
        }
        
        return words;
    }

    public int getNotRepeatedWords()
    {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); 
                
        int length = this.text.length();
        int words = 0;
        
        for (int i = 0; i < length; i++) 
        {
            int beforeI = i;
            int strValue = 0;
            
            while(i < length && Character.isLetter(this.text.charAt(i)))
            {                
                strValue += (int)this.text.charAt(i);
                i++;
            }
                            
            if(strValue > 0)
            {    
                if(map.get(strValue) == null)
                {
                    map.put(strValue, 1);
                    words++;
                }
            }                
        }
        
        return words;
    }
    
    //Devuelve el numero de veces que aparece cada caracter
    public int[] getChars() {
        int chars[] = new int[256];
        int length = this.text.length();
        
        for (int i = 0; i < length; i++) {
             if((int)this.text.charAt(i) > 255) {
                System.out.println("Fuera del código ascci: " + this.text.charAt(i));
                continue;
             }           
             chars[(int)this.text.charAt(i)]++;
        }
        
        return chars;
        
    }
    
    public int countSyllables()
    {
        int numSyllables = 0;
        boolean newSyllable = true;
        String vowels = "aeiou";
        char[] cArray = this.text.toCharArray();
        for (int i = 0; i < cArray.length; i++)
        {
            if (i == cArray.length-1 && Character.toLowerCase(cArray[i]) == 'e' 
                    && newSyllable && numSyllables > 0) {
                numSyllables--;
            }
            if (newSyllable && vowels.indexOf(Character.toLowerCase(cArray[i])) >= 0) {
                newSyllable = false;
                numSyllables++;
            }
            else if (vowels.indexOf(Character.toLowerCase(cArray[i])) < 0) {
                newSyllable = true;
            }
        }

        return numSyllables;
    }
}
