package com.example.eventlistmvvm;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.eventlistmvvm.roomdb.Event;

import java.util.List;

public class EventListViewModel extends ViewModel {
    private MutableLiveData<List<Event>> eventData;
    private EventRepository repo;

    public void init(Context context) {
        if (eventData == null){
            eventData = new MutableLiveData<>();
        }

        repo = EventRepository.getInstance(context);
        eventData.setValue(repo.getEvents());
    }

    public MutableLiveData<List<Event>> getEvents(){
        eventData.setValue(repo.getEvents());
        return eventData;
    }
}
