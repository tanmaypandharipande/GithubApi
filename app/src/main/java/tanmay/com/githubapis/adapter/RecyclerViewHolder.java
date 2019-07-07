package tanmay.com.githubapis.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import tanmay.com.githubapis.R;
import tanmay.com.githubapis.contract.UserContract;

/**
 * Created by tanmay on 07/07/19.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder implements UserContract.RowView {

    TextView textView_id, textView_login;
    ImageView imageView_avatar;
    View itemView;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        textView_id = itemView.findViewById(R.id.textView_id);
        textView_login = itemView.findViewById(R.id.textView_login);
        imageView_avatar = itemView.findViewById(R.id.imageView);
    }

    @Override
    public void setId(String id) {
        textView_id.setText(id);
    }

    @Override
    public void setName(String name) {
        textView_login.setText(name);
    }

    @Override
    public void setImage(Context context, String url) {
        Glide.with(context).load(url).apply(RequestOptions.circleCropTransform()).into(imageView_avatar);
    }
}
