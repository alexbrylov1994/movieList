//               Full assignment 5
//                Oleksiy Brylov
//                   10123597 
//                   CPSC 233
//             Lecture 1, Tutorial 02
//             Version April 13 2014
//                      2.5
// Features: does all human interactions, runs program, shows what program does
// Limitations: Case sensitive for Mune choices and genre (has to start with a capital letter)
// wasn't able to have rating as integer, it was givving me errors.
// some big, weird loops. 



import java.util.Scanner;

public class UserInterface
{
    // references
	private Scanner in = new Scanner(System.in);
    char choice;
    boolean loop=true;
    int count=0;
    boolean movie_cancelled = false;


    Manager manager = new Manager();
	
    public void start(){

    // shows intro message
    intro();

    // runs the loop until u quit the program
    while(loop){
        menu();
    }
    }


	public void add()
	{
        // references
        String title;
        String actor1;
        String actor2;
        String actor3;
        String rating;
        String genre;


        System.out.println("\nAdding a new movie");
        System.out.printf("Movie title: ");
        
        // takes input for the movie
        title = in.nextLine();
        
        // if it's empty, ask u to enter something again
        while(title.equals(""))
        {
            System.out.println("\nYou didn't enter title of the movie");
            System.out.println("Movie title: ");
            title = in.nextLine();
        }
        
        System.out.println("\nEnter Actors' Names: ");
        

        // takes input for 3 actors and then checks if user entered something
        //if not, asks you to enter a something
        System.out.println("First Actor: ");
        actor1 = in.nextLine();
        

        while(actor1.equals(""))
        {
            System.out.println("\nPlease enter actor's name");
            System.out.println("First Actor: ");
            actor1 = in.nextLine();
        }
       

        System.out.println("Second Actor: ");
        actor2 = in.nextLine();

        
        while(actor2.equals(""))
        {
            System.out.println("\nPlease enter actor's name");
            System.out.println("Second Actor: ");
            actor2 = in.nextLine();
        }
        
       
        System.out.println("Third Actor: ");
        actor3 = in.nextLine();

        
        while(actor3.equals(""))
        {
            System.out.println("\nPlease enter actor's name");
            System.out.println("Third Actor: ");
            actor3 = in.nextLine();
        }

        //saves actors into 1d erray
        String[]array = {actor1, actor2, actor3};

        
        // takes input
        System.out.println("\nEnter Movie's genre (Start with a capiral letter. Press enter to cancel movie adding) :");
        genre = in.nextLine();

        
        // if empty input, movie won't isn't empty, if yes, movie won't be added
        if (genre.equals(""))
        {
            System.out.println("Movie won't be added!");
            movie_cancelled = true;
        }

        
        // checks if genre was entered corectly
        while((!genre.equals("Action") && !genre.equals("Drama") && !genre.equals("Science fiction") && !genre.equals("Comedy") && !genre.equals("Horror")&&!genre.equals("Martial arts")&&!genre.equals("Other")) && movie_cancelled==false)
        {
            System.out.println("\nINVALID GENRE TYPE \nEnter a valid movie genre:");
            genre = in.nextLine();

       
        // if this time it's emtpy, movie, won't be added
        if (genre.equals(""))
        {
            System.out.println("Movie won't be added!");
            movie_cancelled = true;
            menu();
        }

        }


        // checks if user changed it's mind, information hiding.
        if(movie_cancelled==false){ 

        System.out.println("\nEnter Movie's rating (negative value for movie cancelation) :");
        
        
        // I'm sorry that I'm using rating as String, I tried to use it as integer, but when I try
        // to take input for integer, program crushes, so I decided to use string instead. I'm sorry
        rating = in.nextLine();


        // checks if there is a minus, then movie won't be added
        if(rating.contains("-")){
            System.out.println("This movie won't be added!");
            movie_cancelled = true;
            menu();
        }


        // checks if rating is between 1-5
        while((!rating.equals("1") && !rating.equals("2") &&!rating.equals("3") &&!rating.equals("4") && !rating.equals("5")) && movie_cancelled==false)
        {
            System.out.println("\nRating can be between 1 and 5, enter a new one");
            System.out.println("Enter Movie's rating:");
            rating = in.nextLine();

            if(rating.contains("-")){
                System.out.println("This movie won't be added!");
                movie_cancelled = true;
                menu();
            }
        }

        
        
        // check if movie was cancelled, if not, does everything else 
        if(movie_cancelled==false){
        
        manager.add(title, array, rating, genre);

        // I use count to display 4th entered movie
        count++;
        
        if((count%4)==0)
        {
        manager.movie4th(title);   
        }

        }

        }

        // resets if movie was cancelled
        movie_cancelled=false;
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
        choice = in.nextLine().charAt(0); 


        // checks if input is correct and then calls fucntions based
        // on your input
        while(choice!='A' && choice!='S' && choice!='R' && choice!='O' && choice!='D' && choice!='Q')
        {
            System.out.println("There is no such option, enter a valid menu choice");
            System.out.printf("Your Choice: ");
            choice = in.nextLine().charAt(0); 
        }
        

        if(choice=='Q')
        {
            System.out.println("\nProgram stops working\n");
            System.exit(0);
        }


        else if(choice=='D')
        {
           manager.display();
        }


        else if(choice=='A'){
            add();
        }


        else if (choice=='R')
        {
            // displays remove list, removes movie, and then display "new" list
            manager.displayRemoveList();
            manager.remove();
            manager.display();
        }

        else if (choice == 'S')
        {
            manager.searchMovie();
        }

        else if (choice =='O') 
        {
           manager.reverse(); 
        }
    }

    // basic intro to the program, u can see it only at the begginning of the program!
    public void intro()
    {
        System.out.println("");
        System.out.println("In this program you can: \n1) add movies to your colection");
        System.out.println("2) display your collection \n3) remove movies from your collection");
        System.out.println("4) view movies in opposite order \n5) search for a specific movie");
        System.out.println("6) Possible genres you can enter: Action, Drama, Science fiction, Comedy, Horror, Martial arts or 'Other' !!!");
        System.out.println("7) If you don't want to add a movie anymore, enter a negative value for Rating or just Press Enter at Genre Location!!!");
    }

}
