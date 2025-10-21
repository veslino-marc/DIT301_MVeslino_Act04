# DIT3-1-MarcVeslino-Act04

1. How did you implement event handling for user actions?

- I used setOnClickListener() on the Submit button to handle user clicks. When the button is pressed, it calls the handleSubmit() function which reads the input from the text fields, checks if the data is valid, and shows the results on screen.

2. What techniques ensured smooth and stable interaction?

- I added validation to check if fields are empty and if the age is a valid number. A try-catch block prevents the app from crashing when users enter letters instead of numbers for age. Toast and Snackbar messages give instant feedback to users about errors or success.

3. What improvements would you add in future versions?

- I would add a database to save user data permanently, add more fields like email and phone number, improve the design with better colors and animations, and use MVVM architecture to make the code cleaner and easier to test.
