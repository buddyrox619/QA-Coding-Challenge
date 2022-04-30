package com.mobiquity.jsonplaceholder.config;

public class RelativeURI {

    public static final String GET_POST_DETAILS = "/posts";
    public static final String GET_POST_COMMENTS = "/posts/{PostID}/comments";
    public static final String GET_USER_ALBUMS = "/users/{UserId}/albums";
    public static final String GET_USER_TODOS = "/users/{UserId}/todos";
    public static final String GET_ALL_USERS = "/users";
    public static final String UPDATE_COMMENT = "/comments/{CommentID}";
    public static final String DELETE_COMMENT = "/posts/comments?id={CommentID}";
    public static final String GET_ALL_COMMENTS= "/comments";
}
