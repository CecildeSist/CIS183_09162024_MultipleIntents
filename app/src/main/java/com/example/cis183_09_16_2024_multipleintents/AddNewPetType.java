package com.example.cis183_09_16_2024_multipleintents;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AddNewPetType extends AppCompatActivity {
    EditText et_j_addType_insertType;
    Button btn_j_addType_newTypeButton;
    TextView tv_j_addType_errorMsgSame;
    TextView tv_j_addType_errorMsgEmpty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_pet_type);

        et_j_addType_insertType = findViewById(R.id.et_v_addType_typeName);
        btn_j_addType_newTypeButton = findViewById(R.id.btn_v_addType_addType);
        tv_j_addType_errorMsgSame = findViewById(R.id.tv_v_addType_errorSame);
        tv_j_addType_errorMsgEmpty = findViewById(R.id.tv_v_addType_errorEmpty);
        //Set error messages to invisible
        tv_j_addType_errorMsgSame.setVisibility(View.INVISIBLE);
        tv_j_addType_errorMsgEmpty.setVisibility(View.INVISIBLE);

        //Create an on-click listener for the button to add a new type
        addTypeButtonListener();
    }

    private void addTypeButtonListener() {
        btn_j_addType_newTypeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer i = 0;
                //Retrieve the text entered in the EditText
                String typeEntered = et_j_addType_insertType.getText().toString();
                //Check if the EditText is empty
                if (typeEntered.isEmpty()) {
                    //If empty, make the error message for "empty" visible
                    tv_j_addType_errorMsgEmpty.setVisibility(View.VISIBLE);
                }
                else {
                    //Check if the string matches anything in the already-existing list of types
                    Integer iType = 0;
                    while (iType < Pet.petType.types.size(), iType++) {
                        if ()
                    }
                }
            }
        });
    }
}