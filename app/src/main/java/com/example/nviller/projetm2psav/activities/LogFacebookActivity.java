package com.example.nviller.projetm2psav.activities;


/**
 * Created by nviller on 06/03/2018.
 */

/* Pour la connexion à Facebook */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.nviller.projetm2psav.R;
import com.example.nviller.projetm2psav.adapter.CustomAdapter;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.ProfileTracker;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class LogFacebookActivity extends AppCompatActivity {
    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private AccessToken accessToken;
    private ProfileTracker profileTracker;
    private ArrayList<HashMap<String,String>> list_events;
    SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_facebook);
        callbackManager = CallbackManager.Factory.create();

        accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {
                // Set the access token using
                // currentAccessToken when it's loaded or set.
            }
        };
        // If the access token is available already assign it.
        accessToken = AccessToken.getCurrentAccessToken();

        profileTracker = new ProfileTracker() {
            @Override
            protected void onCurrentProfileChanged(
                    Profile oldProfile,
                    Profile currentProfile) {
                // App code
            }
        };

       /* LoginManager.getInstance().logInWithReadPermissions(
                this,
                Arrays.asList("email","public_profile","user_events"));*/
        GraphRequest request = GraphRequest.newMeRequest(
                accessToken,
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(
                            JSONObject object,
                            GraphResponse response) {
                        // Application code

                        Log.v("LogFacebookActivity", response.toString());
                        try{
                            String fb_name = object.getString("name");
                            String events = object.getString("events");
                            JSONObject events_json = new JSONObject(events);
                            JSONArray json_events = events_json.getJSONArray("data");
                            list_events = new ArrayList<>();

                            TextView log_fb_name = (TextView)  findViewById(R.id.log_facebook_name);
                            ListView list_fb_event = (ListView) findViewById(R.id.log_facebook_list_event);
                            String[] from = new String[]{"Name","City","Start","End"};
                            int[] to = {R.id.log_facebook_event_name,R.id.log_facebook_event_city,R.id.log_facebook_event_starttime,R.id.log_facebook_event_endtime};

                            simpleAdapter = new CustomAdapter(getApplicationContext(),list_events,R.layout.item_fb_events_list,from,to);
                            list_fb_event.setAdapter(simpleAdapter);

                            log_fb_name.setText(fb_name);

                            for(int i = 0; i<json_events.length();i++){
                                HashMap<String, String> map = new HashMap<>();
                                String event_name = json_events.getJSONObject(i).getString("name");
                                String event_city = "No city";
                                String event_endtime = "No end time";
                                String event_starttime = "No start time";

                                if(json_events.getJSONObject(i).getJSONObject("place").getJSONObject("location").has("city"))
                                    event_city = json_events.getJSONObject(i).getJSONObject("place").getJSONObject("location").getString("city");
                                if(json_events.getJSONObject(i).has("end_time"))
                                    event_endtime = json_events.getJSONObject(i).getString("end_time");
                                if(json_events.getJSONObject(i).has("start_time"))
                                    event_starttime = json_events.getJSONObject(i).getString("start_time");

                                map.put("Name",event_name);
                                map.put("City",event_city);
                                map.put("Start",event_starttime);
                                map.put("End",event_endtime);

                                list_events.add(map);
                                simpleAdapter.notifyDataSetChanged();
                            }

                        }catch(Exception e){
                            e.printStackTrace();

                        }

                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,link,events");
        request.setParameters(parameters);
        request.executeAsync();





        /*TextView log_fb_token = (TextView)  findViewById(R.id.log_facebook_token);
        TextView log_fb_name = (TextView)  findViewById(R.id.log_facebook_name);
        log_fb_token.setText(accessToken.getUserId());
        log_fb_name.setText(fb_name);*/

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();
    }
}