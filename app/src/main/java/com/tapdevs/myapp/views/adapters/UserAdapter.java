package com.tapdevs.myapp.views.adapters;

import android.app.Activity;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tapdevs.myapp.R;
import com.tapdevs.myapp.databinding.UserRowBinding;
import com.tapdevs.myapp.models.User;
import com.tapdevs.myapp.viewmodels.UserViewModel;
import com.tapdevs.myapp.views.activitys.MainActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.R.attr.country;

/**
 * Created by  Jan Shair on 08/02/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.BindingHolder> {

    private List<User> userArrayList;
    private MainActivity context;

    public UserAdapter(MainActivity context, List<User> androidList) {
        this.context=context;
        userArrayList = androidList;

    }

    public void setItems(List<User> posts) {
        userArrayList = posts;
        notifyDataSetChanged();
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        UserRowBinding commentBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.user_row,
                parent,
                false);
        return new BindingHolder(commentBinding);
    }

    @Override
    public void onBindViewHolder(BindingHolder holder, int position) {

        User user=userArrayList.get(position);
        UserRowBinding commentsHeaderBinding = (UserRowBinding) holder.binding;
        commentsHeaderBinding.setViewModel(new UserViewModel(context, user));
//        holder.mTvName.setText(user.getLogin());
//        holder.mTVURL.setText(user.getHtml_url());
//        Glide.with(context)
//                .load(user.getAvatar_url())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.mAvatar);
    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }

    public class BindingHolder extends RecyclerView.ViewHolder{

        private ViewDataBinding binding;

        public BindingHolder(UserRowBinding binding) {
            super(binding.containerItem);
            this.binding = binding;
        }

    }

}
