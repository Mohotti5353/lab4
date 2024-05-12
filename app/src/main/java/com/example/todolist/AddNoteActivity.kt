package com.example.todolist

import android.R
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.todolist.databinding.ActivityAddNote2Binding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNote2Binding
    private lateinit var db :NoteDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNote2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)



        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()

            val note = Note(0, title, content)
            db.insertNote(note)
            finish()
            Toast.makeText(this, "Note saved", Toast.LENGTH_SHORT).show()
        }
    }
}
