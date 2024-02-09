package gr313.ladvinskiy.lab04;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox[] chk = new CheckBox[4];
    EditText[] num = new EditText[4];
    EditText[] price = new EditText[4];
    RadioButton rbutToast;
    RadioButton rbutDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onCalc(View v){
        try {
            num[0] = findViewById(R.id.txtApple);
            num[1] = findViewById(R.id.txtStrawbberry);
            num[2] = findViewById(R.id.txtBlueberry);
            num[3] = findViewById(R.id.txtPotatoes);

            chk[0] = findViewById(R.id.chkApple);
            chk[1] = findViewById(R.id.chkStrawberry);
            chk[2] = findViewById(R.id.chkBlueberry);
            chk[3] = findViewById(R.id.chkPotatoes);

            price[0] = findViewById(R.id.prcApple);
            price[1] = findViewById(R.id.prcStrawberry);
            price[2] = findViewById(R.id.prcBlueberry);
            price[3] = findViewById(R.id.prcPotatoes);

            rbutDialog = findViewById(R.id.rbDialog);
            rbutToast = findViewById(R.id.rbToast);

            String rep = "";
            float sum = 0.0f;
            for (int i = 0; i < chk.length; i++){
                if (chk[i].isChecked()){
                    int q = Integer.parseInt(num[i].getText().toString());
                    float p = Float.parseFloat(price[i].getText().toString());
                    float val = q * p;
                    if (q>0 && p>0){
                        sum += val;
                        rep += String.format("%d: %d x %s = %d x %.2f = %.2f\n", i,q,chk[i].getText().toString(), q, p,val);
                    }
                    else {
                        Toast.makeText(this, "Вы не можете покупать отрицательное или нулевое количество товаров", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            rep += String.format("total - %.2f", sum);
            if (rbutToast.isChecked() && sum != 0){
                Toast.makeText(this, rep, Toast.LENGTH_SHORT).show();

            }
            if (rbutDialog.isChecked() && sum != 0){
                AlertDialog.Builder bld = new AlertDialog.Builder(this);
                AlertDialog dig = bld.create();
                dig.setTitle("Result");
                dig.setIcon(R.drawable.myicon);
                dig.setMessage(rep);
                dig.show();
            }

        }
        catch (Exception ignored){
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        }

    }
}