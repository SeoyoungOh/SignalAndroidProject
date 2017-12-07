package org.androidtown.signalapplication.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.androidtown.signalapplication.Adapter.SearchAdapter;
import org.androidtown.signalapplication.DataSetting.UserItemView;
import org.androidtown.signalapplication.R;
import org.androidtown.signalapplication.Server.Models.User;

import butterknife.BindView;
import co.moonmonkeylabs.realmsearchview.RealmSearchAdapter;
import co.moonmonkeylabs.realmsearchview.RealmSearchView;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class SearchActivity extends AppCompatActivity {

    private RealmSearchView realmSearchView;
    private SearchAdapter adapter;
    private Realm realm;

    Button addPublisher;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Realm.init(this);
        realmSearchView = (RealmSearchView) findViewById(R.id.search_view);

        RealmConfiguration realmConfiguration = new RealmConfiguration
                .Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);

        realm = Realm.getDefaultInstance();
        adapter = new SearchAdapter(this, realm, "userFullName");
        realmSearchView.setAdapter(adapter);

        addPublisher = (Button) findViewById(R.id.add_pub_button);
        addPublisher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, MakePersonActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (realm != null) {
            realm.close();
            realm = null;
        }
    }
}