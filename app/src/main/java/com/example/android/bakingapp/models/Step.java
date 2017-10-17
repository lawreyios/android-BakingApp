package com.example.android.bakingapp.models;

/**
 * Created by Lawrey on 17/10/17.
 */

public class Step {
    int stepId;
    String shortDescription;
    String description;
    String videoURL;
    String thumbnailURL;

    public Step(int stepId, String shortDescription, String description, String videoURL, String thumbnailURL) {
        this.stepId = stepId;
        this.shortDescription = shortDescription;
        this.description = description;
        this.videoURL = videoURL;
        this.thumbnailURL = thumbnailURL;
    }
}