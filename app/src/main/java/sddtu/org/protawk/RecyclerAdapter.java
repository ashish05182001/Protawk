package sddtu.org.protawk;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ASHISH KUMAR on 3/15/2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CardDataHolder> {

    private ArrayList<CardData> arrayList;

    public RecyclerAdapter(ArrayList<CardData> arrayList){
        this.arrayList=arrayList;
    }

    public class CardDataHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imgCon;
        public CardDataHolder(final View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.textView);
            imgCon = (ImageView) itemView.findViewById(R.id.img_con);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i= new Intent(v.getContext(),SearchList.class);
                    i.putExtra("ArrayChoose",getAdapterPosition());
                    itemView.getContext().startActivity(i);

                }
            });
        }
    }
    @Override
    public RecyclerAdapter.CardDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout,parent,false);
        CardDataHolder cardDataHolder=new CardDataHolder(view);
        return cardDataHolder;
    }
    @Override
    public void onBindViewHolder(RecyclerAdapter.CardDataHolder holder, int position) {
        holder.textView.setText(arrayList.get(position).getT1());
        holder.imgCon.setImageResource(arrayList.get(position).getImgRes());
    }
    @Override
    public int getItemCount() {
        return arrayList.size() ;
    }
}
