package sg.edu.rp.c346.id22021136.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {
    TextView myLocalBank;
    TextView dbs;
    TextView ocbc;
    TextView uob;
    ToggleButton TBlanguage;

    String wordClicked = "";
    boolean isEnglish = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myLocalBank = findViewById(R.id.textViewHeader);
        dbs = findViewById(R.id.tvDBS);
        ocbc = findViewById(R.id.tvOCBC);
        uob = findViewById(R.id.tvUOB);
        TBlanguage = findViewById(R.id.tbLanguage);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);

        TBlanguage.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    switchToChi();
                } else {
                    switchToEng();
                }
            }
        });
    }

    private void switchToChi() {
        dbs.setText("星展银行");
        ocbc.setText("华侨银行");
        uob.setText("大华银行");
        myLocalBank.setText("我的本地银行");
        isEnglish = false;
        Toast.makeText(this, "Language switched to Chinese", Toast.LENGTH_SHORT).show();
    }

    private void switchToEng() {
        dbs.setText("DBS");
        ocbc.setText("OCBC");
        uob.setText("UOB");
        myLocalBank.setText("My Local Bank");
        isEnglish = true;
        Toast.makeText(this, "Language switched to English", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact The Bank");

        if (v==dbs)
        {
            wordClicked="dbs";
        }else if (v==ocbc)
        {
            wordClicked="ocbc";
        }else if (v==uob)
        {
            wordClicked="uob";
        }

    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId()==0) {
                Intent intent=new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId()==1) {
                Intent intentCall=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800111111));
                startActivity(intentCall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc"))
        {
            if (item.getItemId()==0) {
                Intent intent=new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;
            } else if (item.getItemId()==1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800363333));
                startActivity(intentCall);
                return true;
            }
        }
        else if (wordClicked.equalsIgnoreCase("uob"))
        {
            if (item.getItemId()==0) {
                Intent intent=new Intent(Intent. ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;
            } else if (item.getItemId()==1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+1800222212));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }
}


