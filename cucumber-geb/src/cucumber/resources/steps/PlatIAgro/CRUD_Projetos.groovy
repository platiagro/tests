import pages.*
import geb.*
import db.*
import cucumber.api.PendingException
import java.util.Random
import org.openqa.selenium.By
import static cucumber.api.groovy.PT.*
import org.openqa.selenium.Keys

//CONTEXTO
Dado (~/que o usuário acessa a Plataforma PlatIAgro/) { ->
  browser.driver.manage().window().maximize()
  to PageProj
}

E(~/está na tela inicial/) { ->
  assert true
}

//CENÁRIO 1
Dado(~/que o usuário está na página Meus Projetos/) { ->
  assert true
}

E(~/será apresentado sua lista de projetos existentes/) { ->
  at PageProj

  waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/ul/li[4]/div/div[1]")).click()
  }
  Thread.sleep(2000)
}

Então(~/deverá observar que as informações dos projetos estarão divididos em cinco colunas: Nome do Projeto, Descrição, Tags, Última Modificação e Ação/) { ->
  at PageProj

  waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/ul/li[4]/div/div[1]")).click()
  }

    Thread.sleep(5000)
}

//CENÁRIO 2
Quando(~/clicar no botão Novo Projeto/) { ->
  at PageProj

    waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/button/span[2]")).click()
    }

  Thread.sleep(2000)
}

Então (~/o sistema deve abrir um modal, com o nome Novo Projeto selecionado/) { ->
    assert true
}

E (~/o usuário limpar o campo nome do projeto/) { ->
  at PageProj

  Thread.sleep(2000)

      //$(By.xpath("//*[@id='name']")).clear();

      //$(By.xpath("//*[@id='name']")).value("");

  $(By.xpath("//*[@id='name']")).value(Keys.chord(Keys.CONTROL, 'A') + Keys.BACK_SPACE)

    Thread.sleep(2000)
}

E (~/nomear o projeto com o nome: '(.*)'/) { String nomeJ ->
  at PageProj

  waitFor(10) {
    page.campnome.value(nomeJ)
  }

      Thread.sleep(2000)
}

E (~/nomear o projeto com:'(.*)'/) { String nome->
  at PageProj

  Random rand = new Random()

  // criar nomes de projetos com numeros aleatórios de 0 a 100
  int n = rand.nextInt(1000)

  waitFor(10) {
    page.campnome.value("${nome}${n}")
  }

      Thread.sleep(2000)
}

E (~/informar a seguinte descrição:'(.*)'/) { String desc->
  at PageProj

      waitFor(60) {
    page.campDesc.value(desc)
      }

  Thread.sleep(5000)
}

Quando (~/clicar no botão Criar/) { ->
    at PageProj

  waitFor(60) {
    page.btnConfirm.click()
  }
  Thread.sleep(5000)
}

Então (~/o novo projeto será criado/) { ->
  assert true
}

E(~/o usuário será direcionado para a página Detalhes do projeto/) { -> assert true }

E(~/será apresentado os seguintes dados: Descrição, Última modificação e Criado por/) { -> assert true }

E(~/nessa página poderá escolher se deseja iniciar um fluxo de Experimentação ou Pré-implantação/) { ->
  assert true
}

Quando (~/selecionar o card Experimento/) { ->
  at PageProj

  waitFor(60) {
    page.cardExp.click()
  }

    Thread.sleep(5000)
}

Então (/o usuário será direcionado para a página do projeto onde poderá iniciar um novo fluxo de experimento/) { -> assert true }

Quando (~/o usuário retornar para a página Meus Projetos deverá observar se o novo projeto foi adicionado à lista de projetos/) { ->
  at PageProj

  //selecionar seta de retornar
  waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div[1]/div/div/div/div/span")).click()
  }

    Thread.sleep(7000)

    waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div[1]/div/div/div/div/span")).click()
    }

  Thread.sleep(5000)
}

//CENÁRIO 3
E (~/o usuário clicar no botão Cancelar/) { ->
  at PageProj

  Thread.sleep(5000)

  waitFor(60) {
    page.btncancel.click()
  }

      Thread.sleep(5000)
}

Então (~/o modal deve ser resetado e fechado/) { ->
  assert true
}

