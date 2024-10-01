
package newpackage;

public class DVD extends Item{
    
    //creating the constructor
    DVD(String ID, String Title, String Availability, String Director1, String Duration1) {
        super(ID,Title,Availability); //calling to the super class
        //adding values to the variables
        Director=Director1;
        Duration=Duration1;
        }

    String Director;
    String Duration;

    //creating method to pass the data to the AddDVD class
    String Director2(){
        return Director;
    }
    String Duration2(){
        return Duration;
    }
   
}

