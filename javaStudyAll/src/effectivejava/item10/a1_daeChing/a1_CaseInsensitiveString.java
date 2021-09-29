package effectivejava.item10.a1_daeChing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * 추이성
 */
public final class a1_CaseInsensitiveString {

    private final String s;

    public a1_CaseInsensitiveString(String s){
        this.s = Objects.requireNonNull(s);
    }


    @Override public boolean equals(Object o){
        if(o instanceof a1_CaseInsensitiveString)
            return s.equalsIgnoreCase(
                    ((a1_CaseInsensitiveString)o).s);

        if(o instanceof String) //한 방향으로만 작동한다
            return s.equalsIgnoreCase((String) o);
        return false;
    }

    public static void main(String[] args) {
        a1_CaseInsensitiveString cis = new a1_CaseInsensitiveString("Polish");
        String s = "Polish";

//        System.out.println(cis.s);
//        System.out.println(s);
        if(cis.equals(s)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        System.out.println("=====================");

        if(s.equals(cis)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        /*
            CaseInsensitiveString의 equals는 일반 String 를 알고있지만,
            String의 equals 는 CaseInsensitiveString 의 존재를 모른다.
            cis.equals(s) => true
            s.equals(cis) => false
            대칭성(symmetry)에 위배된다.
         */

        //==========================================================================
        //리스트
        List<a1_CaseInsensitiveString> list = new ArrayList<>();
        list.add(cis);
        System.out.println("lsit의 String값");
//        System.out.println(list.get(0).s);
        System.out.println(list.contains(s)); // => list 내에 포함된 equals의 "객체"를 이용해 비교를한다.
        // List에 있는 값들과 String문자열s 라는 문자열과 같은지를 "String 클래스의 equals()" 메소드를 이용하여 판단하므로 false를 출력함.



    }//end of main

}//end of class
