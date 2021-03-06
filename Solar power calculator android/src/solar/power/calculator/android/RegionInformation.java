package solar.power.calculator.android;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.*;

public class RegionInformation extends Activity {
	public final static String EXTRA_MESSAGE = "solar.power.calculator.android.MESSAGE";

	/*
	 * sorta need them here, sorta dont, not sure yet.
	 */
	Button calc;
	EditText lat, year;
	
	/*
	 * (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);       
    }
	
	public void calculate(View view){
		//Grab the values from the input box's
		lat  = (EditText)findViewById(R.id.entLat);
        year = (EditText)findViewById(R.id.entYears);
        //Instantiate the InsolationCalculation class
        InsolationCalculation calcu = new InsolationCalculation();
        //Calculate the insolation, The text values had to be parsed as doubles and ints.
		double tot = calcu.TotalSolarInsolation(Double.parseDouble(lat.getText().toString()), 
				Integer.parseInt(year.getText().toString()));
		//Create a new intent
		Intent intent = new Intent(this, Displayresults.class);
		//Pass the Double as a string to the new intent.
		intent.putExtra(EXTRA_MESSAGE, Double.toString(tot));
		//Start the activity
		startActivity(intent);
	}
}
