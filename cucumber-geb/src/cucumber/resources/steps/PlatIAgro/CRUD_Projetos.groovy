import pages.*
import geb.*
import db.*
import cucumber.api.PendingException

import org.openqa.selenium.By
import static cucumber.api.groovy.PT.*


//Contexto

 Dado(~/que o usuário acessa a plataforma PlatIAgro/){->
 to PageProj
 }

 E(~/está na tela inicial/){->
 assert true
 }


//CENÁRIO 1
Dado(~/que o usuário está na página Meus Projetos/){->
 assert true 
}

E(~/será apresentado sua lista de projetos existentes/){->
 at PageProj

   waitFor(60){
     $(By.xpath("//*[@id='root']/section/section/div[2]/div/ul/li[4]/div/div[1]")).click()
   }

    Thread.sleep(2000)
  }

 Então(~/deverá observar que as informações dos projetos estarão divididos em cinco colunas: Nome do Projeto, Descrição, Tags, Última Modificação e Ação/){->
 at PageProj

   waitFor(60){
     $(By.xpath("//*[@id='root']/section/section/div[2]/div/ul/li[4]/div/div[1]")).click()
    }

    Thread.sleep(5000)
  }

//CENÁRIO 2

Quando(~/clicar no botão Novo Projeto/){->
 at PageProj

       waitFor(60){
       $(By.xpath("//*[@id='root']/section/section/div[1]/div/span/div/button/span[1]")).click()
       } 

     Thread.sleep(5000)
}

Então(~/o sistema deve abrir um modal, com o nome Novo Projeto selecionado/){->
    assert true
} 


// Quando(~/o usuário limpar o campo nome do projeto/){->
//  at PageProj

//     Thread.sleep(5000)

//     waitFor(60){
//       $(By.xpath("//*[@id='projectForm']/div[1]/div[2]/div/div/span/span/span")).click()
//     }

//     Thread.sleep(5000)

// }       



E(~/nomear o projeto com:'(.*)'/){String nome->
   at PageProj
        
        waitFor(60){
       page.campnome.value(nome)  
        }

      Thread.sleep(5000) 
}

E(~/informar a seguinte descrição:'(.*)'/){String desc->
   at PageProj

      waitFor(60){
       page.campDesc.value(desc)  
       } 
       
       Thread.sleep(5000) 
}

Quando(~/clicar no botão Criar/){->
    at PageProj

     waitFor(60){
       page.btnConfirm.click()  
       } 
       Thread.sleep(5000) 
 }


Então(~/o novo projeto será criado/){->
  assert true
} 

E(~/o usuário será direcionado para a página do projeto/){->
  assert true
}


E(~/nessa página poderá escolher se deseja iniciar um fluxo de Experimentação ou Pré -implantação/){->
  assert true
}

Quando(~/o usuário retornar para a página Meus Projetos deverá observar se o novo projeto foi adicionado à lista de projetos/){->
  at PageProj

   waitFor(60){
       $(By.xpath("//*[@id='root']/section/section/div[1]/div/div/div/div/span")).click()
       } 

    Thread.sleep(5000)   
}


//CENÁRIO 3

E(~/o usuário clicar no botão Cancelar/){->
   at PageProj
 
   Thread.sleep(5000)

       waitFor(60){
       page.btncancel.click()  
       } 

      Thread.sleep(5000)  
}

Então(~/o modal deve ser resetado e fechado/){->
  assert true
}

E(~/nenhum projeto deve ser criado/){->
  assert true
}

//CENÁRIO 4

Então(~/a operação deve ser cancelada/){->
  assert true
}

E(~/o sistema deverá informar que já existe um projeto com o nome informado/){->
  at PageProj
 
     waitFor(60){
       page.btnclose.click()  
      } 
      Thread.sleep(5000)  
}


//CENÁRIO 5
Então(~/um novo projeto será criado/){->
 assert true
}

Quando(~/o usuário estiver na página do Projeto/){->
 assert true
}

E(~/selecionar o botão Editar, ao lado do nome do projeto/){->
 at PageProj
        
   Thread.sleep(5000)  

      waitFor(60){
        page.btnedit.click()
      }

    Thread.sleep(2000) 
}

Então(~/o sistema deve abrir um modal, com o atual nome do projeto selecionado/){->
 assert true
}


Quando(~/o usuário limpar o campo/){->
at PageProj
       
   Thread.sleep(6000)  

        waitFor(60){
       page.campclear.click()
        }

      Thread.sleep(5000) 
}


