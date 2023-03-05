package com.example.e_shop2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Cart extends AppCompatActivity {

    JSONObject new_obj;
    double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Spinner toText = findViewById(R.id.spinner);
        TextView before = findViewById(R.id.before);
        TextView after = findViewById(R.id.after);
        String[] dropDownList = {"USD","ALL","BTC","ERN","KMF","MVR","PEN","JPY","GBP","ZWL"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, dropDownList);
        toText.setAdapter(adapter);

        View back = findViewById(R.id.backToCategories);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Categories.class);
                startActivity(intent);
            }
        });

        //before.setText(Double.toString(MainActivity.getTotalPrice()));
        before.setText(String.format("%.2f", MainActivity.getTotalPrice()));

        try {
            URL url = new URL("http://data.fixer.io/api/latest?access_key=18cd72a6ac3b441cbc454875fc44f4bd");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responsecode = conn.getResponseCode();
            if (responsecode == 200) {
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inline = "";

                StringBuilder sb = new StringBuilder();
                while ((inline = br.readLine()) != null) {
                    sb.append(inline);
                }

                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(sb.toString());
                new_obj = (JSONObject) data_obj.get("rates");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Button button = findViewById(R.id.calculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                result = Double.parseDouble(before.getText().toString());
                result *= (double) new_obj.get(toText.getSelectedItem().toString());
                after.setText(String.format("%.2f", result));
            }
        });

    }
}