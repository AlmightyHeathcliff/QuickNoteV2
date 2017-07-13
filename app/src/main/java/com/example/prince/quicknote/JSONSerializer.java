package com.example.prince.quicknote;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Prince on 22-06-2017. ch15
 */

public class JSONSerializer {

    private String mFilename;   //file where data will be stored
    private Context mContext;    //we need a context while saving data using file




    public JSONSerializer(String f,Context c){
        mFilename=f;
        mContext=c;
    }

    public void save(List<Note> notes) throws IOException,JSONException{

        JSONArray JArray = new JSONArray();     //350

        for(Note n: notes)
            JArray.put(n.convertToJSON());

        //write to private disk
        Writer writer=null;
        try{
            OutputStream out=mContext.openFileOutput(mFilename,mContext.MODE_PRIVATE);
            writer=new OutputStreamWriter(out);
            writer.write(JArray.toString());
        }finally{if(writer!=null)writer.close();}


    }





    public ArrayList<Note> load() throws IOException,JSONException{

    ArrayList<Note> noteList=new ArrayList<Note>();

        BufferedReader reader=null;

        try{

            InputStream in=mContext.openFileInput(mFilename);
            reader=new BufferedReader(new InputStreamReader((in)));
            StringBuilder jsonString=new StringBuilder();
            String line=null;

            while((line=reader.readLine())!=null){
                    jsonString.append(line);
            }
            JSONArray JArray= (JSONArray) new JSONTokener(jsonString.toString()).nextValue(); //?

            for(int i=0;i<JArray.length();i++){
                noteList.add(new Note(JArray.getJSONObject(i)));

            }

        }catch(FileNotFoundException e){//start fresh}

        } finally{
            if(reader!=null)
                reader.close();}


return noteList;

    }

}
