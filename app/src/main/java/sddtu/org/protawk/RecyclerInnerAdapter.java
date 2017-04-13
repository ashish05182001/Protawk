package sddtu.org.protawk;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dell on 3/17/2017.
 */

public class RecyclerInnerAdapter extends RecyclerView.Adapter<RecyclerInnerAdapter.CardListHolder> {

    private ArrayList<CardList> arraylList;

    public RecyclerInnerAdapter(ArrayList<CardList> arrayList) {
        this.arraylList = arrayList;
    }

    public class CardListHolder extends RecyclerView.ViewHolder {

        TextView textViewinner;

        public CardListHolder(final View itemView) {
            super(itemView);
            textViewinner = (TextView) itemView.findViewById(R.id.textViewinner);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }

    @Override
    public RecyclerInnerAdapter.CardListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout2, parent, false);
        CardListHolder cardListHolder = new CardListHolder(view);
        return cardListHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerInnerAdapter.CardListHolder holder, int position) {
        holder.textViewinner.setText(arraylList.get(position).getT2());
    }

    @Override
    public int getItemCount() {
        return arraylList.size();
    }
}