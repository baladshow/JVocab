package jvocab.jixa.com.jvocab.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.amulyakhare.textdrawable.TextDrawable;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Model.Exam;
import jvocab.jixa.com.jvocab.Model.Word;
import jvocab.jixa.com.jvocab.R;

/**
 * Created by root on 9/15/15.
 */
public class WordListAdapter extends RealmBaseAdapter<Word> {
    public static String TAG = "*****"+ExamListAdapter.class.getName();
    public static final int RESOURCE = R.layout.word_list_item;

    private class ViewHolder {
        TextView title;

        ViewHolder(View convertView){
            title = (TextView) convertView.findViewById(R.id.word_list_item_title);
        }
        public void setData(int position){
            title.setText(realmResults.get(position).getText());
        }
    }

    public WordListAdapter(Context context,
                           RealmResults<Word> realmResults,
                           boolean automaticUpdate) {
        super(context, realmResults, automaticUpdate);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(RESOURCE,   parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Log.d(TAG, "get view" + position);
        viewHolder.setData(position);
        return convertView;
    }

    public void setData(RealmResults<Word> data){
        realmResults = data;
        notifyDataSetChanged();
    }

    public RealmResults<Word> getData() {
        return realmResults;
    }
}