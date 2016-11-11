package com.example.chongshao_mikasa.ble_fingerprint;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.SystemRequirementsChecker;

import org.artoolkit.ar.base.ARActivity;
import org.artoolkit.ar.base.rendering.ARRenderer;

import java.util.Collections;
import java.util.List;
import java.util.UUID;


public class MainActivity extends ARActivity {

    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 133;

    private BeaconManager beaconManager;
    private Region region0;
    private Region region1;
    private Region region2;
    private Region region3;
    private Region region4;
    private Region region5;
    private Region region6;
    private Region region7;

    TextView beacon0;
    TextView beacon1;
    TextView beacon2;
    TextView beacon3;
    TextView beacon4;
    TextView beacon5;
    TextView beacon6;
    TextView beacon7;

    private SimpleRenderer simpleRenderer = new SimpleRenderer();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beacon0 = (TextView)this.findViewById(R.id.beacon0);
        beacon1 = (TextView)this.findViewById(R.id.beacon1);
        beacon2 = (TextView)this.findViewById(R.id.beacon2);
        beacon3 = (TextView)this.findViewById(R.id.beacon3);
        beacon4 = (TextView)this.findViewById(R.id.beacon4);
        beacon5 = (TextView)this.findViewById(R.id.beacon5);
        beacon6 = (TextView)this.findViewById(R.id.beacon6);
        beacon7 = (TextView)this.findViewById(R.id.beacon7);

        beaconManager = new BeaconManager(this);

        region0 = new Region("ranged region",
                UUID.fromString("a75fa152-a904-4502-8ea8-192f8fcfee6a"), 37491, 43355); //1
        region1 = new Region("ranged region",
                UUID.fromString("9795a656-a244-47f5-b8ab-a24cf9728976"), 12703, 41115); //15
        region2 = new Region("ranged region",
                UUID.fromString("58deb431-0387-4aff-b04d-bf773f2409cc"), 918, 44776); //2
        region3 = new Region("ranged region",
                UUID.fromString("e14f37ee-cd9c-41a1-b145-134570f9a8e8"), 41600, 6645); //3
        region4 = new Region("ranged region",
                UUID.fromString("b6fc3980-846c-4f48-bfc5-2b2e0ca2d702"), 2143, 20816); //4
        region5 = new Region("ranged region",
                UUID.fromString("9aa9bca6-b207-41f5-a076-d294c9b374db"), 49523, 36217); //5
        region6 = new Region("ranged region",
                UUID.fromString("21f158a6-a083-4020-9b40-8cd34380ffc3"), 16355, 40884); //6
        region7 = new Region("ranged region",
                UUID.fromString("7691f1bd-284f-439d-8b1a-d223f0249b9b"), 30448, 19478); //7

