//               Full assignment 5
//                Oleksiy Brylov
//                   10123597 
//                   CPSC 233
//             Lecture 1, Tutorial 02
//             Version April 13 2014
//                      1.1
// Features: class that sets nodes, alows to get movie data, and set movie data
// Limitations: no limitations, it only sets and returns things.


public class MovieNode
{
    // references
    private Movie data;
    private MovieNode next;
    
    
    // sets initially to null
    public MovieNode()
    {
        data = null;
        next = null;
    }

   
    //sets new data and next node 
    public MovieNode(Movie someData, MovieNode nextNode)
    {
        setData(someData);
        setNext(nextNode);
    }

   
    // gets data
    public Movie getData()
    {
        return(data);
    }

   
    // gets next node
    public MovieNode getNext()
    {
        return(next);
    }

   
    //sets data
    public void setData(Movie someData)
    {
        data = someData;
    }

   
    //sets next node
    public void setNext(MovieNode nextNode)
    {
        next = nextNode;
    }

    
    //translates data to a string
    public String toString()
    {
        return(data.toString());
    }	
}