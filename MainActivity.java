package com.example.e_shop2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    private static Vector<View> cartList = new Vector<View>();

    private static String[] items = {"addSofa1", "addSofa2", "addSofa3", "addSofa4", "addSofa5", "addSofa6", "addSofa7", "addSofa8", "addSofa9", "addSofa10",
            "addChair1", "addChair2", "addChair3", "addChair4", "addChair5", "addChair6", "addChair7", "addChair8", "addChair9", "addChair10",
            "addTable1", "addTable2", "addTable3", "addTable4", "addTable5", "addTable6", "addTable7", "addTable8", "addTable9", "addTable10",
            "addLamp1", "addLamp2", "addLamp3", "addLamp4", "addLamp5", "addLamp6", "addLamp7", "addLamp8", "addLamp9", "addLamp10",
            "addCarpet1", "addCarpet2", "addCarpet3", "addCarpet4", "addCarpet5", "addCarpet6", "addCarpet7", "addCarpet8", "addCarpet9", "addCarpet10",
            "addVase1", "addVase2", "addVase3", "addVase4", "addVase5", "addVase6", "addVase7", "addVase8", "addVase9", "addVase10",
            "addCurtain1", "addCurtain2", "addCurtain3", "addCurtain4", "addCurtain5", "addCurtain6", "addCurtain7", "addCurtain8", "addCurtain9", "addCurtain10",};
    private static double[] prices = {300, 250, 425, 370, 150, 220, 520, 490, 310, 150,
            32, 15, 24, 60, 72, 50, 43, 50, 25, 120,
            52.5, 46, 32, 240, 110, 61, 130, 260, 130, 64,
            15, 22.5, 17.80, 27, 42.9, 33, 30, 45, 44, 34,
            160, 53, 67.5, 84, 92, 150, 104, 99.9, 130, 70,
            20, 27, 50, 45, 60, 40, 84, 25, 64, 55,
            50, 55, 60, 45, 40, 35, 34.5, 25, 30, 30};

    public static Vector<View> getCartList(){
        return cartList;
    }

    public static void setCartList(View item){
        cartList.add(item);
    }

    public static float getTotalPrice(){

        float price=0;

        for(int i=0; i<cartList.size(); i++){

            String id = cartList.get(i).getResources().getResourceName(cartList.get(i).getId());
            String id2="";
            int flag=0;

            for(int j=0; j<id.length(); j++){

                if(flag==1){
                    id2+=id.charAt(j);
                }
                if(id.charAt(j) == '/') {
                    flag=1;
                }
            }
            for(int j=0; j<items.length; j++){

                if(id2.equals(items[j])) {
                    price+=prices[j];
                    break;
                }
            }
        }
        return price;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Categories.class);
                startActivity(intent);
            }
        });
    }
}