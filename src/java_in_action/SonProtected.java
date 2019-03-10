package java_in_action;

import java_in_action.FatherProtected;
import middleware.A;

import java.util.ArrayList;

/**
 * @Author yuchunwei
 */
public class SonProtected extends FatherProtected {

    public static void main(String[] args) throws Exception {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SonProtected());
        ArrayList a = (ArrayList)arrayList.clone();
        System.out.println(arrayList.get(0));
        System.out.println(a.get(0));
        a.wait();
    }
}   
