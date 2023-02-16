#language: en
@DIRF
Feature: Solilcitacao DIRF
 Background:

  @Regressao @TEST_WE-2281
  Scenario: WE-2281  DIRF_01 validar envio de DIRF para cliente identificado com CPF vinculado a um EC que não tem CNPJ
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 31071827022 senha 852963
    And seleciona a EC 201332834
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 201332834
    And escolha a opcao "5" do submenu
    Then o retona texto deve conter o link "https://minhaconta2.cielo.com.br/minha-conta/centralAjuda"
    And encerro o chat

  @Regressao  @TEST_WE-2282
  Scenario: WE-2282 DIRF_02 validar envio de DIRF de estabelecimento com data de afiliação no ano corrente
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 39804729067 senha 852963
    And seleciona a EC 2006858909
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 2006858909
    And escolha a opcao "5" do submenu
    And informo o ano 2021 de solitacao do DIRF
    And informo o email "botwhatsapp@cielo.com.br"
    Then seleciono opcao envia para outro email 1
    And informo outro email "botwhatsapp2@cielo.com.br"
    And escolha a opcao "4:Encerrar atendimento"
    And encerro o chat

  @Regressao @TEST_WE-2283 @WE6153
  Scenario: WE-2283 DIRF_03 validar envio de DIRF, de um cliente com EC elegível,ano calendário inserido corretamente, e-mail dentro dos padrões, e que deseja enviar a DIRF para outro e-mail
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 39804729067 senha 852963
    And seleciona a EC 2006858909
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 2006858909
    And escolha a opcao "5" do submenu
    And informo o ano 2021 de solitacao do DIRF
    Then informo o email "botwhatsapp@cielo.com.br"
    And escolha a opcao "4:Encerrar atendimento"
    And encerro o chat

  @Regressao @TEST_WE-2284
  Scenario: WE-2284 DIRF_04 validar opção envio de DIRF para E-mail, de um cliente com EC elegível, ano calendário inserido 1 vez incorretamente, e que deseja enviar a DIRF para outro email
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 39804729067 senha 852963
    And seleciona a EC 2006858909
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 2006858909
    And escolha a opcao "5" do submenu
    Then informo o ano 2022 de solitacao do DIRF
    And encerro o chat

  @Regressao @TEST_WE-2285
  Scenario: WE-2285 DIRF_05 validar opção envio de DIRF para E-mail, de um cliente com EC elegível, ano calendário inserido 2 vez incorretamente, e que deseja enviar a DIRF para outro email
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 31071827022 senha 852963
    And seleciona a EC 2012359935
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 2012359935
    And escolha a opcao "5" do submenu
    Then informo o ano 2022 de solitacao do DIRF
    And informo o ano 2022 de solitacao do DIRF
    And encerro o chat

  @Regressao @TEST_WE-2286
  Scenario: WE-2286 DIRF_06  validar opção envio de DIRF para E-mail, de um cliente com EC elegível, ano calendário inserido 3 vez incorretamente, e que deseja enviar a DIRF para outro email
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 31071827022 senha 852963
    And seleciona a EC 2012359935
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 2012359935
    And escolha a opcao "5" do submenu
    Then informo o ano 2202 de solitacao do DIRF
    And informo o ano 2202 de solitacao do DIRF
    And informo o ano 2202 de solitacao do DIRF
    And encerro o chat

  @Regressao @TEST_WE-2287
  Scenario: WE-2287 DIRF_07  validar opção envio de DIRF para E-mail, de um cliente com EC elegível, ano calendário inserido corretamente, e-mail fora dos padrões válidos 1 vez, e que deseja enviar a DIRF para outro e-mail
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 07812763064 senha 199011
    And seleciona a EC 2012359935
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 2012359935
    And escolha a opcao "5" do submenu
    And informo o ano 2021 de solitacao do DIRF
    Then informo o email "botwhatsappcielo.com.br"
    And encerro o chat

  @Regressao @TEST_WE-2288
  Scenario: WE-2288 DIRF_08  validar acesso a opção consultar outro ano de DIRF, de um cliente que já havia consultado outro ano anteriormente, com EC elegível, ano calendário inserido corretamente, e-mail dentro dos padrões válidos
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 07812763064 senha 199011
    And seleciona a EC 2012359935
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 2012359935
    And escolha a opcao "5" do submenu
    And informo o ano 2021 de solitacao do DIRF
    And informo o email "botwhatsapp@cielo.com.br"
    And escolha a opcao "2" do menu de cosulta
    And informo outro ano 2020  de solitacao do DIRF
    Then informo outro email "botwhatsapp2@cielo.com.br"
    And encerro o chat

  @Regressao @TEST_WE-2289
  Scenario: WE-2289 DIRF_09  validar acesso a opção consultar outro ano de DIRF, de um cliente que já havia consultado outro ano anteriormente, com EC elegível, ano de calendário inserido 1 vez fora da data de afiliação, e-mail dentro dos padrões válidos
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 07812763064 senha 199011
    And seleciona a EC 2012359935
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 2012359935
    And escolha a opcao "5" do submenu
    And informo o ano 2021 de solitacao do DIRF
    And informo o email "@cielo.com"
    Then exibe menu com as opcoes
    And encerro o chat

  @Regressao @TEST_WE-2290
  Scenario: WE-2290  DIRF_10  validar acesso a opção consultar outro ano de DIRF, de um cliente com EC elegível, ano calendário inserido 2 vezes incorretamente, e-mail dentro dos padrões válidos
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 31071827022 senha 852963
    And seleciona a EC 2012359935
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 2012359935
    And escolha a opcao "5" do submenu
    Then informo o ano 2022 de solitacao do DIRF
    And informo o ano 2022 de solitacao do DIRF
    And encerro o chat

  @Regressao @TEST_WE-2291
  Scenario: WE-2291 DIRF_11  Validar acesso a opção consultar outro ano de DIRF, de um cliente com EC elegível, ano calendário inserido 3 vezes fora da data de afiliação
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 31071827022 senha 852963
    And seleciona a EC 2012359935
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 2012359935
    And escolha a opcao "5" do submenu
    Then informo o ano 2022 de solitacao do DIRF
    And informo o ano 2022 de solitacao do DIRF
    And informo o ano 2022 de solitacao do DIRF
    And encerro o chat

  @Regressao @TEST_WE-2292
  Scenario: WE-2292 DIRF_12  validar acesso a opção consultar outro ano de DIRF, de um cliente com EC elegível, ano de calendário inserido corretamente, e-mail fora dos padrões válidos inserido 1 vez
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 31071827022 senha 852963
    And seleciona a EC 2012359935
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 2012359935
    And escolha a opcao "5" do submenu
    And informo o ano 2021 de solitacao do DIRF
    Then informo o email "botwhatsapp@.cielo.com.br"
    And encerro o chat

  @Regressao @TEST_WE-2293
  Scenario: WE-2293 DIRF_13  validar opção envio de DIRF para E-mail, de um cliente com EC elegível, ano calendário inserido corretamente, e-mail fora dos padrões válidos 2 vezes, e que deseja enviar a DIRF para outro e-mail
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 31071827022 senha 852963
    And seleciona a EC 2012359935
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 2012359935
    And escolha a opcao "5" do submenu
    And informo o ano 2021 de solitacao do DIRF
    Then informo o email "@.cielo.com"
    And informo o email "@.cielo.com"
    And encerro o chat

  @Regressao @TEST_WE-2294
  Scenario: WE-2294 DIRF_14  validar opção envio de DIRF para E-mail, de um cliente com EC elegível, ano calendário inserido corretamente, e-mail fora dos padrões válidos 3 vezes, e que deseja enviar a DIRF para outro e-mail
    Given que abra o WhatsApp
    And inicie uma interacao no chat-cielo
    And seleciona a opcao 5 menu principal
    And click no link de login
    And efetue o login com estabelecimento 31071827022 senha 852963
    And seleciona a EC 2012359935
    When retornar ao chat digite a opcao 1 - fiz o login
    And confirmo a EC 2012359935
    And escolha a opcao "5" do submenu
    And informo o ano 2021 de solitacao do DIRF
    Then informo o email "@.cielo.com"
    And informo o email "@.cielo.com"
    And informo o email "@.cielo.com"
    And encerro o chat

