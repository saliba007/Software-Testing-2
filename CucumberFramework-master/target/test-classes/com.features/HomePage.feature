Feature: Book Website Test

  Scenario Outline: Reachability of product categories (Check at least 5 categories)

    Given User is already on Books Wagon Page
    And I click on the "<category-name>" category
    Then I should be taken to "<category-name>" category
    And the category should show at least "<num-products>" products
    When I click on the first product in the results
    Then I should be taken to the details page for that product
    And close the browser

    Examples:
      | category-name                 | num-products |
      | Art & Photography             | 100          |
      | Biographies & Memoirs         | 100          |
      | Dictionaries & Language       | 100          |
      | Literature & literary studies | 100          |
      | English Language Teaching     | 100          |


  Scenario: Search functionality

    Given User is already on Books Wagon Page
    When I search for a product using the term "java"
    Then I should see the search results
    And there should be at least 5 products in the search results
    When I click on the first product in the results
    Then I should be taken to the details page for that product
    And close the browser