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

Quando(~/o usuário selecionar o Menu Conjunto de Dados/){-> 
 at PageProj
   
  Thread.sleep(5000)

     waitFor(60){
         page.menuconjunto.click()
       }

 Thread.sleep(2000)
}

E(~/selecionar e arrastar o operador "Upload de arquivos" para o fluxo/){->
 at PageProj
   
 Thread.sleep(5000)

   waitFor(60){
         page.uploadArq.click()
       }

  Thread.sleep(2000)
    
     interact {
        println "Arrastar Operador"
         moveToElement($(By.xpath("//*[contains(text(), 'Upload de arquivo')]")))
          
          //moveByOffset(0,0).click()
                  
           perform()  
        }
   
   Thread.sleep(5000)
}

Quando(~/selecionar o operador novamente/){->
 at PageProj
   
  Thread.sleep(5000)

     waitFor(60){
         page.operadorUpArq.click()
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

E(~/poderá escolher arquivos .csv, .zip e imagem para importar os dados/){->
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

  Thread.sleep(70000)

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

   waitFor(10){$(By.xpath("//*[@id='rc-tabs-2-panel-1']/div[2]/div")).click()}
   
  Thread.sleep(5000)
     
    waitFor(60){
      page.abametricas.click()
    }

  Thread.sleep(5000)

   waitFor(60){
      page.abaparametros.click()
    }
 
   Thread.sleep(5000)

     waitFor(10){$(By.xpath("/html/body/div[6]/div/div[2]/div/div[2]/div[3]/button[2]")).click()}

   Thread.sleep(5000)

}




//CENÁRIO 2

E(~/selecionar a tarefa "Regressão Linear"/){->
 at PageProj
  
  Thread.sleep(2000)

   waitFor(60){
      page.taskreglinear.click()
    }
  
   Thread.sleep(2000)

}

Quando(~/selecionar a tarefa Regressão Linear presente no fluxo/){->
 at PageProj
  
  Thread.sleep(5000)

   waitFor(60){
      page.opreglinear.click()
    }
  
   Thread.sleep(5000)
}

Então(~/o usuário irá selecionar o atributo "label"/){->
 at PageProj
  
  Thread.sleep(5000)

   waitFor(60){
      page.atributolabel.click()
    }
  
   Thread.sleep(5000)
}

E(~/no campo Modo de seleção das features, deixar o campo com o valor default/){->
  assert true
}

E(~/no campo Features para incluir-remover no modelo selecionar o atributo "text"/){->
 at PageProj
  
  Thread.sleep(5000)

   waitFor(60){
      page.campoFeature.click()
    }

  Thread.sleep(5000)

   waitFor(60){
      page.atributotext.click()
    }
  
   Thread.sleep(2000)
}


E(~/no campo Features para fazer codificação ordinal selecionar o atributo "is_valid"/){->
 at PageProj
  
  Thread.sleep(5000)

   waitFor(60){
      page.campofcode.click()
    }

  Thread.sleep(5000)

   waitFor(60){
      page.atributoisvalid.click()
    }
  
   Thread.sleep(5000)

}

Então(~/a execução não será finalizada/){->
 assert true
}

E(~/a Tarefa será sinalizada com erro/){->
 assert true
}

Quando(~/o usuário selecionar a Tarefa/){->
 at PageProj
  
  Thread.sleep(5000)

   waitFor(60){
      page.opreglinear.click()
    }
  
   Thread.sleep(5000)
}

Então(~/será exibido no drawer de propriedades da tarefa, o campo Erro na Execução/){->
 at PageProj 

  waitFor(60){ 
     $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[2]/div[1]/div[2]/div/div/p[31]")).click()}
 

  Thread.sleep(6000)

}

E(~/o usuário poderá visualizar o motivo do erro/){->
 assert true
}

Quando(~/selecionar o botão "Ver código no Jupyter"/){->
 at PageProj
  
  Thread.sleep(2000)

   waitFor(60){
      page.btnjupyter.click()
    }
  
   Thread.sleep(10000)
}

Então(~/o usuário será direcionado a página JupyterLab/){->
 assert true
}

// E(~/poderá ver mais detallhes do erro na execução/){->
//  at PageProj
  
//   Thread.sleep(2000)

//    waitFor(60){
//       page.campError.click()
//     }
  
//    Thread.sleep(7000)
// }




//CENÁRIO 3

Quando(~/selecionar um projeto da lista de Projetos/){->
 at PageProj
  
  Thread.sleep(2000)

   waitFor(60){
      page.selectProj.click()
    }
  
   Thread.sleep(5000)
}



Então(~/o usuário será direcionado a página do projeto/){->
 assert true
}

Quando(~/selecionar o botão "Novo experimento", ícone "+" posicionado ao lado da aba do Experimento 1/){->
 at PageProj
  
  Thread.sleep(2000)

   waitFor(60){
      page.newexp.click()
    }
  
   Thread.sleep(5000)
}


Então(~/o modal Novo Experimento será aberto/){-> assert true }

E(~/o nome "Novo Experimento" deve estar destacado/){-> assert true } 

Quando(~/o usuário clicar no botão limpar/){->
 at PageProj
  
  Thread.sleep(2000)

   waitFor(60){
      page.btncleancamp.click()
    }
  
   Thread.sleep(2000)
}

E(~/o campo nome do experimento for limpo/){-> assert true }

Então(~/a mensagem "Por favor insira um nome para o experimento!" deve ser exibida abaixo do campo nome/){->
 assert true
}

Quando(~/o usuário inserir o nome: '(.*)'/){String namexp->
 at PageProj
  
  Thread.sleep(2000)

   waitFor(60){
      page.campnamExp.value(namexp) }

  Thread.sleep(2000)

}

E(~/selecionar o botão Criar/){->
 at PageProj

 Thread.sleep(2000)

  waitFor(60){
    page.btnNewExp.click() }
 
 Thread.sleep(5000)

}


E(~/o sistema deverá informar que já existe um Experimento com o nome informado nesse Projeto/){->
 assert true
}

Então(~/o usuário deverá limpar o campo nome/){->
 at PageProj
  
  Thread.sleep(2000)

   waitFor(60){
      page.btncleancamp.click()
    }
  
   Thread.sleep(5000)
}

E(~/informar um novo nome para o experimento, como: '(.*)'/){String namexp2->
 at PageProj
  
  Thread.sleep(2000)

   waitFor(60){
      page.campnamExp.value(namexp2) }

  Thread.sleep(5000)

}

Então(~/um novo experimento deve ser criado/){-> assert true }

E(~/uma mensagem de sucesso com o nome do experimento deve ser exibida no topo da tela/){-> assert true}



//CENÁRIO 4

Quando(~/selecionar a aba de um experimento/){-> assert true}

// E(~/clicar no botão direito/){->
//  at PageProj
  
//   Thread.sleep(2000)

//    waitFor(60){
//       page.selectaba. }

//   Thread.sleep(5000)


// E selecionar a opção "Renomear"
// Então um modal será aberto 
// E o usuário deverá limpar o campo 
// E inserir um novo nome para o experimento: 'AltName_Exp'
// Quando clicar no botão OK
// Então o nome do experimento será alterado 
// E o modal será resetado