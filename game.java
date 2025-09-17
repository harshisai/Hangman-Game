import random

def hangman():
    # List of words for the game
    words = ['python', 'programming', 'computer', 'algorithm', 'developer', 'software']
    
    # Select a random word
    secret_word = random.choice(words)
    
    # Game variables
    guessed_letters = []
    attempts = 7
    word_progress = ['_'] * len(secret_word)
    
    print("Welcome to Hangman!")
    print(" ".join(word_progress))
    
    while attempts > 0 and '_' in word_progress:
        guess = input("\nGuess a letter: ").lower()
        
        # Validate input
        if len(guess) != 1 or not guess.isalpha():
            print("Please enter a single letter.")
            continue
            
        if guess in guessed_letters:
            print("You already guessed that letter.")
            continue
            
        guessed_letters.append(guess)
        
        if guess in secret_word:
            # Update word progress with correctly guessed letter
            for i, letter in enumerate(secret_word):
                if letter == guess:
                    word_progress[i] = guess
            print("Good guess!")
        else:
            attempts -= 1
            print(f"Wrong! You have {attempts} attempts left.")
        
        # Display current progress
        print(" ".join(word_progress))
        print(f"Guessed letters: {', '.join(guessed_letters)}")
    
    # Game conclusion
    if '_' not in word_progress:
        print("\nCongratulations! You won!")
    else:
        print(f"\nGame over! The word was: {secret_word}")

# Start the game
if __name__ == "__main__":
    hangman()
