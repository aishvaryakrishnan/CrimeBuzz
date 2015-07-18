package com.crimebuzz;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.os.Bundle;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends FragmentActivity  implements OnMapReadyCallback {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);

		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

		if (mapFragment==null) {
			Log.e("TAG", "mapFragment is null");
			Toast.makeText(this, "null mapFragment", Toast.LENGTH_LONG).show();
			mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentByTag("googlemap");
			if (mapFragment==null) {
				Log.e("TAG", "mapFragment is null again");
				Toast.makeText(this, "null mapFragment again", Toast.LENGTH_LONG).show();
			}
		} else {
			mapFragment.getMapAsync(this);
		}
	}

	@Override
	public void onMapReady(GoogleMap map) {
		LatLng sydney = new LatLng(-33.867, 151.206);

		map.setMyLocationEnabled(true);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 13));

		map.addMarker(new MarkerOptions()
				.title("Sydney")
				.snippet("The most populous city in Australia.")
				.position(sydney));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