        beaconManager.setRangingListener(new BeaconManager.RangingListener() {
            @Override
            public void onBeaconsDiscovered(Region region, List<Beacon> list) {
                if (!list.isEmpty()) {
                  //  Beacon nearestBeacon = list.get(0);
                    for (Beacon beacon : list) {
                        if (beacon.getProximityUUID().equals(UUID.fromString("a75fa152-a904-4502-8ea8-192f8fcfee6a"))) {
                            Log.d("Airport", "Beacon 0 dist: " + String.valueOf(beacon.getRssi()));
                            beacon0.setText("distance: "+ String.valueOf(beacon.getRssi()));
                        }
                        if (beacon.getProximityUUID().equals(UUID.fromString("9795a656-a244-47f5-b8ab-a24cf9728976"))) {
                            Log.d("Airport", "Beacon 1 dist: " + String.valueOf(beacon.getRssi()));
                            beacon1.setText("distance: "+ String.valueOf(beacon.getRssi()));
                        }
                        if (beacon.getProximityUUID().equals(UUID.fromString("58deb431-0387-4aff-b04d-bf773f2409cc"))) {
                            Log.d("Airport", "Beacon 2 dist: " + String.valueOf(beacon.getRssi()));
                            beacon2.setText("distance: "+ String.valueOf(beacon.getRssi()));
                        }
                        if (beacon.getProximityUUID().equals(UUID.fromString("e14f37ee-cd9c-41a1-b145-134570f9a8e8"))) {
                            Log.d("Airport", "Beacon 3 dist: " + String.valueOf(beacon.getRssi()));
                            beacon3.setText("distance: "+ String.valueOf(beacon.getRssi()));
                        }
                        if (beacon.getProximityUUID().equals(UUID.fromString("b6fc3980-846c-4f48-bfc5-2b2e0ca2d702"))) {
                            Log.d("Airport", "Beacon 4 dist: " + String.valueOf(beacon.getRssi()));
                            beacon4.setText("distance: "+ String.valueOf(beacon.getRssi()));
                        }
                        if (beacon.getProximityUUID().equals(UUID.fromString("9aa9bca6-b207-41f5-a076-d294c9b374db"))) {
                            Log.d("Airport", "Beacon 5 dist: " + String.valueOf(beacon.getRssi()));
                            beacon5.setText("distance: "+ String.valueOf(beacon.getRssi()));
                        }
                        if (beacon.getProximityUUID().equals(UUID.fromString("21f158a6-a083-4020-9b40-8cd34380ffc3"))) {
                            Log.d("Airport", "Beacon 6 dist: " + String.valueOf(beacon.getRssi()));
                            beacon6.setText("distance: "+ String.valueOf(beacon.getRssi()));
                        }
                        if (beacon.getProximityUUID().equals(UUID.fromString("7691f1bd-284f-439d-8b1a-d223f0249b9b"))) {
                            Log.d("Airport", "Beacon 7 dist: " + String.valueOf(beacon.getRssi()));
                            beacon7.setText("distance: "+ String.valueOf(beacon.getRssi()));
                        }
                    }
//                    double distance = computeDistance(nearestBeacon);
//                    beacon0.setText("distance: "+ String.valueOf(nearestBeacon.getRssi()));
//                    beacon1.setText("distance: "+ String.valueOf(distance));
//                    beacon2.setText("distance: "+ String.valueOf(distance));
//                    beacon3.setText("distance: "+ String.valueOf(distance));
//                    beacon4.setText("distance: "+ String.valueOf(distance));
//                    beacon5.setText("distance: "+ String.valueOf(distance));
//                    beacon6.setText("distance: "+ String.valueOf(distance));
//                    beacon7.setText("distance: "+ String.valueOf(distance));
                    //       List<String> places = placesNearBeacon(nearestBeacon);
                }
            }
        });

        if (!checkCameraPermission()) {
            //if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) { //ASK EVERY TIME - it's essential!
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_REQUEST_CAMERA);
        }

        // When the screen is tapped, inform the renderer and vibrate the phone
        mainLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                simpleRenderer.click();
                Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                vib.vibrate(40);
            }
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        SystemRequirementsChecker.checkWithDefaultDialogs(this);

        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startRanging(region0);
                beaconManager.startRanging(region1);
                beaconManager.startRanging(region2);
                beaconManager.startRanging(region3);
                beaconManager.startRanging(region4);
                beaconManager.startRanging(region5);
                beaconManager.startRanging(region6);
                beaconManager.startRanging(region7);
            }
        });
    }

    @Override
    protected void onPause() {
        beaconManager.stopRanging(region0);
        beaconManager.stopRanging(region1);
        beaconManager.stopRanging(region2);
        beaconManager.stopRanging(region3);
        beaconManager.stopRanging(region4);
        beaconManager.stopRanging(region5);
        beaconManager.stopRanging(region6);
        beaconManager.stopRanging(region7);
        super.onPause();
    }

//    private List<String> placesNearBeacon(Beacon beacon) {
//        String beaconKey = String.format("%d:%d", beacon.getMajor(), beacon.getMinor());
//        if (PLACES_BY_BEACONS.containsKey(beaconKey)) {
//            return PLACES_BY_BEACONS.get(beaconKey);
//        }
//        return Collections.emptyList();
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    private double computeDistance(Beacon beacon) {
        int txPower = beacon.getMeasuredPower();
        int rssi = beacon.getRssi();
        return Math.pow(10d, ((double) txPower - rssi) / (10 * 2));
    }


    @Override
    protected ARRenderer supplyRenderer() {
        if (!checkCameraPermission()) {
            Toast.makeText(this, "No camera permission - restart the app", Toast.LENGTH_LONG).show();
            return null;
        }
        return simpleRenderer;
    }

    @Override
    protected FrameLayout supplyFrameLayout() {
        return (FrameLayout)this.findViewById(R.id.mainLayout);
    }

    private boolean checkCameraPermission() {
        return ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CAMERA: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                return;
            }
        }
    }
}