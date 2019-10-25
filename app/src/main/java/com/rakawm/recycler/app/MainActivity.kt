package com.rakawm.recycler.app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()
        initButtons()
    }

    private fun initRecycler() {
        data_container.layoutManager = LinearLayoutManager(this)
        val adapter = UserDataAdapter()
            .apply {
                setData(generateDummyData())
            }

        data_container.adapter = adapter
    }

    private fun generateDummyData(): MutableList<UserData> {
        return mutableListOf(
            UserData(
                id = UUID.randomUUID().toString(),
                name = "User 1",
                university = "Universitas Gadjah Mada",
                dateOfBirthFormatted = "21 Januari 1981",
                shortBio = getString(R.string.sample_lorem_ipsum)
            ),
            UserData(
                id = UUID.randomUUID().toString(),
                name = "User 2",
                university = "Universitas Indonesia",
                dateOfBirthFormatted = "21 Januari 1982",
                shortBio = getString(R.string.sample_lorem_ipsum)
            ),
            UserData(
                id = UUID.randomUUID().toString(),
                name = "User 3",
                university = "Institut Teknologi Bandung",
                dateOfBirthFormatted = "21 Januari 1983",
                shortBio = getString(R.string.sample_lorem_ipsum)
            )
        )
    }

    private fun initButtons() {
        grid_button.setOnClickListener {
            useGrid()
        }

        linear_button.setOnClickListener {
            useLinear()
        }
    }

    private fun useGrid() {
        data_container.layoutManager = GridLayoutManager(this, COLUMN_COUNT)
        linear_button_checked.visibility = View.INVISIBLE
        grid_button_checked.visibility = View.VISIBLE
    }

    private fun useLinear() {
        data_container.layoutManager = LinearLayoutManager(this)
        grid_button_checked.visibility = View.INVISIBLE
        linear_button_checked.visibility = View.VISIBLE
    }

    companion object {
        private const val COLUMN_COUNT = 2
    }
}