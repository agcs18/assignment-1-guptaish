import com.sun.javaws.IconUtil;

import java.util.*;
class Student
{
     String fname;
     String lname;
     String phone;
     String email;

    public Student(String fname, String lname, String phone, String email) {
        this.fname = fname;
        this.lname = lname;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return ("-------- * -------- * -------- * --------"+"\n"+
                "First name :- "+ fname + "\n" +"Last name :- "+ lname + "\n" + "phone number :- "+ phone + "\n" + "email id :- "+ email);
    }
    public String disp()
    {
        return fname + " " + lname;
    }
}
class Node1
{
    Object data;
    Node1 next;

    public Node1(Object data) {
        this.data = data;
        this.next = null;
    }
}
class LinkList
{

    Node1 head=null;
    Node1 tail=null;

    public void add(Object data)
    {
        Node1 new_node=new Node1(data);
        if(head==null)
        {
            head=new_node;
            tail=new_node;
        }
        else
        {
            tail.next=new_node;
            tail=new_node;
        }


    }
    public void show()
    {

        Node1 current=head;
        if(current==null)
        {
            System.out.println("Empty List");
        }
        else {
            while (current != null) {
                System.out.println(current.data);
                current=current.next;
            }
            System.out.println();

        }
    }


    public void delete(int data)
    {
        Node1 temp,current;
        current=head;
        if(current==null)
        {
            System.out.println("List is Empty");
        }
        else
        {
            int count=data;
            if(head!=tail)
            {
                temp=head;
                current=null;

                for(int i=0;i<count;i++)
                {
                    current=temp;
                    temp=temp.next;
                }
                if(current!=null)
                {
                    current.next=temp.next;
                    temp=null;
                }
                else {
                    head = current = temp.next;

                    temp = null;
                }

            }
        }

    }

}
public class Demo {
    public static void main(String[] args) {

        LinkList n2 = new LinkList();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag == true) {
            System.out.println("Welcome to AG's Contact List App");
            System.out.println("Press 1 to add a new contact");
            System.out.println("Press 2 to view all contacts");
            System.out.println("Press 3 to delete a contact");
            System.out.println("Press 4 to exit program");
            System.out.println();
            int n = sc.nextInt();
            sc.nextLine();
            switch (n) {
                case 1:
                    System.out.print("Enter Fname : ");
                    String fname = sc.nextLine();
                    System.out.print("Enter Lname : ");
                    String lname = sc.nextLine();
                    System.out.print("Enter phone : ");
                    String p=" , ";
                    String phone = sc.nextLine();
                    boolean flag1=true;
                    while(flag1==true) {
                        System.out.print("Do you want to add another phone number (y/n) ");
                        String choice = sc.nextLine();
                        if (choice.equals("y")) {
                            String ano = sc.nextLine();
                            phone = phone + p + ano;
                        }
                        else
                        {
                            flag1=false;
                        }
                    }
                    System.out.print("Enter email : ");
                    String em=" , ";
                    String email = sc.nextLine();
                    boolean flag3=true;
                    while(flag3==true) {
                        System.out.print("Do you want to add another email (y/n) ");
                        String choice2 = sc.nextLine();
                        if (choice2.equals("y")) {
                            String ano = sc.nextLine();
                            email = email + em + ano;
                        }
                        else
                        {
                            flag3=false;
                        }
                    }
                    Student obj = new Student(fname, lname, phone,email);
                    n2.add(obj);
                    break;

                case 2:
                    n2.show();
                    break;
                case 4:
                    flag=false;
                    System.out.println(" BYE FOR NOW ");
                    break;
                case 3:
                    System.out.println("Which one to delete (1-n) ");
                    n2.show();
                    int number=sc.nextInt();
                    n2.delete(number);
                    n2.show();
                default:
                    System.out.println("bye");
                    break;

            }

        }
    }
}
