package com.example.brain.Calculator;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.brain.Calculator.databinding.ActivityMainBinding;

// TODO: Add Android app icon
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    private Button opClear, opDivide, opMulti, opSub, opAdd, opEqual;
    private TextView Display;
    private ActivityMainBinding binding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initialize();
    }

    private void initialize()
    {
        binding.num0.setOnClickListener(this);
        binding.num1.setOnClickListener(this);
        binding.num2.setOnClickListener(this);
        binding.num3.setOnClickListener(this);
        binding.num4.setOnClickListener(this);
        binding.num5.setOnClickListener(this);
        binding.num6.setOnClickListener(this);
        binding.num7.setOnClickListener(this);
        binding.num8.setOnClickListener(this);
        binding.num9.setOnClickListener(this);

        binding.opClear.setOnClickListener(this);
        binding.opDivide.setOnClickListener(this);
        binding.opMulti.setOnClickListener(this);
        binding.opSub.setOnClickListener(this);
        binding.opAdd.setOnClickListener(this);
        binding.opEqual.setOnClickListener(this);
        binding.Display.setOnClickListener(this);
    }

    // TODO: Sadat fill in the rest of this part
    public void onClick(View view)
    {
        // If the 0 button is clicked, on then add the string "0" to the display
        if (view.getId() == binding.num0.getId())
        {
            binding.Display.setText(binding.Display.getText() + "0");
        }

        // If the C button is clicked on, then set the display to an empty string
        if (view.getId() == binding.opClear.getId())
        {
            binding.Display.setText("");
        }
    }
}
