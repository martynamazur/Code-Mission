package com.example.nauka.TypeABCD;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.nauka.R;
import com.example.nauka.TypeABCD.QuestionModelAbcd;
import com.example.nauka.play.Exercise1Fragment;
import com.example.nauka.play.TaskModel;
import com.example.nauka.play.TaskPagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class test extends AppCompatActivity {

    private ViewPager2 viewPager;
    private TaskPagerAdapter pagerAdapter;
    private List<TaskModel> taskList;
    private int currentItemIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question_abcd_template);

        // Inicjalizacja ViewPager2
        viewPager = findViewById(R.id.viewPager);
        viewPager.setUserInputEnabled(false); // Opcjonalne: Wyłącza przewijanie gestami

        // Inicjalizacja listy zadan
        taskList = new ArrayList<>();
        taskList.add(new TaskModel("wyklad1", generateQuestionModelAbcdList(2), generateQuestionModelFillBlockList(2)));
        // Dodaj kolejne zadania do listy

        // Utwórz adapter i przekaż mu listę zadań oraz referencję do menedżera fragmentów
        pagerAdapter = new TaskPagerAdapter(getSupportFragmentManager(), taskList, getLifecycle(),"abcd");


        // Ustaw adapter w ViewPager2
        viewPager.setAdapter(pagerAdapter);

        // Ustaw domyślny indeks wyświetlanego zadania
        currentItemIndex = 0;
        viewPager.setCurrentItem(currentItemIndex, false); // Opcjonalne: Wyłącza animację przejścia

        // Dodaj obsługę przycisku "Next"
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentItemIndex < taskList.size() - 1) {
                    currentItemIndex++;
                    viewPager.setCurrentItem(currentItemIndex);
                }
            }
        });
    }

    // Pozostała część kodu



    private static List<QuestionModelAbcd> generateQuestionModelAbcdList(int count) {
        List<QuestionModelAbcd> questionModelAbcdList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            String title = "Question " + (i + 1);
            String questionDescription = "Description " + (i + 1);
            String correctAnswer = getRandomAnswer();
            List<String> answers = Arrays.asList("Answer 1", "Answer 2", "Answer 3", "Answer 4");
            int correctAnswerIndex = random.nextInt(4);

            QuestionModelAbcd questionModelAbcd = new QuestionModelAbcd(title, questionDescription, correctAnswer, answers, correctAnswerIndex);
            questionModelAbcdList.add(questionModelAbcd);
        }

        return questionModelAbcdList;
    }

    private static List<QuestionModelFillBlock> generateQuestionModelFillBlockList(int count) {
        List<QuestionModelFillBlock> questionModelFillBlockList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            String title = "Question " + (i + 1);
            String questionDescription = "Description " + (i + 1);
            String correctAnswer = "Correct Answer " + (i + 1);
            String category = "Category " + (i + 1);
            List<String> codeText = Arrays.asList("Code Text 1", "Code Text 2", "Code Text 3");
            List<Integer> editTextIndices = getRandomEditIndices(codeText.size());

            QuestionModelFillBlock questionModelFillBlock = new QuestionModelFillBlock(title, questionDescription, correctAnswer, category, codeText, (ArrayList<Integer>) editTextIndices);
            questionModelFillBlockList.add(questionModelFillBlock);
        }

        return questionModelFillBlockList;
    }



    private static String getRandomAnswer() {
        Random random = new Random();
        List<String> answers = Arrays.asList("Answer 1", "Answer 2", "Answer 3", "Answer 4");
        int randomIndex = random.nextInt(4);
        return answers.get(randomIndex);
    }

    private static List<Integer> getRandomEditIndices(int size) {
        Random random = new Random();
        List<Integer> editIndices = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            if (random.nextBoolean()) {
                editIndices.add(i);
            }
        }

        return editIndices;
    }
}
