package bppc.com.firebasetest.Data;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

import bppc.com.firebasetest.R;
import bppc.com.firebasetest.SecondActivity;

/**
 * Created by rishabh on 6/12/2016.
 */
public class PojoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View view;
    Context c;
    ArrayList<Pojo> category=new ArrayList<>();
    public PojoHolder(View itemView, Context c, ArrayList<Pojo> category ) {
        super(itemView);
        view = itemView;
        this.c = c;
        view.setOnClickListener(this);
        this.category=category;
    }

    public void setValue(String name)
    {
        TextView field = (TextView) view.findViewById(R.id.category);
        field.setText(name);
    }
    public void setUrl(String url)
    {
        ImageView img=(ImageView)view.findViewById(R.id.imgView);
        //url="http://".concat(url);
        System.out.println(url);
        Glide.with(c).load(url).override(250,250).fitCenter()
                .diskCacheStrategy( DiskCacheStrategy.SOURCE )
                .into(img);


    }


    @Override
    public void onClick(View v) {
        int position= getAdapterPosition();
        String s=  this.category.get(position).getValue();
        Intent intent=new Intent(c, SecondActivity.class);
        intent.putExtra("category",s);
        c.startActivity(intent);
    }


}