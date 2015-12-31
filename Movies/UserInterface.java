import java.util.Scanner;

public class UserInterface
{
	private static final int MATCH = 0;
    private MovieNode head;
    private String LIST_HEADER = "DISPLAYING LIST";
	
	private Scanner in = new Scanner(System.in);
	String title;
	String actor1;
	String actor2;
	String actor3;
	String rating;
	String[] array;
    char choice;
    boolean loop=true;

    int count=0;

    int test = 0;
    //boolean test=true;

	public UserInterface()
	{
		MovieNode head = null;

	}
	
    public void start(){

    while(loop){
        menu();

    // should display only 4 recent entered values, not the whole list     
    // if((count%4)==0)
    // {
    //     display();
    // }

    }
    }

	public void add()
	{
        System.out.println("\nAdding a new movie");
        System.out.printf("Movie title: ");
        
        title = in.nextLine();
        
        System.out.println("Enter Actors' Names: ");
        
        System.out.println("First Actor: ");
        actor1 = in.nextLine();
       
        System.out.println("Second Actor: ");
        actor2 = in.nextLine();
        
        System.out.println("Third Actor: ");
        actor3 = in.nextLine();

        String[]array = {actor1, actor2, actor3};



        System.out.println("Enter Movie's rating:");
        
        rating = in.nextLine();

        while(!rating.equals("0") &&!rating.equals("1") &&!rating.equals("2") &&!rating.equals("3") &&!rating.equals("4") &&!rating.equals("5"))
        {
            System.out.println("Rating can be between 0 and 5, enter a new one");
            System.out.println("Enter Movie's rating:");
            rating = in.nextLine();
        }

        // String price = String.valueOf(x);
        //  System.out.println("test: " +price);
        //     loop=false;
        Movie newMovie = new Movie(title,array, rating);
        MovieNode newNode = new MovieNode(newMovie, null);	

        // Case 1: List empty: new node becomes first node
        if (head == null)
        {
            head = newNode; 
        }
        // Case 2: Node not empty, find insertion point (end of list)
        else
        {
            MovieNode current = head;
            MovieNode previous = null;
            // Traverse list: when current is null end is reached
            // Previous reference is one step back and will refer to
            // the last node in the list.
            while (current != null)
            {
                previous = current;
                current = current.getNext();
            }
            // Previous refers to last node. Link in new node but adding
            // it to the end (last node's next pointer refers to the new
            // node).
            previous.setNext(newNode);
        }

        

	}

    public void menu()
    {
        System.out.println("\n(A)dd a movie to the collection:");
        System.out.println("(D)isplay:");
        System.out.println("(S)earch:");
        System.out.println("(R)emove a movie from the list:");
        System.out.println("(O)pposite order display:");
        System.out.println("(Q)uit menu:");
        System.out.printf("Your Choice: ");
        choice = in.nextLine().charAt(0); // in.next().charAt(0);

        while(choice!='A' && choice!='S' && choice!='R' && choice!='O' && choice!='D' && choice!='Q')
        {
            System.out.println("There is no such option, enter a valid menu choice");
            System.out.printf("Your Choice: ");
            choice = in.nextLine().charAt(0); 
        }
        
        if(choice=='Q')
        {
            System.out.println("\nProgram stops working");
            System.exit(0);
        }

        else if(choice=='D')
        {
            display();
        }

        else if(choice=='A'){
            add();
            count++;
        }

        else if (choice=='R')
        {
            displayRemoveList();
            remove();
            display();
        }

        else if (choice == 'S')
        {
            searchMovie();
        }

        else if (choice =='O') // delete it
        {
           MovieNode temp = head;
           reverseOrder(temp); 
        }
    }

	public void display()
	{
	int count = 1;
        MovieNode temp = head;

        System.out.println("\nMOVIE LIST");
        for (int i = 0; i < LIST_HEADER.length(); i++)
            System.out.print("-");
        System.out.println();
        if (temp == null)
            System.out.println("\tList is empty: nothing to display");
        while (temp != null)
        {
            String starts=("\n********************");
            System.out.println("\n\t#" + count + ": " + temp+starts);
            
	    temp = temp.getNext();
	    count = count + 1;
	}
	System.out.println();		
	}

    private void displayAndRecurse(MovieNode temp, int count)
    {
        // Stop when end of list reached
        if (temp == null)
            return;
        else
        {
           // Display data and move onto next element
            System.out.println("\t#" + count + ": " + temp);
	      temp = temp.getNext();
	      count = count + 1;
            displayAndRecurse(temp,count);
        }

    }

    public void displayRemoveList()
    {
        MovieNode temp = head;
        System.out.println("DISPLAYING LIST (Remove)");
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

    private void recurseAndDisplay(MovieNode temp, int count)
    {
        if (temp.getNext() == null)
    {
            System.out.println("\n\t#" + count + ": " + temp);
            return;
        }
        else
        {
        temp = temp.getNext();
        count = count + 1;
            displayAndRecurse(temp,count);
        }
    }
    public void eraseList ()
    {
    // JT's note: In Java this is okay with other languages such as C/C++ we should
    // manually step through the list element by element and de-allocate or free up
    // the memory taken up by the list.
     System.out.println("Destroying the contents of entire list");
    head = null;
    }

    public void remove ()
    {

    // CASE 1: EMPTY LIST
    if (head == null)
        System.out.println("List is already empty: Nothing to remove");

    // CASE 2: NON-EMPTY LIST  
    else
    {
            removeNonempty();
        }
    } 

    // Case 2 & 3:
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
        System.out.println("Removing movie called " + searchName);
        // CASE 2A: REMOVE THE FIRST NODE
        if (previous == null)
            head = head.getNext();
        // CASE 2B: REMOVE ANY NODE EXCEPT FOR THE FIRST 
        else
            previous.setNext(current.getNext());
    }

    // CASE 3: NO MATCHES FOUND (NOTHING TO REMOVE).
    else  // isFound == false
        System.out.println("No movie called " + searchName + 
                  " in the collection.");
    }

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

        // CASE 2A OR 2B: MATCH FOUND (REMOVE A NODE)         
    if (isFound == true)
    {
        System.out.println("\nResults of Movie Search: \n" + current);
    }

    // CASE 3: NO MATCHES FOUND (NOTHING TO REMOVE).
    else  // isFound == false
        System.out.println("No movie called " + searchName + 
                  " in the collection.");
    }

    public void reverseOrder(MovieNode temp)
    {
        System.out.println();       
        if (temp==null){
            System.out.print("List is empty, can't do anything");
      
        System.out.println("\nREVERSE MOVIE LIST");
        for (int i = 0; i < LIST_HEADER.length(); i++)
            System.out.print("-");
        }

        else 
        {
            reverseOrder(temp.getNext());
            String starts=("\n********************");
            System.out.print("\n\t#"+temp+starts);
        }

        // while (temp != null)
        // {
        //     String starts=("\n********************");
        //     System.out.println("\n\t#" + count + ": " + temp + starts);
            
        // temp = temp.getNext();
        // count = count + 1;
    //}

    }
}
