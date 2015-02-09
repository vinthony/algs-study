package main;

/**
 * Created by nantu on 15/2/9.
 */
public class FixedStringOfStack {
    private String s[];
    private int N = 0;
    public FixedStringOfStack(int count){
        s = new String[count];
    }
    public boolean isEmpty(){
        return N == 0;/* s.length == 0*/
    }
    public void push(String str){
        s[N++] = str;
    }
    public String pop(){
//        return  s[--N];
        String item = s[--N];
        s[N] = null;
        return item;
    }
}
