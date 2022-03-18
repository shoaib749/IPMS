package com.unicon.ipms.student_ui.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unicon.ipms.R;

public class myinternAdaptor extends RecyclerView.Adapter<myinternAdaptor.holder> {

    String data[];
    String sd[], ed[];

    public myinternAdaptor(String[] data, String[] sd, String ed[]) {
        this.data = data;
        this.sd = sd;
        this.ed = ed;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View view = inflator.inflate(R.layout.student_my_internship_cardview, parent, false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        String title = data[position];
        String sd_1 = sd[position];
        String ed_1 = ed[position];
        holder.tv.setText(title);
        holder.sd.setText(sd_1);
        holder.ed.setText(ed_1);


    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    class holder extends RecyclerView.ViewHolder {
        private TextView tv, sd, ed;

        public holder(@NonNull View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.Company_Name_TV);
            sd = (TextView) itemView.findViewById(R.id.Start_Date_TV);
            ed = (TextView) itemView.findViewById(R.id.End_Date_TV);
        }

        public TextView getView() {
            return tv;
        }
    }

}
