package com.example.miconexionimagenes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler;

    private RecyclerView.LayoutManager lManager;
    private List<Heroe> listItemsPlaces;
    private  String Listnames[];
    private String Listurl_images[];
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ClassConnection classConnection = new ClassConnection();
        try {
            String cadena = classConnection.execute("https://simplifiedcoding.net/demos/view-flipper/heroes.php").get();

            JSONObject ob = new JSONObject( cadena);
            JSONArray arrar = ob.getJSONArray("heroes");//usar el lenght de esta

    Heroe h = null;
           String chido ="";
            for (int i = 0; i < arrar.length(); i++)
            {
                try {
                    String url = arrar.getJSONObject(i).getString("imageurl");//habemus por objeto
                    Listurl_images[i]= url;
                    String nombre = arrar.getJSONObject(i).getString("name");//habemus por objeto
                    Listnames[i] = nombre;
                    chido = chido + "  " + url;
                    h.agregar( new Heroe(url, nombre));
                    listItemsPlaces.add(new Heroe(url, nombre));

                } catch (JSONException e) {
                    Log.e("Parser JSON", e.toString());
                }
            }
        recycler = (RecyclerView)findViewById(R.id.reci);
           recycler.setHasFixedSize(true);
           LinearLayoutManager llm = new LinearLayoutManager(context);
            recycler.setLayoutManager(llm);
            Toast.makeText(this,chido+"", Toast.LENGTH_LONG ).show();


          //  listItemsPlaces = new ArrayList<>();
            Adapter adapter = new Adapter(listItemsPlaces);
            recycler.setAdapter(adapter);





            // ArrayList Heroes = prepareData();
            //PlaceCardAdapter adapter = new PlaceCardAdapter(context, Heroes);
            // recycler.setAdapter(adapter);
            //JSONArray array = ob.getJSONArray("heroes");
       // String d = ob.getJSONObject("heroes").getString("imageurl");





//
               //


        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "No jalo", Toast.LENGTH_LONG).show();
        }
    }


    private void initViews(){





    }
    private ArrayList prepareData(){

        ArrayList android_version = new ArrayList<>();
        for(int i=0;i<Listnames.length;i++){
            Heroe androidVersion = new Heroe();
            androidVersion.setName(Listnames[i]);
            androidVersion.setImage_url(Listurl_images[i]);
            android_version.add(androidVersion);
        }
        return android_version;
    }
}
