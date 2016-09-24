package com.nkdroid.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView data_bank_code, data_bank_name;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data_bank_code = (TextView) findViewById(R.id.data_bank_code);
        data_bank_name = (TextView) findViewById(R.id.data_bank_name);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.horizontal_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<Bank> call = apiService.getBankDetails();
        call.enqueue(new Callback<Bank>() {
            @Override
            public void onResponse(Call<Bank> call, Response<Bank> response) {
                recyclerView.setAdapter(new BanksAdapter(response.body().getDataBank(), R.layout.horizontal_item_view, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<Bank> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });

//        horizontalAdapter=new HorizontalAdapter(horizontalList);
//        LinearLayoutManager horizontalLayoutManagaer
//                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
//        horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
//
//        horizontal_recycler_view.setAdapter(horizontalAdapter);
    }



//    public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {
//
//        private List<String> horizontalList;
//
//        public class MyViewHolder extends RecyclerView.ViewHolder {
//            public TextView txtView;
//
//            public MyViewHolder(View view) {
//                super(view);
//                txtView = (TextView) view.findViewById(R.id.data_bank_code);
//
//            }
//        }
//
//
//        public HorizontalAdapter(List<String> horizontalList) {
//            this.horizontalList = horizontalList;
//        }
//
//        @Override
//        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            View itemView = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.horizontal_item_view, parent, false);
//
//            return new MyViewHolder(itemView);
//        }
//
//        @Override
//        public void onBindViewHolder(final MyViewHolder holder, final int position) {
//            holder.txtView.setText(horizontalList.get(position));
//
//            holder.txtView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Toast.makeText(MainActivity.this,holder.txtView.getText().toString(),Toast.LENGTH_SHORT).show();
//                }
//            });
//        }
//
//        @Override
//        public int getItemCount() {
//            return horizontalList.size();
//        }
//    }
}
