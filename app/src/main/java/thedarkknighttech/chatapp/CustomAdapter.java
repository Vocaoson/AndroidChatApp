package thedarkknighttech.chatapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import thedarkknighttech.chatapp.Bean.Chat;
import thedarkknighttech.chatapp.Bean.Group;

public class CustomAdapter extends ArrayAdapter<Group> {
    private Context context;
    private int resource;
    private ArrayList<Group> groups;
    public CustomAdapter(Context context, int resource, ArrayList<Group> groups) {
        super(context, resource, groups);
        this.context = context;
        this.resource = resource;
        this.groups = groups;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Group group = getItem(position);
        View view = null;
        if(convertView == null) {
            LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(resource,parent,false);
            ImageView icon = view.findViewById(R.id.avarta);
           // icon.setImageResource(R.drawable.ic_launcher_background);
            //setImg(icon,chat.getImage());
            TextView groupName = view.findViewById(R.id.groupName);
            groupName.setText(group.getGroupName());
            TextView groupDesctiption = view.findViewById(R.id.groupDescription);
            groupDesctiption.setText(group.getGroupDescription());
        }
        if(view == null){
            return convertView;
        }
        return view;
    }
    private void setImg(ImageView img, String path){
        // load image
        try {
            // get input stream
            InputStream ims = context.getAssets().open(path);
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            img.setImageDrawable(d);
        }
        catch(IOException ex) {
            return;
        }
    }
}
