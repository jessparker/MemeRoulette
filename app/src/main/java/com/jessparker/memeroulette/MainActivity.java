package com.jessparker.memeroulette;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nextImage(View view) {
        Log.i("button", "BUTTON CLICKED!");

        // find the image frame and change the image
        ImageView img = (ImageView) findViewById(R.id.image_frame);
        img.setImageResource(R.drawable.top3);

        FrameLayout.LayoutParams layoutParams = imageResize(100, 200);
        img.setLayoutParams(layoutParams);
    }

    public FrameLayout.LayoutParams imageResize(int width, int height) {
        // convert image width and height dp values to pixels
        int resizeWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width,
                getResources().getDisplayMetrics());
        int resizeHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height,
                getResources().getDisplayMetrics());

        // change the size of the image to the desired width and height

        return new FrameLayout.LayoutParams(resizeWidth, resizeHeight);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
