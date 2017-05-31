package studentlibrary.ctz.com.studentlibrary_new.Adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import studentlibrary.ctz.com.studentlibrary_new.R;

/**
 * Created by ZEESHAN on 22-03-2017.
 */

public class List_Adapter extends BaseAdapter{
    String temp,pdf_type;
    String name_temp;
    int sr_no;
    int type,size;

    ArrayList<DTO> list=new ArrayList<>();
    Activity ctx;

    public List_Adapter(ArrayList<DTO> arr,Activity context)
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
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        temp= String.valueOf(position+1);
        final viewHolder holder;
        if(convertView==null){
            convertView=ctx.getLayoutInflater().inflate(R.layout.layout_fragment,null);
            holder = new viewHolder();
            holder.pdf_name=(TextView)convertView.findViewById(R.id.tv_name);
            holder.img_doc=(ImageView)convertView.findViewById(R.id.img_doc);
            holder.ll_main=(LinearLayout)convertView.findViewById(R.id.ll_main_frag);
            holder.img_logo=(ImageView)convertView.findViewById(R.id.im_logo);

            convertView.setTag(holder);

        }
        else
        {
            holder=(viewHolder)convertView.getTag();
        }


//        holder.pdf_num.setText(temp);
        size=list.get(position).getPdf_name().length();
        pdf_type=list.get(position).getPdf_name().substring(size-4,size);
        if (pdf_type.compareTo(".pdf")==0)
        {
            holder.img_doc.setImageResource(R.drawable.ic_pdf);

        } else if(pdf_type.compareTo(".doc")==0){

            holder.img_doc.setImageResource(R.drawable.ic_doc);
        }else if(pdf_type.compareTo("docx")==0){

            holder.img_doc.setImageResource(R.drawable.ic_doc);
        }else if(pdf_type.compareTo(".ppt")==0){

            holder.img_doc.setImageResource(R.drawable.ic_ppt);
        }else if(pdf_type.compareTo("pptx")==0){

            holder.img_doc.setImageResource(R.drawable.ic_ppt);
        }



        holder.img_logo.setImageResource(R.drawable.arrow_right);
        holder.pdf_name.setText( (position+1) +". "+ list.get(position).getPdf_name().substring(0,size - 8).replace('_',' ').replaceFirst("E ","ESE_").replace('-',' '));


        return convertView;
    }

    public static class viewHolder
    {
        public TextView pdf_name,pdf_num;
        LinearLayout ll_main;
        ImageView img_logo,img_doc;
    }
}
