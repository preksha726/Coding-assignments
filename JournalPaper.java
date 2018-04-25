
/**
 * class Journal Paper is derived from Publication
 * 
 * @author Preksha Kasatwar
 * @version final
 */


public class JournalPaper extends Publication
{

    protected String journalname;
    protected int volume;  
    protected int issue;
    protected String pagenumber;

    //Constructor
    public JournalPaper(String journalName , int vOLUME, int iSSUE, String pageNUMBER,String pUBLISHER, String title, String aUTHORS,int yEAR)
    {
        super (pUBLISHER , title, aUTHORS, yEAR);
        this.journalname = journalName;
        this.volume = vOLUME;
        this.issue = iSSUE;
        this.pagenumber = pageNUMBER;
    }

    public int getVolume()
    {
        return (volume);
    }

    public int getIssue()
    {
        return (issue);
    }

    public String getJournalName()
    {
        return (journalname);
    }

    public String getPagenumber()
    {
        return pagenumber;
    }

    public void setVolume(int vOLUME)
    {
        volume = vOLUME;
    }

    public void setIssue(int iSSUE)
    {
        issue = iSSUE;
    }

    public void setJournalName(String journalName)
    {
        journalname = journalName;
    }

    public void setPagenumber(String pageNUMBER)
    {
        pagenumber = pageNUMBER;   
    }

    public String toString() 
    {
      return "Journal Paper Name = " + journalname + "; Journal Paper : " + super.toString() + ", Issue = " + issue+ "; Volume = " + volume + ", Pagenumbers = " + pagenumber; 
    }

}