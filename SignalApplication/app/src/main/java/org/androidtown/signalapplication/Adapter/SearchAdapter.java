package org.androidtown.signalapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.androidtown.signalapplication.DataSetting.UserItemView;
import org.androidtown.signalapplication.R;
import org.androidtown.signalapplication.Server.Models.User;

import co.moonmonkeylabs.realmsearchview.RealmSearchAdapter;
import co.moonmonkeylabs.realmsearchview.RealmSearchViewHolder;
import io.realm.Realm;



public class SearchAdapter extends RealmSearchAdapter<User, SearchAdapter.ViewHolder> {

    public SearchAdapter(Context context, Realm realm, String filterColumnName) {
        super(context, realm, filterColumnName);
    }

    public class ViewHolder extends RealmSearchViewHolder {

        private UserItemView userItemView;

        public ViewHolder(FrameLayout container, TextView footerTextView) {
            super(container, footerTextView);
        }

        public ViewHolder(UserItemView userItemView) {
            super(userItemView);
            this.userItemView = userItemView;
        }
    }

    @Override
    public ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int viewType) {
        ViewHolder vh = new ViewHolder(new UserItemView(viewGroup.getContext()));
        return vh;
    }

    @Override
    public void onBindRealmViewHolder(ViewHolder viewHolder, int position) {
        final User user = realmResults.get(position);
        viewHolder.userItemView.bind(user);
    }

    @Override
    public ViewHolder onCreateFooterViewHolder(ViewGroup viewGroup) {
        View v = inflater.inflate(R.layout.footer_view, viewGroup, false);
        return new ViewHolder(
                (FrameLayout) v,
                (TextView) v.findViewById(R.id.footer_text_view));
    }

    @Override
    public void onBindFooterViewHolder(ViewHolder holder, int position) {
        super.onBindFooterViewHolder(holder, position);
        holder.itemView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                }
        );
    }
}

