package com.example.cis183_09_16_2024_multipleintents;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btn_j_goToAddPet;
    ListView lv_j_listOfPets;
    Intent intent_j_addNewPet;
    //This is to show that when we load an intent, it will always be a new load. Data will not be
    //retained between loads. We change this variable below to 99, but when we come back from
    //addNewPet, it will be 50 again.
    int numberTestingIfNewLoad = 50;
    static ArrayList<Pet> listOfPets = new ArrayList<>();
    PetListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Log.d("VALUE TESTING ON CLICK: ", numberTestingIfNewLoad + "");

        btn_j_goToAddPet = findViewById(R.id.btn_v_main_addNewPet);
        lv_j_listOfPets = findViewById(R.id.lv_v_listOfPets);
        Intent cameFrom = getIntent();
        if (cameFrom.getSerializableExtra("petData") != null) {
            Pet petData = (Pet) cameFrom.getSerializableExtra("petData");
            listOfPets.add(petData);
            Log.d("INFO FROM FROM ADD PET", listOfPets.get(listOfPets.size() - 1).getName());
        }
        else {
            addDummyDataToArrayList();
        }


        //Give the intent the following info:
        //The class you came from. the class you want to open
        intent_j_addNewPet = new Intent(MainActivity.this, AddNewPet.class);

        addNewPetButtonListener();
        fillListView();
    }

    private void addDummyDataToArrayList() {
        Pet newPet = new Pet("Tito", 6, Pet.petType.getPetAt(0));
        listOfPets.add(newPet);

        newPet = new Pet("Willow", 3, Pet.petType.getPetAt(0));
        listOfPets.add(newPet);

        newPet = new Pet("Abigail", 1, Pet.petType.getPetAt(3));
        listOfPets.add(newPet);

        newPet = new Pet("Hiss", 12, Pet.petType.getPetAt(2));
        listOfPets.add(newPet);

        newPet = new Pet("Meow", 15, Pet.petType.getPetAt(1));
        listOfPets.add(newPet);
    }

    private void fillListView() {
        adapter = new PetListAdapter(this, listOfPets);
        lv_j_listOfPets.setAdapter(adapter);
    }

    private void addNewPetButtonListener() {
        btn_j_goToAddPet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                numberTestingIfNewLoad = 99;
                Log.d("VALUE TESTING ON CLICK: ", numberTestingIfNewLoad + "");
                intent_j_addNewPet.putExtra("InfoPassed", "Hello from main");
                startActivity(intent_j_addNewPet);
            }
        });

    }
}