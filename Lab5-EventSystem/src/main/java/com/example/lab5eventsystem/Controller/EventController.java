package com.example.lab5eventsystem.Controller;

import com.example.lab5eventsystem.API.ApiResponse;
import com.example.lab5eventsystem.Model.Event;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
    ArrayList<Event> events =new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Event> getEvent(){
        return events;
    }

    @PostMapping("/add")
    public ApiResponse addEvent(@RequestBody Event event){
        events.add(event);
        return new ApiResponse(" The Event Is Added Successfully") ;
    }

    @PutMapping("/update/event/{index}")
    public ApiResponse updateEvent(@PathVariable int index,@RequestBody Event event){
        events.set(index,event);
        return new ApiResponse(" The Event Is Updated Successfully") ;
    }

    @DeleteMapping("/delete/event/{index}")
    public ApiResponse deleteEvent(@PathVariable int index){
        events.remove(index);
        return new ApiResponse(" The Event Is Deleted Successfully") ;
    }

    @PutMapping("/update/event/capacity/{index}/{capacity}")
    public ApiResponse updateCapacity(@PathVariable int index,@PathVariable int capacity){
        events.get(index).setCapacity(capacity);
        return new ApiResponse(" The Event Is Updated Successfully");
    }

    @GetMapping("/get/id/{id}")
    public ApiResponse getEventById(@PathVariable String id){
        for(Event e:events){
            if(e.getId().equalsIgnoreCase(id)){
                return new ApiResponse(" The Event of "+e.getId()+ " Is Found Successfully");
            }
        }
        return new ApiResponse(" ");
    }
}
