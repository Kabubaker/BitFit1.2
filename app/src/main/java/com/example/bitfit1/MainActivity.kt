package com.example.bitfit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfit1.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    val sleepData = mutableListOf<DisplaySleepData>()
    private lateinit var sleepRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eType = findViewById<EditText>(R.id.typeET)
        val eFeel = findViewById<EditText>(R.id.feelingET)
        val eReason = findViewById<EditText>(R.id.reasonET)
        val eHours = findViewById<EditText>(R.id.hourET)
        val btn = findViewById<Button>(R.id.btnE)

        sleepRV = findViewById(R.id.mainRv)
        val adapter = SleepAdapter(sleepData)

        sleepRV.adapter = adapter
        sleepRV.layoutManager = LinearLayoutManager(this)
        adapter.notifyDataSetChanged()

        var divider:DividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        sleepRV.addItemDecoration(divider)

        lifecycleScope.launch {
            (application as SleepApplication).db.sleepDao().getAll().collect { databaseList ->
                databaseList.map { entity ->
                    DisplaySleepData(
                        entity.typeEnt,
                        entity.feelingEnt,
                        entity.hoursEnt,
                        entity.reasonEnt
                    )
                }.also { mappedList ->
                    sleepData.clear()
                    sleepData.addAll(mappedList)
                    adapter.notifyDataSetChanged()
                }
            }
        }

        btn.setOnClickListener {
            val userList = DisplaySleepData(
                eType.text.toString(),
                eFeel.text.toString(),
                eHours.text.toString().toDouble(),
                eReason.text.toString()
            )

            sleepData.add(userList)
            adapter.notifyItemInserted(sleepData.size)

            lifecycleScope.launch(Dispatchers.IO) {
                (application as SleepApplication).db.sleepDao().deleteAll()
                (application as SleepApplication).db.sleepDao().insert(sleepData.map {
                    SleepEntity(
                        typeEnt = it.typeSleep,
                        feelingEnt = it.feelingSleep,
                        hoursEnt = it.hoursSleep,
                        reasonEnt = it.reasonSleep
                    )
                })
            }
            adapter.notifyDataSetChanged()

        }


    }
}