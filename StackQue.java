/*
- 4 files: Node.java, LinkedList.java
*/
import java.util.*;
public class StackQue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int command = 0;
        String x = "";
        LinkedList list = new LinkedList();
        System.out.println("Enter if you would like a stack or queue");
        x = input.nextLine();
        while(command != 6){
            System.out.println("You are in a " + x);
            System.out.println("Menu:\n1. Push\n2. Pop\n3. Display\n4. Is it in the list?\n5. Reverse\n6. Quit");
                command = input.nextInt();
                if(command == 1){
                    System.out.println("Enter the value you would like to push");
                    int val = input.nextInt();
                    list.addTail(val);
                }
                else if(command == 3){
                    list.show();
                }
                else if(command == 2){
                    if(list.count()==0){
                        System.out.println("Nothing to delete");
                    }
                    else if(x.equalsIgnoreCase("stack")){
                        list.deleteTail();
                    }
                    else if(x.equalsIgnoreCase("queue")){
                        list.deleteHead();
                    }
                }
                else if(command == 4){
                    System.out.println("Enter the number you would like to search for.");
                    int temp = input.nextInt();
                    if(list.indexOf(temp) > 0){
                        System.out.println("In position " + list.indexOf(temp));
                    }
                    else{
                        System.out.println("Not in the list");
                    }
                }
                else if(command == 5){
                    list = list.reverse(list);
                    System.out.println("List reversed");
                }
        }
        System.out.println(list.calcTotal());
    }
}