@regression2
Feature: Testing the account creation and validation from SmartBear

  Scenario:Validation account creation for different input
    Given User provides username, password and click Order Button
    When User provides the product,quantity for product information
      | product  | MyMoney |
      | quantity | 4       |
    And User provides name,street,city,state,zip for address information
      | name   | Ahmet   |
      | street | midway  |
      | city   | Chicago |
      | state  | IL      |
      | zip    | 60343   |
    And User provides cardType,cardNumber,expirationDate for payment information
      | cardType       | VISA      |
      | cardNumber     | 123342342 |
      | expirationDate | 06/28     |

    Then User clicks process button and validate message
      |New order has been successfully added.|

 #   And User validates all information '<name>','<product>','<quantity>','<street>','<city>','<state>','<zip>','<cardType>','<cardNumber>','<expirationDate>' from table

#    Examples:
#      | product     | quantity | name   | street | city    | state   | zip    | cardType         | cardNumber | expirationDate | message                                |
#      | MyMoney     | 4        | Ahmet  | midway | Chicago | IL      | 60343  | VISA             | 123342342  | 06/28          | New order has been successfully added. |
