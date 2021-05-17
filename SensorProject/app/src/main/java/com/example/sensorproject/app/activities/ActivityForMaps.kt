package com.example.sensorproject.app.activities


import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.example.sensorproject.R
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration.*
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.compass.CompassOverlay
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ActivityForMaps : AppCompatActivity() {

    private lateinit var map : MapView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        setContentView(R.layout.activity_for_maps);

        val intent = intent
        val nameSensor = intent.getStringExtra("nameSensor")
        val latitude = intent.getFloatExtra("latitude", 0.0f)
        val longitude = intent.getFloatExtra("longitude", 0.0f)

        map = findViewById<MapView>(R.id.map)
        map.setTileSource(TileSourceFactory.MAPNIK);

        map.setTilesScaledToDpi(true)

        // add multi-touch capability
        map.setMultiTouchControls(true)

        // add compass to map
        val compassOverlay =
            CompassOverlay(this, InternalCompassOrientationProvider(this), map)
        compassOverlay.enableCompass()
        map.getOverlays().add(compassOverlay)

        // get map controller
        val controller: IMapController = map.getController()

        val positions = GeoPoint(latitude.toDouble(), longitude.toDouble())

        controller.setCenter(positions)
        val zoomMaps = 10
        controller.setZoom(zoomMaps)

        val firstMarker = Marker(map)
        val geoPoint = GeoPoint(latitude.toDouble(), longitude.toDouble())
        firstMarker.position = geoPoint
        firstMarker.title = nameSensor
        firstMarker.setAnchor(Marker.ANCHOR_BOTTOM, Marker.ANCHOR_CENTER)

        map.overlays.add(firstMarker)
        map.invalidate()
    }
}