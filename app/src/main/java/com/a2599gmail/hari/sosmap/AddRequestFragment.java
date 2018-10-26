package com.a2599gmail.hari.sosmap;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;


public class AddRequestFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private LocationManager locationManager;
    private LocationListener locationListener;

    private ImageView locationButton;
    private TextView locationView;
    private ImageView imageButton;
    private Spinner spinner;
    private TextView reqList;
    private Button clr,sos;
    private EditText desc;

    ArrayList<String> types;
    ArrayAdapter<String> typesAdapter;

    public AddRequestFragment() {
        // Required empty public constructor
    }

    public static AddRequestFragment newInstance() {
        AddRequestFragment fragment = new AddRequestFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_request, container, false);

        locationButton = view.findViewById(R.id.Location_button);
        imageButton = view.findViewById(R.id.Photo_button);
        locationView = view.findViewById(R.id.textViewLocation);
        spinner = view.findViewById(R.id.Spinner);
        reqList = view.findViewById(R.id.ReqList);
        desc = view.findViewById(R.id.Desc);
        sos = view.findViewById(R.id.SubmitRequestButton);
        clr = view.findViewById(R.id.clear);
        clr.setOnClickListener(this);

        types = new ArrayList<>();
        types.add("None");
        types.add("Emergency Rescue");
        types.add("Drinking Water");
        types.add("Food");
        types.add("Infant Food");
        types.add("Child Medical Supplies");
        types.add("Doctor visit");
        types.add("Menstrual Hygiene");
        types.add("Clothes for Men");
        types.add("Clothes for Women");
        types.add("Other (mention in decription)");

        typesAdapter = new ArrayAdapter<>(getContext(),R.layout.support_simple_spinner_dropdown_item,types);
        typesAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(typesAdapter);

        spinner.setOnItemSelectedListener(this);

        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
//        locationListener = new LocationListener() {
//            @Override
//            public void onLocationChanged(Location location) {
//                locationView.append("\n"+location.getLatitude() + "," + location.getLongitude());
//                Log.d("Location", "onLocationChanged: ");
//            }
//
//            @Override
//            public void onStatusChanged(String provider, int status, Bundle extras) {
//
//            }
//
//            @Override
//            public void onProviderEnabled(String provider) {
//
//            }
//
//            @Override
//            public void onProviderDisabled(String provider) {
//
//            }
//        };

        //checkLocation();
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i!=0)
        {

            String selected = adapterView.getItemAtPosition(i).toString();
            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>"+selected);

            reqList.setText(new StringBuilder(reqList.getText().toString()+selected+","));
            types.remove(selected);
            typesAdapter.remove(selected);
            typesAdapter.notifyDataSetChanged();
            spinner.setSelection(0);
        }


    }

    @Override
    public void onClick(View view) {
        desc.setText("");
        String requests = reqList.getText().toString();
        StringTokenizer st = new StringTokenizer(requests,",");
        while (st.hasMoreTokens())
        {
            String str = st.nextToken();
            if(!str.isEmpty())
            {
                typesAdapter.add(str);
            }
        }
        spinner.setSelection(0);
        typesAdapter.notifyDataSetChanged();
        reqList.setText("");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    //    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        switch(requestCode){
//            case 10:
//                checkLocation();
//                break;
//            default:
//                break;
//        }
//    }
//
//    public void checkLocation(){
//
//        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            if(Build.VERSION.SDK_INT > 23)
//                requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET},10);
//            return;
//        }
//        locationButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
//            }
//        });
//    }
}
