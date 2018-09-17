package com.washit.washit;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NotificationsCutomAdapter extends RecyclerView.Adapter<NotificationsCutomAdapter.MyViewHolder>{

    private Context context;
    private List<Notification> notificationList;

    public NotificationsCutomAdapter(Context context, List<Notification> notificationList) {
        this.context = context;
        this.notificationList = notificationList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewItem = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_list_item,parent, false);
        return new MyViewHolder(viewItem);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Notification notification = notificationList.get(position);

        holder.title.setText(notification.getTitle());
        holder.description.setText(notification.getDescription());
        holder.date.setText(notification.getTime().toString());

        switch (notification.getType()) {
            case INFORMATION:
                holder.image.setImageResource(R.drawable.ic_info);
                break;
            case OFFER:
                holder.image.setImageResource(R.drawable.ic_offer);
                break;

            case WARNING:
                holder.image.setImageResource(R.drawable.ic_warning);
                break;
        }

        switch (notification.getStatus()) {
            case Unseen:
                holder.notification_item.setCardBackgroundColor(Color.parseColor("#dedede"));
                break;
            case Seen:
                holder.notification_item.setCardBackgroundColor(Color.parseColor("#ffffff"));
                break;

        }

        holder.notification_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.notification_item.setCardBackgroundColor(Color.parseColor("#FFFFFF"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView title;
        TextView date;
        TextView description;
        CardView notification_item;

        public MyViewHolder(final View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.notification_image);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
            description = itemView.findViewById(R.id.description);
            notification_item = itemView.findViewById(R.id.notification_item);
        }
    }
}

