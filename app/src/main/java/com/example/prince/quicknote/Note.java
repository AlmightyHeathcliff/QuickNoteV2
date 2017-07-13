package com.example.prince.quicknote;


import org.json.JSONException;
import org.json.JSONObject;

public class Note {
    private String mDescription;
    private boolean mIdea;
    private boolean mImportant;
    private String mTitle;
    private boolean mTodo;

    public static final String JSON_TITLE="title";
    public static final String JSON_DESCRIPTION="description";
    public static final String JSON_IDEA="idea";
    public static final String JSON_TODO="todo";
    public static final String JSON_IMPORTANT="important";

    public Note(){}

    public Note(JSONObject jo) throws JSONException {       //object members packed as a single object
    mTitle=jo.getString(JSON_TITLE);
        mDescription=jo.getString(JSON_DESCRIPTION);
        mIdea=jo.getBoolean(JSON_IDEA);
        mTodo=jo.getBoolean(JSON_TODO);
        mImportant=jo.getBoolean(JSON_IMPORTANT);
    }


    public JSONObject convertToJSON() throws JSONException {

        JSONObject jo = new JSONObject();
        jo.put(JSON_TITLE, mTitle);
        jo.put(JSON_DESCRIPTION, mDescription);
        jo.put(JSON_IDEA, mIdea);
        jo.put(JSON_IMPORTANT, mImportant);
        jo.put(JSON_TODO, mTodo);

        return jo;
    }





    public String getTitle() {
        return this.mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public boolean isIdea() {
        return this.mIdea;
    }

    public void setIdea(boolean mIdea) {
        this.mIdea = mIdea;
    }

    public boolean isTodo() {
        return this.mTodo;
    }

    public void setTodo(boolean mTodo) {
        this.mTodo = mTodo;
    }

    public boolean isImportant() {
        return this.mImportant;
    }

    public void setImportant(boolean mImportant) {
        this.mImportant = mImportant;
    }
}

