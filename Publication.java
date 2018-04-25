/**
 * class Publication
 * 
 * @author Bindu Kondreddi
 * @version final
 */

public abstract class Publication { 

      protected String authors;
      protected String tITLE;
      protected String publisher;
      protected int year;
      //constructor
      public Publication(String pUBLISHER, String title, String aUTHORS,int yEAR)
      {
         publisher = pUBLISHER;
         authors = aUTHORS;
         tITLE = title;
         year = yEAR;
         
      }
      //Get and set methods
      public String getAuthors() 
      {
         return authors;
      }
      
      public void setAuthors(String aUTHORS)
      {
        authors = aUTHORS;
      }

      public String getTitle() 
      {
       return tITLE;
      }

      public void setTitle(String title)
      {
        tITLE = title;
      }

      public String getPublisher() 
      { 
         return publisher;
      }
      public void setPublisher(String pUBLISHER)
      {
        publisher= pUBLISHER;
      } 

      public int getYear() 
      { 
         return year;
      }
      public void setYear(int yEAR)
      {
        year= yEAR;
      } 

      public String toString() 
      {
      return "Publisher: "+ publisher+"; Title = " + tITLE + "; Authors = " + authors + ", Year = " + year; 
      }

} 