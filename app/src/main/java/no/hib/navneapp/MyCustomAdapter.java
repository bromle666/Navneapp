package no.hib.navneapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Endre on 24-Mar-15.
 */
public class MyCustomAdapter extends ArrayAdapter<Drawable> {
    Activity activity;

    public MyCustomAdapter(Activity context, List<Drawable> drawables) {
        super(context, R.layout.list_image_layout, drawables);
        activity = context;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Drawable pic = getItem(position);
        LayoutInflater inflater = activity.getLayoutInflater();

        ImageView imageView = (ImageView) inflater.inflate(R.layout.list_image_layout, null, true);

        imageView.setImageDrawable(pic);

        return imageView;
    }
}






