Feature: 测试用例1

  Scenario Outline: 商品购物车-<caseDesc>-<itemId>
    When 查询<itemId>-'<itemName>'
    Then 检查'<itemName>'
    Examples:
      | caseDesc | itemId | itemName |
      | 用例1      | 111211 | 普通商品1    |
      | 用例2      | 223334 | 普通商品2    |


  Scenario Outline: Many additions
    Given the previous entries:
      | first | second | operation |
      | 1     | 1      | +         |
      | 2     | 1      | +         |
    When I press +
    And I add <a> and <b>
    And I press +
    Then the result is <c>

    Examples: Single digits
      | a | b | c  |
      | 1 | 2 | 8  |
      | 2 | 3 | 10 |

    Examples: Double digits
      | a  | b  | c  |
      | 10 | 20 | 35 |
      | 20 | 30 | 55 |

