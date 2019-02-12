package com.example.talaeeandroid;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.talaeeandroid.model.User;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.UserInfoViewHolder> {

    List<User> usersInfo;

    public UserInfoAdapter(List<User> usersInfo) {
        this.usersInfo = usersInfo;
    }

    @NonNull
    @Override
    public UserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_info_recyclerview_item, parent, false);
        UserInfoViewHolder viewHolder = new UserInfoViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserInfoViewHolder holder, int position) {

        User user = usersInfo.get(position);
        holder.tvUserInfoName.setText(user.getName());
        holder.tvUserInfoFamily.setText(user.getFamily());
        holder.tvUserInfoAge.setText("Age: ".concat(String.valueOf(user.getAge())));
        try {
            holder.imgCountry.setImageResource(R.drawable.class.getField(user.getCountry().toLowerCase()).getInt(null));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            holder.imgCountry.setImageResource(R.drawable.usa);
        }

    }

    @Override
    public int getItemCount() {
        return (usersInfo != null) ? usersInfo.size() : 0;
    }

    class UserInfoViewHolder extends RecyclerView.ViewHolder {

        TextView tvUserInfoName;
        TextView tvUserInfoFamily;
        ImageView imgCountry;
        TextView tvUserInfoAge;

        public UserInfoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUserInfoName = itemView.findViewById(R.id.tvUserInfoName);
            tvUserInfoFamily = itemView.findViewById(R.id.tvUserInfoFamily);
            imgCountry = itemView.findViewById(R.id.imgCountry);
            tvUserInfoAge = itemView.findViewById(R.id.tvUserInfoAge);
        }
    }
}
