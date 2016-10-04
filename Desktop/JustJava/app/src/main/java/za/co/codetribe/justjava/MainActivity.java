package za.co.codetribe.justjava;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity
   { int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
       public void submitOrder(View view)
       {
           CheckBox whippedCreamCkeckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
           boolean hasWhippedCream = whippedCreamCkeckBox.isChecked();

           EditText nameField = (EditText) findViewById(R.id.name_field);
           String name = nameField.getText().toString();

           CheckBox chocolateCkeckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
           boolean hasChocolate = chocolateCkeckBox.isChecked();

           int price = calcualtePrice( hasWhippedCream, hasChocolate);
           String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);


           Intent intent = new Intent(Intent.ACTION_SENDTO);
           intent.setData(Uri.parse("mailto:")); //only emails should handle this
           intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order Summary for " + name);
           intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
           if (intent.resolveActivity(getPackageManager()) != null)
           {
               startActivity(intent);
           }

   }

    public void increment(View view)
    {
        if(quantity == 100)
        {
            Toast.makeText(this, "You cannot have more than 100 coffee", Toast.LENGTH_LONG).show();
            return;
        }

        quantity = quantity + 1;
        display(quantity);

    }

    public void decrement(View view)
    {
        if(quantity == 1)
        {
            Toast.makeText(this, "You cannot have less than 1 coffees", Toast.LENGTH_LONG).show();
            return;
        }

        quantity = quantity - 1;

        display(quantity);

    }



    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


    private String createOrderSummary(String name, int price, boolean hasWhippedCream, boolean hasChocolate)
    {
        String priceMessage = "Name: " + name;
        priceMessage = priceMessage + "\nAdd whipped cream?: " + hasWhippedCream;
        priceMessage += "\nAdd whipped cream?: " + hasChocolate;
        priceMessage = priceMessage + "\nQuantity: " + quantity;
        priceMessage = priceMessage + "\nTotal: $" + price;
        priceMessage = priceMessage + "\nThank You!";

        return priceMessage;

    }

    public int calcualtePrice( boolean addWhippedCream, boolean addChocolate)
    {
        int basePrice = 5;

        if (addWhippedCream)
        {
            basePrice += 1;
        }

        if (addChocolate)
        {
            basePrice += 2;
        }

        return  quantity * basePrice;
    }
}
