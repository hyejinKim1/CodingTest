package Programmers;

import java.util.*;

public class 전화번호목록 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for(int i=1; i<phone_book.length; i++){
            String before = phone_book[i-1];
            String current = phone_book[i];
            if(current.startsWith(before)){
                return false;
            }
        }
        return true;
    }
}