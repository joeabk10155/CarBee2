package joe.joeabk.carbee;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class CarDetailsActivity extends Activity {
    TextView head=(TextView)findViewById(R.id.head);
    ImageView car=(ImageView)findViewById(R.id.carimage);
    TextView spec1=(TextView)findViewById(R.id.spec1);
    TextView spec2=(TextView)findViewById(R.id.spec2);
    TextView spec3=(TextView)findViewById(R.id.spec3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        String url="http://10.0.3.2/";
        StringRequest stringRequest =new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
