package com.example.mnk.proje1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Text = findViewById(R.id.Text);
        SharedPreferences Gelenveri = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        Text.setText(Gelenveri.getString("AcilisEkrani","Bulunamadı"));

        final ActionBar actionbar = getSupportActionBar();

        switch (Gelenveri.getString("selectedThema",""))
        {
            case "Kırmızı":
                actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#b61620")));
                break;
            case "Mavi":
                actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1669b6")));
                break;
            case "Yeşil":
                actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33b616")));
                break;
            case "Siyah":
                actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
                break;
        }
    }

    public void Login(View v){
        EditText K_Adi = findViewById(R.id.Edt_K_Adi);
        EditText K_Sifre = findViewById(R.id.Edt_Sifre);
        CheckBox Hatirla = findViewById(R.id.CBox_BeniHatirla);

        if (K_Adi.getText().toString().equals("Tarikmnk") && K_Sifre.getText().toString().equals("123") )
        {
            if (Hatirla.isActivated())
            {
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor SharedEdit = pref.edit();
                SharedEdit.putString("Appusername",K_Adi.getText().toString());
                SharedEdit.putString("Appuserpassword",K_Sifre.getText().toString());
                SharedEdit.commit();
            }
            Intent i = new Intent(MainActivity.this,Ayarlar.class);
            startActivity(i);
        }

    }
}
