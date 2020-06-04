package com.err.covidtracker;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_one extends Fragment {

TextView one,two,three,four,five,six,seven,eigth,nine,threee,twoo;
    public Fragment_one() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragment_one, container, false);

        one=(TextView)view.findViewById(R.id.one);
        two=(TextView)view.findViewById(R.id.two);
        three=(TextView)view.findViewById(R.id.three);
          four=(TextView)view.findViewById(R.id.four);
            five=(TextView)view.findViewById(R.id.five);
             six =(TextView)view.findViewById(R.id.six);
                seven=(TextView)view.findViewById(R.id.seven);
                 eigth =(TextView)view.findViewById(R.id.eigth);
                    nine=(TextView)view.findViewById(R.id.nine);

                    threee=(TextView)view.findViewById(R.id.threee);
        twoo=(TextView)view.findViewById(R.id.twoo);




        RequestQueue queue = Volley.newRequestQueue(getContext());

       // String url = "https://api.covid19api.com/summary";



        String url = "https://disease.sh/v2/all";
        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {
                        // display response


                        try {


                            one.setText(response.getString("cases"));
                            two.setText(response.getString("deaths"));
                            twoo.setText(response.getString("recovered"));
                            three.setText(response.getString("active"));
                            four.setText(response.getString("todayCases"));
                            five.setText(response.getString("todayDeaths"));
                            six.setText(response.getString("casesPerOneMillion"));
                            seven.setText(response.getString("testsPerOneMillion"));
                            eigth.setText(response.getString("deathsPerOneMillion"));
                            nine.setText(response.getString("affectedCountries"));
                            threee.setText(response.getString("critical"));


                        } catch (JSONException e) {
                            Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
                        }




//                        try {
//                            JSONArray contacts = response.getJSONArray("Countries");
//                            try {
//                                Toast.makeText(getContext(), "hello"+contacts.getString(0), Toast.LENGTH_SHORT).show();
//                            } catch (JSONException e) {
//                                Toast.makeText(getContext(), "error", Toast.LENGTH_SHORT).show();
//                            }
//                            for (int i = 0; i < contacts.length(); i++) {
//
//                                JSONObject data=contacts.getJSONObject(i);
//                                one.setText(data.getString("NewConfirmed"));
//                            }
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "error"+error.toString(), Toast.LENGTH_SHORT).show();

                        one.setText(error.toString());
                    }
                }
        );

// add it to the RequestQueue
        queue.add(getRequest);

        return  view;
    }

}
