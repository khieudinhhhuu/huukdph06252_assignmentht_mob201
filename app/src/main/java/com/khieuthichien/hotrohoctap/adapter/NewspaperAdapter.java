package com.khieuthichien.hotrohoctap.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.khieuthichien.hotrohoctap.news.NewsActivity;
import com.khieuthichien.hotrohoctap.R;
import com.khieuthichien.hotrohoctap.model.Newspaper;

import java.util.List;

public class NewspaperAdapter extends RecyclerView.Adapter<NewspaperAdapter.NewspaperHolder> {

    private Context context;
    private List<Newspaper> newspapers;

    public NewspaperAdapter(Context context, List<Newspaper> newspapers) {
        this.context = context;
        this.newspapers = newspapers;
    }

    @NonNull
    @Override
    public NewspaperAdapter.NewspaperHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_newspaper, parent, false);
        return new NewspaperHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewspaperAdapter.NewspaperHolder holder, int position) {
        final Newspaper newspaper = newspapers.get(position);
        holder.tvTitle.setText(newspaper.name);

        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, NewsActivity.class);
                intent.putExtra("data",newspaper.rssLink);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        if (newspapers == null) return 0;
        return newspapers.size();
    }

    public class NewspaperHolder extends RecyclerView.ViewHolder {

        public final TextView tvTitle;

        public NewspaperHolder(View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);

        }
    }
}
