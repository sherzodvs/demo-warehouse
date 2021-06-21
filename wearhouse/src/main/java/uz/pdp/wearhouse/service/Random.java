package uz.pdp.wearhouse.service;

import lombok.Data;

@Data
public class Random {
    public static String random(String name){
       int d = (int)(Math.random()*10000);
       String natija = Integer.toString(d);

       while (natija.length()<4){
           natija = "0"+natija;
       }
       return name+natija;
    }


}
