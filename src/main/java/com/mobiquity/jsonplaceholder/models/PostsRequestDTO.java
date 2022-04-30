package com.mobiquity.jsonplaceholder.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostsRequestDTO {

    private String title;
    private String body;
    private int userId;

}
