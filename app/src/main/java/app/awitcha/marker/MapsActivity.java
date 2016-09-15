package app.awitcha.marker;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import app.awitcha.marker.model.MarkerModel;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private List<MarkerModel> markerModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        markerModels = new ArrayList<>();

        MarkerModel modelA = new MarkerModel();
        modelA.setTitle("Amnatcharoen");
        modelA.setLatLng(new LatLng(15.9113333,104.1774139));
        modelA.setBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

        MarkerModel modelB = new MarkerModel();
        modelB.setTitle("Ubonrachathani");
        modelB.setLatLng(new LatLng(15.1532374,103.8791492));
        modelB.setBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

        MarkerModel modelC = new MarkerModel();
        modelC.setTitle("Khonkaen");
        modelC.setLatLng(new LatLng(16.3633187,101.3428402));
        modelC.setBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));

        markerModels.add(modelA);
        markerModels.add(modelB);
        markerModels.add(modelC);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng currentPosition = new LatLng(15.3671787,101.5531182);

        for (MarkerModel model : markerModels) {
            mMap.addMarker(new MarkerOptions()
                    .position(model.getLatLng())
                    .title(model.getTitle())
                    .icon(BitmapDescriptorFactory.fromBitmap(model.getBitmap())));
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLng(currentPosition));
        mMap.moveCamera(CameraUpdateFactory.zoomTo(6));

    }
}
