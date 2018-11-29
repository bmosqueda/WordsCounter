class UseWordsCount 
{
  public static void main(String[] args) {
    WordsCounter counter = new WordsCounter("Hola mundo");

    System.out.println("El número de palabras es: " + counter.getWords());
    System.out.println("El número de palabras sin repetir es: " + counter.getNotRepeatedWords());
    System.out.println("El número de sílabas es: " + counter.countSyllables());

    System.out.println("Número de apariciones de cada caracter");
    int chars[] = counter.getChars();
    for (int i = 0; i < chars.length; i++)
      System.out.println((char)i + ": " + chars[i]);  
  }
}