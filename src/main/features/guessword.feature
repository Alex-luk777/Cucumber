Feature: LogIn test with combination fo logins and passwords

  @tag1
  Scenario Outline: "Login and password combinations"
    Given open logInPage:https://bpla.mpsdevelopment.com/sign-in
    When type to input login text:<login>
    And type to input with name password text:<password>
    And press element with value Submit
    Then The element with tag Welcome should exist:<positiveTest>,<test>
    Examples:
      | test                 | login                | password     | positiveTest |
      | login-wrong pw-ok    | lilisdfpyt@gmail.com | 11111111     | false        |
      | login-ok pw-wrong    | lilipyt@gmail.com    | 111111       | false        |
      | login-wrong pw-wrong | lilidfpyt@gmail.com  | 11sdfg111111 | false        |
      | login-empty pw-ok    |                      | 11111111     | false        |
      | login-ok pw-empty    | lilipyt@gmail.com    |              | false        |
      | login-empty pw-empty |                      |              | false        |
      | login-empty pw-wrong |                      | 1321111111   | false        |
      | login-wrong pw-empty | liliadfpyt@gmail.com |              | false        |
      | login-ok pw-ok       | lilipyt@gmail.com    | 11111111     | true         |










