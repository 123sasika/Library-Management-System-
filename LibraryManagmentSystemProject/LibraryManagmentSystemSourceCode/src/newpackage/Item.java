
package newpackage;

//importing classes from libraries
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Item {
     static String ID;
     static String Title;
     static String Availability;

    // Constructor of superclass
    Item(String ID1, String Title1, String Availability1) {
        ID= ID1;
        Title=Title1;
        Availability=Availability1;
        
    }

    
    // Superclass methods
    static String ID2() {
        return ID;
    }
    static String Title2(){
        return Title;
    }
    static String Availability2(){
        return Availability;
    }
    
    
    
        //method for returning books which is inherited by the Book and DVD sub Classes
        public static void borrow(String selectedBookId,String borrowerName,String Title) {
        BorrowBook b= new BorrowBook();
        if (borrowerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Borrower name cannot be empty.");
            return;
        }
        
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            Statement stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO borrowbook (ID, Title, BorrowerName) VALUES (?, ?, ?)");
            pstmt.setString(1, selectedBookId);
            pstmt.setString(2, Title);
            pstmt.setString(3, borrowerName);
            pstmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Item borrowed successfully!");

            b.loadData(); 
             
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
           
        }
    }
     
     
      //method for borrowing books which is inherited by the Book and DVD class
      public void borrow(String selectedID,String borrowerName,String Title,String TBName) {
       
        //checking borrowerName is empty
        if (borrowerName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Borrower name cannot be empty.");
            return;
        }
        
        try {
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            PreparedStatement pst;
            
            //checking TBName value is equal to book
             if (TBName.equals("book")) {
                pst = conn.prepareStatement( "INSERT INTO borrowbook (ID, Title, BorrowerName) VALUES (?, ?, ?)");
                pst.setString(1, selectedID);
                pst.setString(2, Title);
                pst.setString(3, borrowerName);
                int rowsDeleted=pst.executeUpdate();
                
                 if (rowsDeleted== 0) {
                //custom exception
                throw new ItemNotBorrowException("Book "+selectedID+" was not found");
            } else {
                JOptionPane.showMessageDialog(null, "Book borrowed successfully!");
            }
                
            } 
            else if (TBName.equals("dvd")) {
                pst = conn.prepareStatement( "INSERT INTO borrowdvd (ID, Title, BorrowerName) VALUES (?, ?, ?)");
                pst.setString(1, selectedID);
                pst.setString(2, Title);
                pst.setString(3, borrowerName);
                int rowsDeleted=pst.executeUpdate();
               
                if (rowsDeleted== 0) {
                //custom exception
                throw new ItemNotBorrowException("DVD "+selectedID+" was not found");
                } else {
                JOptionPane.showMessageDialog(null, "DVD borrowed successfully!");
                }
            }
            
            else {
                throw new IllegalArgumentException("Invalid table name");
            }
           conn.close();
           
        } 
        catch(ItemNotBorrowException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed to borrow Item.");
        }
        
        //update availability of the item from the main table user selected
        try {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            //for  book table
             if (TBName.equals("book")) {
            String query = "UPDATE book SET  Availability= ? WHERE ID = ?";
           
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,"No");
           
            pst.setString(2, selectedID);  // For the WHERE clause

            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Book details updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Book not found!");
            }
             }
             //for dvd table
             else if(TBName.equals("dvd")){
                 
                String query = "UPDATE dvd SET  Availability= ? WHERE ID = ?";
           
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1,"No");

                pst.setString(2, selectedID);  // For the WHERE clause

                int rowsUpdated = pst.executeUpdate();

                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(null, "DVD details updated successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "DVD not found!");
                }
             }

            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"DVD ID already exist");
        }
      }


 //method for displaying details to the AdminDVDHomePage and AdminBookHomePage tables
 public void displayDetails(JTable table, String tableName) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            PreparedStatement pst;

            if (tableName.equals("book")) {
                pst = conn.prepareStatement("SELECT * FROM book");
            }
            else if (tableName.equals("dvd")) {
                pst = conn.prepareStatement("SELECT * FROM dvd");
            } 
            else {
                throw new IllegalArgumentException("Invalid table name");
            }
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            model.setRowCount(0); // Clear existing rows

             //custom exception
            if(!rs.next()){
                throw new ItemDetailsNotFoundException("Item was not loaded");
            }
            
            while (rs.next()) {
                if (tableName.equals("book")) {
                    String bookId = rs.getString("ID");
                    String title = rs.getString("Title");
                    String author = rs.getString("Author");
                    String genre = rs.getString("Genre");
                    String isbn = rs.getString("ISBN");
                    String availability = rs.getString("Availability");

                    Object[] obj = {bookId, title, author, genre, isbn, availability};
                    model.addRow(obj);
                } else if (tableName.equals("dvd")) {
                    String dvdId = rs.getString("ID");
                    String title = rs.getString("Title");
                    String director = rs.getString("Director");
                    String duration = rs.getString("Duration");
                    String availability = rs.getString("Availability");

                    Object[] obj = {dvdId, title, director, duration, availability};
                    model.addRow(obj);
                }
            }

            conn.close();
        }
         catch(ItemDetailsNotFoundException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
 public void returnItem(String selectedID,String Title,String borrowerName,String TBName){
 

        if (selectedID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a valid Book ID!");
            return;
        }
       
        try {
            
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","");
            
            if(TBName.equals("Book1")){
            String query = "DELETE FROM borrowbook WHERE ID = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, selectedID);
            int rowDeleted = pst.executeUpdate();
             
              if (rowDeleted > 0) {
                JOptionPane.showMessageDialog(null, "Item returned successfully!");
            } 
            else {
                JOptionPane.showMessageDialog(null, "Error returning Item!");
            }
            }
            
             else if(TBName.equals("DVD1")){
                    String query = "DELETE FROM borrowdvd WHERE ID = ?";
                    PreparedStatement pst = conn.prepareStatement(query);
                    pst.setString(1, selectedID);
                    int rowDeleted = pst.executeUpdate();
                    
                    if (rowDeleted > 0) {
                        JOptionPane.showMessageDialog(null, "Item returned successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error returning Item!");
            }
            }

            conn.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }  
 }   
}





