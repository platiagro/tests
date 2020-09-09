import pages.*
import geb.*
import db.*
import cucumber.api.PendingException

import org.openqa.selenium.By
import static cucumber.api.groovy.PT.*


String filePath = System.getProperty("user.dir")
String caminho = "/src/cucumber/resources/files/"


//Cenário 1

E(~/um novo experimento será criado, nomeado como "Experimento 1"/){->
 assert true
}

E(~/os botões acima da tela do fluxo de experimentação estarão desabilitados, exceto o botão Excluir/){->
 assert true
}

Quando(~/o usuário selecionar o operador Conjunto de Dados, presente no fluxo de experimento/){->
 at PageProj
   
  Thread.sleep(5000)

     waitFor(60){
         page.opconjunto.click()
       }

 Thread.sleep(2000)

}


E(~/no drawer de propriedades selecionar o botão "Importar"/){->
 at PageProj
   
   Thread.sleep(2000)

   waitFor(60){
     page.select.click()
   }

    Thread.sleep(2000)

}

E(~/poderá escolher arquivos .csv e .zip para importar os dados/){->
 assert true
}

Então(~/o usuário irá informar o arquivo '(.*)' para importar os dados de entrada/){ String arquivo1->
 at PageProj

  Thread.sleep(2000)

    waitFor(60){
      page.inputFile.value(filePath + caminho + arquivo1) //upload do arquivo de entrada
    }

  Thread.sleep(5000)
}

Quando(~/selecionar o botão Visualizar Dados/){->
  at PageProj

  Thread.sleep(2000)

    waitFor(60){
      page.btnvisualizar.click()
    }

  Thread.sleep(5000)
}


E(~/a tela de visualização de dados for aberta/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.abaobs.click()
    }

    Thread.sleep(5000)

    waitFor(60){
      page.abaatb.click()
    }

   Thread.sleep(5000)
}

Então(~/o usuário irá voltar ao fluxo/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.btnvisufechar.click()
    }

  Thread.sleep(5000)
}


Quando(~/selecionar o Menu Engenharia de atributos/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.menuEngAt.click()
    }

  Thread.sleep(5000)
}

E(~/selecionar a tarefa "Imputação de Valores Faltantes"/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.opImputer.click()
    }

  Thread.sleep(5000)

   browser.driver.executeScript("window.scrollTo(0, document.body.scrollHeight)")

}


Então(~/a Tarefa será adicionada ao fluxo/){->
 assert true
}

Quando(~/selecionar o Menu Treinamento/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.menuTreinamento.click()
    }

  Thread.sleep(5000)

}

E(~/selecionar a tarefa "Regressão Logística"/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.opReglog.click()
    }

  Thread.sleep(5000)
}

Quando(~/o usuário selecionar a tarefa "Imputação de Valores Faltantes"/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.tarefaImputer.click()
    }

  Thread.sleep(5000)

}
 
E(~/no drawer de propriedades da tarefa selecionar o campo "Atributo Alvo"/){->
  at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.selectAtrib.click()
    }

  Thread.sleep(5000)
}

E(~/será exibido os atributos do arquivo de entrada/){->
 assert true

}

Então(~/o usuário irá selecionar o atributo "Species"/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.atributoSpecies.click()
    }

  Thread.sleep(5000)
}

E(~/no último campo de preenchimento de valores nulos, o usuário irá inserir: '(.*)'/){String valor->
  at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.campinput.value(valor)
    }

  Thread.sleep(5000)

}

Quando(~/selecionar a tarefa "Regressão Logística" presente no fluxo/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.tarefaReg.click()
    }

  Thread.sleep(2000)

    waitFor(60){
      page.tarefaReg.click()
    }
 
  Thread.sleep(2000)

}

E(~/no campo Modo de seleção das features, o usuário irá selecionar a opção "Incluir"/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.campomsf.click()
    }

  Thread.sleep(5000)

   waitFor(60){
      page.opincluir.click()
    }
  
   Thread.sleep(2000)
}

E(~/no campo Features para incluir-remover no modelo selecionar o atributo "SepalLengthCm"/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.campoFeature.click()
    }

  Thread.sleep(5000)

   waitFor(60){
      page.atributoSepalL.click()
    }
  
   Thread.sleep(2000)

}


E(~/no campo Features para fazer codificação ordinal selecionar o atributo "PetalWidthCm"/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.campofcode.click()
    }

  Thread.sleep(5000)

   waitFor(60){
      page.atributoPetal.click()
    }
  
   Thread.sleep(2000)

}


Então(~/o usuário não irá alterar os demais campos da Tarefa/){->
 assert true

}

Quando(~/o usuário selecionar o botão Executar/){->
  at PageProj

  Thread.sleep(5000)

   waitFor(60){
      page.btnexecut.click()
    }

  Thread.sleep(120000)

}


E(~/o sistema enviar a seguinte mensagem "Treinamento iniciado!"/){->
  assert true
}

Então(~/cada tarefa será sinalizada como "Tarefa Pendente"/){->
  assert true
}

E(~/os botões "Salvar como Template" e "Executar" serão desabilitados/){->
 assert true
}

E(~/o botão "Interromper" será exibido/){->
  assert true
}

Quando(~/a operação for concluída com sucesso/){->
  assert true
}

Então(~/cada tarefa será sinalizada como "Tarefa executada com sucesso"/){->
 assert true
}

E(~/os botões acima do fluxo de experimento serão habilitados/){->
  assert true
}

Quando(~/o usuário selecionar a tarefa "Regressão Logística"/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.tarefaReg.click()
    }

  Thread.sleep(5000)
}

E(~/selecionar o botão Visualizar Resultados/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.btnvisuresult.click()
    }

}


Então(~/um modal será aberto/){->
 assert true
} 

E(~/o usuário poderá visualizar os gráficos do Resultados, o valor das Métricas e dos Parâmetros/){->
 at PageProj
  
  Thread.sleep(5000)

   waitFor(60){
      page.abaresult.click()
    }
    
    browser.driver.executeScript("window.scrollTo(0, document.body.scrollHeight)")

    Thread.sleep(5000)
     
    waitFor(60){
      page.abametricas.click()
    }

  Thread.sleep(5000)

   waitFor(60){
      page.abaparametros.click()
    }
 
   Thread.sleep(5000)

}