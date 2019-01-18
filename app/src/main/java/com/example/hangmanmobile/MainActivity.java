package com.example.hangmanmobile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class MainActivity extends AppCompatActivity {

    Button submitGuessButton;
    EditText guess;
    TextView badGuessesText;
    TextView progressText;

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BufferedReader reader = null;

        try {
           reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("words.txt")));
        }catch(IOException e){
            e.printStackTrace();
        }

        MyFileReader fileReader = new MyFileReader(reader);
        String word = fileReader.getRandomWord();
        Game game = new Game(word);

        Button b = findViewById(R.id.submitButton);
        guess = findViewById(R.id.editTextView);
        badGuessesText = findViewById(R.id.textViewBadGuesses);
        progressText = findViewById(R.id.textViewProgress);
        img = findViewById(R.id.imageView);
        img.setImageResource(R.drawable.level0);

        HangManController controller = new HangManController(game, fileReader, b, guess, img, badGuessesText, progressText);


    }
}
