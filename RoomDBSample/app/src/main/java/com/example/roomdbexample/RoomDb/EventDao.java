package com.example.roomdbexample.RoomDb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EventDao {
    @Query("SELECT * FROM event")
    List<Event> getAllEvents();

    @Insert
    void insertEvent(Event event);

    @Delete
    void deleteEvent(Event event);
}
