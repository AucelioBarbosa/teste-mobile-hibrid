#language: en

Feature: Logar seu barriga híbrido

  Background:
    Given inciado uma sessão no app

  @TST_HIBRIDO
  Scenario: login saíndo do app nativo para um app hibrido

    And clicado no opção seu barriga híbrido
    When efetuado o login
    Then valido se consegui realizar ações na tela Web_viwer
