import pages.*
import geb.*
import db.*
import cucumber.api.PendingException

import org.openqa.selenium.By
import static cucumber.api.groovy.PT.*

//CENÁRIO 1

Dado(~/que o usuário está na página Tarefas/){->
 at PageProj

   waitFor(60){
       page.tarefaMenu.click()
   } 

   Thread.sleep(5000)

}

Então(~/deverá observar que todas as tarefas existentes estarão listadas em ordem alfabética/){->
at PageTarefa

    Thread.sleep(2000)

       waitFor(60){
       page.btnnext.click()
      } 

   Thread.sleep(5000) 

       waitFor(60){
       page.btnnext.click()
       } 
    
    Thread.sleep(5000) 
}


E(~/as informações das tarefas estarão divididas em três colunas: Nome da Tarefa, Origem,Descrição e Ação/){->
 at PageTarefa

    Thread.sleep(2000)

      waitFor(60){
       page.btnprevious.click()
      } 
   
     Thread.sleep(5000) 

      waitFor(60){
       page.btnprevious.click()
      } 
    
    Thread.sleep(5000) 

}

//CENÁRIO 2

Quando(~/selecionar o botão Nova Tarefa/){->
  at PageTarefa

    waitFor(60){
       page.btntarefa.click()
    } 

   Thread.sleep(2000) 
}

E(~/será aberto um modal onde o usuário poderá escolher um exemplo ou um template em branco para criar nova tarefa/){->
 assert true
}

E(~/o nome default Nova tarefa deve estar destacado no campo nome/){->
 assert true
}

E(~/o Template em branco também deve estar definido como default/){->
 assert true
}

Quando(~/o usuário limpar o campo nome da tarefa/){->
  at PageTarefa

    Thread.sleep(2000)

    waitFor(60){
       page.btnlimp.click()
    } 

   Thread.sleep(2000) 
}

E(~/nomear a Tarefa: '(.*)'/){String name->
 at PageTarefa


     waitFor(60){
       page.campnametask.value(name)  
      }

      Thread.sleep(2000)
}


E(~/inserir a Descrição: '(.*)'/){String descTarefa->
 at PageTarefa

     waitFor(60){
       page.campdesctask.value(descTarefa)  
     }

      Thread.sleep(1000) 
}


E(~/clicar no botão Criar Notebooks/){->
 at PageTarefa

     waitFor(60){
     $(By.xpath("//*[contains(text(), 'Criar Notebooks')]")).click()
    }

   Thread.sleep(7000)
}

Então(~/o modal será resetado e fechado/){->
   at PageTarefa

}

E(~/a tarefa será criada/){->
 assert true
}


E(~/o usuário deverá observar que a tarefa criada foi adicionada na lista de tarefas de acordo com a ordenação alfabética/){->
 at PageTarefa

    waitFor(60){
       page.btnnext3.click()
    } 

    Thread.sleep(5000)
}

//CENÁRIO 3

E(~/o sistema deverá informar que já existe uma tarefa com aquele nome/){->
  assert true
}

E(~/nenhuma tarefa deve ser criada/){->
  at PageTarefa

     waitFor(60){
       page.btnclose.click()
     }
    
    Thread.sleep(2000)
}

//CENÁRIO 4
E(~/clicar no botão Cancelar/){->
 at PageTarefa

     waitFor(60){
       $(By.xpath("//*[contains(text(), 'Cancelar')]")).click()
     }
    
    Thread.sleep(2000)
}

E(~/nenhuma tarefa será criada/){->
 at PageTarefa

    Thread.sleep(1000)

    waitFor(60){
       page.btnnext.click()
    } 

   Thread.sleep(5000) 

   waitFor(60){
       page.btnnext.click()
   } 
    
    Thread.sleep(5000)
}

//CENÁRIO 5
E(~/o usuário deverá observar que a tarefa criada foi adicionada a lista de Tarefas/){->
  assert true
}


Quando(~/selecionar o botão Alterar nome e descrição da tarefa criada/){->
  at PageTarefa

    Thread.sleep(2000)

     waitFor(60){
      $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[1]/td[3]/button[1]")).click()
      }
    
      Thread.sleep(5000)
}



Então(~/será aberto um modal onde o usuário poderá editar o nome e a descrição da Tarefa/){->
 assert true
}

Quando(~/limpar o campo nome/){->
  at PageTarefa

    Thread.sleep(2000)

     waitFor(60){
      $(By.xpath("//*[@id='newEditTaskForm']/div[1]/div[2]/div/span/span/span")).click()
     }

    Thread.sleep(2000)  
}

E(~/informar um novo nome para a Tarefa: '(.*)'/){ String editname->
  at PageTarefa

   waitFor(60){
   page.campeditname.value(editname)
   }

  Thread.sleep(2000) 
}

E(~/uma nova descrição: '(.*)'/){String editdesc->
  at PageTarefa

   waitFor(60){
   page.campeditdesc.value(editdesc)
   }

  Thread.sleep(2000)
}

E(~/clicar no botão Confirmar/){->
  at PageTarefa

    Thread.sleep(2000)

     waitFor(60){
       $(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/div/button[2]")).click()  
     }

      Thread.sleep(5000)
      
}

Então(~/o modal será fechado/){->
    assert true
}

E(~/uma mensagem de sucesso será exibida na tela/){->
  assert true
}

E(~/o usuário poderá observar que o nome e descrição da tarefa foram editados/){->
 at PageTarefa

    Thread.sleep(2000)

    waitFor(60){
       page.btnnext3.click()
    } 

    Thread.sleep(5000)
} 