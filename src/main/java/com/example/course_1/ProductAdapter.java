package com.example.course_1;
import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder>{
    ArrayList<Person> mPersonList;
    LayoutInflater inflater;

    public ProductAdapter(Context context, ArrayList<Person> mPersonList){
        inflater = LayoutInflater.from(context);
        this.mPersonList = mPersonList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){     //view oluşturma
        View view = inflater.inflate(R.layout.cardview, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }
    @Override                                                                   //view içine bilgileri gönderiyoruz.
    public void onBindViewHolder(MyViewHolder holder, int position){
        Person selectedProdutct = mPersonList.get(position);
        holder.setData(selectedProdutct, position);
    }

    @Override
    public int getItemCount(){return mPersonList.size();}

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView pName, pDescribtion;
        ImageView pImage, deleteP;

        public MyViewHolder(View itemView) {
            super(itemView);
            pName = (TextView) itemView.findViewById(R.id.productName);
            pDescribtion = (TextView) itemView.findViewById(R.id.productDescription);
            pImage = (ImageView) itemView.findViewById(R.id.productImage);
            //deleteP = (ImageView) itemView.findViewById(R.id.deleteP);
            //deleteP.setOnClickListener(this);
        }


        public void setData(Person selectedPerson, int position) {
            this.pName.setText(selectedPerson.getPersonName());
            this.pDescribtion.setText(selectedPerson.getPassword());
            this.pImage.setImageResource(selectedPerson.getImageID());      //image eklenecek
        }

        @Override
        public void onClick(View v) {       //setOnClickListener için bunu koyuyoruz.!
        }
    }
}

