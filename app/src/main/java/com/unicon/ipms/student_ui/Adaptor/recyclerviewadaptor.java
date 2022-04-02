package com.unicon.ipms.student_ui.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.unicon.ipms.R;

import java.util.ArrayList;

public class recyclerviewadaptor extends RecyclerView.Adapter<recyclerviewadaptor.holder> {

    ArrayList<String> arr;

    public recyclerviewadaptor(ArrayList<String> data) {
        this.arr = data;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflator=LayoutInflater.from(parent.getContext());
        View view=inflator.inflate(R.layout.student_company_list,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        String title=arr.get(position);
        holder.tv.setText(title);

    }

    @Override
    public int getItemCount() {
        return arr.size();
    }


    class holder extends RecyclerView.ViewHolder
    {
        private TextView tv;
        public holder(@NonNull View itemView) {
            super(itemView);
            tv=(TextView) itemView.findViewById(R.id.Name_TV);
        }
        public TextView getView(){
            return tv;
        }
    }

}