E(~/clicar no botão Salvar/){->
 at PageProj

     waitFor(60){
       page.btnConfirm.click()  
       } 

       Thread.sleep(5000) 
       
}


Então(~/o nome e a descrição do projeto serão atualizados/){->
  at PageProj

   waitFor(60){
       $(By.xpath("//*[@id='root']/section/section/div[1]/div/div/div/div/span")).click()
       } 

    Thread.sleep(5000) 
}



//CENÁRIO 6

Quando(~/selecionar o projeto que deseja Editar/){->
 at PageProj

     Thread.sleep(5000) 

     waitFor(60){
     $(By.xpath("//*[contains(text(), 'TesteProj3')]")).click()
    }
}

E(~/o sitema direcionar o usuário para a página do projeto/){->
 assert true
}


Quando(~/selecionar o botão Editar/){->
 at PageProj
   Thread.sleep(5000) 

      waitFor(60){
       page.btnedit.click()
      }

      Thread.sleep(5000)
}

E(~/o sitema abrir o modal/){->
 assert true
}

E(~/o usuário informar a seguinte descrição:'(.*)'/){String editdesc->
 at PageProj

      waitFor(60){
       page.campDesc.value(editdesc)  
      } 
       
     Thread.sleep(5000) 
}


E(~/selecionar o botão Cancelar/){->
 at PageProj

    Thread.sleep(5000)

      waitFor(60){
       page.editcancel.click()  
      } 
       
     Thread.sleep(2000)
}


E(~/nenhuma alteração deve ser feita/){->
at PageProj

   waitFor(60){
       $(By.xpath("//*[@id='root']/section/section/div[1]/div/div/div/div/span")).click()
       } 

    Thread.sleep(7000)

}




//CENARIO 7
E(~/selecionar um dos projetos da lista de projetos/){->
  at PageProj

     Thread.sleep(5000) 

     waitFor(60){
     $(By.xpath("//*[contains(text(), 'ProjetoTeste')]")).click()
    }
} 

E(~/o atual nome do projeto deve estar selecionado/){->
 assert true
}


E(~/manter a descrição atual do projeto/){->
assert true
}  

E(~/selecionar o botão Salvar/){->
   at PageProj

   Thread.sleep(5000)

     waitFor(60){
     $(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]")).click()
     }

     Thread.sleep(2000)
}

