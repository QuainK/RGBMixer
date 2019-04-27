package org.quaink.rgbmixer;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public SeekBar sb1;
    public SeekBar sb2;
    public SeekBar sb3;
    public TextView txt_cur;
    public TextView txt_red;
    public TextView txt_green;
    public TextView txt_blue;
    public int red = 0;
    public int green = 0;
    public int blue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb1 = findViewById(R.id.sb1);
        sb2 = findViewById(R.id.sb2);
        sb3 = findViewById(R.id.sb3);
        txt_cur = findViewById(R.id.txt_cur);
        txt_red = findViewById(R.id.txt_red);
        txt_green = findViewById(R.id.txt_green);
        txt_blue = findViewById(R.id.txt_blue);

        // 直接new一个内部类对象作为参数
        sb1.setOnSeekBarChangeListener(new MySeekBarChangeListener());
        sb2.setOnSeekBarChangeListener(new MySeekBarChangeListener());
        sb3.setOnSeekBarChangeListener(new MySeekBarChangeListener());
    }

    class MySeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            switch (seekBar.getId()) {
                case 2131165282:
                    red = progress;
                    break;
                case 2131165283:
                    green = progress;
                    break;
                case 2131165284:
                    blue = progress;
                    break;
                default:
                    break;
            }
            txt_cur.setBackgroundColor(Color.argb(255, red, green, blue));
            try {
                txt_cur.setText("当前拖动条SeekBar的控件ID " + seekBar.getId()
                        + "\n红色Red " + red
                        + "\n绿色Green " + green
                        + "\n蓝色Blue " + blue);
                if (red > 191 || green > 191) {
                    txt_cur.setTextColor(Color.argb(255, 0, 0, 0));
                } else {
                    txt_cur.setTextColor(Color.argb(255, 255, 255, 255));
                }
                txt_red.setText("红色Red " + red);
                txt_green.setText("绿色Green " + green);
                txt_blue.setText("蓝色Blue " + blue);
            } catch (Exception e) {
                txt_cur.setText("数据显示出错");
            }
        }
    }
}
