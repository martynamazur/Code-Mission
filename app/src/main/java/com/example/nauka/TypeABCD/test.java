package com.example.nauka.TypeABCD;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.nauka.R;
import com.example.nauka.hint_quiz.HintModel;

import java.util.ArrayList;

public class test extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstance) {

        super.onCreate(saveInstance);
        setContentView(R.layout.question_abcd_template);
        ArrayList<String> array = new ArrayList<>();
        array.add("t1");
        array.add("t1");
        array.add("t1");
        array.add("t4");
        QuestionModel questionModel = new QuestionModel("Wybierz odpowiedz","Jak wypiszesz na ekran napis Hello World ?","test",array);
        AbcdAdapter abcdAdapter = new AbcdAdapter(questionModel.getAnwsers(),test.this);
        RecyclerView recyclerView = findViewById(R.id.recyclerViewAbcd);



        recyclerView.setAdapter(abcdAdapter);
        // Ustawienie menedżera układu (layout manager) dla RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HintModel hintModel1 = new HintModel(7,"hint_quiz_skip");
        HintModel hintModel2 = new HintModel(6,"hint_quiz_skip");
        HintModel hintModel3 = new HintModel(8,"hint_quiz_skip");
        ArrayList<HintModel> array2 = new ArrayList<>();
        array2.add(hintModel1);
        array2.add(hintModel2);
        array2.add(hintModel3);
        RecyclerView recyclerViewHints = findViewById(R.id.hintsRV);




    }
}
