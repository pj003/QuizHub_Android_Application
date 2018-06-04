package com.example.katykarthik.quizhubnew;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.katykarthik.quizhubnew.Interface.ItemClickListener;
import com.example.katykarthik.quizhubnew.Model.Class;
import com.example.katykarthik.quizhubnew.ViewHolder.ClassViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;


public class ClassFragmentTeacher extends Fragment {

    View myFragment;

    RecyclerView listClass;
    RecyclerView.LayoutManager layoutManager;
    FirebaseRecyclerAdapter<Class, ClassViewHolder> adapter;

    FirebaseDatabase database;
    DatabaseReference categories;

    public static ClassFragment newInstance() {
        ClassFragment classFragment = new ClassFragment();
        return classFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();
        categories = database.getReference("Class");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_class, container, false);

        listClass = (RecyclerView) myFragment.findViewById(R.id.listClass);
        listClass.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(container.getContext());
        listClass.setLayoutManager(layoutManager);

        loadCategories();
        return myFragment;
    }

    private void loadCategories() {
        adapter = new FirebaseRecyclerAdapter<Class, ClassViewHolder>(
                Class.class,
                R.layout.class_layout,
                ClassViewHolder.class,
                categories
        ) {
            @Override
            protected void populateViewHolder(ClassViewHolder viewHolder, final Class model, int position) {
                viewHolder.class_name.setText(model.getName());
                Picasso.with(getActivity())
                        .load(model.getImage())
                        .into(viewHolder.class_image);

                viewHolder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position, boolean isLongClick) {
                        Toast.makeText(getActivity(), String.format("%s|%s",adapter.getRef(position).getKey(),model.getName()), Toast.LENGTH_SHORT).show();
//                        Intent startGame = new Intent(getActivity(), Start.class);
//                        Common.classId = adapter.getRef(position).getKey();
//
//                        startActivity(startGame);

                    }
                });
            }
        };
        adapter.notifyDataSetChanged();
        listClass.setAdapter(adapter);
    }
}