E(~/o sistema deverá informar que já existe um projeto com aquele nome/){->
  at PageProj

   Thread.sleep(5000)

     waitFor(60){
     $(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/button")).click()
     }

     Thread.sleep(5000)
}


//CENÁRIO 8

E(~/deseja pesquisar um projeto pelo nome/){->
 assert true
} 

Então(~/será aberto um modal/){->
 assert true
}

Quando(~/selecionar o icone de pesquisa ao lado da coluna Nome do Projeto/){->
 at PageProj

 Thread.sleep(5000)

  waitFor(60){
    page.btnsearch.click()  
  } 
  
  Thread.sleep(2000)
}



Quando(~/o usuário inserir:'(.*)'/){String psqnome->
 at PageProj

    Thread.sleep(5000)

     waitFor(60){
       $(By.xpath("/html/body/div[2]/div/div/div/div/input")).value(psqnome)
     }
    
    Thread.sleep(2000)
       
}


E(~/selecionar o botão Search/){->
 at  PageProj

   Thread.sleep(5000)

      waitFor(60){
       page.btnpesq.click()  
       } 
       
       Thread.sleep(7000)
}

Então(~/o sistema deve apresentar o projeto que possui o nome inserido no campo de pesquisa/){->
  assert true
}

E(~/se não houver nenhum projeto com o nome informado o sitema deve apresentar a página em branco/){->
 assert true
}


//CENARIO 9

E(~/selecionar o botão "Reset"/){->
at PageProj

Thread.sleep(5000)

      waitFor(60){
       page.btnreset.click()  
       } 
       
    Thread.sleep(5000)
}

Então(~/o sistema deve cancelar a operação/){->
 assert true
}


E(~/o modal deve ser fechado/){->
 assert true
}


//CENÁRIO 10

E(~/deseja pesquisar um projeto pela Tag/){->
  assert true
}

Quando(~/selecionar o icone ao lado da coluna Tags/){->
at PageProj

 Thread.sleep(5000)

      waitFor(60){
       page.btntag.click()  
       } 
       
   Thread.sleep(5000)
}

Então(~/será aberto um modal com as opções de tags/){->
  assert true
}

Quando(~/o usuário selecionar a Tag "Experimentação"/){->
 at PageProj

 Thread.sleep(5000)

  waitFor(60){
    $(By.xpath("/html/body/div[4]/div/div/div/ul/li[1]/label/span")).click()
  }

 Thread.sleep(2000)

} 

E(~/selecionar o botão "OK"/){->
at PageProj

 Thread.sleep(5000)

  waitFor(60){
    page.btnok.click()
  }

 Thread.sleep(2000)

}

Então(~/o sistema deverá exibir os projetos que possuem experimeto/){->
 assert true
}


Então(~/novamente será aberto o modal com as opções de tags/){->
 assert true
}

Quando(~/o usuário selecionar a Tag "Pré implantação"/){->
 at PageProj

 Thread.sleep(5000)

  waitFor(60){
    $(By.xpath("/html/body/div[4]/div/div/div/ul/li[2]/label/span")).click()
  }
 
 Thread.sleep(2000)

} 

Então(~/o sistema deverá exibir os projetos que possuem Pré implantação/){->
  assert true
}

Quando(~/o usuário selecionar a Tag "Implantado"/){->
 at PageProj

 Thread.sleep(5000)

  waitFor(60){
    $(By.xpath("/html/body/div[4]/div/div/div/ul/li[3]/label/span")).click()
  }
 
 Thread.sleep(2000)


}

Então(~/o sistema deverá exibir os projetos que possuem Experimento Implantado/){->
 assert true
}



//CENÁRIO 11

E(~/selecionar o botão "Resetar"/){->
 at PageProj

 Thread.sleep(5000)

  waitFor(60){
   page.btnresetar.click()
  }
  
  Thread.sleep(2000)
}



//CENÁRIO 12

Quando(~/selecionar um dos projetos da lista/){->
at PageProj

    waitFor(60){
     $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[3]/td[1]/label/span")).click()
    }
}


E(~/na coluna ação selecionar a opção Excluir/){->
   at PageProj

     Thread.sleep(1000) 

     waitFor(60){
       page.btnexcluir.click()  
      } 
      
      Thread.sleep(1000) 

}

E(~/o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir esse Projeto?"/){->
   assert true
}

E(~/o usuário confirmar a operação clicando no botão Sim/){->
at PageProj

 Thread.sleep(5000)

     waitFor(60){
       page.btnsim.click()  
      } 
      
      Thread.sleep(5000) 
}

Então(~/o projeto será excluído da lista de Projetos/){->
 assert true
}


//CENÁRIO 13

E(~/o usuário clicar no botão Não/){->
at PageProj

Thread.sleep(1000)

     waitFor(60){
       page.btnNao.click() 
      } 
      
      Thread.sleep(5000) 
}

Então(~/a operação será cancelada/){->
  assert true
}


E(~/o projeto não será excluído e permanecerá na lista de projetos/){->
 assert true
}

//CENÁRIO 14
E(~/será apresentado sua lista de projetos existente/){->
assert true
}

Quando(~/selecionar vários projetos da lista/){->
 at PageProj
Thread.sleep(5000)

    waitFor(60){
     $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[1]/div/label/span")).click()
     }

      Thread.sleep(5000) 
}



E(~/clicar no botão Excluir Selecionados/){->
at PageProj

    waitFor(60){
     $(By.xpath("//*[@id='root']/section/section/div[1]/div/span/div/button[2]")).click()
     }
    
     Thread.sleep(5000)
}


E(~/o sistema abrir uma pop-up com a seguinte mensagem "Excluir projetos selecionados?"/){->
 assert true
}

E(~/o usuário selecionar o botão "Não"/){->
 at PageProj

    waitFor(60){
     $(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[1]")).click()
    }
}



E(~/nenhum dos projetos selecionados será excluído/){->
 assert true
}


Quando(~/o usuários selecionar vários projetos da lista novamente/){->
 assert true
}

E(~/selecionar o botão "Sim"/){->
at PageProj

  Thread.sleep(2000)

    waitFor(60){
     $(By.xpath("/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[2]")).click()
    }

    Thread.sleep(5000)
}

Então(~/todos os projetos selecionados serão excluídos/){->
 assert true
}

E(~/removidos da lista de projetos/){->
 assert true
}
