
package newpackage;

public class Book extends Item {
    
    //creating the constructor 
    Book(String ID, String Title, String Availability, String Author1, String Genre1, String ISBN) {
        
        super(ID,Title,Availability);  //passing data to the super class constructor  
        //passing data to the variables of Book class
        Author=Author1;
        Genre=Genre1;
        this.ISBN=ISBN;
    }

    //creating variables
   String Author;
   String Genre;
   String ISBN;

   
   //passing data to the AddBook class
    String Author2(){
        return Author;
    }
    String Genre2(){
        return Genre;
    }
    String ISBN1(){
        return ISBN;
    }
}
