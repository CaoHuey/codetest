## android-codetest

## overview

Refactor a basic form that submits input to a `ResultsActivity` which then displays the input values.

## main project goal

* Refactor the project from Java to kotlin and complete the project using kotlin.
* Refactor the `MainActivity` and the `ResultsActivity` to use the Google Jetpack `ViewModel`, `Databinding`, and `LiveData` Architecture components.

## extended project goals
(not required to complete - feel free to incorporate any of these)

* Setup an architecture framework such as MVVM
* Add input validation to the `MainActivity` view model (see validation requirements below).
* Enable the Submit button only when all of the input validations pass.
* Use `Retrofit2` to pull down the list of US States from [here](https://api.jsonbin.io/b/60770a3c5b165e19f6201b95) and populate the `Spinner` instead of using the provided `states-array`.

## validation requirements

First name, Last name, Address, and City should not be empty. Address2 can be empty.

Phone should only use numbers, and should validate against a standard US phone (5555555555).

The State Spinner should be anything but "Select a State" on submit.

Zipcode shouldn't be any longer/shorter than a standard US zip (60601).

## goals++
(not required to complete - using any of the following tools would be a bonus)

* Incorporate `Dagger2` where you see fit.
* Use `Room` to save the user input to an `android_code_test` database on submission, and retrieve the data back to display.
* Use `WorkManager` to queue up your database and/or networking jobs.