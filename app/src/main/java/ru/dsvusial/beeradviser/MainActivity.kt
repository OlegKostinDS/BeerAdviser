package ru.dsvusial.beeradviser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val findBeer = findViewById<Button>(R.id.find_beer)
        val brands = findViewById<TextView>(R.id.brands)
        val beerColor = findViewById<Spinner>(R.id.beer_color)
        findBeer.setOnClickListener {
val beerList = getBeers(beerColor.selectedItem.toString())
            val beers =
                beerList.reduce{str, item -> str + '\n' + item}
            brands.text = beers

        }
    }

    fun getBeers (color: String) : List<String>{
        return when (color){
            "Light" -> listOf("Jail Pale Ale", "Lager")
            "Amber" -> listOf("Jack Amber", "Red Mouse")
            "Brown" -> listOf("Brown beer", "Bock Brownie")
            else -> listOf("Gout Stout", "Dark Daniel")
        }
    }
}