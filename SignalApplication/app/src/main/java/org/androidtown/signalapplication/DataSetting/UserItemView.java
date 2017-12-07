package org.androidtown.signalapplication.DataSetting;

import android.content.Context;
import android.net.Uri;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidtown.signalapplication.CircleImageView;
import org.androidtown.signalapplication.R;
import org.androidtown.signalapplication.Server.Models.User;

import butterknife.BindView;
import butterknife.ButterKnife;


public class UserItemView extends RelativeLayout {

    @BindView(R.id.user_img)
            CircleImageView userImg;
    @BindView(R.id.user_fullname)
            TextView userFullName;
    @BindView(R.id.user_job)
            TextView userJob;

    public UserItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        inflate(context, R.layout.user_item_view, this);
        ButterKnife.bind(this);

    }

    public void bind(User user) {
        String userImgPath = user.getProfilePhoto();
        Uri uri = Uri.parse(userImgPath);
        userImg.setImageURI(uri);
        userFullName.setText(user.getUserFullName());
        userJob.setText(user.getJob());
    }
}
