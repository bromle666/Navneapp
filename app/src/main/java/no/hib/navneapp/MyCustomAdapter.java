package no.hib.navneapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import no.hib.navneapp.R;

public class MyCustomAdapter extends BaseAdapter {

    Context context;
    List<Drawable> drawableList;

    MyCustomAdapter(Context context, List<Drawable> drawableList) {
        this.context = context;
        this.drawableList = drawableList;
    }

    @Override
    public int getCount() {
        return drawableList.size();
    }

    @Override
    public Object getItem(int position) {
        return drawableList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return drawableList.indexOf(getItem(position));
    }



    private class ViewHolder {
        ImageView ivMenu;
        TextView tvMenuHeader;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.fragment_bildeliste, null);
            holder = new ViewHolder();

            holder.tvMenuHeader = (TextView) convertView.findViewById(R.id.tvMenuHeader);
            holder.ivMenu = (ImageView) convertView.findViewById(R.id.ivMenuItem);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Drawable row_pos = drawableList.get(position);





        return convertView;
    }

}