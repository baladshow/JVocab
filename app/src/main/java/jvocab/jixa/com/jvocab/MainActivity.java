package jvocab.jixa.com.jvocab;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

<<<<<<< HEAD
import jvocab.jixa.com.jvocab.View.SplashScreenActivity;
=======
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
>>>>>>> Database
import jvocab.jixa.com.jvocab.Cache.DatabaseManager;
import jvocab.jixa.com.jvocab.Model.Word;


public class MainActivity extends ActionBarActivity {

<<<<<<< HEAD
    DatabaseManager dbmanager;
=======
    DatabaseManager dbm;

>>>>>>> Database
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        //startActivity(new Intent(this, SplashScreenActivity.class));
        dbmanager = DatabaseManager.getInstance();
        Word word = new Word("word1");
        dbmanager.putWord(word);

=======

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
>>>>>>> Database
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
