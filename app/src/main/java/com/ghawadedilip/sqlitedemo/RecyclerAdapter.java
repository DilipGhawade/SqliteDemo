package com.ghawadedilip.sqlitedemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Dilip on 03-Dec-17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

  List<DataModel> alluserList;

  public RecyclerAdapter(List<DataModel> alluserList) {
    this.alluserList=alluserList;
  }

  @Override
  public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View v = LayoutInflater.from(parent.getContext())
      .inflate(R.layout.item_list,parent,false);

    return new MyViewHolder(v);
  }

  @Override
  public void onBindViewHolder(MyViewHolder holder, int position) {
    holder.txtname.setText(alluserList.get(position).getName());
    holder.txtemail.setText(alluserList.get(position).getEmail());
    holder.txtpassword.setText(alluserList.get(position).getPassword());
    holder.txtaddress.setText(alluserList.get(position).getAddress());
    holder.txtmobno.setText(alluserList.get(position).getMobno());
    holder.txtcity.setText(alluserList.get(position).getCity());

  }

  @Override
  public int getItemCount() {
    return alluserList.size();
  }

  public class  MyViewHolder extends RecyclerView.ViewHolder
  {

    TextView txtname,txtemail,txtpassword,txtmobno,txtcity,txtaddress;

    public MyViewHolder(View itemView) {
      super(itemView);
      txtname = itemView.findViewById(R.id.txt_name);
      txtemail = itemView.findViewById(R.id.txt_email);
      txtaddress = itemView.findViewById(R.id.txt_address);
      txtmobno = itemView.findViewById(R.id.txt_mobno);
      txtcity = itemView.findViewById(R.id.txt_city);
      txtpassword = itemView.findViewById(R.id.txt_password);

    }
  }
}
