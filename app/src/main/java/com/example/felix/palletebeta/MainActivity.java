package com.example.felix.palletebeta;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void palleteOpen (View v)
    {
        // Adding The necessary components the quick action
        QuickAction q = new QuickAction(this, QuickAction.VERTICAL);
        ActionItem ac = new ActionItem();
        ac.setTitle("Red\nGreen\nBlue\nBlack\n");
        q.addActionItem(ac);


        // The Following is setiing up a on clikc listener for the quick action. This will enable it to pop up
        q.setOnActionItemClickListener(new QuickAction.OnActionItemClickListener()
        {
            @Override
            public void onItemClick(QuickAction source, int pos, int actionId)
            {
                if (pos == 0) {
                    Toast.makeText(MainActivity.this, "Add Item Selected", Toast.LENGTH_SHORT).show();
                } else if (pos == 1) {
                    Toast.makeText(MainActivity.this, "Something Selected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "NOTHING?", Toast.LENGTH_LONG).show();
                }
            }
        });
        // addAction.setIcon(getResources().getDrawable(R.drawable.ic));
        q.show(v);



    }


}
