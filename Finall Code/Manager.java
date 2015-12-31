//               Full assignment 5
//                Oleksiy Brylov
//                   10123597 
//                   CPSC 233
//             Lecture 1, Tutorial 02
//             Version April 13 2014
//                      1.8
// Features: adds move info, erases it, removes some data, searches for data, 
// displays everything, shows 4th movie after 4 new added movies
// Limitations: no real limitations, can't use rating as integer. Method that display 4th movie,
// it's the best one


import java.util.Scanner;
public class Manager
{
    // references
	private static final int MATCH = 0;
    private MovieNode head;
    private String LIST_HEADER = "DISPLAYING LIST";

    private Scanner in = new Scanner(System.in);

	
	public Manager()
	{
		MovieNode head = null;
	}

    public void add(String title, String[] array, String rating , String genre)
	{

        // sets movie info and node
        Movie newMovie = new Movie(title,array, rating,genre);
        MovieNode newNode = new MovieNode(newMovie, null);	


        // if List empty, new node becomes first node
        if (head == null)
        {
            head = newNode; 
        }


        // if Node not empty, find insertion point (end of list)
        else
        {
            MovieNode current = head;
            MovieNode previous = null;

            // when current is null end is reached, previous reference is one step back and will refer to
            // the last node in the list.
            while (current != null)
            {
                previous = current;
                current = current.getNext();
            }


            // Previous refers to last node. Link in new node but adding it to the end 
            // (last node's next pointer refers to the new node)
            previous.setNext(newNode);
        }
	}


    public void eraseList ()
    {
    // erases the whole list, I'm not using it enywhere, I used it to do debuging, 
    // but u can add it as extra feature
    System.out.println("Destroying the contents of entire list");
    head = null;
    }


    public void remove ()
    {

    // checks if list is empyu
    if (head == null)
        System.out.println("List is already empty: Nothing to remove");


    // if it's not empty
    else
    {
            removeNonempty();
        }
    } 


   private void removeNonempty()
    {

    MovieNode previous = null;
    MovieNode current = head;
    String searchName = null;
    boolean isFound = false;
    String currentName;
    Scanner in = new Scanner(System.in);
    System.out.print("Enter name of movie to remove: ");
    searchName = in.nextLine();      


    // checks for current note 
        while ((current != null) && (isFound == false))
    {   
        //uses players input to find the name of the movie 
        currentName = current.getData().getName();

        // check if movies match
        if (searchName.compareToIgnoreCase(currentName) == MATCH)
            isFound = true;
        
        
        // if not moves to another node
        else
        {
        previous = current;
        current = current.getNext();
        }
    }

    // match is found (removes a node)         
    if (isFound == true)
    {

        System.out.println("REMOVING MOVIE CALLED: " + searchName);

        // removes first node 
        if (previous == null)
            head = head.getNext();


        //removes any other expect the first one
        else
            previous.setNext(current.getNext());
    }


    // if movie wasn't found
    else  // isFound == false
        System.out.println("No movie called " + searchName + 
                  " in the collection.");
    }


    // this method is almost identical to the one above "removeNonempty"

    public void searchMovie()
    {
    MovieNode previous = null;
    MovieNode current = head;
    String searchName = null;
    boolean isFound = false;
    String currentName;
    System.out.print("Enter name of movie that you want to find: ");
    searchName = in.nextLine();      

        while ((current != null) && (isFound == false))
    {
        currentName = current.getData().getName();
        if (searchName.compareToIgnoreCase(currentName) == MATCH)
            isFound = true;
        else
        {
        previous = current;
        current = current.getNext();
        }
    }
      
    if (isFound == true)
    {

        // prints a specific box and movie and all it's info
        System.out.println("\nResults of Movie Search:");

        for (int i = 0; i < LIST_HEADER.length(); i++)
            System.out.print("-");  

        System.out.println("\n"+current);

        for (int i = 0; i < LIST_HEADER.length(); i++)
            System.out.print("-");
    }

    
    else 
        System.out.println("No movie called " + searchName + 
                  " in the collection.");
    }

    // reverses order 
    public void reverse()
    {
        MovieNode temp = head;

        System.out.println();       
        
        System.out.println("\nREVERSE MOVIE LIST");
        for (int i = 0; i < LIST_HEADER.length(); i++)
            System.out.print("-");

        if (temp==null)
            System.out.print("\nList is empty, can't do anything");
        

        reverseOrder(temp); 
    }


    // checks if node it's null and prints revesed list of movies
    public void reverseOrder(MovieNode temp)
    {

        if (temp!=null) 
        {
            reverseOrder(temp.getNext());
            String starts=("\n********************\n");
            System.out.print("\n"+temp+starts);

        }
    }

 	public void display()
	{
	int count = 1;
    MovieNode temp = head;

    System.out.println("\nMOVIE LIST");
    
    // prints lines
    for (int i = 0; i < LIST_HEADER.length(); i++)
            System.out.print("-");
    
    
    // cheks if there is something in the list
    System.out.println();
    if (temp == null)
        System.out.println("\tList is empty: nothing to display");
    
    
    // prins movie, checks each node.
    while (temp != null)
    {
        String starts=("\n********************");
        System.out.println("\n#" +count  + " " +temp+starts);
            
	    temp = temp.getNext();
	    count = count + 1;
	}
	System.out.println();		
	}


    // it's a part of the remove functuonality
    private void displayAndRecurse(MovieNode temp, int count)
    {
        // Stops when end of list reached
        if (temp == null)
            return;
      
        else
        {

          // Display data and move onto next element
          String starts=("\n********************\n");
          System.out.println("#" + count + ": " + temp+starts);
	      temp = temp.getNext();
	      count = count + 1;
          displayAndRecurse(temp,count);
        }

    }

    // shows the "remove list" , so we can see what we can remove!
    public void displayRemoveList()
    {
        MovieNode temp = head;

        System.out.println("REMOVE LIST");
        for (int i = 0; i < LIST_HEADER.length(); i++)
            System.out.print("-");
       

        System.out.println();
        if (temp == null)
            System.out.println("\tList is empty: nothing to display");
        else
	{
	    int count = 1;
            displayAndRecurse(temp,count);
	}
	System.out.println();
    }
 

    // this method works as SearchMovie, it's not the best way to see what we saved last
    // but James said that we don't have to write checks to see if we have duplicats
    // so we can assume that all movies are different and in this case this method will work just fine
    // it works fine if there are no duplicats. If James said that we don't have to worry about duplicats
    // then this method is fine!

    public void movie4th(String title)
    {
    MovieNode previous = null;
    MovieNode current = head;
    String searchName = null;
    boolean isFound = false;
    String currentName;
   
    searchName = title;     

    while ((current != null) && (isFound == false))
    {
        currentName = current.getData().getName();
        if (searchName.compareToIgnoreCase(currentName) == MATCH)
            isFound = true;
       
        else
        {
        previous = current;
        current = current.getNext();
        }
    }

        // CASE 2A OR 2B: MATCH FOUND (REMOVE A NODE)         
    if (isFound == true)
    {
        String choice; 

        System.out.println("\n4th Movie Have Been Added");
        for (int i = 0; i < LIST_HEADER.length(); i++)
            System.out.print("-");

       
        System.out.println("\n" + current);

        
        for (int i = 0; i < LIST_HEADER.length(); i++)
            System.out.print("-");

        System.out.printf("\nPress Enter to Continue:");
        in.nextLine();
        
    }

    }
}
