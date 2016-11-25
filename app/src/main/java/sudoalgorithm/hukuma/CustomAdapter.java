package sudoalgorithm.hukuma;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by kunalmalhotra on 11/22/16.
 */

public class CustomAdapter extends BaseAdapter {

    private Context context;
    private List<RowItem> rowItems;

    public CustomAdapter(Context context, List<RowItem> items) {
        this.context = context;
        rowItems = items;
    }

    private class ViewHolder {
        ImageView imageView;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.row, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.imageViewRow);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        RowItem rowItem = (RowItem) getItem(position);


        holder.imageView.setImageResource(rowItem.getImgID());

        return convertView;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }

    /*private final Activity context;
    private final Integer[] imgid;

    public CustomAdapter(Activity context, Integer[] imgid) {
        super(context, R.layout.row);
        this.context = context;
        this.imgid = imgid;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.row, parent, false);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageViewRow);
        imageView.setImageResource(imgid[position]);
        return rowView;

    }*/

}
