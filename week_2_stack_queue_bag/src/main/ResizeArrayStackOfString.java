package main;

/**
 * Created by nantu on 15/2/9.
 */
public class ResizeArrayStackOfString {
    private String[] s ;
    private int N = 0;
    public ResizeArrayStackOfString(){
        s = new String[1];
    }
    public void push(String str){
        if( N == s.length ) resize( s.length * 2 );
        s[N++] = str;
    }
    private void resize(int size){
        String[] s_temp = new String[size];
        for (int i = 0; i < N; i++) {
            s_temp[i] = s[i];
        }
        s = s_temp;
    }
    public String pop(){
        String item = s[--N];
        s[N] = null;
        if( N > 0 && s.length/4 == N ) resize( s.length / 2 );
        return item;
    }
}
