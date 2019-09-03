Feature: 钉钉知人创建

  Scenario Outline: 钉钉知人创建:<info>
    When 钉钉知人创建:新增用户,staffId='<staffId>'
    Then 钉钉知人创建:校验调用zhirenService的接口的入参'<param>'
    Examples:
      | info      | staffId              | param |
      | 职位映射关系不存在 | 05220668512088867729 |       |
