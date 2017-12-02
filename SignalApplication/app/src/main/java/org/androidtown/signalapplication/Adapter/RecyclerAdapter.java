package org.androidtown.signalapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.androidtown.signalapplication.CircleImageView;
import org.androidtown.signalapplication.DataSetting.CardItem;
import org.androidtown.signalapplication.R;
import org.androidtown.signalapplication.Server.Models.Meeting;
import org.androidtown.signalapplication.Server.Models.User;

import java.util.List;

import io.realm.RealmList;
import io.realm.RealmResults;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private RealmResults<Meeting> mDataset;
    int item_layout;

    public RecyclerAdapter(RealmResults<Meeting> mDataset, int item_layout) {
        this.mDataset = mDataset;
        this.item_layout = item_layout;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.meeting_card, parent, false);
        return new ViewHolder(v);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)

    // 정보 및 이벤트 처리
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        RealmList<User> publisher = mDataset.get(position).getPublisher();
        User publisherItem = publisher.get(position);


        // 입력받은 내용 담기
        holder.image.setImageURI(Uri.parse(publisherItem.getProfilePhoto()));
        holder.userName.setText(publisherItem.getUsername());
        holder.userTitle.setText(publisherItem.getJob());
        holder.meetingTitle.setText(mDataset.get(position).getTitle());
        holder.meetingContents.setText(mDataset.get(position).getContent());

        // 프로필 터치하면 퍼블리셔 페이지로 이동
        holder.rl_publisher.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(context, PublisherPageActivity.class);
                //퍼블리셔 정보도 함께 넘어가도록 할 것
                //i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //context.startActivity(i);
            }
        });

        // 내용 터치하면 세부 내용 페이지로 이동
        holder.rl_publishedMeeting.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Intent i = new Intent(context, DetailActivity.class);
                // 데이터 정리 후 받아서 넘길 수 있도록
                //i.putExtra("writer", noticeList.get(pos).writer);
                //i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                //context.startActivity(i);
            }
        });

        // 버튼 누르면 카드 지우기
        // 이후 swipe to dismiss 추가하기
        holder.deleteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //items.remove(items.indexOf(this));
            }
        });



    }

    @Override
    public int getItemCount() {
        return this.mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image;
        TextView userName;
        TextView userTitle;

        RelativeLayout rl_publisher;

        ImageButton deleteButton;

        TextView meetingTitle;
        TextView meetingContents;

        RelativeLayout rl_publishedMeeting;

        //ImageView additional_image;

        CardView cardview;
        //RelativeLayout rl_image;

        // 담은 내용을을 반영할 아이디와 연결하기
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        public ViewHolder(View itemView) {
            super(itemView);
            image = (CircleImageView) itemView.findViewById(R.id.rec_pub_image);

            userName = (TextView) itemView.findViewById(R.id.userName);
            userTitle = (TextView) itemView.findViewById(R.id.userTitle);

            rl_publisher = (RelativeLayout) itemView.findViewById(R.id.rl_publisher);

            deleteButton = (ImageButton) itemView.findViewById(R.id.deleteButton);

            meetingTitle = (TextView) itemView.findViewById(R.id.meetingTitle);
            meetingContents = (TextView) itemView.findViewById(R.id.meetingContents);

            rl_publishedMeeting = (RelativeLayout) itemView.findViewById(R.id.rl_publishedMeeting);

            //additional_image = (ImageView) itemView.findViewById(R.id.additional_image);

            cardview = (CardView) itemView.findViewById(R.id.cardview);
            //rl_image = (RelativeLayout) itemView.findViewById(R.id.rl_image);
        }
    }

}
