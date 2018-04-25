/**
 * class  PublicationTest
 * 
 * @author Bindu Kondreddi
 * @version final
 */
public class PublicationTest {

   //An array to hold instances of the Publication class
   private Publication pubsArray[];

   public void createpubsArray() {

      pubsArray = new Publication[6]; // generic array of any shape
      //two instances of the Book class 
      pubsArray[0]  = new Book("9781449331443", "2nd", 720, "O'Reilly Media, Inc", "Head First Java: A Brain-Friendly Guide", "Kathy Sierra and Bert Bates ", 2005);
      
      pubsArray[1]  = new Book("9780071606318", "8th", 720, "McGraw Hill Professional", "Java The Complete Reference", "Herbert Schildt ", 2011);
      //two instances of the ConferencePaper class 
      pubsArray[2]  = new ConferencePaper("Principles and Practices of Programming in java" ,"Melbourne", "Ryan Stansifer", "0-190","ACM", "Principles and Practices of Programming on the Java Platform", "Ching Yaung",2005);
      
      pubsArray[3]  = new ConferencePaper("IEEE" ,"Greenville", "Ryan Stansifer", "25-38","ACM", "Principles and Practices of Programming", "Ching Yaung",2010);
      //two instances of the JournalPaper class 
      pubsArray[4]  = new JournalPaper("Image quality assessment: from error visibility to structural similarity" , 3, 2, "1-10","ACM", "Image quality assessment", "A. C. Bovik, H. R. Sheikh ,E. P. Simoncelli",2008);
      pubsArray[5]  = new JournalPaper("quality assessment" , 1, 5, "30-45","IEE", "quality assessment", "Zhou Wang",2015);

   }

   public void printpubsArray() {

      // Loop through arrayOfPublication. Use polymorphism to print 

      for ( int i = 0; i < pubsArray.length; i++ ) {

         System.out.println(pubsArray[i].toString());
          System.out.println("\n");
      }
   }


   public static void main (String[] args) {

      PublicationTest publicationTest = new PublicationTest();
      publicationTest.createpubsArray();
      publicationTest.printpubsArray();    
   }

}