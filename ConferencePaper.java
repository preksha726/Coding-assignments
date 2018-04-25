/**
 * class Conference Paper is derived from Publication
 * 
 * @author Preksha Kasatwar
 * @version final
 */



public class ConferencePaper extends Publication
{

    protected String conferencename;
    protected String city;  
    protected String editors;
    protected String pagenumbers;

    //Conference Paper
    public ConferencePaper(String conferenceNAME , String cITY, String eDITORS, String pageNUMBERS,String pUBLISHER, String title, String aUTHORS,int yEAR)
    {
        super (pUBLISHER , title, aUTHORS, yEAR);
        this.conferencename = conferenceNAME;
        this.city = cITY;
        this.editors = eDITORS;
        this.pagenumbers = pageNUMBERS;
    }

    
    //Set and Get methods
    public String getEditor()
    {
        return (editors);
    }

    public String getCity()
    {
        return (city);
    }

    public String getConferenceName()
    {
        return (conferencename);
    }

    public String getPagenumbers()
    {
        return pagenumbers;
    }

    public void setEditor(String eDITORS)
    {
        editors = eDITORS;
    }

    public void setCity(String cITY)
    {
        city = cITY;
    }

    public void setConferenceName(String conferenceNAME)
    {
        conferencename = conferenceNAME;
    }

    public void setPagenumbers(String pageNUMBERS)
    {
        pagenumbers = pageNUMBERS;   
    }

    //ToString methods
    public String toString() 
    {
      return "ConferencePaper Name = " + conferencename + "; ConferencePaper " + super.toString() + ", City = " + city+ "; Editors = " + editors + ", Pagenumbers = " + pagenumbers; 
    }

}