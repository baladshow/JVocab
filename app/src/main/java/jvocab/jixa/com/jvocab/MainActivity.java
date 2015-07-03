package jvocab.jixa.com.jvocab;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import io.realm.Realm;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmBusHandler;
import jvocab.jixa.com.jvocab.Cache.DatabaseManager;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.View.CollectionListActivity;


public class MainActivity extends ActionBarActivity {

    DatabaseManager dbm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(null == dbm){
            dbm = DatabaseManager.getInstance();
        }
//        Realm realm = Realm.getInstance(this);
//        realm.beginTransaction();
//        Word word = realm.createObject(Word.class);
//        word.setText("first");
//        realm.commitTransaction();
//        RealmQuery<Word> query = realm.where(Word.class);
//        RealmResults<Word> results = query.findAll();
//        Log.d("DATABASEGET--MAIN", results.toString());
//        Log.d("DATABASEGET", String.valueOf(dbm.getWordById(1).getSynonyms()));

    }

//    public void onEvent(RealmResponse response){
//        RealmResults<Collection> results = response.getData();
//        Log.d("**********",results.get(0).getName());
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onStart() {
        super.onStart();
//        EventBus.getDefault().register(this);
        RealmBusHandler bh = RealmBusHandler.createInstance();
        Realm.deleteRealmFile(getApplicationContext());
        Realm realm = Realm.getInstance(this);
        realm.beginTransaction();
//        Word w = realm.createObject(Word.class);
//        w.setText("first word");
//        RealmList<Word> wList = new RealmList<>();
//        wList.add(w);
//            realm.where(Collection.class)
//                    .findFirst()
//                    .setWords(wList);
        Collection c1 = realm.createObject(Collection.class);
        c1.setId(1);
        Collection c2 = realm.createObject(Collection.class);
        c2.setId(2);
        c2.setName("second collection");
//        Collection c3 = realm.createObject(Collection.class);

        c1.setName("first collection");

//        c2.setName("second collection");
//        c3.setId(2);
//        c3.setName("third collection");
        realm.commitTransaction();
//        RealmRequest request = new RealmRequest(RealmRequest.COLLECTION_WORD_REQUEST,13,getApplicationContext());
//        EventBus.getDefault().post(request);
//        Word word = new Word();
//        word.setText("Testing Event bus");
//        EventBus.getDefault().post(word);
        startActivity(new Intent(getApplicationContext(), CollectionListActivity.class));
    }

    @Override
    public void onStop() {
//        EventBus.getDefault().unregister(this);
        super.onStop();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
