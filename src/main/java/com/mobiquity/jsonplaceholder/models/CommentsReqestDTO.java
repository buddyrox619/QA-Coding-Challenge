package com.mobiquity.jsonplaceholder.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentsReqestDTO {

    private String name;
    private String email;
    private String body;
}
