package org.quaink.rgbmixer;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public View viewColor;
    public TextView textViewRed;
    public TextView textViewGreen;
    public TextView textViewBlue;
    public SeekBar seekBarRed;
    public SeekBar seekBarGreen;
    public SeekBar seekBarBlue;
    public int red = 0;
    public int green = 0;
    public int blue = 0;
    public String txtRed;
    public String txtGreen;
    public String txtBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewColor = findViewById(R.id.view_color);
        textViewRed = findViewById(R.id.txt_red);
        textViewGreen = findViewById(R.id.txt_green);
        textViewBlue = findViewById(R.id.txt_blue);
        seekBarRed = findViewById(R.id.seek_bar_red);
        seekBarGreen = findViewById(R.id.seek_bar_green);
        seekBarBlue = findViewById(R.id.seek_bar_blue);

        txtRed = getResources().getString(R.string.txt_red);
        txtGreen = getResources().getString(R.string.txt_green);
        txtBlue = getResources().getString(R.string.txt_blue);
        textViewRed.setText(String.format(txtRed, red));
        textViewGreen.setText(String.format(txtGreen, green));
        textViewBlue.setText(String.format(txtBlue, blue));

        ColorSeekBarListener colorSeekBarListener = new ColorSeekBarListener();
        seekBarRed.setOnSeekBarChangeListener(colorSeekBarListener);
        seekBarGreen.setOnSeekBarChangeListener(colorSeekBarListener);
        seekBarBlue.setOnSeekBarChangeListener(colorSeekBarListener);
    }

    class ColorSeekBarListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (seekBar == seekBarRed) {
                red = progress;
            } else if (seekBar == seekBarGreen) {
                green = progress;
            } else if (seekBar == seekBarBlue) {
                blue = progress;
            }

            viewColor.setBackgroundColor(Color.argb(255, red, green, blue));

            textViewRed.setText(String.format(txtRed, red));
            textViewGreen.setText(String.format(txtGreen, green));
            textViewBlue.setText(String.format(txtBlue, blue));
        }
    }
}