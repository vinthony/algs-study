package main;

/**
 * Created by nantu on 15/2/23.
 */
public class Subset {
    public static void main(String[] args){
        //test client
        int sub = 3;
        String[] arr = {"a","b","c","d","e","f","g"};
        RandomizedQueue<String> r = new RandomizedQueue<String>();
        Deque d = new Deque<String>();
        for (int i = 0 ;i < arr.length;i++)
        {
            r.enqueue(arr[i]);

        }
        System.out.println(r.sample());
        System.out.println(r.sample());
        System.out.println(r.sample());
        System.out.println(r.sample());
        System.out.println(r.sample());
        System.out.println("--------------------");
        for (int j = 0 ;j<arr.length;j++){
            String m = r.dequeue();
            System.out.println(m);
            d.addLast(m);
        }
        System.out.println("--------------------");
        System.out.println(d.removeFirst());
        System.out.println(d.removeFirst());
        System.out.println(d.removeFirst());
        System.out.println(d.removeFirst());
        d.addFirst("X");
        System.out.println(d.removeLast());
        System.out.println(d.removeLast());

    }
}