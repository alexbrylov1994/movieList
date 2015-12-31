public class Movie
{
	private String name;
    private String[] actors;
    private String rating;
    
    public Movie(String aName, String[] people, String number)
    {
	name = aName;
    actors = people;
    rating = number;
    }

    public String getName()
    {
	return(name);
    }

    public void setName(String aName)
    {
	name = aName;

    }

    public String toString()
    {
	String temp;
    String names;
    String move_cast = "\n\tActors: " + "\n\t" + actors[0]+ "\n\t" +actors[1]+"\n\t"+actors[2];
	if (name != null)
    {
	    temp = "Movie's name: " + name + move_cast+ "\n\tRating:" + "\n\t" + rating;

    }
	else
	    temp = "Movie's name: No-name";
	return(temp);
    }
}