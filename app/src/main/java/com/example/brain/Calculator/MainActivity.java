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
    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, point;
    private Button opClear, opDivide, opMulti, opSub, opAdd, opEqual;
    private TextView Display;
    private TextView Intermediate;
    private ActivityMainBinding binding;

    /**
     * Value stored to be displayed
     */
    private double value1 = Double.NaN;
    private double value2;
    private boolean add = false;
    private boolean sub = false;
    private boolean mul = false;
    private boolean div = false;
    private boolean textSet = false;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private char CURRENT_ACTION;






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
        binding.Decimal.setOnClickListener(this);

        binding.opClear.setOnClickListener(this);
        binding.opDivide.setOnClickListener(this);
        binding.opMulti.setOnClickListener(this);
        binding.opSub.setOnClickListener(this);
        binding.opAdd.setOnClickListener(this);
        binding.opEqual.setOnClickListener(this);
        binding.Display.setOnClickListener(this);

        binding.Display.setText(null);
    }

    // TODO: Sadat fill in the rest of this part
    public void onClick(View view)
    {
        // If the 0 button is clicked, on then add the string "0" to the display
        if (view.getId() == binding.num0.getId())
        {
            checkTextSet();
            binding.Display.setText(binding.Display.getText() + "0");
        }
        // If the 1 button is clicked, on then add the string "0" to the display
        if (view.getId() == binding.num1.getId())
        {
            checkTextSet();
            binding.Display.setText(binding.Display.getText() + "1");
        }
        // If the 2 button is clicked, on then add the string "0" to the display
        if (view.getId() == binding.num2.getId())
        {
            checkTextSet();
            binding.Display.setText(binding.Display.getText() + "2");
        }
        // If the 3 button is clicked, on then add the string "0" to the display
        if (view.getId() == binding.num3.getId())
        {
            checkTextSet();
            binding.Display.setText(binding.Display.getText() + "3");
        }
        // If the 4 button is clicked, on then add the string "0" to the display
        if (view.getId() == binding.num4.getId())
        {
            checkTextSet();
            binding.Display.setText(binding.Display.getText() + "4");
        }
        // If the 5 button is clicked, on then add the string "0" to the display
        if (view.getId() == binding.num5.getId())
        {
            checkTextSet();
            binding.Display.setText(binding.Display.getText() + "5");
        }
        // If the 6 button is clicked, on then add the string "0" to the display
        if (view.getId() == binding.num6.getId())
        {
            checkTextSet();
            binding.Display.setText(binding.Display.getText() + "6");
        }
        // If the 7 button is clicked, on then add the string "0" to the display
        if (view.getId() == binding.num7.getId())
        {
            checkTextSet();
            binding.Display.setText(binding.Display.getText() + "7");
        }
        // If the 8 button is clicked, on then add the string "0" to the display
        if (view.getId() == binding.num8.getId())
        {
            checkTextSet();
            binding.Display.setText(binding.Display.getText() + "8");
        }
        // If the 9 button is clicked, on then add the string "0" to the display
        if (view.getId() == binding.num9.getId())
        {
            checkTextSet();
            binding.Display.setText(binding.Display.getText() + "9");
        }
        if (view.getId() == binding.Decimal.getId())
        {
            checkTextSet();
            if(binding.Display.getText() == null || binding.Display.getText() == "" ){
                binding.Display.setText("0");
            }
            binding.Display.setText(binding.Display.getText() + ".");
        }









        // If the C button is clicked on, then set the display to an empty string
        else if (view.getId() == binding.opClear.getId())
        {
            value1 = Double.NaN;
            binding.Display.setText(null);
        }
        //
        else if (view.getId() == binding.opAdd.getId())
        {
            calc();
            CURRENT_ACTION = ADDITION;
            //binding.Intermediate.setText(value1 + "+");
            binding.Display.setText("+");
            textSet = true;


        }
        //
        else if (view.getId() == binding.opSub.getId())
        {

            calc();
            CURRENT_ACTION = SUBTRACTION;
            //binding.Intermediate.setText(value1 + "-");
            binding.Display.setText("-");
            textSet = true;
        }
        //
        else if (view.getId() == binding.opMulti.getId())
        {
            calc();
            CURRENT_ACTION = MULTIPLICATION;
            //binding.Intermediate.setText(value1 + "x");
            binding.Display.setText("x");
            textSet = true;
        }
        //
        else if (view.getId() == binding.opDivide.getId())
        {
            calc();
            CURRENT_ACTION = DIVISION;
            //binding.Intermediate.setText(value1 + "/");
            binding.Display.setText("/");
            textSet = true;
        }
        //
        else if (view.getId() == binding.opEqual.getId())
        {
            calc();
            binding.Display.setText(Double.toString(value1) );
            value1 = Double.NaN;
            textSet = true;
        }
    }


    private void checkTextSet(){
        if(textSet){
            binding.Display.setText(null);
            textSet = false;
        }
    }

    public void calc(){
        if (Double.isNaN(value1)) {
            value1 = Double.parseDouble(binding.Display.getText().toString());

        } else {
            value2 = Double.parseDouble(binding.Display.getText().toString());
            binding.Display.setText(null);

            if(CURRENT_ACTION == ADDITION) {
                value1 += value2;
            }
            else if(CURRENT_ACTION == SUBTRACTION) {
                value1 -= value2;
            }
            else if(CURRENT_ACTION == MULTIPLICATION) {
                value1 *= value2;
            }
            else if(CURRENT_ACTION == DIVISION) {
                value1 /= value2;
            }


        }
    }

}
