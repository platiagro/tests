# Testes Automatizados da PlatIAgro

Para testes dos módulos web foi escolhida a solução GEB para os testes automatizados por ser um framework que utiliza o Selenium WebDriver que é muito utilizado no mercado para automações web. Utiliza a linguagem Groovy que é de fácil compreensão e de altíssimo nível e também é baseado em Java com o gradle como gerenciador de dependências. Mais detalhes e a documentação pode ser acessada no site oficial http://www.gebish.org/. Em conjunto com o GEB são aplicados conceitos de BDD.

Veja mais detalhes no Confluence: https://confluence.cpqd.com.br/pages/viewpage.action?pageId=15966929

## Requisitos

- Java >= 1.8
- Gradle == 4.x
- Google Chrome

## Rodando os testes

```
gradle bdd
```

ou

```
gradle bdd -Ptag=@tagDesejada
```

## TODO Exemplo de Teste em Execução (GIF)
