package com.example.googlemap;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.googlemap.utils.Utils;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMapClickListener {
    @SuppressLint("NonConstantResourceId")
    @BindView(R.id.searchView)
    SearchView searchView;
    GoogleMap map;
    SupportMapFragment mapFragment;
    TextView txt_name, txt_infor2;
    ImageView img_place;
    @SuppressLint("InflateParams")
    View custom_infor;
    Marker marker;

    @SuppressLint("InflateParams")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custom_infor = getLayoutInflater().inflate(R.layout.custom_infowindow, null);
        //Tao ban do
        GoogleMapOptions options = new GoogleMapOptions().zoomControlsEnabled(true).mapToolbarEnabled(true);//Hien thi nut zoom cuar map
        mapFragment = SupportMapFragment.newInstance(options);
        getSupportFragmentManager().beginTransaction().add(R.id.myMap, mapFragment).commit();
        mapFragment.getMapAsync(this);//Dong bo voi onMapReady
        searchView = findViewById(R.id.searchView);
        searchView.onActionViewExpanded();//Hien thi hint cua search
        searchView.clearFocus();//Ko cho ban phim hien thi len
        txt_name = custom_infor.findViewById(R.id.text_name);
        txt_infor2 = custom_infor.findViewById(R.id.text_infor2);
        img_place = custom_infor.findViewById(R.id.image_place);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                String location = searchView.getQuery().toString();
                List<Address> addressList = null;
                Geocoder geocoder = new Geocoder(MainActivity.this);
                try {
                    addressList = geocoder.getFromLocationName(location, 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                assert addressList != null;
                Address address = (addressList.isEmpty() ? null : addressList.get(0));
                if (address != null) {
                    if (marker != null) {
                        marker.remove();
                    }
                    LatLng latLng2 = new LatLng(address.getLatitude(), address.getLongitude());
                    marker = map.addMarker(new MarkerOptions()
                            .position(latLng2)
                            .title(address.getFeatureName())
                            .snippet(address.getAddressLine(0))
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                    map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng2, 20f));
                } else {
                    Toast.makeText(MainActivity.this, "Không tìm thấy địa chỉ nhập!", Toast.LENGTH_LONG).show();
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        googleMap.setTrafficEnabled(true);
        googleMap.setBuildingsEnabled(true);
        googleMap.setOnInfoWindowClickListener(this);
        googleMap.setOnMapClickListener(this);
        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                txt_name.setText(marker.getTitle());
                txt_infor2.setText(marker.getSnippet());
                return custom_infor;
            }
        });
        Utils.createMark(this, map);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.map_mode, menu);

        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.normal_mode:
                map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                Toast.makeText(this, "Bạn đã chọn chế độ Normal", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.hybrid_mode:
                map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                Toast.makeText(this, "Bạn đã chọn chế độ HyBrid:" +
                        " Dữ liệu ảnh vệ tinh có thêm bản đồ đường đi. Các nhãn đường và đối tượng địa lý cũng hiển thị.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.satellite_mode:
                map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                Toast.makeText(this, "Bạn đã chọn chế độ vệ tinh: " +
                        "Dữ liệu ảnh vệ tinh. Các nhãn đường và đối tượng địa lý không hiển thị.", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.terrain_mode:
                map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                Toast.makeText(this, "Bạn đã chọn chế độ Terrain:" +
                        " Dữ liệu địa hình. Bản đồ bao gồm màu sắc, đường đồng mức và nhãn cũng như tô bóng phối cảnh. ", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.none_mode:
                map.setMapType(GoogleMap.MAP_TYPE_NONE);
                Toast.makeText(this, "Bạn đã chọn chế độ trống", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Toast.makeText(this, "Click Success", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onMapClick(LatLng latLng) {
        Toast.makeText(this, "Chuc nang click vao ban do chua hoan thien", Toast.LENGTH_SHORT).show();
    }
}