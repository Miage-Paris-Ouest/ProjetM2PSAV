package com.example.nviller.projetm2psav.activities;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by mouna on 01/03/2018.
 */

public class ListEventActivity extends AppCompatActivity{
/*
    private ListView listEvents;
    private ArrayList<HashMap<String, Object>> listValuesEvents = new ArrayList<>();
    private SimpleAdapter adapter;
    private List<Event> listeEvenements = new ArrayList<>();
    private List<Event> listEventSort = new ArrayList<>();
    private HashMap<String, String> listAssociation= new HashMap<>();
    private final SimpleDateFormat inputDate  = new SimpleDateFormat("HH:mm dd/MM/yyyy", Locale.FRANCE);
    private final SimpleDateFormat simpleDate  = new SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE);
    private final SimpleDateFormat outputDate = new SimpleDateFormat("EEEE d MMM à HH:mm", Locale.FRANCE);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_event);
        loadEventInBackground();
    }

    public void launchEventPage() {
        listEvents.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), EventInfosActivity.class);
                Event event = listEventSort.get(position);

                intent.putExtra("eventName", event.nameEvent);
                intent.putExtra("eventStartDate", event.debut);
                intent.putExtra("eventEndDate", event.fin);
                startActivity(intent);
            }
        });
    }

    public Boolean convertToDate(String eventDate) {
        DateFormat dateFormatter = new SimpleDateFormat("kk:mm dd/MM/yyyy");
        Date start;
        Date today;
        Calendar c = Calendar.getInstance();
        try {
            start = dateFormatter.parse(eventDate);
            today = dateFormatter.parse(dateFormatter.format(c.getTime()));
            if (start.after(today)) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public Boolean compareDate(String event1, String event2) {
        DateFormat dateFormatter = new SimpleDateFormat("kk:mm dd/MM/yyyy");
        Date myEvent;
        Date eventNext;
        try {
            myEvent = dateFormatter.parse(event1);
            eventNext = dateFormatter.parse(event2);
            if (myEvent.before(eventNext)) {
                return true;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void loadEventInBackground() {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("events");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int tailleList;
                int nbEvent;
                int eventRestant;

                if (dataSnapshot.exists()) {
                    for (DataSnapshot e : dataSnapshot.getChildren()) {
                        Event event = e.getValue(Event.class);
                        event.idEvent = e.getKey();
                        if (convertToDate(event.debut) || convertToDate(event.fin)) {
                            listeEvenements.add(event);
                        }
                    }
                    eventRestant = listeEvenements.size();
                    while (eventRestant > 0) {
                        tailleList = listeEvenements.size();
                        for (int i = 0; i < tailleList; i++) {
                            nbEvent = 1;
                            for (int j = 0; j < tailleList; j++) {
                                if (i != j && compareDate(listeEvenements.get(i).debut, listeEvenements.get(j).debut)) {
                                    nbEvent++;
                                }
                            }
                            if (nbEvent == eventRestant) {
                                listEventSort.add(listeEvenements.get(i));
                                eventRestant--;
                            }
                        }
                    }



                    for (Event event : listEventSort) {
                        HashMap<String, Object> hashMapValuesEvent = new HashMap<>();
                        hashMapValuesEvent.put("nameEvent", event.nameEvent);
                        //hashMapValuesEvent.put("association", listAssociation.get(event.association));
                        try {
                            hashMapValuesEvent.put("dateEventBegin",outputDate.format(inputDate.parse(event.debut)));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        hashMapValuesEvent.put("AdressEvent", event.adresse);
                        listValuesEvents.add(hashMapValuesEvent);
                    }
                    String[] from = new String[]{"nameEvent","dateEventBegin","locationEvent"};
                    int[] to = new int[]{R.id.activity_content_event_name_event,R.id.activity_content_event_date_event_begin, R.id.activity_content_event_adress_event};


                    listEvents = (ListView) findViewById(R.id.activity_list_event_list);
                    adapter = new SimpleAdapter(ListEventActivity.this, listValuesEvents, R.layout.activity_content_event, from, to);
                    listEvents.setAdapter(adapter);
                    launchEventPage();

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Error : ", "onCancelled", databaseError.toException());
            }
        });
    }
    */
}
