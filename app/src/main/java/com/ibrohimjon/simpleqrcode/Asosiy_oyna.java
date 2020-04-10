package com.ibrohimjon.simpleqrcode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

public class Asosiy_oyna extends AppCompatActivity {

    ImageView imageView;
    Button btn_scan;
    TextView txt_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asosiy_oyna);

        imageView = findViewById(R.id.imageView);
        btn_scan = findViewById(R.id.btn_scan);
        txt_result = findViewById(R.id.txt_result);

        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.qrcode);
        imageView.setImageBitmap(bitmap);

        btn_scan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BarcodeDetector detector = new BarcodeDetector.Builder(getApplicationContext())
                        .setBarcodeFormats(Barcode.QR_CODE).build();

                Frame frame = new Frame.Builder().setBitmap(bitmap).build();
                SparseArray<Barcode> barcode = detector.detect(frame);
                Barcode result = barcode.valueAt(0);
                txt_result.setText(result.rawValue);
            }
        });
    }
}
