package com.example.roomdbexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.roomdbexample.RoomDb.Event;
import com.example.roomdbexample.RoomDb.EventDao;
import com.example.roomdbexample.RoomDb.EventDb;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private ListView eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, CreateEventActivity.class);
        FloatingActionButton fab = findViewById(R.id.add_event_btn);
        fab.setOnClickListener((view) -> startActivity(intent));
        eventList = findViewById(R.id.event_list);
    }

    @Override
    protected void onResume() {
        super.onResume();
        EventDb db = Room.databaseBuilder(getApplicationContext(),
                EventDb.class, EventDb.DATABASE_NAME).allowMainThreadQueries().build();

        EventDao dao = db.eventDao();
        ArrayAdapter<Event> adapter = new EventListAdapter(getApplicationContext(), dao.getAllEvents());
        eventList.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = new Intent(this, CreateEventActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
}