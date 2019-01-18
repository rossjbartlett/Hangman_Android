package com.example.hangmanmobile;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class HangManController {

	private Game game; // model
	private MyFileReader fileReader;

	Button submitGuessButton;
	EditText guess;
	TextView badGuessesText;
	TextView progressText;

	int imageNumber = 0;
	ImageView img;


	public HangManController(Game g, MyFileReader fr, Button b, EditText text, ImageView i, TextView v, TextView p) {
		game = g;
		fileReader = fr;
		submitGuessButton = b;
		guess = text;
		img = i;
		badGuessesText = v;
		progressText =p;
		submitGuessButton.setOnClickListener(new ButtonListener());
	}


	class ButtonListener implements View.OnClickListener {

		@Override
		public void onClick(View arg0 ) {
			String input = guess.getText().toString();

			if(validInput(input)) {
				//run logic 
				input = input.toLowerCase();
				int result = game.testInput(input);


				if(result==0) {
					//bad guess
					try {
						updateHangman();
					} catch (LostTheGameException e) {
						System.out.println("GAME OVER");
//						JOptionPane.showMessageDialog(null, "Congratulations! You Suck!!","You Lose", JOptionPane.INFORMATION_MESSAGE);
						reset();

					}

					String badGuesses = game.getBadGuesses();
					badGuessesText.setText(badGuesses);
//					window.getGuessCharacterPanel().setGuessString(badGuesses);

				}
				if(result == 2 ) { // correct guess
					String progress = game.getProgressString();
					//window.getCurrentGuessPanel().changeWord(progress);
					progressText.setText(progress);
					boolean win = game.checkVictory();

					if(win) {
						//JOptionPane.showMessageDialog(null, "Congratulations! You Win!!", "You Win", JOptionPane.INFORMATION_MESSAGE);
						System.out.println("YOU WIN");

						reset();
					}
				}
				else {
					//guess was used already
					//do nothing
				}
			}
			else {
				//JOptionPane.showMessageDialog(null, "Error: Invalid input, please try again", "Error", JOptionPane.WARNING_MESSAGE);
			}
//			window.getGuessCharacterPanel().clearInputField();
			guess.setText("");
		}

		private boolean validInput(String input) {
			System.out.println("input: " + input);
			//true if length == 1 and the char is the letter 
			if(input.length()!=1 || !Character.isLetter(input.charAt(0))){
				return false;
			}
			return true;
		}
	}


	private void reset() {
		String word = fileReader.getRandomWord();
		game = new Game(word);
		img.setImageResource(R.drawable.level0);
		imageNumber = 0;
		badGuessesText.setText("");
		progressText.setText(game.getProgressString()); // show the empty underscores that show how long the word is


//		window.dispose();
//		window = new HangmanWindow(word.length());
//		window.getGuessCharacterPanel().setSubmitGuessButtonListener(new ButtonListener());


	}

	public void updateHangman() throws LostTheGameException
	{

		int imgID = -1;
		switch(++imageNumber){
			case 0: imgID = R.drawable.level0; break;
			case 1: imgID = R.drawable.level1; break;
			case 2: imgID = R.drawable.level2; break;
			case 3: imgID = R.drawable.level3; break;
			case 4: imgID = R.drawable.level4; break;
			case 5: imgID = R.drawable.level5; break;
			case 6: imgID = R.drawable.level6; break;
			case 7: imgID = R.drawable.level7; break;
			case 8: imgID = R.drawable.level8; break;
			case 9: imgID = R.drawable.level9; break;
			default: throw new LostTheGameException("You Lost!");
		}
		img.setImageResource(imgID);
//		image = ImageIO.read(new File("Level" + imageNumber + ".png"));

//		repaint();
//		if(imageNumber > 9){
//			throw new LostTheGameException("You Lost!");
//		}
	}
}
