package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.utylo.apply.EthConversion;
import com.example.utylo.apply.R;

import java.util.ArrayList;

import pojo.ETH;

/**
 * Created by UTYLO on 11/3/2017.
 */

public class EthAdapter extends RecyclerView.Adapter<EthAdapter.AdapterViewHolder> {

    ArrayList<ETH> ethArrayList;

    public EthAdapter(ArrayList<ETH> btcArrayList) {
        this.ethArrayList = btcArrayList;
    }

    @Override
    public AdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layoutlist, parent, false);
        return new AdapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(AdapterViewHolder holder, int position) {
        ETH eth = ethArrayList.get(position);
        holder.mName.setText(eth.getName());
        holder.mRate.setText(eth.getRate());
        holder.mImage.setImageResource(eth.getImage());

    }

    @Override
    public int getItemCount() {
        return ethArrayList.size();
    }

class AdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    TextView mName, mRate;
    ImageView mImage;

    public AdapterViewHolder(View itemView) {
        super(itemView);
        mName = (TextView) itemView.findViewById(R.id.currency_symbol);
        mRate = (TextView) itemView.findViewById(R.id.currency_price);
        mImage = (ImageView) itemView.findViewById(R.id.image_poster);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, EthConversion.class);
        ETH eth = ethArrayList.get(getLayoutPosition());
        intent.putExtra("data", eth);
        context.startActivity(intent);
    }
}
}
