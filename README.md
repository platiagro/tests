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
gradle bdd -Ptag=@CRUDPROJ
gradle bdd -Ptag=@CRUDTAREFA
```

![Vídeo de uma execução de testes. Uma pessoa roda o comando gradle bdd, e o Google Chrome abre automaticamente na página de projetos da PlatIAgro. Em seguida, um novo projeto é criado. O teste finaliza com sucesso.](animation.gif)


## Versão do Driver(Google Chrome) para que fique compativel com a automação.

### 1° Em seu Explorador de Arquivos ir até a pasta do driver. Ex: C:\AUTOMACAO\testes_automaticos\cucumber-geb\build\webdriver.
 
 
### 2° Excluir Arquivos/Pastas "chromedriver".
![](https://bitbucket.cpqd.com.br/projects/PLATIA/repos/testes_automaticos/raw/Excluir%20Aquivos%20Driver.png?at=refs%2Fheads%2Fmaster)


### 3° Ir no Site onde encontra os drivers do Chrome e fazer o download(na pasta webdriver) da versão mais recente: https://chromedriver.chromium.org/downloads
![](https://bitbucket.cpqd.com.br/projects/PLATIA/repos/testes_automaticos/raw/Chrome%20Driver%20Recente.png?at=refs%2Fheads%2Fmaster)


### 4° Terminando o download, extrair arquivo.


### 5° Na Automação, indo em build.gradle, alterar o número da versão do driver do chrome conforme o download feito.
![](https://bitbucket.cpqd.com.br/projects/PLATIA/repos/testes_automaticos/raw/ChromeDriverVersion.png?at=refs%2Fheads%2Fmaster)


### 6° Em sua Automação rodar qualquer cenário, ao rodar a atualização do Driver será automatica.
