package com.example.fypmanagementapp.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.fypmanagementapp.Models.Project;
import com.example.fypmanagementapp.R;

import java.util.LinkedList;

public class StudentSelectProjectList extends BaseAdapter {
    private Context context;
    private LinkedList<Project> showList = new LinkedList<>();

    public StudentSelectProjectList(Context context, LinkedList<Project> mList) {
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
        name.setText(showList.get(position).getTitle());

        return v;
    }
}
