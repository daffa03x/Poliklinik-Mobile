package com.kadazi.poliklinikapps.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.kadazi.poliklinikapps.Adapter.AdapterDataPembayaranResep;
import com.kadazi.poliklinikapps.Adapter.AdapterDataPemeriksaanResep;
import com.kadazi.poliklinikapps.Api.APIRequestData;
import com.kadazi.poliklinikapps.Api.RetroServer;
import com.kadazi.poliklinikapps.Model.DataModelPembayaranResep;
import com.kadazi.poliklinikapps.Model.DataModelPemeriksaanResep;
import com.kadazi.poliklinikapps.Model.ResponseModelPembayaranResep;
import com.kadazi.poliklinikapps.Model.ResponseModelPemeriksaanResep;
import com.kadazi.poliklinikapps.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailPemeriksaanActivity extends AppCompatActivity {
    TextView Nama_dokter;
    TextView Nama_poli;
    TextView tgl_pendaftaran;
    TextView keluhan;
    TextView diagnosa;
    TextView perawatan;
    TextView tindakan;
    TextView bb;
    TextView tensi;
    ImageButton back;
    Button resep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pemeriksaan);

        Nama_dokter = findViewById(R.id.detail_pemeriksaan_dokter);
        Nama_poli = findViewById(R.id.detail_pemeriksaan_poliklinik);
        tgl_pendaftaran = findViewById(R.id.detail_pemeriksaan_tgl);
        keluhan = findViewById(R.id.keluhan_pemeriksaan);
        diagnosa = findViewById(R.id.diagnosa_pemeriksaan);
        perawatan = findViewById(R.id.perawatan_pemeriksaan);
        tindakan = findViewById(R.id.tindakan_pemeriksaan);
        bb = findViewById(R.id.bb_pemeriksaan);
        tensi = findViewById(R.id.tensi_pemeriksaan);
        resep = findViewById(R.id.pemeriksaan_detail);
        Intent terima = getIntent();
        String xnama_dokter = terima.getStringExtra("nama");
        String xnama_poli = terima.getStringExtra("poli");
        String xtgl_pendaftaran = terima.getStringExtra("tgl_pendaftaran");
        String xkeluhan = terima.getStringExtra("keluhan");
        String xdiagnosa = terima.getStringExtra("diagnosa");
        String xperawatan = terima.getStringExtra("perawatan");
        String xtindakan = terima.getStringExtra("tindakan");
        String xbb = terima.getStringExtra("bb");
        String xtensi = terima.getStringExtra("tensi");
        resep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailPemeriksaanActivity.this, RiwayatPemeriksaanResepActivity.class);
                intent.putExtra("nama",xnama_dokter);
                intent.putExtra("poli",xnama_poli);
                intent.putExtra("tgl_pendaftaran",xtgl_pendaftaran);
                startActivity(intent);
            }
        });

        Nama_dokter.setText(xnama_dokter);
        Nama_poli.setText(xnama_poli);
        tgl_pendaftaran.setText(xtgl_pendaftaran);
        keluhan.setText(xkeluhan);
        diagnosa.setText(xdiagnosa);
        perawatan.setText(xperawatan);
        tindakan.setText(xtindakan);
        bb.setText(xbb+"Kg");
        tensi.setText(xtensi+"mmHg");
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.page_1:
                        return false;
                    case R.id.page_2:
                        startActivity(new Intent(getApplicationContext(),ResepActivity.class));
                        overridePendingTransition(0,0);
                        return false;
                    case R.id.page_3:
                        startActivity(new Intent(getApplicationContext(),RiwayatPemeriksaanActivity.class));
                        overridePendingTransition(0,0);
                        return false;
                    case R.id.page_4:
                        startActivity(new Intent(getApplicationContext(),PengaturanActivity.class));
                        overridePendingTransition(0,0);
                        return false;
                }
                return false;
            }
        });
        back = findViewById(R.id.back_detail_riwayat);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}