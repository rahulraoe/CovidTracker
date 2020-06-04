package com.err.covidtracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Rahul Rao on 04-06-2020.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<String> country= new ArrayList<>();
    private ArrayList<String> flag= new ArrayList<>();
    private ArrayList<String> cases= new ArrayList<>();
    private ArrayList<String>  deaths= new ArrayList<>();
    private ArrayList<String> active= new ArrayList<>();
    private ArrayList<String>  critical= new ArrayList<>();


    private ArrayList<String> recover= new ArrayList<>();



    private ArrayList<String> tcases= new ArrayList<>();
    private ArrayList<String> tdeaths= new ArrayList<>();

    private ArrayList<String> cpm= new ArrayList<>();
    private ArrayList<String> dpm= new ArrayList<>();
    private ArrayList<String> tpm= new ArrayList<>();
    private ArrayList<String> ddm= new ArrayList<>();
    private ArrayList<String> cont= new ArrayList<>();
    Context con;

    public RecyclerAdapter(ArrayList<String> country, ArrayList<String> flag, ArrayList<String> cases, ArrayList<String> deaths, ArrayList<String> active, ArrayList<String> critical, ArrayList<String> recover, ArrayList<String> tcases, ArrayList<String> tdeaths, ArrayList<String> cpm, ArrayList<String> dpm, ArrayList<String> tpm, ArrayList<String> cont, ArrayList<String> ddm) {
        this.country = country;
        this.flag = flag;
        this.cases = cases;
        this.deaths = deaths;
        this.active = active;
        this.critical = critical;
        this.recover = recover;
        this.tcases = tcases;
        this.tdeaths = tdeaths;
        this.cpm = cpm;
        this.dpm = dpm;
        this.tpm = tpm;
        this.ddm = ddm;
        this.cont = cont;
    }

    public RecyclerAdapter(ArrayList<String> country, ArrayList<String> flag, ArrayList<String> cases, ArrayList<String> deaths, ArrayList<String> active, ArrayList<String> critical, ArrayList<String> recover, ArrayList<String> tcases, ArrayList<String> tdeaths, ArrayList<String> cpm, ArrayList<String> dpm, ArrayList<String> tpm, ArrayList<String> cont) {
        this.country = country;
        this.flag = flag;
        this.cases = cases;
        this.deaths = deaths;
        this.active = active;
        this.critical = critical;
        this.recover = recover;
        this.tcases = tcases;
        this.tdeaths = tdeaths;
        this.cpm = cpm;
        this.dpm = dpm;
        this.tpm = tpm;
        this.cont = cont;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.items_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(con)
                .load(flag.get(position))
                .into(holder.img);
        holder.text.setText(country.get(position));

        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(con, View_Details_Activity.class);
                intent.putExtra("country",country.get(position));
                intent.putExtra("flag",flag.get(position));
                intent.putExtra("cases",cases.get(position));
                intent.putExtra("deaths",deaths.get(position));
                intent.putExtra("recover",recover.get(position));
                intent.putExtra("active",active.get(position));

                intent.putExtra("critical",critical.get(position));
                intent.putExtra("tcases",tcases.get(position));
                intent.putExtra("tdeaths",tdeaths.get(position));
                intent.putExtra("cpm",cpm.get(position));
                intent.putExtra("tpm",tpm.get(position));
                intent.putExtra("ddm",ddm.get(position));
                intent.putExtra("cont",cont.get(position));





                con.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return country.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView img;
        TextView text;
        CardView card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            con=itemView.getContext();
            img=(CircleImageView)itemView.findViewById(R.id.img);
            text=(TextView) itemView.findViewById(R.id.text);
            card=(CardView)itemView.findViewById(R.id.card);
        }
    }
}
