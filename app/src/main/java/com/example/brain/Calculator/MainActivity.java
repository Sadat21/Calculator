package com.example.brain.Calculator;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ExpandedMenuView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.brain.Calculator.databinding.ActivityMainBinding;

// TODO: Add Android app icon
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9, point;
    private Button opClear, opDivide, opMulti, opSub, opAdd, opEqual;
    private TextView Display, Work;
    private TextView Intermediate;
    private ActivityMainBinding binding;

    /**
     * Value stored to be displayed
     */
    private double value1 = Double.NaN;
    private double value2 = Double.NaN;


    private boolean textSet = false;
    private boolean negative = false;
    boolean equal = true;

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';

    private static String negativeTemp;

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
        binding.PlusMinus.setOnClickListener(this);

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
        if (view.getId() == binding.PlusMinus.getId())
        {

            checkTextSet();
            if(binding.Display.getText() == null || binding.Display.getText() == ""){
                return;
            }
            else if(!negative){
                negativeTemp = binding.Display.getText().toString();
                binding.Display.setText( "-" + binding.Display.getText());
                negative = true;

            }
            else {
                binding.Display.setText(negativeTemp);
                negative = false;
            }


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
            if(!calc()){
                return;
            }
            CURRENT_ACTION = ADDITION;
            binding.Work.setText(value1 + " + ");
            //binding.Display.setText("+");
            textSet = true;


        }
        //
        else if (view.getId() == binding.opSub.getId())
        {

            if(!calc()){
                return;
            }
            CURRENT_ACTION = SUBTRACTION;
            binding.Work.setText(value1 + " - ");
            //binding.Display.setText("-");
            textSet = true;
        }
        //
        else if (view.getId() == binding.opMulti.getId())
        {
            if(!calc()){
                return;
            }
            CURRENT_ACTION = MULTIPLICATION;
            binding.Work.setText(value1 + " x ");
            //binding.Display.setText("x");
            textSet = true;
        }
        //
        else if (view.getId() == binding.opDivide.getId())
        {
            if(!calc()){
                return;
            }
            CURRENT_ACTION = DIVISION;
            binding.Work.setText(value1 + " / ");
            //binding.Display.setText("/");
            textSet = true;
        }
        //
        else if (view.getId() == binding.opEqual.getId())
        {
            if(!equal && !(Double.isNaN(value1))) {
                if(!calc()){
                    return;
                }
                String temp = binding.Work.getText().toString();
                binding.Work.setText(null);
                binding.Work.setText(temp + value2 + " = " + value1);
                binding.Display.setText(Double.toString(value1));
                value1 = Double.NaN;
                value2 = Double.NaN;
                textSet = true;
                equal = true;
            }
        }
    }


    private void checkTextSet(){
        equal = false;
        if(textSet){
            binding.Display.setText(null);
            textSet = false;
        }
    }

    public boolean calc(){
        negative = false;
        equal = false;
        if (Double.isNaN(value1)) {
            try {
                value1 = Double.parseDouble(binding.Display.getText().toString());
                binding.Display.setText(null);
            }
            catch (Exception e){
                e.printStackTrace();
                return false;
            }

        }
        else {
            try {
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
            catch (Exception e){
                e.printStackTrace();
                return false;
            }

        }
        return true;
    }

}
