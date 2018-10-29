package java_in_action.interfaces.adpater;

import java.util.Vector;

public class JapanHotel {
    public void socket(JapanInterface japanInterface){
        japanInterface.voltage();
    }

    public static void main(String[] args){
        JapanHotel hotel = new JapanHotel();
//        China china = new China();
//        hotel.socket(china);中国的接口不能在日本使用
        Adapter adapter = new Adapter(new China());//通过使用适配器后就可以在日本使用了
        hotel.socket(adapter);

    }
}
