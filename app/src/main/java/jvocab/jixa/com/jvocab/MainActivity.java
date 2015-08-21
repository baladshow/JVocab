package jvocab.jixa.com.jvocab;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import io.realm.Realm;
import jvocab.jixa.com.jvocab.BusHandler.Realm.RealmBusHandler;
import jvocab.jixa.com.jvocab.Cache.DatabaseManager;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.View.MainPagesActivity;


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
        Realm realm = Realm.getInstance(this);
//        EventBus.getDefault().post(request);
//        Word word = realm.where(Word.class).equalTo("id", 89).findFirst();
//        Log.d("Test Word -->", word.getText() + " " + word.getSynonyms() + " " + word.getAntonyms() + " " + word.getSentences()
//                + "  Conf -->" + word.getConfusing());
//        Collection collection =realm.where(Collection.class).equalTo("id",2).findFirst();
//        Log.d("Test Collection --> ", collection.getName() + " words " + collection.getWords().first().getText() + " last: " + collection.getWords().last().getText());
//
//        Exam exam = realm.where(Exam.class).equalTo("id", 1).findFirst();
//        Log.d("Exam --> " , exam.getName() + "  "  + exam.getCollections());

//        Log.d(TAG, dbr.getWord(76).getSynonyms().get(0).getText());
//        word.setText("Testing Event bus");
//        EventBus.getDefault().post(word);

//        startActivity(new Intent(getApplicationContext(), CollectionListFragment.class));

        startActivity(new Intent(getApplicationContext(), MainPagesActivity.class));
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
