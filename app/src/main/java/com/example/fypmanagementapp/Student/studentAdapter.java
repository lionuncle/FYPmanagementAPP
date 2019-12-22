package com.example.fypmanagementapp.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fypmanagementapp.Models.Advisor;
import com.example.fypmanagementapp.Models.Student;
import com.example.fypmanagementapp.R;

import java.util.LinkedList;

public class studentAdapter extends BaseAdapter {
    private Context context;
    private LinkedList<Student> showList = new LinkedList<>();

    public studentAdapter(Context context, LinkedList<Student> mList) {
        this.context = context;
        this.showList = mList;
    }
    @Override
    public int getCount() {
        return showList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false);
        TextView name = v.findViewById(R.id.advisorNameListViewITEM);
        name.setText(showList.get(position).getName());

        return v;
    }
}