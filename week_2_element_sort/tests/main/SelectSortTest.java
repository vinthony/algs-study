package main;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SelectSortTest {
    private String[] a = null;
    private String[] b =  null;
    @Before
    public void importArray() throws Exception{
        String encodeing = "UTF-8";
        String allStr=null;
        String lineStr;
        File file = new File("/Users/nantu/test.md");
        InputStreamReader read = new InputStreamReader(new FileInputStream(file),encodeing);
        BufferedReader bufferedReader = new BufferedReader(read);
        while((lineStr = bufferedReader.readLine())!=null) {
            allStr += lineStr;
        }
        a = allStr.split(".");
        b = new String[]{"3", "4", "1", "5", "0"};
    }
    @Test
    public void testSelectSort() throws Exception{
       System.out.println(Arrays.toString(SelectSort.sort(b)));
        System.out.println(Arrays.toString(InsertSort.sort(b)));
    }
    @Test
    public void testoldSelect() throws Exception{
        Arrays.toString(SelectSort.sort_my(a));
    }
}