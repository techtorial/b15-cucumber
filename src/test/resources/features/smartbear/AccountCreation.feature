@regression
Feature: Testing the account creation and validation from SmartBear

  Scenario Outline:Validation account creation for different input
    Given User provides username, password and click Order Button
    When User provides the '<product>','<quantity>' for product information
    And User provides '<name>','<street>','<city>','<state>','<zip>' for address information
    And User provides '<cardType>','<cardNumber>','<expirationDate>' for payment information
    Then User clicks process button and validate '<message>'
   # And User validates all information '<name>','<product>','<quantity>','<date>','<street>','<city>',<state>','<zip>','<cardType>','<cardNumber>,'<expirationDate>' from table
    Examples:
      | product | quantity | name  | street | city    | state | zip   | cardType | cardNumber | expirationDate | message                                |
      | MyMoney | 4        | Ahmet | midway | Chicago | IL    | 60343 | VISA     | 123342342  | 06/28          | New order has been successfully added. |





    #First Create your hook class and add your @Before and @After
    #Read username,password,url from configuration.properties
    #Start writing your test case in feature file
    #Start creating your Page Object model
      #Login Page  MainPage OrderPage ViewOrderPage
    #Create your Runner class and get the all snips from RUNNER CLASS
    #Put the snips in step definition class
      #ProductCreationStepDef(you can call it like that if you want)
    #Start implementing your page classes
    #Login Page
       #-->username -->Tester   password -->test  LoginButton
    #MainPage
       #orderButton   viewAllOrdersButton
    #OrderPage
       #All the red dots boxes and also state
       #Validation message
    #ViewOrderPage
       #Validate all the information from data table
       #You can think of Arrays.aslist(not first and last one need to be validated





