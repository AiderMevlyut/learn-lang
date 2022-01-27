package com.example.myapplication.learnlang.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.myapplication.learnlang.R
import com.example.myapplication.learnlang.fragments.LessonFragment
import com.example.myapplication.learnlang.fragments.RuleFragment
import com.example.myapplication.learnlang.fragments.SettingsFragment
import com.example.myapplication.learnlang.fragments.StatisticsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        supportFragmentManager.commit {
            add<LessonFragment>(R.id.fragmentContainerView)
            setReorderingAllowed(true)
            addToBackStack("name") // name can be null
        }

        // рабочий варик с дипрекейтед методом
        var bottomNavigation: BottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.item_lessons -> {
                    // Respond to navigation item 1 reselection
                    println("item 1")
                    Toast.makeText(this, "item_lessons", Toast.LENGTH_SHORT).show()

                    supportFragmentManager.commit {
                        replace<LessonFragment>(R.id.fragmentContainerView)
                        setReorderingAllowed(true)
                        addToBackStack("name") // name can be null
                    }
                }
                R.id.item_rule -> {
                    // Respond to navigation item 2 reselection
                    println("item 1")
                    Toast.makeText(this, "item_rule", Toast.LENGTH_SHORT).show()

                    supportFragmentManager.commit {
                        replace<RuleFragment>(R.id.fragmentContainerView)
                        setReorderingAllowed(true)
                        addToBackStack("name") // name can be null
                    }
                }
                R.id.item_statistics -> {
                    // Respond to navigation item 1 reselection
                    println("item 1")
                    Toast.makeText(this, "item_statistics", Toast.LENGTH_SHORT).show()

                    supportFragmentManager.commit {
                        replace<StatisticsFragment>(R.id.fragmentContainerView)
                        setReorderingAllowed(true)
                        addToBackStack("name") // name can be null
                    }
                }
                R.id.item_settings -> {
                    // Respond to navigation item 2 reselection
                    println("item 1")
                    Toast.makeText(this, "item_settings", Toast.LENGTH_SHORT).show()

                    supportFragmentManager.commit {
                        replace<SettingsFragment>(R.id.fragmentContainerView)
                        setReorderingAllowed(true)
                        addToBackStack("name") // name can be null
                    }
                }
            }
            true
        }
    }
}