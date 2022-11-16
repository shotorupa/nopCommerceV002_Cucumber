Feature:Customers
Scenario: Add new Customer
        Given User Launch Chrome Browser
        When User Opens URL "http://admin-demo.nopcommerce.com/login"
        And User Enters Email as "admin@yourstore.com" and Password as "admin"
        And Click On Login
       Then User can view Dashboard
       When User clicks on customer menu 
       And click on customers menu Item
       And click on add new button
       Then user can view add new customer page
       When user enter customer info
       And click on save button
       Then User can view confirmation message "The new customer has been added successfully"
      And Close Browser
       