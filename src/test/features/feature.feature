#language: en


@test
Feature: Log In

  Scenario: Create user


    Then open "sign-up" page
    Then Click "Start Learning" button
    Then Input email
    Then Input first name
    Then Input last name
    Then Input password
    Then Click "Start Learning" button span
    Then Content "Start Teaching" button visible
    Then Click Avatar button
    Then Click "Settings" button li
    Then Content class info visible

    Then Check firstName field
    Then Check lastName field

  Scenario: Create user by Api
    Then Create user by api
    Then Login user by api
