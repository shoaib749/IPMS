package com.unicon.ipms.student_ui.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unicon.ipms.R;

public class yourplaceAdaptor extends RecyclerView.Adapter<yourplaceAdaptor.holder> {

    String data[];
    String sal[];

    public yourplaceAdaptor(String[] data,String[] sal) {
        this.data = data;
        this.sal=sal;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflator=LayoutInflater.from(parent.getContext());
        View view=inflator.inflate(R.layout.fragment_your_placements_student,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        String title=data[position];
        String salary=sal[position];
        holder.tv.setText(title);
        holder.salary_1.setText(salary);

    }

    @Override
    public int getItemCount() {
        return data.length;
    }


    class holder extends RecyclerView.ViewHolder
    {
        private TextView tv,salary_1;
        public holder(@NonNull View itemView) {
            super(itemView);
            tv=(TextView) itemView.findViewById(R.id.Company_Name_TV_Card);
            salary_1=(TextView) itemView.findViewById(R.id.salary_TV_card);
        }
        public TextView getView(){
            return tv;
        }
    }

}
