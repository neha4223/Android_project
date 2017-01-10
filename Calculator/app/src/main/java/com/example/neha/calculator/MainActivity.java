package com.example.neha.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    private Button btnadd,btnOne,btnTwo,btnThree,btnFour,btnFive,btnSix,
            btnSeven, btneight,btnNine,btnZero,btndot, btnequals,btnSubtract,btnMul,btnDiv;
    private TextView txtOperands, txtResult;

    private int operand1, operand2, result, operation;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubtract=(Button)findViewById(R.id.btnSub);
        btnMul=(Button)findViewById(R.id.btnMul);
        btnDiv=(Button)findViewById(R.id.btnDiv);
        btnadd=(Button)findViewById(R.id.btnadd);
        btnOne=(Button)findViewById(R.id.btnOne);
        btnTwo=(Button)findViewById(R.id.btnTwo);
        btnThree=(Button)findViewById(R.id.btnThree);
        btnFour=(Button)findViewById(R.id.btnFour);
        btnFive=(Button)findViewById(R.id.btnFive);
        btnSix=(Button)findViewById(R.id.btnSix);
        btnSeven=(Button)findViewById(R.id.btnSeven);
        btneight=(Button)findViewById(R.id.btneight);
        btnNine=(Button)findViewById(R.id.btnNine);
        btnZero=(Button)findViewById(R.id.btnZero);
        btndot=(Button)findViewById(R.id.btnDot);
        btnequals=(Button)findViewById(R.id.btnequls);
        txtOperands=(TextView)findViewById(R.id.txtOperands);
        txtResult=(TextView)findViewById(R.id.txtAnswer);

        btnOne.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtOperands.setText(txtOperands.getText() + "1");
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtOperands.setText(txtOperands.getText() + "2");
            }
        });
        btnThree.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtOperands.setText(txtOperands.getText() + "3");
            }
        });
        btnFour.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtOperands.setText(txtOperands.getText() + "4");
            }
        });
        btnFive.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtOperands.setText(txtOperands.getText() + "5");
            }
        });
        btnSix.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtOperands.setText(txtOperands.getText() + "6");
            }
        });
        btnSeven.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtOperands.setText(txtOperands.getText() + "7");
            }
        });

        btneight.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                txtOperands.setText(txtOperands.getText() + "8");
            }
        });
        btnNine.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtOperands.setText(txtOperands.getText() + "9");
            }
        });
        btnZero.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtOperands.setText(txtOperands.getText() + "0");
            }
        });
        btndot.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txtOperands.setText(txtOperands.getText() + ".");
            }
        });



        btnadd.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String tempOp1 = txtOperands.getText().toString();
                operand1 = Integer.parseInt(tempOp1);

                txtOperands.setText("0"); // Clear the txtOperands
                operation = 1;
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String tempOp1 = txtOperands.getText().toString();
                operand1 = Integer.parseInt(tempOp1);

                txtOperands.setText("0"); // Clear the txtOperands
                operation = 2;
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String tempOp1 = txtOperands.getText().toString();
                operand1 = Integer.parseInt(tempOp1);

                txtOperands.setText("0"); // Clear the txtOperands
                operation = 3;
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String tempOp1 = txtOperands.getText().toString();
                operand1 = Integer.parseInt(tempOp1);

                txtOperands.setText("0"); // Clear the txtOperands
                operation = 4;
            }
        });


        btnequals.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String tempOp2 = txtOperands.getText().toString();
                operand2 = Integer.parseInt(tempOp2);

                if (operation == 1)
                {
                    // Addition
                    result = operand1 + operand2;
                    txtResult.setText("" + result);
                    txtOperands.setText(operand1 + " + " + operand2);
                }
                else if (operation == 2)
                {
                    // sub
                    result = operand1 - operand2;
                    txtResult.setText("" + result);
                    txtOperands.setText(operand1 + " - " + operand2);

                }
                else if (operation == 3)
                {
                    // mul
                    result = operand1 * operand2;
                    txtResult.setText("" + result);
                    txtOperands.setText(operand1 + " * " + operand2);

                }
                else if (operation == 4)
                {
                    // div
                    result = operand1 / operand2;
                    txtResult.setText("" + result);
                    txtOperands.setText(operand1 + " / " + operand2);

                }
            }
        });
    }
}
