package com.github.keyhansoft.sample;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.keyhansoft.easyfragmentdialog.EasyDialogFragment;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new EasyDialogFragment.Builder(this)
                .setTitle("TEST")
                .setCancelable(true)
                .setMessage("test")
                .setPositiveText("test2")
                .setButtonColor(Color.RED)
                .onPositive(new EasyDialogFragment.SingleButtonCallback()
                {
                    @Override
                    public void onClick(DialogInterface dialog)
                    {

                    }
                })
                .show();
    }
}
