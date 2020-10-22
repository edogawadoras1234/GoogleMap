package com.example.googlemap.utils;

import android.content.Context;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static final LatLng NHA_TRANG_UNIVER = new LatLng(12.2681489, 109.2023759);
    private static final LatLng NHA_HANG_YEN_SAO = new LatLng(12.2659938, 109.2026238);
    private static final LatLng CAU_TRAN_PHU = new LatLng(12.2623592, 109.1994028);
    private static final LatLng CONG_VIEN_TRAN_PHU = new LatLng(12.2651313, 109.2009512);
    private static final LatLng GALAXY_COFFE = new LatLng(12.2651313, 109.1987625);
    private static final LatLng MY_HOME = new LatLng(12.1545323, 109.0775708);
    private static final LatLng vietnam = new LatLng(15.7583475,108.277199);
    public static void createMark(Context context, GoogleMap googleMap) {
        IconGenerator iconGenerator = new IconGenerator(context);
        Bitmap bitmap1 = iconGenerator.makeIcon("    $1   ");
        Bitmap bitmap2 = iconGenerator.makeIcon("    $2   ");
        Bitmap bitmap3 = iconGenerator.makeIcon("    $3   ");
        Bitmap bitmap4 = iconGenerator.makeIcon("    $4   ");
        Bitmap bitmap5 = iconGenerator.makeIcon("    $5   ");
        Bitmap bitmap6 = iconGenerator.makeIcon("   My Home   ");

        List<Marker> markerList = new ArrayList<>();

        Marker nhatrang_univer = marker(googleMap, NHA_TRANG_UNIVER, bitmap1, "Nha Trang Universary", "Đây là Trường DH Nha Trang");
        markerList.add(nhatrang_univer);
        Marker yen_sao_res = marker(googleMap, NHA_HANG_YEN_SAO, bitmap2, "Yen Sao Restaurant", "Đây là nhà hàng Yến Sào");
        markerList.add(yen_sao_res);
        Marker tran_phu_brigde = marker(googleMap, CAU_TRAN_PHU, bitmap3, "Tran Phu Brigde", "Đây là Cầu Trần Phú");
        markerList.add(tran_phu_brigde);
        Marker tran_phu_park = marker(googleMap, CONG_VIEN_TRAN_PHU, bitmap4, "Tran Phu Park", "Đây là công viên Trần Phú");
        markerList.add(tran_phu_park);
        Marker galaxy_cf = marker(googleMap, GALAXY_COFFE, bitmap5, "Galaxy Coffe", "Đây là Galaxy Coffe");
        markerList.add(galaxy_cf);
        Marker myhouse = marker(googleMap, MY_HOME, bitmap6, "Nhà Tui", "Đây là nhà của tui nè :v!");
        markerList.add(myhouse);

        googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

        for (Marker m : markerList) {
            LatLng latLng = new LatLng(m.getPosition().latitude, m.getPosition().longitude);
            googleMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .alpha(0.0f)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vietnam, 100f));
        }
    }

    @NonNull
    public static Marker marker(GoogleMap googleMap, LatLng latLng, Bitmap bitmap, String title, String snippet) {
        return googleMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title(title)
                .snippet(snippet)
                .icon(BitmapDescriptorFactory.fromBitmap(bitmap)));
    }

    @Deprecated
    public static void showMarkerToGoogleMap(GoogleMap map, LatLng position) {
        map.clear();
        MarkerOptions markerOptions = new MarkerOptions().position(position);
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        map.addMarker(markerOptions);
    }

}
