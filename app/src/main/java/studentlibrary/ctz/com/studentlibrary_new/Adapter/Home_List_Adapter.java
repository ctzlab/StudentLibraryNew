package studentlibrary.ctz.com.studentlibrary_new.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import studentlibrary.ctz.com.studentlibrary_new.R;



public class Home_List_Adapter extends BaseAdapter {

    ArrayList<HomeDTO> list=new ArrayList<>();
    Activity ctx;

   public Home_List_Adapter(ArrayList<HomeDTO> arr, Activity context)
    {
        list.addAll(arr);
        ctx=context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        final viewHolder holder;
        if(convertView==null){
            convertView=ctx.getLayoutInflater().inflate(R.layout.layout_fragment_home,null);
            holder = new viewHolder();
            holder.tile_name=(TextView)convertView.findViewById(R.id.tv_main_home_list);
            holder.ll_tile=(LinearLayout)convertView.findViewById(R.id.ll_main_home_list);
            convertView.setTag(holder);

        }
        else
        {
            holder=(viewHolder)convertView.getTag();
        }



        holder.tile_name.setText(list.get(position).getTile_name().trim());

        return convertView;
    }


    public static class viewHolder
    {
        public TextView tile_name;
        LinearLayout ll_tile;
    }
}

