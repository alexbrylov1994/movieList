public class MovieNode
{
    private Movie data;
    private MovieNode next;
    
    public MovieNode()
    {
        data = null;
        next = null;
    }

    public MovieNode(Movie someData, MovieNode nextNode)
    {
        setData(someData);
        setNext(nextNode);
    }

    public Movie getData()
    {
        return(data);
    }

    public MovieNode getNext()
    {
        return(next);
    }

    public void setData(Movie someData)
    {
        data = someData;
    }

    public void setNext(MovieNode nextNode)
    {
        next = nextNode;
    }

    public String toString()
    {
        return(data.toString());
    }	
}