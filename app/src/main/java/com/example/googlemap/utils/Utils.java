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

        for (Marker m : markerList) {
            LatLng latLng = new LatLng(m.getPosition().latitude, m.getPosition().longitude);
            googleMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .alpha(0.0f)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(MY_HOME, 10.0f));
        }
    }

    public static void findHotel(Context context, GoogleMap googleMap) {
        final LatLng DIAMOND_BAY = new LatLng(12.2476877,109.1951248);
        final LatLng YASAKA_NHATRANG = new LatLng(12.2483015,109.1955298);
        final LatLng ALMA_RESORT = new LatLng(12.2476825,109.192699);
        final LatLng SHERATON_HOTEL = new LatLng(12.2474593,109.1952488);
        final LatLng SUNRISE_NHATRANG = new LatLng(12.2503127,109.1933745);

        IconGenerator iconGenerator = new IconGenerator(context);
        Bitmap bitmap1 = iconGenerator.makeIcon("    $23   ");
        Bitmap bitmap2 = iconGenerator.makeIcon("    $24   ");
        Bitmap bitmap3 = iconGenerator.makeIcon("    $255   ");
        Bitmap bitmap4 = iconGenerator.makeIcon("    $69   ");
        Bitmap bitmap5 = iconGenerator.makeIcon("    $33   ");

        List<Marker> markerList = new ArrayList<>();

        Marker diamon_bay = marker(googleMap, DIAMOND_BAY, bitmap1, "Diamond Bay", "$23/night");
        markerList.add(diamon_bay);

        Marker yasaka_saigon_nha_trang = marker(googleMap, YASAKA_NHATRANG, bitmap2, "Yasaka Saigon Nha Trang", "24/night");
        markerList.add(yasaka_saigon_nha_trang);

        Marker alma_resort = marker(googleMap, ALMA_RESORT, bitmap3, "Alma Resort", "255/night");
        markerList.add(alma_resort);

        Marker sheraton_hotel = marker(googleMap, SHERATON_HOTEL, bitmap4, "Sheraton Nha Trang Hotel & Spa", "69/night");
        markerList.add(sheraton_hotel);

        Marker sunrise_nhatrang = marker(googleMap, SUNRISE_NHATRANG, bitmap5, "Sunrise Nha Trang Beach Hotel & Spa", "33/night");
        markerList.add(sunrise_nhatrang);

        for (Marker m : markerList) {
            LatLng latLng = new LatLng(m.getPosition().latitude, m.getPosition().longitude);
            googleMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .alpha(0.0f)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(DIAMOND_BAY, 15.0f));
        }
    }

    public static void findRestaurant(Context context, GoogleMap googleMap) {
        final LatLng BIEN_QUAN_RESTAURANT = new LatLng(12.2537401,109.192161);
        final LatLng GIA_DINH_QUAN = new LatLng(12.2533023,109.1931481);
        final LatLng BBQ_UN_IN = new LatLng(12.2585515,109.1884692);
        final LatLng PHAP_HY_VEGETA = new LatLng(12.2474593,109.1952488);
        final LatLng HAI_SAN_BINH_DAN = new LatLng(12.2503127,109.1933745);

        IconGenerator iconGenerator = new IconGenerator(context);
        Bitmap bitmap1 = iconGenerator.makeIcon("    Biển quán   ");
        Bitmap bitmap2 = iconGenerator.makeIcon("    Gia đình quán   ");
        Bitmap bitmap3 = iconGenerator.makeIcon("    BBQ Ủn Ỉn   ");
        Bitmap bitmap4 = iconGenerator.makeIcon("    Pháp Hỷ Chay Quán   ");
        Bitmap bitmap5 = iconGenerator.makeIcon("    Hải Sản Bình Dân   ");

        List<Marker> markerList = new ArrayList<>();

        Marker bien_quan = marker(googleMap, BIEN_QUAN_RESTAURANT, bitmap1, "Bien Quan Restaurant", "*****");
        markerList.add(bien_quan);

        Marker gia_dinh_quan = marker(googleMap, GIA_DINH_QUAN, bitmap2, "Quán Cơm Gia Đình", "******");
        markerList.add(gia_dinh_quan);

        Marker bbq_un_in = marker(googleMap, BBQ_UN_IN, bitmap3, "BBQ ỦN ỈN", "******");
        markerList.add(bbq_un_in);

        Marker phap_hy_vegetarian = marker(googleMap, PHAP_HY_VEGETA, bitmap4, "Phap Hy Vegetarian", "****");
        markerList.add(phap_hy_vegetarian);

        Marker hai_san_binh_dan = marker(googleMap, HAI_SAN_BINH_DAN, bitmap5, "Hải Sản Bình Dân CCK", "****");
        markerList.add(hai_san_binh_dan);

        for (Marker m : markerList) {
            LatLng latLng = new LatLng(m.getPosition().latitude, m.getPosition().longitude);
            googleMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .alpha(0.0f)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(BIEN_QUAN_RESTAURANT, 15.0f));
        }
    }

    public static void findCoffe(Context context, GoogleMap googleMap) {
        final LatLng HIGH_LAND_COFFE = new LatLng(12.2602152,109.1945855);
        final LatLng GALAXY_COFFE = new LatLng(12.2672634,109.1977566);
        final LatLng MILANO_COFFE = new LatLng(12.2684683,109.1998365);
        final LatLng LILA_COFFE = new LatLng(12.2695895,109.2010743);
        final LatLng THUY_MOC_COFFE = new LatLng(12.2725755,109.1923207);

        IconGenerator iconGenerator = new IconGenerator(context);
        Bitmap bitmap1 = iconGenerator.makeIcon("    HIGHLAND   ");
        Bitmap bitmap2 = iconGenerator.makeIcon("    GALAXY COFFE   ");
        Bitmap bitmap3 = iconGenerator.makeIcon("    MILANO COFFE   ");
        Bitmap bitmap4 = iconGenerator.makeIcon("    LILA_COFFE   ");
        Bitmap bitmap5 = iconGenerator.makeIcon("    THUY MOC COFFE   ");

        List<Marker> markerList = new ArrayList<>();

        Marker high_land = marker(googleMap, HIGH_LAND_COFFE, bitmap1, "Highlands Coffee - Muong Thanh Luxury", "Comment:...");
        markerList.add(high_land);

        Marker galaxy_coffe = marker(googleMap, GALAXY_COFFE, bitmap2, "Galaxy Garden Coffee & Bar", "Comment:...");
        markerList.add(galaxy_coffe);

        Marker milano_coffee = marker(googleMap, MILANO_COFFE, bitmap3, "Milano Coffee", "Comment:...");
        markerList.add(milano_coffee);

        Marker liLa_coffee = marker(googleMap, LILA_COFFE, bitmap4, "Wood House Coffee - Nhà Gỗ", "Comment:...");
        markerList.add(liLa_coffee);

        Marker thuy_moc_coffe = marker(googleMap, THUY_MOC_COFFE, bitmap5, "Thủy Mộc Cafe", "Comment:...");
        markerList.add(thuy_moc_coffe);

        for (Marker m : markerList) {
            LatLng latLng = new LatLng(m.getPosition().latitude, m.getPosition().longitude);
            googleMap.addMarker(new MarkerOptions()
                    .position(latLng)
                    .alpha(0.0f)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(HIGH_LAND_COFFE, 15.0f));
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
