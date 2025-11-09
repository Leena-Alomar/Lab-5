package com.example.lab5trackersyatem.Controller;
import java.util.ArrayList;

import com.example.lab5trackersyatem.API.ApiResponse;
import com.example.lab5trackersyatem.Model.TrackerSystem;
import org.springframework.web.bind.annotation.*;
import javax.annotation.processing.Generated;

@RestController
@RequestMapping("/api/v1/tracker")
public class TrackerSystemController {
    ArrayList<TrackerSystem> trackers =new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<TrackerSystem> getTracker(){
        return trackers;
    }

    @PostMapping("/add")
    public ApiResponse addTracker(@RequestBody TrackerSystem tracker){
        trackers.add(tracker);
        return new ApiResponse(" The Project System Is Added Successfully");
    }

    @PutMapping("/update/tracker/{index}")
    public ApiResponse updateTracker(@PathVariable int index,@RequestBody TrackerSystem tracker){
        trackers.set(index,tracker);
        return new ApiResponse(" The Project Is Updated Successfully") ;
    }

    @DeleteMapping("/delete/tracker/{index}")
    public ApiResponse deleteTracker(@PathVariable int index){
        trackers.remove(index);
        return new ApiResponse(" The Project Is Updated Successfully") ;
    }

    @PutMapping("/update/status/{index}")
    public ApiResponse updateStatus(@PathVariable int index){
        boolean notStatus=trackers.get(index).isStatus();
        trackers.get(index).setStatus(!notStatus);
        return new ApiResponse(" The Status Is Updated Successfully") ;
    }

    @GetMapping("/get/title/{title}")
    public ApiResponse getTitle(@PathVariable String title){
        for(TrackerSystem tr: trackers){
            if(tr.getTitle().equalsIgnoreCase(title)){
                return new ApiResponse("The Title: "+tr.getTitle()+" Is Found !") ;
            }
        }
        return new ApiResponse(" ");
    }

    @GetMapping("/get/company/{companyName}")
    public ApiResponse getCompanyName(@PathVariable String companyName){
        for(TrackerSystem t: trackers){
            if(t.getCompanyName().equalsIgnoreCase(companyName)){
                return new ApiResponse("The Company Name: "+t.getCompanyName()+" Is Found !");
            }
        }
        return new ApiResponse(" ");
    }
}
