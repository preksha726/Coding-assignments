/**
 * class Book is derived from Publication
 * 
 * @author Bindu Kondreddi
 * @version final
 */
public class Book extends Publication
{

    protected String iSBN; 
    protected String edition;
    protected int numberofpages;

   public Book(String isbn , String eDITION, int numberOFPAGES,String pUBLISHER, String title, String aUTHORS,int yEAR)
   {
        super (pUBLISHER , title, aUTHORS, yEAR);
        iSBN = isbn;
        edition = eDITION;
        numberofpages = numberOFPAGES;
   }

   public String getEditon()
   {
      return (edition);
   }

   public String getISBN()
   {
      return (iSBN);
   }

   public int getNumberOfPages()
   {
      return (numberofpages);
   }


   public void setEditon(String eDITION)
   {
      this.edition = eDITION;
   }

   public void setISBN(String isbn)
   {
      this.iSBN = isbn;
   }

   public void setNumberOfPages(int numberOFPAGES)
   {
      this.numberofpages = numberOFPAGES;
   }

   public String toString() 
   {
      return "Book ISBN = " + iSBN + ", Edition = " + edition+ "; Number Of Pages = " + numberofpages+"; Book " + super.toString(); 
   }

}