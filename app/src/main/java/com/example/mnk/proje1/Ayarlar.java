package com.example.mnk.proje1;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Ayarlar extends AppCompatActivity {


public String selectedThema="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ayarlar);

        final ActionBar actionbar = getSupportActionBar();

        Spinner spn_Tema =findViewById(R.id.spinner_Tema);
        final List<String> Renkler = new ArrayList<>();
        Renkler.add("Kırmızı");
        Renkler.add("Mavi");
        Renkler.add("Yeşil");
        Renkler.add("Siyah");
        SpinnerAdapter adapter=new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,Renkler);
        spn_Tema.setAdapter(adapter);

        spn_Tema.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        selectedThema="Kırmızı";
                        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#b61620")));
                        break;
                    case 1:
                        selectedThema="Mavi";
                        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1669b6")));
                        break;
                    case 2:
                        selectedThema="Yeşil";
                        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#33b616")));
                        break;
                    case 3:
                        selectedThema="Siyah";
                        actionbar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#000000")));
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public void Kaydet(View v)
    {

        EditText BaslatYazisi=findViewById(R.id.edit_AcilisEkrani);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor edit = pref.edit();
        edit.putString("selectedThema",selectedThema);
        edit.putString("AcilisEkrani",BaslatYazisi.getText().toString());
        edit.commit();
        Toast.makeText(Ayarlar.this, "Kaydedildi", Toast.LENGTH_SHORT).show();
    }
}
