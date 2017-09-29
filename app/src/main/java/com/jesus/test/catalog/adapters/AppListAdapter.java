package com.jesus.test.catalog.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.jesus.test.catalog.R;
import com.jesus.test.catalog.activities.AppDetailActivity;
import com.jesus.test.catalog.activities.FeedActivity;
import com.jesus.test.catalog.activities.MainActivity;
import com.jesus.test.catalog.models.App;

import java.util.ArrayList;




/**
 * Created by jaas1 on 9/28/2017.
 */

public class AppListAdapter extends RecyclerView.Adapter<AppListAdapter.ViewHolder>{

    private ArrayList <App> dataset;
    private Context context;

    public AppListAdapter(Context context) {
        dataset =new ArrayList<>();
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.app_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final App myApp = dataset.get(position);
        holder.appName.setText((CharSequence) myApp.getImName().getLabel());

        Glide.with(context)
            .load(myApp.getImImage().get(2).getLabel())
                .centerCrop()
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.appImagePreview);

        holder.appImagePreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Gson gson = new Gson();
                String appString = gson.toJson(myApp);

                Intent intent = new Intent(context, AppDetailActivity.class);
                intent.putExtra("appString", appString);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addList(ArrayList<App> entry) {
        dataset.addAll(entry);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView appImagePreview;
        private TextView appName;

        public ViewHolder(View itemView) {
            super(itemView);

            appImagePreview = (ImageView) itemView.findViewById(R.id.app_image_preview);
            appName = (TextView) itemView.findViewById(R.id.app_name);


        }
    }
}
