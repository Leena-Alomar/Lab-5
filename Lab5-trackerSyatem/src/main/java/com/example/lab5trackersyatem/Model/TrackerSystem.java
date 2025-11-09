package com.example.lab5trackersyatem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TrackerSystem {
    private String id;
    private String title;
    private String description;
    private boolean status;
    private String companyName;

}
