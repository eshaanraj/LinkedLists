import java.util.*;
public class LinkedList {
    public Node head;
    public static int listCount;
    public LinkedList(){
        head = new Node(4);
        listCount = 1;
    }
    public void show(){
        Node current = head;
        // loop stops right before last term; second to last term
        if(head != null){
            while(current.next != null){
                System.out.print(current.data + "->");
                current = current.next;
            }
            System.out.println ("last -->" + current.data);
        }
        else{
            System.out.println("NullPointerExceptionThrown! - NO List to Print");
        }
    }
    public boolean addHead(int d){
        Node newhead = new Node(d);
        newhead.next = head;
        head = newhead;
        listCount+=1;
        return true;
    }
    public boolean addTail(int d){
        Node newtail = new Node(d);
        Node current = head;
        if(head == null){
            addHead(d);
            listCount++;
            return true;
        }
        while(current.next != null){
            current = current.next;
        }
        current.next = newtail;
        listCount++;
        return true;
    }
    public boolean insert(int d){
        Node ins = new Node(d);
        Node current = head;
        if(ins.data<head.data){
            ins.next = head;
            head = ins;
            listCount++;
        return true;
        }
        else{
            while(current.next != null && ins.data > current.next.data){
                current = current.next;
            }
            ins.next = current.next;
            current.next = ins;
            listCount++;
            return true;
        }
    }
    public int count(){
        return listCount;
    }
    public boolean delete(int d){
        Node temp = new Node(d);
        Node current = head;
        if(current != null && current.data == d){
            head = current.next;
            return true;
        }
        while(current != null && current.next != null){
            if(current.next.data == d){
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        listCount--;
        return true;
    }
    public boolean deleteHead(){
        Node current = head;
        head = current.next;
        listCount--;
        return true;
    }
    public boolean deleteTail(){
        Node current = head;
        if(listCount == 1){
            head = null;
            listCount--;
            return true;
        }
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
        listCount--;
        return true;
    }
    public int indexOf(int x){
        Node current = head;
        int i = 1; 
        while(current != null){
            if(current.data == x){
                return i;
            }
            current = current.next;
            i++;
        }
        return -1;
    }
    public LinkedList reverse(LinkedList original){
        Node current = original.head;
        LinkedList temp = new LinkedList();
        while(current != null){
            temp.addHead(current.data);
            current = current.next;
        }
        temp.deleteTail();
        return temp;
    }
    public int calcTotal(){
        int total = 0;
        Node current = head;
        if(head != null){
            while(current != null){
                total+= current.data;
                current = current.next;
            }
        }
        else{
            System.out.println("NullPointerExceptionThrown! - NO numbers to add");
        }
        return total;
    }
    public void oddGame(){
        Scanner input = new Scanner(System.in);
        int total = 0;
        while(total < 100){
            System.out.println("Enter a number");
            int choice = input.nextInt();
            Node c = new Node(choice);
            if(c.data%2 != 0 && c.data%5 != 0){
                addTail(c.data);
                total += c.data;
                show();
            }
            else if(c.data%2 != 0 && c.data%5 == 0){
                int temp = (2*c.data);
                addHead(temp);
                total += temp;
                show();
            }
            else if(c.data%2 == 0 && c.data%5 != 0){
                Node current = head;
                while(current.next!=null){
                    current = current.next;
                }
                deleteTail();
                total-=current.data;
                show();
            }
            else if(c.data%2 ==0 && c.data%5 ==0){
                Node current = head;
                deleteHead();
                total-=current.data;
                show();
            }
        }
        System.out.println(calcTotal());
    }
}