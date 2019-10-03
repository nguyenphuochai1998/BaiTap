package com.example.asus.baitap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView grvPhim;
    ArrayList<HinhAnh> arrHinh;
    HinhAnhAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findId();
        adapter = new HinhAnhAdapter(this,R.layout.hinh_anh,arrHinh);
        grvPhim.setAdapter(adapter);

        grvPhim.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent chuyen= new Intent(MainActivity.this,Main2Activity.class);
                Bundle bundle=new Bundle();
                bundle.putString("chuoi",arrHinh.get(position).getTen());
                chuyen.putExtra("chuyenchuoi",bundle);
                startActivity(chuyen);




            }
        });

    }
    private void findId(){
        grvPhim = (GridView) findViewById(R.id.grv_Phim);
        arrHinh = new ArrayList<>();
        arrHinh.add(new HinhAnh("1",R.drawable.hanh_dong));
        arrHinh.add(new HinhAnh("2",R.drawable.tinh_cam));
        arrHinh.add(new HinhAnh("3",R.drawable.vien_tuong));
        arrHinh.add(new HinhAnh("4",R.drawable.kinh_di));
        arrHinh.add(new HinhAnh("5",R.drawable.hoat_hinh));
        arrHinh.add(new HinhAnh("6",R.drawable.phim_han));
        arrHinh.add(new HinhAnh("7",R.drawable.au_mi));
    }


}
