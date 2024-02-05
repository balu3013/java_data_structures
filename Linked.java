// import java.time.format.SignStyle;

interface List<T>{
    public boolean isEmpty();
    public void removeFirstOne();
    public void addLast(T data);
    public void display();
    public int size();
    public String isPresent(T data);
    public void remove();
    public void addFirst(T data);
}
public class Linked{
    public static void main(String[] args) {
        SingleLinked<Integer> obj = new SingleLinked<>();
        SingleLinked<Character> charObj = new SingleLinked<>();

        for(int i=1;i<=10;i++){
            obj.addLast(i);
            charObj.addLast((char)i);
        }
        obj.display();
        System.out.println(obj.size());
        obj.remove();
        obj.display();
        System.out.println(obj.isEmpty());
        System.out.println(obj.size());
        System.out.println("---------------------------------");
        charObj.display();
        System.out.println("----------------------");
        charObj.removeFirstOne();
        System.out.println("------------------------");
        charObj.display();
    }
}

class SingleLinked<T> implements List<T>{
    static class Node<T>{
        T data;
        Node<T> next;
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }

    Node<T> head = null,tail = null;

    @Override
    public void addLast(T data){
        Node<T> newNode = new Node<T>(data);
        if(head == null){
            head = tail = newNode;
            tail.next = null;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public void addFirst(T data){
        Node<T> newNode = new Node<T>(data);
        if(head == null){
            head = tail = newNode;
            tail.next = null;
        }else{
            newNode.next = head;
            head = newNode;
        }
    }

    @Override
    public void remove(){
        if(head != null){
            Node<T> temp = head;
            while(temp.next.next != null){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    @Override
    public void display(){
        if(head == null) return;
        Node<T> temp = head;
        while(temp != null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public String isPresent(T data){
        Node<T> temp = head;
        if(head ==null) return "List is empty";
        while(temp != null){
            if(temp.data == data){
                return "Data found successfully";
            }
        }
        return "No data found";
    }

    @Override
    public int size(){
        int length =0;
        if(head ==null) return length;
        Node<T> temp = head;
        while(temp != null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    @Override
    public void removeFirstOne(){
        if(head == null) return;
        Node<T> temp = head.next;
        head.next = null;
        head = temp;
    }

    @Override
    public boolean isEmpty(){
        return head == null;
    }
}