E (~/nenhum projeto deve ser criado/) { ->
  assert true
}

//CENÁRIO 4
Então(~/a operação deve ser cancelada/) { ->
  assert true
}

E(~/o sistema deverá informar que já existe um projeto com o nome informado/) { ->
  at PageProj

  waitFor(60) {
    page.btnclose.click()
  }
      Thread.sleep(5000)
}

//CENÁRIO 5
Então(~/um novo projeto será criado/) { ->
  assert true
}

Dado (/que o usuário está na página Detalhes do Projeto/) { -> assert true }

Quando (~/selecionar o botão Editar, ao lado do nome do projeto/) { ->
  at PageProj

  Thread.sleep(5000)

      waitFor(60) {
        page.btnedit.click()
      }

    Thread.sleep(2000)
}

E (/o sistema abrir um modal, com o atual nome do projeto selecionado/) { -> assert true }

Quando (~/o usuário limpar o campo/) { ->
  at PageProj

  Thread.sleep(6000)

  waitFor(60) {
    page.campclear.click()
  }

      Thread.sleep(5000)
}

E (~/clicar no botão Salvar/) { ->
  at PageProj

  waitFor(60) {
    page.btnConfirm.click()
  }

  Thread.sleep(5000)
}

Então (~/o nome e a descrição do projeto serão atualizados/) { ->
  at PageProj

  waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div[1]/div/div/div/div/span")).click()
  }

    Thread.sleep(5000)
}

//CENÁRIO 6
Quando (~/selecionar o projeto que deseja Editar/) { ->
  at PageProj

  Thread.sleep(5000)

  waitFor(60) {
    $(By.xpath("//*[contains(text(), 'TesteProj3 ')]")).click()
  }
}

Quando (~/selecionar o botão Editar/) { ->
  at PageProj
  Thread.sleep(5000)

      waitFor(60) {
    page.btnedit.click()
      }

      Thread.sleep(5000)
}

E (~/o sitema abrir o modal/) { ->
  assert true
}

E (~/o usuário informar a seguinte descrição:'(.*)'/) { String editdesc->
  at PageProj

      waitFor(60) {
    page.campDesc.value(editdesc)
      }

  Thread.sleep(5000)
}

E (~/selecionar o botão Cancelar/) { ->
  at PageProj

    Thread.sleep(5000)

      waitFor(60) {
    page.editcancel.click()
      }

  Thread.sleep(2000)
}

E (~/nenhuma alteração deve ser feita/) { ->
  at PageProj

  waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div[1]/div/div/div/div/span")).click()
  }

    Thread.sleep(7000)
}

//CENARIO 7
E (~/selecionar um dos projetos da lista de projetos/) { ->
  at PageProj

  Thread.sleep(4000)

  waitFor(50) {
    $(By.xpath("//*[contains(text(), 'TesteProj3 ')]")).click()
  }
}

E (~/o atual nome do projeto deve estar selecionado/) { ->
  assert true
}

E (~/manter a descrição atual do projeto/) { ->
  assert true
}

E (~/selecionar o botão Salvar/) { ->
  at PageProj

  Thread.sleep(5000)

  waitFor(60) {
    $(By.xpath('/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]')).click()
  }

  Thread.sleep(2000)
}

E (~/o sistema deverá informar que já existe um projeto com aquele nome/) { ->
  at PageProj

  Thread.sleep(5000)

  waitFor(60) {
    $(By.xpath('/html/body/div[2]/div/div[2]/div/div[2]/button')).click()
  }

  Thread.sleep(5000)
}

//CENÁRIO 8
E (~/deseja pesquisar um projeto pelo nome/) { ->
  assert true
}

Então (~/será aberto um modal/) { ->
  assert true
}

Quando (~/selecionar o icone de pesquisa ao lado da coluna Nome do Projeto/) { ->
  at PageProj

  Thread.sleep(3000)

  waitFor(30) {
    page.btnsearch.click()
  }

  Thread.sleep(2000)
}

Quando (~/o usuário inserir:'(.*)'/) { String psqnome->
  at PageProj

    Thread.sleep(1000)

  waitFor(30) {
    $(By.xpath('/html/body/div[2]/div/div/div/div/input')).value(psqnome)
  }

    Thread.sleep(1000)
}

