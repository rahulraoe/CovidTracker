package com.err.covidtracker;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_two extends Fragment {


    public Fragment_two() {
        // Required empty public constructor
    }

    TextView one;
    RecyclerView countries;

    private ArrayList<String> country= new ArrayList<>();
    private ArrayList<String> flag= new ArrayList<>();
    private ArrayList<String> cases= new ArrayList<>();
    private ArrayList<String>  deaths= new ArrayList<>();
    private ArrayList<String> recover= new ArrayList<>();
    private ArrayList<String> active= new ArrayList<>();
    private ArrayList<String>  critical= new ArrayList<>();

    private ArrayList<String> tcases= new ArrayList<>();
    private ArrayList<String> tdeaths= new ArrayList<>();

    private ArrayList<String> cpm= new ArrayList<>();
    private ArrayList<String> dpm= new ArrayList<>();
    private ArrayList<String> tpm= new ArrayList<>();
    private ArrayList<String> ddm= new ArrayList<>();
    private ArrayList<String> cont= new ArrayList<>();


   RecyclerAdapter recycler_adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment_two, container, false);
        RequestQueue queue = Volley.newRequestQueue(getContext());

        // String url = "https://api.covid19api.com/summary";

one=(TextView)v.findViewById(R.id.one);
countries=(RecyclerView)v.findViewById(R.id.coutries);

        countries.setLayoutManager(new LinearLayoutManager(getContext()));
       countries.setAdapter(recycler_adapter);
LoadData();
        return  v;
    }





    private void LoadData() {
        String url = "https://disease.sh/v2/countries";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (response != null) {

                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject data = jsonArray.getJSONObject(i);

                            // Extract JSONObject inside JSONObject


                            JSONObject count = data.getJSONObject("countryInfo");

                            country.add(data.getString("country"));
                            flag.add(count.getString("flag"));









                            cases.add(String.valueOf(data.getInt("cases")));
                            deaths.add(String.valueOf(data.get("deaths")));
                            active.add(String.valueOf(data.get("active")));
                            critical.add(String.valueOf(data.get("critical")));
                            recover.add(String.valueOf(data.get("recovered")));

                            tcases.add(String.valueOf(data.get("todayCases")));
                            tdeaths.add(String.valueOf(data.get("todayDeaths")));
                            cpm.add(String.valueOf(data.get("casesPerOneMillion")));
                            dpm.add(String.valueOf(data.get("deathsPerOneMillion")));
                            tpm.add(String.valueOf(data.get("testsPerOneMillion")));

                            ddm.add(String.valueOf(data.get("deathsPerOneMillion")));
                            cont.add(data.getString("continent"));

                        }

                        recycler_adapter=new RecyclerAdapter(country,flag,cases,deaths,active,critical,recover,tcases,tdeaths,cpm,dpm,tpm,cont,ddm);
                        countries.setAdapter(recycler_adapter);




                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        Volley.newRequestQueue(getActivity()).add(stringRequest);
    }



}
