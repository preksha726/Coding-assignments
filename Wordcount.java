import java.io.File;
import java.io.*;

// reads data from files as streams of characters
import java.io.FileReader;

// reads text efficiently from character-input
// stream buffers 
import java.io.BufferedReader;

// for writing data to files
import java.io.PrintWriter;

// signals that an input/output (I/O) exception 
// of some kind has occurred
import java.io.IOException;

// compiled representation of a regular expressions
import java.util.regex.Pattern;

// matches a compiled regular expression with an input string
import java.util.regex.Matcher;
 import java.lang.*;
 import java.util.*;


public class Wordcount {
  public static int totalWords;
  
  public static void main(String[] args){

        // did the user provide correct number of command line arguments?
        // if not, print message and exit
       if (args.length != 3){
            System.err.println("Number of command line arguments must be 3");
            System.err.println("You have given only " + args.length + "command line arguments");
            System.err.println("Incorrect usage. Program terminated");
            System.err.println("Correct usage: java TextProcessingV3 <input-file-name> <word-output-file-name> <word-counts-output-file-name>");
            System.exit(1);
        }
    
        String inFileName = args[0];
        System.out.println("Input file name is: " + inFileName);

        // extract first output file name from the command line arguments
        // write words into this file
        
        String wordFileName = args[1];
        System.out.println("Output file name for writing words is: " + wordFileName);

        String wordCountFileName = args[2];
        System.out.println("Output file name for writing words is: " + wordCountFileName);


        BufferedReader br = null;
        
        // wdWriter for writing extracted words to an output file
        PrintWriter wdWriter = null;

        
        // wordPattern specifies pattern for words using a regular expression
        //Pattern wordPattern = Pattern.compile("[<>?a-zA-Z]+");
        Pattern wordPattern = Pattern.compile("<.*?>(.*?)</.*?>");
        //<.*?>(.*?)</.*?>
        //Pattern wordpatternend = Pattern.compile(">");

        // wordMatcher finds words by spotting word word patterns with input
        Matcher wordMatcher;
        //Matcher wordMatcherend;
        
        
        String line;


        
        String word;

        TreeMap<String, Integer> frequencyData = new TreeMap<String, Integer>( );
        
        totalWords=0;

        try {
            wdWriter = new PrintWriter(wordFileName, "UTF-8");
            System.out.println(wordFileName + " successfully opened for writing");
        }
        catch (IOException ex){
            System.err.println("Unable to open " + wordFileName + " for writing");
            System.err.println("Program terminated\n");
            System.exit(1);
        }
        try {
            // get a BufferedReader object, which encapsulates
            // access to a (disk) file
            br = new BufferedReader(new FileReader(inFileName));

            // as long as we have more lines to process, read a line
            // the following line is doing two things: makes an assignment
            // and serves as a boolean expression for while test
            while ((line = br.readLine()) != null)   {

                

                // process the line by extracting words using the wordPattern
                wordMatcher = wordPattern.matcher(line);
                //wordMatcherend = wordPatternend.matcher(line);

                // process one word at a time
                while ( wordMatcher.find() ) {

                    // extract the word
                    word = line.substring(wordMatcher.start(), wordMatcher.end());
                   

                    // convert the word to lower-case
                                       
                    word = word.toLowerCase();
                    word = word.replaceAll("<.*?>", "");
                    word = word.replaceAll(" ", "\n");
                    word = word.replace("?","");
                    word = word.replace("!","");
                    word = word.replace(",","");
                    word = word.replace("-","");
                    word = word.replace(".","");
                    word = word.replace(";","");
                    word = word.replace(":","");
                    word = word.replace("'d", "ed");
                    word = word.replace("'s", "is");
                    word = word.replace("'n", "en");
                    word = word.replace("'t", "it");
                    word = word.replace("'st", "");
                    word = word.replace("'er", "ver");
                    word = word.replace("'ll", "will");
                    word = word.replace("'ld", "would");
                    word = word.replace("'ldst", "would");
                    word = word.replace("'rt", "art");
                    word = word.replace("'tis", "it is");
                    word = word.replace("'twas", "it was");
                    word = word.replace("'tween", "between");
                    word = word.replace("'twere", "it were");
                    word = word.replace("'twould", "it would");
                    word = word.replace("'twill", "it will");
                    word = word.replace("'twixt", "betwixt");
                    word = word.replace("'twould", "it would");
                    word = word.replace("wi'", "with");
                    word = word.replace("'re", "are");
                    word = word.replace("'Zounds", "By God's wounds");
                    word = word.replace("'Fore","before");
                    word = word.replace("'gainst","against");
                    word = word.replace("i'","in");
                    word = word.replace("in's","in his");
                    word = word.replace("'las","alas");
                    word = word.replace("let's","let us");
                    word = word.replace("''mongst", "amongst");
                    word = word.replace("o'", "of");
                    word = word.replace("'scuse", "excuse");
                    word = word.replace("ta'en", "taken");
                    word = word.replace("tell's", "tell us");

                    word = word.replace("'","");
                    

                    if(word.charAt(0) == '\'')
                    {
                      word = word.replaceAll(" \'' ", "");
                    }

                  wdWriter.println(word);
                  
 
                } // while - wordMatcher

                
            } // while - line


        
        } // try
        catch (IOException ex) {
            System.err.println("File " + inFileName + " not found. Program terminated.\n");
            System.exit(1);
        }

         wdWriter.close();

      readWordFile(frequencyData, wordFileName); 
      printAllCounts(frequencyData, wordCountFileName,totalWords);
      Scanner wordFile;
      
      Integer count;   // The number of occurrences of the word

                     
       
        
  }
     public static int getCount
   (String word, TreeMap<String, Integer> frequencyData)
   {
      if (frequencyData.containsKey(word))
      {  // The word has occurred before, so get its count from the map
       return frequencyData.get(word); // Auto-unboxed
      }
      else
      {  // No occurrences of this word
         return 0;
      }
   }

