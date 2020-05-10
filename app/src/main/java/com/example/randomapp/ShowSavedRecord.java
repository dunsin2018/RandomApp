package com.example.randomapp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Map;

public class ShowSavedRecord extends AppCompatActivity {


    // test
    RecyclerView recylcerList;
    ArrayList<FireBaseRecordModel> list=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_saved_record);


        setUpViews();
        getRecords();
    }

    private void getRecords()
    {

        final ProgressDialog pb=new ProgressDialog(this);
        pb.setMessage("Getting Records..");
        pb.setCancelable(false);
        pb.show();



        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("Records")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        pb.dismiss();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult())
                            {
                                FireBaseRecordModel obj=new FireBaseRecordModel();
                                Map<String, Object> data = document.getData();
                                obj.setEquation(data.get("equation").toString());
                                obj.setTimeStamp(data.get("timeStamp").toString());
                                list.add(obj);
                            }

                            if(list.size()<1)
                            {
                                Toast.makeText(ShowSavedRecord.this,"No Record Found",Toast.LENGTH_SHORT).show();
                                return;
                            }

                            recylcerList.setAdapter(new recycleadapter(ShowSavedRecord.this,list));
                        }
                        else
                        {

                            Toast.makeText(ShowSavedRecord.this,"Failed To Get Records",Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }

    private void setUpViews()
    {



        recylcerList=findViewById(R.id.recylcerList);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(ShowSavedRecord.this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recylcerList.setLayoutManager(mLayoutManager);
        recylcerList.setItemAnimator(new DefaultItemAnimator());

    }
}
