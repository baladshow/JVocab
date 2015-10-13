package jvocab.jixa.com.jvocab.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import io.realm.Realm;
import jvocab.jixa.com.jvocab.Adapters.MainMenuAdapter;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmBusHandler;
import jvocab.jixa.com.jvocab.R;

public class MainMenuActivity extends Activity  implements AdapterView.OnItemClickListener{

    ListView listView;
    MainMenuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        RealmBusHandler bh = RealmBusHandler.createInstance();
        Realm realm = Realm.getInstance(this);
        listView = (ListView) findViewById(R.id.main_menu_list_view);
        adapter = new MainMenuAdapter(this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplicationContext(), MainPagesActivity.class);
        intent.putExtra("pageId", position);
//        Log.d("main menu activity postion page : ", Integer.toString(position));
        startActivity(intent);
    }
}