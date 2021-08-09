Feature: LogIn test with combination fo logins and passwords

  @tag1
  Scenario Outline: "Login and password combinations"
    Given open logInPage:/sign-in
    When type to input login text:<login>
    And type to input with name password text:<password>
    And press element with value Submit
    Then The element with tag Welcome should exist:<positiveTest>,<test>
    Examples:
      | test              | login                | password | positiveTest |
      | login-wrong pw-ok | lilisdfpyt@gmail.com | 11111111 | false        |
      | login-ok pw-wrong    | lilipyt@gmail.com    | 111111       | false        |
      | login-wrong pw-wrong | lilidfpyt@gmail.com  | 11sdfg111111 | false        |
      | login-empty pw-ok    |                      | 11111111     | false        |
      | login-ok pw-empty    | lilipyt@gmail.com    |              | false        |
      | login-empty pw-empty |                      |              | false        |
      | login-empty pw-wrong |                      | 1321111111   | false        |
      | login-wrong pw-empty | liliadfpyt@gmail.com |              | false        |
      | login-ok pw-ok       | lilipyt@gmail.com    | 11111111     | true         |

  @tag2
  Scenario Outline: "Sign up user"
    Given open SignUp page:/sign-up
    When fillInSignUpForm email OK:<userName>,<userSurname>,<userPhone>,<userBirthday>,<passwordSignUp>,<passwordConfirm>
    And fill checkbox and press element with value Submit
    Then Catch Pushnotification:<positiveTest2>,<test>
    Examples:
      | loginSignUp | userName | userSurname | userPhone  | userBirthday | passwordSignUp | passwordConfirm | positiveTest2 | test         |
      | ok          |          | Luk         | 0654324343 | 01.01.9      | 111111111      | 111111111       | false         | no user name |
      | ok          | Alex     |             | 0654324343 | 01.01.9      | 111111111      | 111111111       | false         | no surname               |
      | ok          | Alex     | Luk         |            | 01.01.9      | 111111111      | 111111111       | false         | no phone                 |
      | ok          | Alex     | Luk         | 0654324343 |              | 111111111      | 111111111       | false         | no birthday              |
      | ok          | Alex     | Luk         | 0654324343 | 01.01.9      |                | 111111111       | false         | no password              |
      | ok          | Alex     | Luk         | 0654324343 | 01.01.9      | 111111111      |                 | false         | no confirmation password |
      | ok          | Alex     | Luk         | 0654324343 | 01.01.9      | 111111111      | 1111111         | false         | passwords don`t match    |
      | ok          | Alex     | Luk         | 0654324343 | 01.01.9      | 111111111      | 111111111       | true          | ok                       |

  @tag3
  Scenario Outline: "Sign up different login check"
    Given open SignUp page:/sign-up
    When fillInSignUpForm:<loginSignUp> ,<userName>,<userSurname>,<userPhone>,<userBirthday>,<passwordSignUp>,<passwordConfirm>
    And fill checkbox and press element with value Submit
    Then Catch Pushnotification:<positiveTest2>,<test>
    Examples:
      | loginSignUp       | userName | userSurname | userPhone  | userBirthday | passwordSignUp | passwordConfirm | positiveTest2 | test          |
      | lilipyt@gmail.com | Alex     | Luk         | 0654324343 | 01.01.9      | 111111111      | 111111111       | false         | existed login |
      | lilipyt@mail.ru   | Alex     | Luk         | 0654324343 | 01.01.9      | 111111111      | 111111111       | false         | .ru domain    |
      | lilipyt@gmail     | Alex     | Luk         | 0654324343 | 01.01.9      | 111111111      | 111111111       | false         | no .com       |
      | lilipytgmail.com  | Alex     | Luk         | 0654324343 | 01.01.9      | 111111111      | 111111111       | false         | no @          |
      | lilipyt@.com      | Alex     | Luk         | 0654324343 | 01.01.9      | 111111111      | 111111111       | false         | no gmail      |
      | lilipyt           | Alex     | Luk         | 0654324343 | 01.01.9      | 111111111      | 111111111       | false         | mo gmail.com  |
      |                   | Alex     | Luk         | 0654324343 | 01.01.9      | 111111111      | 111111111       | false         | login empty   |

  @tag4
  Scenario Outline: "Buttons chek prior logIn"
    Given open startPage:/start
    Then button is displayed check:<id>,<assertUrl>
    Examples:
      | Button name    | id        | assertUrl  |
      | signIn         | signIn    | /sign-in   |
      | signUp         | signUp    | /sign-up   |
      | system preview | dashboard | /dashboard |
      | contacts       | contacts  | /contacts  |

    @tag5
    Scenario Outline: "Buttons chek prior logIn link"
      Given open startPage:/start
      Then new window displayed check:<id>,<assertFullUrl>
      Examples:
        | Button name    | id            | assertFullUrl                               |
        | overview_video | overviewVideo | https://www.youtube.com/watch?v=xUyaurwGQOQ |
        | public_info    | publicInfo    | https://e-transport.gov.ua/                 |








