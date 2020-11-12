import pages.*
import geb.*
import db.*
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Action
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.remote.DesiredCapabilities
import cucumber.api.PendingException
import org.openqa.selenium.By
import static cucumber.api.groovy.PT.*


String filePath = System.getProperty("user.dir")
String caminho = "/src/cucumber/resources/files/"


//Cenário 1

E(~/um novo experimento será criado, nomeado como Experimento 1/){->
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

E(~/selecionar e arrastar o operador Upload de arquivos para o fluxo/){->
 at PageProj

   Thread.sleep(5000)
      def simulateDragDrop = '''
        function createCustomEvent(type) {
            var event = new CustomEvent("CustomEvent");
            event.initCustomEvent(type, true, true, null);
            event.dataTransfer = {
                data: {
                },
                setData: function(type, val) {
                    this.data[type] = val;
                },
                getData: function(type) {
                    return this.data[type];
                }
            };
            return event;
        }

        function dispatchEvent(node, type, event) {
            if (node.dispatchEvent) {
                return node.dispatchEvent(event);
            }
            if (node.fireEvent) {
                return node.fireEvent("on" + type, event);
            }
        }

        function simulateDragDrop(sourceNode, destinationNode) {
            var EVENT_TYPES = {
                DRAG_END: 'dragend',
                DRAG_START: 'dragstart',
                DROP: 'drop'
            };

            var event = createCustomEvent(EVENT_TYPES.DRAG_START);
            dispatchEvent(sourceNode, EVENT_TYPES.DRAG_START, event);

            var dropEvent = createCustomEvent(EVENT_TYPES.DROP);
            dropEvent.dataTransfer = event.dataTransfer;
            dispatchEvent(destinationNode, EVENT_TYPES.DROP, dropEvent);

            var dragEndEvent = createCustomEvent(EVENT_TYPES.DRAG_END);
            dragEndEvent.dataTransfer = event.dataTransfer;
            dispatchEvent(sourceNode, EVENT_TYPES.DRAG_END, dragEndEvent);
        }

        var source = document.getElementsByClassName('drag-icon')[1];
        var destination = document.getElementsByClassName('react-flow')[0];
        simulateDragDrop(source, destination);
      '''
      browser.driver.executeScript(simulateDragDrop)

      Thread.sleep(8000)
}  


Quando(~/selecionar o operador novamente/){->
 at PageProj 
   
  Thread.sleep(5000)

     waitFor(60){
         page.operadorUpArq.click()
       }

 Thread.sleep(2000)

}


E(~/no drawer de propriedades selecionar o botão Importar/){->
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

E(~/selecionar a tarefa Imputação de Valores Faltantes/){->
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

E(~/selecionar a tarefa Regressão Logística/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.opReglog.click()
    }

  Thread.sleep(5000)
}

Quando(~/o usuário selecionar a tarefa Imputação de Valores Faltantes/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60){
      page.tarefaImputer.click()
    }

  Thread.sleep(5000)

}
 
E(~/no drawer de propriedades da tarefa selecionar o campo Atributo Alvo/){->
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

Então(~/o usuário irá selecionar o atributo Species/){->
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

Quando(~/selecionar a tarefa Regressão Logística presente no fluxo/){->
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

E(~/no campo Modo de seleção das features, o usuário irá selecionar a opção Incluir/){->
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

E(~/no campo Features para incluir-remover no modelo selecionar o atributo SepalLengthCm/){->
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


E(~/no campo Features para fazer codificação ordinal selecionar o atributo PetalWidthCm/){->
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


E(~/o sistema enviar a seguinte mensagem Treinamento iniciado!/){->
  assert true
}

Então(~/cada tarefa será sinalizada como Tarefa Pendente/){->
  assert true
}

E(~/os botões Salvar como Template e Executar serão desabilitados/){->
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
  
  Thread.sleep(5000)

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



//CENÁRIO 3.1

 Dado(~/que o projeto contém tarefas no fluxo/){-> assert true }

 Quando(~/o usuário selecionar a Tarefa para puxar o conector/){->
   at PageProj

      Thread.sleep(2000)


       println "Objeto"
       println $(By.xpath("//*[@id='d30740d2-87f5-4f86-aa9b-8850e5d97ed7']/div/div[3]/div"))
       println "Objeto2"
       println $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[2]/div/div[1]/svg/g/g"))

       page.interact {
        println "OK"
         clickAndHold($(By.xpath("//*[@id='d30740d2-87f5-4f86-aa9b-8850e5d97ed7']/div/div[3]/div")))
         perform()
         

           println "OK2"
           moveToElement($(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[2]/div/div[1]/svg/g/g")))
                    moveByOffset(1, 1) 
                    release()

       }

   }
 
    
   

    E(~/conectar uma tarefa na outra/) {-> assert true }
   
       

//CENÁRIO 4

Quando(~/selecionar a aba de um experimento/){-> assert true }

E(~/clicar no botão direito/){->
 at PageProj
 
  Thread.sleep(5000)

      println "Aba"
      println $(By.xpath("//*[contains(text(), 'Experimento 1')]"))
      page.interact { 
 
       println "OK"

          contextClick($(By.xpath("//*[contains(text(), 'Experimento 1')]")))
          release()
      }

    Thread.sleep(5000) 
}

E(~/selecionar a opção "Renomear"/){->
 at PageProj

   waitFor(60){
      page.btnrename.click() }

  Thread.sleep(5000)
}


E(~/o usuário deverá limpar o campo/){->
 at PageProj

   waitFor(60) {
     page.clearcamp.click()
     }

   Thread.sleep(2000)  

}

E(~/inserir um novo nome para o experimento: '(.*)'/){String rename->
 at PageProj

     waitFor(60) {
        page.inputname.value(rename)
      }

   Thread.sleep(5000)  
}

Quando(~/clicar no botão OK/){->
 at PageProj

   Thread.sleep(2000) 

   waitFor(60) {
      $(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/span/span/span[2]/button")).click()
     }

   Thread.sleep(2000)  
}

Então(~/o nome do experimento será alterado/){-> assert true}

E(/o modal será resetado/) {  ->
    assert true
}

//CENÁRIO 5

Quando(~/selecionar um projeto da lista/){->
 at PageProj

   Thread.sleep(2000)

   waitFor(60){
     page.projeselect.click()
   }

   Thread.sleep(5000)
}


E (~/selecionar a opção Duplicar/){->
 at PageProj
  
  waitFor(60){
    page.btndup.click()
  }

}

E(~/o usuário deverá inserir o nome: '(.*)' para a duplicata/){String namedup->
 at PageProj

 waitFor(60){
   page.inputname.value(namedup)
 }

  Thread.sleep(5000)
} 

Então(~/o Experimento será duplicado/){-> assert true}

Dado(/que o usuário está na aba da duplicata do experimento/){-> assert true}



//CENÁRIO 6

 Dado(~/selecionar um projeto com N Experimentos/){->
    at PageProj
 
   Thread.sleep(5000)

   waitFor(60) {
     page.selectprojteste.click()
     }

   Thread.sleep(5000)
 } 

 Quando(/selecionar o botão Comparar Resultados/){->
   at PageProj

   waitFor(60) {
     page.btncomp.click()
     }

  Thread.sleep(5000)
 }

 E(~/o sistema abrir a tela "Comparar resultados"/){-> assert true}

 E(~/selecionar o botão Adicionar Resultado/){->
   at PageProj

   waitFor(60) {
     page.btnaddresult.click()
     }

   Thread.sleep(5000)

    waitFor(60){
      page.btnaddresult2.click()
    }

    Thread.sleep(2000)
 }
 
 E(~/selecionar os experimentos que deseja comparar/){->
   at PageProj

    Thread.sleep(5000)

   waitFor(60) {
     page.btnselectexp.click()
     }

   Thread.sleep(5000)

    waitFor(60) {
     page.btnexpe.click()
     }

   Thread.sleep(2000)

   waitFor(60) {
     page.btnopc.click()
     }

   Thread.sleep(5000)

      waitFor(60) {
       page.selecttask.click()
     }

   Thread.sleep(5000)
     
       waitFor(60) {
       $(By.xpath("/html/body/div[4]/div/div/div/div[2]/div/div/div/div/div")).click()
      }

     Thread.sleep(5000)
    
 }

 Então(~/deverá ser apresentado o histórico de execução de cada experimento selecionado/){->
   at PageProj

    waitFor(60) {
     page.btnselectexp2.click()
     }

   Thread.sleep(5000)

    waitFor(60) {
     page.btnexpe2.click()
     }

   Thread.sleep(2000)

   waitFor(60) {
     page.btnopc2.click()
     }

   Thread.sleep(5000)
 }
 
 Quando(~/o usuário selecionar uma das opções do histórico de execução/){->
   assert true
 }


 E(~/selecionar uma tarefa/){->
  at PageProj

    Thread.sleep(2000)

   waitFor(60) {
     page.selecttask2.click()
     }

   Thread.sleep(5000)
     
     waitFor(60) {
      page.selectoptask2.click()
      
     }

     Thread.sleep(7000)
 }

 Então(~/será exibido os resultados, as métricas e os parâmetros da tarefa selecionada/){->
  at PageProj

    Thread.sleep(5000)

   //selecionar aba: parâmetros do primeiro experimento - Tarefa selecionada: Análise Descritiva
   waitFor(60){
     $(By.xpath("//*[@id='rc-tabs-1-tab-3']")).click() 
   }
    
     Thread.sleep(5000)

    //selecionar aba: métricas do segundo experimento
     waitFor(60){
     $(By.xpath("//*[@id='rc-tabs-2-tab-2']")).click()
    }

    Thread.sleep(5000)

    //selecionar aba: parâmetros do segundo experimento
     waitFor(60){
     $(By.xpath("//*[@id='rc-tabs-2-tab-3']")).click()

    }

     Thread.sleep(5000)

     //fechar janela
      waitFor(60){
        $(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button")).click()
      }

      Thread.sleep(5000)
 }



//CENÁRIO 7
E(~/esse Projeto possui experimentos associados/){-> assert true }

Quando(~/o usuário selecionar o botão "Salvar como template"/){->
 at PageProj

   waitFor(60) {
     page.btnsalvartemp.click()
     }

  Thread.sleep(5000)
}


Então(~/o modal Novo Template será aberto/){-> assert true}

E(~/o nome "Novo template" deve estar destacado/){-> assert true}

Quando(~/o usuário limpar o campo nome do template/){->
  at PageProj

   waitFor(60) {
     page.btnlimptemplate.click()
     }

  Thread.sleep(2000)
}


Então(~/a mensagem "Por favor insira um nome para o template!" deve ser exibida abaixo do campo nome/){-> assert true}

Quando(~/inserir: '(.*)'/){String template->
 at PageProj

   waitFor(60) {
     page.camptemplate.value(template)
     }

  Thread.sleep(2000)

}

E(~/selecionar o botão "Salvar"/){->
 at PageProj

   waitFor(60) {
     page.btnsalvar.click()
     }

  Thread.sleep(2000)
}

Então(~/o Menu Templates ficará visível no Armazém de Tarefas/){-> assert true }

E(~/o template será salvo nesse menu/){-> 
 at PageProj

  Thread.sleep(5000)

   waitFor(60) {
     page.menutemplates.click()
     }

  Thread.sleep(2000)

}

Quando(~/o usuário selecionar o botão "Novo experimento"/){->
 at PageProj

  Thread.sleep(5000)

   waitFor(60) {
     page.newExperimento.click()
     }

  Thread.sleep(2000)
}

E(~/nomear o experimento como: '(.*)'/){String nameExp->
 at PageProj

  Thread.sleep(2000)

   waitFor(60) {
     page.camptemplate.value(nameExp)
     }

  Thread.sleep(2000)
}
E(~/clicar no botão "Criar"/){->
 at PageProj

   waitFor(60) {
     page.btncriar.click()
     }

  Thread.sleep(2000)
}


Quando(~/selecionar o template salvo anteriormente/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60) {
     page.selectTemplate.selectionchange()
     }

  Thread.sleep(2000)
} 

Então(~/as tarefas do template serão adicionadas ao fluxo/){->
 at PageProj

 Thread.sleep(5000)

     inject {  
                    println "Mover operador"
                    moveToElement($(By.xpath("//*[@id='TEMPLATES$Menu']/li/div/div[1]/span")))
                    moveByOffset(0,0).click()
                    
                    perform()                                                                                                              
             }
 
}


E(~/o usuário poderá iniciar seu novo experimento/){-> assert true}


Dado(/que o usuário deseja criar um novo Projeto para testar o template/) {-> throw new PendingException() }

Então(/o usuário será direcionado a página do Projeto/) {-> throw new PendingException()}

Quando(/o usuário selecionar o Menu Templates/) { -> throw new PendingException()}



//CENÁRIO 8

Quando(~/selecionar o botão Interromper/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60) {
     page.selectTemplate.click()
     }

  Thread.sleep(2000)

}

Então(~/a mensagem "Interrompendo execução..." deve ser exibida no topo da tela/){-> assert true}

Quando(~/o processo de interrupção for finalizado/){-> assert true}

E(~/a mensagem "Treinamento interrompido!" for exibido no topo da tela/){-> assert true }

Então(~/as tarefas no fluxo de experimento deverão ser sinalizadas como "Tarefa Interrompida"/){-> assert true }

E(~/ao selecionar as tarefas o usuário poderá editar suas propriedades/){-> assert true}

E(~/executar o experimento novamente/){-> assert true}


//CENÁRIO 9

Quando(~/selecionar o botão "Preparar para Implantação"/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60) {
     page.btnImplantar.click()
     }

  Thread.sleep(2000)
}

Então(~/o usuário será direcionado a página Fluxos implantados/){-> assert true}

Quando(~/o usuário voltar para a página do Projeto/){->
 at PageProj

  Thread.sleep(2000)

   waitFor(60) {
      $(By.xpath("//*[@id='root']/section/aside/div[1]/ul/li[1]")).click()
     }

  Thread.sleep(2000)

     waitFor(60) {
          $(By.xpath("//*[contains(text(), 'Teste')]")).click() }

  Thread.sleep(20000)

}
Então(~/deverá observar que o botão Preparar para Implantação estará em modo de execução/){-> assert true}

E(~/quando a implantação for finalizada/){-> assert true }

Então(~/o botão de implantação será desabilitado/){->  
 at PageProj

  Thread.sleep(2000)

         waitFor(60) {
          $(By.xpath("//*[@id='root']/section/aside/div[1]/ul/li[2]")).click() }

       Thread.sleep(60000)


            waitFor(60) {
              $(By.xpath("//*[@id='root']/section/aside/div[1]/ul/li[1]")).click()}

       Thread.sleep(2000)

              waitFor(60) {
                $(By.xpath("//*[contains(text(), 'Teste')]")).click() }

   Thread.sleep(5000)
}

//CENÁRIO 10

Quando(~/selecionar a Tarefa presente no fluxo de experimento/){->
 at PageProj
 
   waitFor(60) { page.selectTask.click() } 
   
  Thread.sleep(5000)
}

E(~/selecionar o botão Excluir Tarefa/){->
  at PageProj
 
   waitFor(60) { page.btnremovetask.click() } 
   
  Thread.sleep(5000)
}

Então(~/o sistema irá abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir essa tarefa?"/){-> assert true}

Quando(~/o usuário selecionar o botão Sim/){->
 at PageProj
 
   waitFor(60) { page.btnsimremover.click() }

  Thread.sleep(5000)
 
}


Então(~/a tarefa será retirada do fluxo de experimento/){-> assert true }

E(~/o usuário poderá adicionar outra Tarefa ao fluxo/){-> assert true }

Quando(~/o usuário selecionar o botão Excluir, ao lado do nome do Experimento/){->
  at PageProj
 
   Thread.sleep(5000)

     waitFor(60) { 
       $(By.xpath("//*[@id='rc-tabs-0-tab-ddc540f8-0f6c-4179-b1b2-cc5cf3b2afd2']/div/div/span")).click() 
       }

  Thread.sleep(5000)
}

E(~/uma pop-up com a seguinte mensagem "Excluir Experimento?" for exibida/){-> assert true}

E(~/selecionar o botão Sim/){-> 
 at PageProj
 
   waitFor(60) { page.btnRemoverconfirm.click() }

  Thread.sleep(5000) 
}

Então(~/o experimento será excluído/){-> assert true }

Quando(~/o usuário selecionar o botão excluir/){->
 at PageProj
 
   Thread.sleep(5000) 

     waitFor(60){ 
       $(By.xpath("//*[@id='rc-tabs-0-tab-abd9374f-335c-4d56-bd99-6f9f777b21f9']/div/div/span")).click()
      }
 
   Thread.sleep(5000)

}

E(~/clicar no botão Não/){->
 at PageProj
 
   Thread.sleep(5000)

      waitFor(60){ 
        page.btnremoverNo.click() 
       }

   Thread.sleep(2000)

} 

Então(/o pop-up será fechado/) {  -> assert true }

Então(/o experimento não será excluído/) {  -> assert true }

E(~/se o usuário excluir todos os Experimentos do Projeto/){->
 at PageProj
 
     waitFor(60){ 
       $(By.xpath("//*[@id='rc-tabs-0-tab-abd9374f-335c-4d56-bd99-6f9f777b21f9']/div/div/span")).click()
      }
 
   Thread.sleep(5000)
  
     waitFor(60){
       $(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[2]")).click() 
       }

   Thread.sleep(6000)
     
}

Então(~/a página do Projeto ficará vazia/){-> 
 assert true 

}
 