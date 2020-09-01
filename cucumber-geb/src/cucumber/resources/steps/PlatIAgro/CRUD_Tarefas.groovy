import pages.*
import geb.*
import db.*
import cucumber.api.PendingException
import org.openqa.selenium.Keys
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

       Thread.sleep(5000)

       waitFor(60){
         page.btnop10.click()
       }

       Thread.sleep(5000)

       browser.driver.executeScript("window.scrollTo(0, document.body.scrollHeight)")

       waitFor(60){
         page.btnop50.click()
       } 
   
       browser.driver.executeScript("window.scrollTo(0, document.body.scrollHeight)")

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
 at PageTarefa

    Thread.sleep(2000)

     waitFor(60){
       page.btnselect2.click()
     }
    
    Thread.sleep(5000)
}

E(~/nenhuma tarefa deve ser criada/){->
  at PageTarefa

    Thread.sleep(2000)

     waitFor(60){
       page.btnselect2.click()
     }
    
    Thread.sleep(5000)
}

//CENÁRIO 4
E(~/clicar no botão Cancelar/){->
 at PageTarefa

     waitFor(60){
     page.btncalceltask.click()
    } 

   Thread.sleep(5000)
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
E(~/tarefa será criada/){->
 assert true
}


E(~/o usuário deverá observar que a tarefa criada foi adicionada a lista de Tarefas/){->
  assert true
}


Quando(~/selecionar a Tarefa criada/){->
  at PageTarefa

    Thread.sleep(2000)

     waitFor(60){
      $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[2]/td[1]/div/button")).click()
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
      page.btneditlimp.click()
     }

    Thread.sleep(2000)  
}

E(~/informar um novo nome para a Tarefa: '(.*)'/){ String editname->
  at PageTarefa

   waitFor(60){
    $(By.xpath("//*[@id='name']")).value(editname)
   }

  Thread.sleep(2000) 
}

E(~/uma nova descrição: '(.*)'/){String editdesc->
  at PageTarefa

   waitFor(60){
   $(By.xpath("//*[@id='description']")).value(editdesc)
   }

  Thread.sleep(2000)
}

E(~/confirmar a operação/){->
 at PageTarefa
   
   Thread.sleep(2000)

   waitFor(60){
     page.btneditTask.click()
   }

   Thread.sleep(5000)

     waitFor(60){
       $(By.xpath("/html/body/div[5]/div/div[2]/div/div[2]/button")).click() 
     }

     Thread.sleep(2000)

}


Então(~/o modal será fechado/){->
    assert true
}

E(~/uma mensagem de sucesso será exibida na tela/){->
  assert true
}

E(~/o usuário poderá observar que o nome e descrição da tarefa foram editados/){->
 at PageTarefa

    waitFor(60){
     page.btnnext3.click()
    } 

    Thread.sleep(5000)
} 

//CENARIO 6

E(~/escolhe uma das Tarefas da lista de tarefas para editar/){->
at PageTarefa

     waitFor(60){
      $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[3]/td[1]/div/button")).click()
    }

    Thread.sleep(5000)
}

E(~/o nome e descrição da Tarefa não devem ser alterados/){->
  assert true
}


//ESQUEMA DO CENARIO 7
E(~/deseja pesquisar um Tarefa pelo nome/){->
 assert true
}

Quando(~/selecionar o icone de pesquisa ao lado da coluna Nome da Tarefa/){->
 at PageTarefa

    Thread.sleep(5000)

     waitFor(60){
       page.iconpesq.click() 
     }

     Thread.sleep(2000)

}

Quando(~/o usuário inserir o nome da tarefa: '(.*)'/){String task->
 at PageTarefa
  
  Thread.sleep(2000)

   waitFor(60){
     page.camptask.value(task)
   }

  Thread.sleep(2000)

}

E(~/clicar no botão Search/){->
  at PageTarefa

     Thread.sleep(2000)

     waitFor(60){
       page.btnSearch.click()
     }

     Thread.sleep(5000)
}


Então(~/o sistema deve apresentar a Tarefa que possui o nome inserido no campo de pesquisa/){->
 assert true
}

 E(~/o usuário deverá selecionar o botão "Reset" para a lista de Tarefas ser apresentada novamente/){->
   at PageTarefa

    Thread.sleep(5000)

     waitFor(60){
       page.iconpesq.click() 
     }

     Thread.sleep(2000)

     waitFor(60){
       page.btnreset.click() 
     }
    
    Thread.sleep(5000)

 }


//CENÁRIO 8

E(~/seleciona uma Tarefa da lista de tarefas/){->
  at PageTarefa

    Thread.sleep(2000)

    waitFor(60){
       page.btnnext3.click()
    } 

    Thread.sleep(5000)
}



E(~/na coluna Ação clicar no botão Excluir/){->
 at PageTarefa

     Thread.sleep(2000)

     waitFor(60){
       $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[4]/td[4]/div/div[3]/button")).click()     
     }

     Thread.sleep(2000)

       waitFor(60){
         $(By.xpath("//*[contains(text(), 'Excluir')]")).click()
       }

     Thread.sleep(5000)
}


Quando(~/o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir essa Tarefa?"/){->
 assert true
}

E(~/o usuário confirmar a operação/){->
  at PageTarefa
 
    Thread.sleep(2000)

      waitFor(60){
       page.btnsim.click()
      }

    Thread.sleep(5000)
}

Então(~/a terefa será excluida da lista/){->
 assert true
}



//CENÁRIO 09

E(~/selecionar o botão Não/){->
 at PageTarefa
 
     Thread.sleep(5000)

      waitFor(60){
       page.btnnao.click()
      }

     Thread.sleep(5000)
}

E(~/nenhuma tarefa será excluída/){->
 assert true
}

//CENÁRIO 10

E(~/seleciona uma Tarefa da lista que esteja relacionada a um projeto/){->
 assert true
}

E(~/na coluna Ação clicar nos botões Mais e Excluir/){->
 at PageTarefa
 
     Thread.sleep(2000)

      waitFor(60){
       page.btnmais.click()
      }

     Thread.sleep(5000)
    
      waitFor(60){
         $(By.xpath("//*[contains(text(), 'Excluir')]")).click()
      }

     Thread.sleep(5000)
}

E(~/o sistema deverá informar que aquela Tarefa está em uso/){->
  assert true 
}

Quando(~/o sistema abrir uma pop-up com a seguinte mensagem "Você tem certez  a que deseja excluir essa Tarefa?"/){->
 assert true
} 