E (~/selecionar o botão Search/) { ->
  at  PageProj

  Thread.sleep(1000)

      waitFor(60) {
    page.btnpesq.click()
      }

  Thread.sleep(3000)
}

Então (~/o sistema deve apresentar o projeto que possui o nome inserido no campo de pesquisa/) { ->
  assert true
}

E (~/se não houver nenhum projeto com o nome informado o sitema deve apresentar a página em branco/) { ->
  assert true
}

//CENARIO 9
E (~/selecionar o botão "Reset"/) { ->
  at PageProj

  Thread.sleep(5000)

      waitFor(60) {
    page.btnreset.click()
      }

    Thread.sleep(5000)
}

Então (~/o sistema deve cancelar a operação/) { ->
  assert true
}

E(~/o modal deve ser fechado/) { ->
  assert true
}

//CENÁRIO 10
E (~/deseja pesquisar um projeto pela Tag/) { ->
  assert true
}

Quando (~/selecionar o icone ao lado da coluna Tags/) { ->
  at PageProj

  Thread.sleep(3000)

      waitFor(40) {
    page.btntag.click()
      }

  Thread.sleep(3000)
}

Então (~/será aberto um modal com as opções de tags/) { ->
  assert true
}

Quando (~/o usuário selecionar a Tag Experimentação/) { ->
  at PageProj

  Thread.sleep(2000)

  waitFor(60) {
    $(By.xpath('/html/body/div[2]/div/div/div/ul/li[1]/label')).click()
  }

  Thread.sleep(3000)
}

E (~/selecionar o botão "OK"/) { ->
  at PageProj

  Thread.sleep(3000)

  waitFor(50) {
    page.btnok.click()
  }

  Thread.sleep(3000)
}

Então (~/o sistema deverá exibir os projetos que possuem experimeto/) { ->
  assert true
}

Então (~/novamente será aberto o modal com as opções de tags/) { ->
  assert true
}

Quando (~/o usuário selecionar a Tag Pré implantação/) { ->
  //Tirar a seleção da tag Experimentação
  at PageProj

    Thread.sleep(1000)

    waitFor(50) {
    $(By.xpath('/html/body/div[2]/div/div/div/ul/li[1]/label')).click()
    }

  Thread.sleep(1000)

    waitFor(50) {
    $(By.xpath('/html/body/div[2]/div/div/div/ul/li[2]/label')).click()
    }

  Thread.sleep(3000)
}

Então (~/o sistema deverá exibir os projetos que possuem Pré implantação/) { ->
  assert true
}

Quando (~/o usuário selecionar a Tag Implantado/) { ->
  //Tirar a seleção da tag Pré implantação
  at PageProj

  Thread.sleep(1000)

  waitFor(50) {
    $(By.xpath('/html/body/div[2]/div/div/div/ul/li[2]/label')).click()
  }

  Thread.sleep(3000)

  waitFor(50) {
    $(By.xpath('/html/body/div[2]/div/div/div/ul/li[3]/label')).click()
  }

  Thread.sleep(3000)
}

Então (~/o sistema deverá exibir os projetos que possuem Experimento Implantado/) { ->
  assert true
}

//CENÁRIO 11
Quando (~/o usuário selecionar Experimentação/) { ->
  at PageProj

  Thread.sleep(1000)

  waitFor(50) {
    $(By.xpath('/html/body/div[2]/div/div/div/ul/li[1]/label')).click()
  }

  Thread.sleep(2000)
}

Quando(~/o usuário selecionar Pré implantação/) { ->
  at PageProj

  Thread.sleep(1000)

  waitFor(50) {
    $(By.xpath('/html/body/div[2]/div/div/div/ul/li[2]/label')).click()
  }

  Thread.sleep(1000)
}

Quando (~/o usuário selecionar Implantado/) { ->
  at PageProj

  Thread.sleep(1000)

  waitFor(50) {
    $(By.xpath('/html/body/div[2]/div/div/div/ul/li[3]/label')).click()
  }

  Thread.sleep(2000)
}

E (~/selecionar o botão "Resetar"/) { ->
  at PageProj

  Thread.sleep(2000)

    waitFor(60) {
      page.btnresetar.click()
    }

    Thread.sleep(5000)
}

