package com.example.fypmanagementapp.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fypmanagementapp.Models.Advisor;
import com.example.fypmanagementapp.Models.Project;
import com.example.fypmanagementapp.Models.Student;
import com.example.fypmanagementapp.R;
import com.example.fypmanagementapp.Repository.Repository;

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

        TextView assign = v.findViewById(R.id.assignListViewITEM);

        try {
            if (Repository.getInstance().getStudentList().get(position).getProjectId() != null){
                Project p = new Project();
                String projectId = Repository.getInstance().getStudentList().get(position).getProjectId();
                for (int i=0; i< Repository.getInstance().getProjectList().size(); i++)
                    if (Repository.getInstance().getProjectList().get(i).getId().equals(projectId))
                        p = Repository.getInstance().getProjectList().get(i);
                assign.setText("Project: "+p.getTitle());
                assign.setVisibility(View.VISIBLE);
            }
            else {
                assign.setVisibility(View.VISIBLE);
                assign.setText("PROJECT NOT ASSIGNED");
            }
        } catch (Exception e) {
            Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show();
        }
        return v;
    }
}
