package jvocab.jixa.com.jvocab.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jvocab.jixa.com.jvocab.R;

public class MainMenuListAdapter extends BaseAdapter {
    static final int RESOURCE = R.layout.main_menu_list_row;
    static final int[] COLORS = {};
    static final int[] LABELS = {};
    static final int[] ICONS = {};
    static final int MENU_ITEM__COUNT = 5;
    Context context;

    public MainMenuListAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return MENU_ITEM__COUNT;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(RESOURCE, parent, false);
            ViewHolder viewHolder = new ViewHolder(convertView, position);
            convertView.setTag(viewHolder);
        } else {
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            viewHolder.setData(position);
        }
        return convertView;
    }

    class ViewHolder {
        TextView label;
        ImageView icon;
        RelativeLayout root;


        ViewHolder(View view, int position) {
            label = (TextView) view.findViewById(R.id.main_menu_row_label);
            icon = (ImageView) view.findViewById(R.id.main_menu_row_icon);
            root = (RelativeLayout) view.findViewById(R.id.main_menu_row_root);
            setData(position);
        }

        private void setData(int pos) {
            label.setText(LABELS[pos]);
            icon.setImageResource(ICONS[pos]);
            root.setBackgroundColor(COLORS[pos]);
        }
    }
    
}
