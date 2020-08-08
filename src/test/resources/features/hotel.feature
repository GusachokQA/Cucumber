Feature: Тест по поиску Отеля

  Scenario: Отель Five Jumeirah Village
    Given browser is started
    * search page is opened
    * search button is displayed
    When find "Five Jumeirah Village" hotel click button
    Then hotel name "Five Jumeirah Village" is displayed
    * score "8.5" is displayed

