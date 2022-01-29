package com.example.myapplication.learnlang.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.learnlang.R
import com.example.myapplication.learnlang.recyclerView.CustomAdapter
import com.example.myapplication.learnlang.recyclerView.ItemsViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlin.random.Random


class LessonFragment : Fragment() {

    val TAG: String = "MY DATA :::\t"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_lesson, container, false)

        // getting the recyclerview by its id
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)
        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(context)


        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE
        recyclerview.visibility = View.GONE

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // Write a message to the database
        // Write a message to the database
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("array")

       // myRef.setValue("Hello, World!!!!!!!!!!!")

        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.value
                Log.d(TAG, "Value is: $value")

                for (postSnapshot in dataSnapshot.children) {
                    Log.d(TAG, "Value is: $postSnapshot")

                    data.add(ItemsViewModel(
                        postSnapshot.value as String,
                        Random.nextInt(0, 70),
                        Random.nextInt( 70, 100)
                    ))
                }

                // This will pass the ArrayList to our Adapter
                val adapter = CustomAdapter(data)
                adapter.setOnItemClickListener(object : CustomAdapter.OnItemClickListener {
                    override fun onItemClick(pos: Int) {
                        Toast.makeText(context, pos.toString(), Toast.LENGTH_SHORT).show()
                    }

                })

                // Setting the Adapter with the recyclerview
                recyclerview.adapter = adapter

                progressBar.visibility = View.GONE
                recyclerview.visibility = View.VISIBLE
            }//

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException())
            }
        })

        // Inflate the layout for this fragment
        return view
    }
}