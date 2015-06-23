package jvocab.jixa.com.jvocab.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import io.realm.RealmBaseAdapter;
import io.realm.RealmResults;
import jvocab.jixa.com.jvocab.Model.Collection;
import jvocab.jixa.com.jvocab.R;

public class CollectionListAdapter extends RealmBaseAdapter<Collection> implements ListAdapter {
    public static String TAG = "*****"+CollectionListAdapter.class.getName();
    public static final int RESOURCE = R.layout.collection_grid_item;
    
    private class ViewHolder {
        TextView title;
        ViewHolder(View convertView){
            title = (TextView) convertView.findViewById(R.id.collection_gird_item_title);
        }
        public void setData(int position){
            title.setText(realmResults.get(position).getName());
        }
    }

    public CollectionListAdapter(Context context,
                                 RealmResults<Collection> realmResults,
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
        Log.d(TAG,"get view" + position);
        viewHolder.setData(position);
        return convertView;
    }

    public void setData(RealmResults<Collection> data){
        realmResults = data;
        notifyDataSetChanged();
    }

    public RealmResults<Collection> getRealmResults() {
        return realmResults;
    }
}