//CENÁRIO 12
Quando (~/selecionar o botão Excluir/) { ->
  at PageProj

  Thread.sleep(2000)

    waitFor(60) {
      page.btndeleteProj.click()
    }

    Thread.sleep(5000)
}

E (~/o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir esse Projeto?"/) { -> assert true }

E (~/confirmar a operação clicando no botão Sim/) { ->
  at PageProj

    waitFor(60) {
      page.deleteYes.click()
    }

    Thread.sleep(5000)
}

Então (~/o projeto será excluído/) { -> assert true }

E (~/o usuário será direcionado para a página Meus Projetos/) { -> assert true }

//CENÁRIO 13
Quando (~/selecionar um dos projetos da lista/) { ->
  at PageProj

    waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[3]/td[1]/label/span")).click()
    }
}

E (~/na coluna ação selecionar a opção Excluir/) { ->
  at PageProj

  Thread.sleep(1000)

  waitFor(60) {
    page.btnexcluir.click()
  }

      Thread.sleep(1000)
}

E (~/o usuário confirmar a operação clicando no botão Sim/) { ->
  at PageProj

  Thread.sleep(5000)

  waitFor(60) {
    page.btnsim.click()
  }

      Thread.sleep(6000)
}

Então (~/o projeto será excluído da lista de Projetos/) { ->
  assert true
}

//CENÁRIO 14
E (~/o usuário clicar no botão Não/) { ->
  at PageProj

  Thread.sleep(1000)

  waitFor(60) {
    page.btnNao.click()
  }

      Thread.sleep(2000)
}

Então (~/a operação será cancelada/) { ->
  assert true
}

E (~/o projeto não será excluído e permanecerá na lista de projetos/) { ->
  at PageProj

  Thread.sleep(2000)

    waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[3]/td[1]")).click()
    }

    Thread.sleep(2000)
}

Dado (~/que o usuário seleciona outro projeto/) { ->
  at PageProj

  Thread.sleep(2000)

    //Selecionar segundo projeto da lista
    waitFor(60) { $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[2]/td[2]/button")).click() }

  Thread.sleep(5000)
}

E (~/acessar a página Detalhes do projeto selecionado/) { -> assert true }

E (~/o usuário selecionar no botão Não/) { ->
  at PageProj

  Thread.sleep(2000)

    waitFor(60) { page.deleteNo.click() }

  Thread.sleep(5000)
}

E (~/o projeto não será excluído/) { ->
  at PageProj

  Thread.sleep(2000)

    waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div/div/div/div/div")).click()
    }

    Thread.sleep(2000)
}

//CENÁRIO 15
E(~/será apresentado sua lista de projetos existente/) { ->
  assert true
}

Quando (~/selecionar vários projetos da lista/) { ->
  at PageProj
  Thread.sleep(5000)

    waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[1]/div/label/span")).click()
    }

      Thread.sleep(5000)
}

E (~/clicar no botão Excluir Selecionados/) { ->
  at PageProj

    waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/button[2]/span[2]")).click()
    }

  Thread.sleep(5000)
}

E (~/o sistema abrir uma pop-up com a seguinte mensagem "Excluir projetos selecionados?"/) { ->
  assert true
}

E (~/o usuário selecionar o botão "Não"/) { ->
  at PageProj

    waitFor(60) {
    $(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[1]')).click()
    }
}

E (~/nenhum dos projetos selecionados será excluído/) { ->
  //Tirar a seleção dos projetos
  at PageProj

  Thread.sleep(2000)

    waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[1]/div/label/span")).click()
    }
}

Quando (~/o usuários selecionar vários projetos da lista novamente/) { ->
  at PageProj

  Thread.sleep(3000)

    waitFor(60) {
    $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[1]/div/label/span")).click()
    }
}

E (~/selecionar o botão "Sim"/) { ->
  at PageProj

  Thread.sleep(2000)

    waitFor(60) {
    $(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[2]')).click()
    }

    Thread.sleep(5000)
}

Então (~/todos os projetos selecionados serão excluídos/) { ->
  assert true
}

E(~/removidos da lista de projetos/) { ->
  assert true
}
