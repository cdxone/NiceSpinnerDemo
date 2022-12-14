package com.cdx.nicespinnerdemo

import android.os.Bundle
import android.text.SpannableString
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.angmarch.views.NiceSpinner
import org.angmarch.views.OnSpinnerItemSelectedListener
import org.angmarch.views.SpinnerTextFormatter
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDefault()
        setupTintedWithCustomClass()
        setupXml()
    }

    private fun setupXml() {
        val spinner = findViewById<NiceSpinner>(R.id.niceSpinnerXml)
        spinner.onSpinnerItemSelectedListener =
            OnSpinnerItemSelectedListener { parent, view, position, id ->
                val item = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, "Selected: $item", Toast.LENGTH_SHORT).show()
            }
    }

    private fun setupTintedWithCustomClass() {
        val spinner = findViewById<NiceSpinner>(R.id.tinted_nice_spinner)
        val people: MutableList<Person> = ArrayList()
        people.add(Person("Tony", "Stark"))
        people.add(Person("Steve", "Rogers"))
        people.add(Person("Bruce", "Banner"))
        people.add(Person("Tony", "Stark"))
        people.add(Person("Steve", "Rogers"))
        people.add(Person("Bruce", "Banner"))
        people.add(Person("Tony", "Stark"))
        people.add(Person("Steve", "Rogers"))
        people.add(Person("Bruce", "Banner"))
        val textFormatter: SpinnerTextFormatter<*> =
            SpinnerTextFormatter<Person> { person -> SpannableString(person.name + " " + person.surname) }
        spinner.setSpinnerTextFormatter(textFormatter)
        spinner.setSelectedTextFormatter(textFormatter)
        spinner.onSpinnerItemSelectedListener =
            OnSpinnerItemSelectedListener { parent, view, position, id ->
                val person = spinner.selectedItem as Person
                Toast.makeText(this@MainActivity, "Selected: $person", Toast.LENGTH_SHORT).show()
            }
        spinner.attachDataSource(people)
    }

    private fun setupDefault() {
        val spinner = findViewById<NiceSpinner>(R.id.nice_spinner)
        val dataset: List<String> = LinkedList(
            Arrays.asList(
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "One",
                "Two",
                "Three",
                "Four",
                "Five",
                "One",
                "Two",
                "Three",
                "Four",
                "Five"
            )
        )
        spinner.attachDataSource(dataset)
        spinner.onSpinnerItemSelectedListener =
            OnSpinnerItemSelectedListener { parent, view, position, id ->
                val item = parent.getItemAtPosition(position).toString()
                Toast.makeText(this@MainActivity, "Selected: $item", Toast.LENGTH_SHORT).show()
            }
    }
}

internal class Person(val name: String, val surname: String) {

    override fun toString(): String {
        return "$name $surname"
    }
}