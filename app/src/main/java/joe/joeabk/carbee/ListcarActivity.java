package joe.joeabk.carbee;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.ArraySet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.amigold.fundapter.BindDictionary;
import com.amigold.fundapter.FunDapter;
import com.amigold.fundapter.extractors.StringExtractor;
import com.amigold.fundapter.interfaces.DynamicImageLoader;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.kosalgeek.android.json.JsonConverter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListcarActivity extends Activity implements Response.Listener<String> {
    final String TAG=this.getClass().getSimpleName();
    ListView lvProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listcar);
        String url="http://10.0.3.2/test1.php";
        StringRequest stringRequest=new StringRequest(Request.Method.GET,url,this, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ListcarActivity.this, "Error ", Toast.LENGTH_SHORT).show();
            }
        });
        MySingleton .getInstance(getApplicationContext()).addToRequestQueue(stringRequest);
        lvProduct=(ListView)findViewById(R.id.lvProduct);

    }

    @Override
    public void onResponse(String response) {
        Log.d(TAG,response);
       ArrayList<Car> jsonObjects =new JsonConverter<Car>().toArrayList(response, Car.class);

        BindDictionary<Car> dictionary = new BindDictionary<>();
        dictionary.addStringField(R.id.tvText, new StringExtractor<Car>() {
            @Override
            public String getStringValue(Car car, int position) {
                return car.Name;
            }
        });
        dictionary.addDynamicImageField(R.id.ivImage, new StringExtractor<Car>() {
            @Override
            public String getStringValue(Car car, int position) {
                return car.imageurl;
            }
        }, new DynamicImageLoader() {
            @Override
            public void loadImage(String url, ImageView imageView) {
                Picasso.with(getApplicationContext()).load("http://10.0.3.2/"+ url).into(imageView);
            }
        });

        FunDapter<Car> adapter = new FunDapter<>(getApplicationContext(),jsonObjects ,R.layout.car_layout,dictionary);
        lvProduct.setAdapter(adapter);


    }
}