   public static void printAllCounts(TreeMap<String, Integer> frequencyData, String s, int n )
   {  
      // ccWriter for writing characters and their occurrence 
        // counts to an output file
        PrintWriter ccWriter = null;
        int count;

      try {
            ccWriter = new PrintWriter(s, "UTF-8");
            System.out.println(s + " successfully opened for writing");
        }
        catch (IOException ex){
            System.err.println("Unable to open " + s + " for writing");
            System.err.println("Program terminated\n");
            System.exit(1);
        }
      ccWriter.println("-----------------------------------------------");
      ccWriter.println("    Occurrences RelFrequency   Word");

      double relF,freq;
      int uniqueWords = 0;
         
      
      for(String word : frequencyData.keySet( ))
      {
          uniqueWords++;
      }
     
      
      for(String word : frequencyData.keySet( ))
      { 
        count = frequencyData.get(word);
        relF = (double)count/(double)n;
        //freq = (double)(count/uniqueWords);

        

       
        ccWriter.printf("%10d"+ "       "+ "%4f " +"    "+"  %s\n", count,relF,word);
        
        
      }

      ccWriter.println("-----------------------------------------------");
      ccWriter.close();

   }  
    public static void readWordFile(TreeMap<String, Integer> frequencyData, String wordFileName)
   {
      Scanner wordFile;
      String word;     // A word read from the file
      Integer count;   // The number of occurrences of the word

      try
      {
         wordFile = new Scanner(new FileReader(wordFileName));
      }
      catch (FileNotFoundException e)
      {
     System.err.println(e);
     return;
      }
      
      while (wordFile.hasNext( ))
      {
          // Read the next word and get rid of the end-of-line marker if needed:
      word = wordFile.next( );

          // Get the current count of this word, add one, and then store the new count:
          count = getCount(word, frequencyData) + 1;
          frequencyData.put(word, count);
          totalWords++;
      }
}      
}             
            
        