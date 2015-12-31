//               Full assignment 5
//                Oleksiy Brylov
//                   10123597 
//                   CPSC 233
//             Lecture 1, Tutorial 02
//             Version April 13 2014
//                      1.3
// Features: sets actors,name,rating, genre of the movie, allows to get name,set name, and translates everything
//into a string
// Limitations: temp is too long, but it works fine


public class Movie
{
	//references 
    private String name;
    private String[] actors;
    private String rating;
    private String genre;
    
   
    // sets name, actors, rating, genre
    public Movie(String aName, String[] people, String number, String type)
    {
	name = aName;
    actors = people;
    rating = number;
    genre = type;
    }

    
    //alows to get name of the movie
    public String getName()
    {
	return(name);
    }

    
    //alows to set name of the movie
    public void setName(String aName)
    {
	name = aName;
    }


    // translates everything into a string
    public String toString()
    {

	String temp;
    String names;

   
    // adds all actors into 1 string
    String movie_cast = "\nActors: " + "\n" + actors[0]+ "\n" +actors[1]+"\n"+actors[2];
	
    
    // checks if name isn't null, sets everything or returns the message in other case 
    if (name != null)
    {
	    temp = "Movie's name: " + name + movie_cast+ "\nGenre:\n" + genre + "\nRating:" + "\n" + rating;

    }
	
    else
	    temp = "Movie's name: No-name";
	return(temp);
    }
}