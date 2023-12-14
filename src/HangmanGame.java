    import java.util.Scanner;
    public class HangmanGame
    {
        private static final String[] WORDS = {"Dog", "Alien", "Whole", "Lotta", "Red", "Music", "Unicorn", "Seriously", "Carrot", "Apple", "Shirt"};

        private static int maxAttempts = 6;


        private String secretWord;
        private StringBuilder guessedWord;
        private int attemptsLeft;
        // Constructor 1
        public HangmanGame()
        {
            this((int) (Math.random() * WORDS.length));
        }


        // Constructor 2
        public HangmanGame(int wordIndex)
        {
            this.secretWord = WORDS[wordIndex].toUpperCase();
            this.guessedWord = new StringBuilder("_".repeat(secretWord.length()));
            this.attemptsLeft = maxAttempts;
        }


        // Getter for attemptsLeft
        public int getAttemptsLeft()
        {
            return attemptsLeft;
        }


        // Setter for attemptsLeft
        public void setAttemptsLeft(int attemptsLeft)
        {
            this.attemptsLeft = attemptsLeft;
        }


        // Brain method 1: Check if the guessed letter is in the secret word
        public boolean guessLetter(char letter)
        {
            boolean correctGuess = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == letter)
                {
                    guessedWord.setCharAt(i, letter);
                    correctGuess = true;
                }
            }
            if (!correctGuess) {
                attemptsLeft--;
            }
            return correctGuess;
        }


        // Brain method 2: Check if the game is won
        public boolean isGameWon()
        {
            return guessedWord.toString().equals(secretWord);
        }


        // toString method
        public String toString()
        {
            return "Guessed Word: " + guessedWord + "\nAttempts Left: " + attemptsLeft;
        }

        //static method
        public static void main(String[] args)
        {
            Scanner scanner = new Scanner(System.in);
            HangmanGame hangmanGame = new HangmanGame();

            while (hangmanGame.getAttemptsLeft() > 0 && !hangmanGame.isGameWon())
            {
                System.out.println(hangmanGame);
                System.out.print("Enter a letter: ");
                char guess = scanner.next().toUpperCase().charAt(0);

                //  if statement
                if (!Character.isLetter(guess))
                {
                    System.out.println("Please enter a valid letter.");
                    continue;
                }
                // if statement
                if (!hangmanGame.guessLetter(guess))
                {
                    System.out.println("Incorrect guess. Attempts left: " + hangmanGame.getAttemptsLeft());
                }
                // While loop
                while (true)
                {
                    // For loop
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Loop iteration: " + i);
                    }
                    break;
                }
                // Boolean operators
                if (hangmanGame.getAttemptsLeft() == 0 || hangmanGame.isGameWon())
                {
                    break;
                }
                // String methods
                System.out.println("Length: " + hangmanGame.secretWord.length());
                System.out.println("Index of 'A': " + hangmanGame.secretWord.indexOf('A'));
            }
            scanner.close();
            System.out.println("Game over! \nThe word was: " + hangmanGame.secretWord);
        }
    }