package jvm.OOM;

import java.util.ArrayList;
import java.util.List;

public class HeapOOm {

    static class OOMObejct{

    }
    public static void main(String[] args){
        List<OOMObejct> list = new ArrayList<>();
        while (true){
            list.add(new OOMObejct());
        }
    }
}
