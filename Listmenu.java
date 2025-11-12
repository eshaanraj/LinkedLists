import java.util.*;
public class Listmenu
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int command = 0;
        LinkedList potter = new LinkedList();
        while(command != 5){
            System.out.println("Menu:\n1. Insert a value\n2. Delete a value\n3. Display list\n4. Display list length\n5. Quit\nChoose the number of the command you would like to do.");
            command = input.nextInt();
            if(command == 3){
                potter.show();
            }
            else if(command == 4){
                System.out.println(potter.count() + " is the length");
            }
            else if(command ==1){
                System.out.println("Enter a value to insert");
                int val = input.nextInt();
                if(potter.count()==0){
                    potter.addHead(val);
                }
                else{
                    potter.insert(val);
                }
            }
            else if(command == 2){
                if(potter.count() == 0){
                    System.out.println("Nothing to delete");
                }
                else{
                    System.out.println("Enter value you want to delete");
                    int val = input.nextInt();
                    potter.delete(val);
                }
            }
        }
    }
}