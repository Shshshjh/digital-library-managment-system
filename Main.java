import java.util.*;
public class Main {
    public static void select()//FUNCTION OF SHOWING ALL OPTIONS WHICH LIBRARIAN CAN OPT
    {
        System.out.println("PRESS 1 : ADD A BOOK");
        System.out.println("PRESS 2 : VIEW ALL BOOKS");
        System.out.println("PRESS 3 : SEARCH BOOK BY ID");
        System.out.println("PRESS 4 : UPDATE BOOK DETAILS");
        System.out.println("PRESS 5 : DELETE BOOK RECORD");
        System.out.println("PRESS 6 : EXIT PROGRAM");
    }
    public static void addbook(HashMap<Integer,bookinfo> m)//FUNCTION TO ADD NEW BOOK
    {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter book id");//TAKE BOOK-ID AS INPUT
        int a=sc.nextInt();sc.nextLine();
        while(m.containsKey(a))//SEARCH WHETHER NEW INPUT BOOK-ID ALREADY EXISTS.
        {
            System.out.println("Sorry this id already exist Try with another id");//IF YES,IT WILL CONTINUE TO TAKE INPUT UNTIL UNIQUE ID TAKEN AS INPUT
            a=sc.nextInt();sc.nextLine();
        }
        System.out.println("Enter book title");//TAKE TITLE AS INPUT
        String b=sc.nextLine();
        System.out.println("Enter book author");//TAKE AUTHOR AS INPUT
        String c=sc.nextLine();
        System.out.println("Enter book genre");//TAKE GENRE AS INPUT
        String d=sc.nextLine();
        System.out.println("Enter book availability status");//TAKE AVAILABILITY AS INPUT
        Boolean e=sc.nextBoolean();sc.nextLine();

        bookinfo b1=new bookinfo(a,b,c,d,e);//PASSING VALUE TO A CONSTRUCTOR
        m.put(b1.getId(),b1);
        return;
    }
    public static void display(HashMap<Integer,bookinfo>m)//DISPLAY ALL BOOK RELATED PARAMETERS
    {
        if(m.size()==0)//CHECK WHETHER COLLECTION OF BOOK IS EMPTY
            System.out.println("currently no book inside library");//IF YES, IT WILL RESULTS OUTPUT "NO BOOK EXIST"
        else {                 //IF NO,
            for(Map.Entry<Integer,bookinfo>e:m.entrySet())//DISPLAYING ALL PARAMETERS RELATED TO BOOK
            {
                System.out.println("Book id : "+e.getKey());
                System.out.println("Book title : "+e.getValue().getTitle());
                System.out.println("Book author's name : "+e.getValue().getAuthor());
                System.out.println("Book genre : "+e.getValue().getGenre());
                System.out.println("Book status : "+e.getValue().getStatus());
            }
        }

        return;
    }
    public static void searchbyid(HashMap<Integer,bookinfo>m)// SEARCH BOOK BY ID
    {
        if(m.size()==0)//CHECK WHETHER COLLECTION OF BOOK IS EMPTY
            System.out.println("currently no book inside library");//IF YES , IT WILL RESULTS OUTPUT "NO BOOK EXIST"
        else {                         //IF NO,
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter book id you want to search : ");
            int a=sc.nextInt();sc.nextLine();
            if(!m.containsKey(a))//CHECK WHETHER INPUT BOOK-ID DOES NOT EXIST
            {
                System.out.println("No book exist with such id");//IF NO IT WILL SHOW "NO" AS OUTPUT
            }
            else {                 // ELSE SHOWING ALL BOOK RELATED PARAMETERS
                System.out.println(m.get(a).getId());
                System.out.println(m.get(a).getTitle());
                System.out.println(m.get(a).getAuthor());
                System.out.println(m.get(a).getGenre());
                System.out.println(m.get(a).getStatus());
                return;
            }
        }
    }
    public static void update(HashMap<Integer,bookinfo>m)// UPDATE BOOK INFORMATION
    {
        if(m.size()==0) //CHECK WHETHER COLLECTION OF BOOK IS EMPTY
            System.out.println("currently no book inside library");//IF NO IT WILL SHOW "NO BOOK EXIST" AS OUTPUT
        else {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter book id you want to updated : ");//TAKE ID INPUT LIBRARIAN WANT TO UPDATE
            int a=sc.nextInt();sc.nextLine();
            if(m.containsKey(a))
            {
                System.out.println("Enter updated title name");//UPDATING TITLE NAME OF BOOK
                String b=sc.nextLine();
                System.out.println("Enter updated author name");//UPDATING AUTHOR NAME OF BOOK
                String c=sc.nextLine();
                System.out.println("Enter updated availability status");//UPDATING AVAILABILITY STATUS OF BOOK
                Boolean d=sc.nextBoolean();
                m.get(a).setAuthor(c);
                m.get(a).setTitle(b);
                m.get(a).setStatus(d);
                return;
            }
            else
            {
                System.out.println("No book exist with such id"); // IF NO BOOK EXIST OF SUCH ID, IT WILL RESULTS OUTPUT AS NO
                return;
            }
        }
    }
    public static void delete(HashMap<Integer,bookinfo>m)//DELETE OF BOOK USING BOOK ID
    {
        Scanner sc=new Scanner(System.in);
        if(m.size()==0)//CHECK WHETHER COLLECTION OF BOOK IS EMPTY
        {
            System.out.println("currently no book inside library");
        }
        else {
            System.out.println("Enter book id you want to delete");
            int a=sc.nextInt();sc.nextLine();//TAKING INPUT ID LIBRARIAN WANT TO DELETE
            if(m.containsKey(a))//CHECK WHETHER INPUT BOOK-ID EXIST
            {
                m.remove(a);//IF YES, IT WILL REMOVE BOOK FROM COLLECTION
                return;
            }
            else
            {
                System.out.println("No book exist with such id");//IF NO,IT WILL RESULT OUTPUT AS "NO SUCH BOOK EXIST"
                return;
            }
        }

    }
    public static void main(String[] args) {
        System.out.println("Welcome to Digital Library System");
        HashMap<Integer,bookinfo>m=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        int n=0;
        while(n!=6)//LOOP WILL CONTINUE UNTIL VALUE DOESN'T MATCH THE EXIT VALUE i.e. 6
        {
            select();
            System.out.print("enter your choice : ");
            n=sc.nextInt();sc.nextLine();
            if(n==1)//1 FOR ADD A NEW BOOK
                addbook(m);
            else if(n==2)//2 FOR VIEW ALL BOOK
                display(m);
            else if (n==3)//3 FOR SEARCH BOOK BY IT'S ID
                searchbyid(m);
            else if (n==4)//4 FOR UPDATE BOOK BY IT'S ID
                update(m);
            else if (n==5)//5 FOR DELETE BOOK BY IT'S ID
                delete(m);
        }
        System.out.println("Thank you for visiting the library");
        return;
    }
}