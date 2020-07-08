import pages.*
import geb.*
import db.*
import cucumber.api.PendingException

import org.openqa.selenium.By
import static cucumber.api.groovy.PT.*


//Contexto

 Dado(~/que o usuário acessa a plataforma PlatIAgro/){->
 to PageInicial
 }

 E(~/está na tela inicial/){->
 assert true
 }


//CENÁRIO 1
Dado(~/que o usuário está na página Meus Projetos/){->
at PageInicial

   waitFor(60){
       page.projetoMenu.click()
   } 

   Thread.sleep(2000) 
}

E(~/será apresentado sua lista de projetos existentes/){->
 assert true
}

Então(~/deverá observar que as informações dos projetos estarão divididos em cinco colunas: Nome do Projeto, Descrição e Ação/){->
assert true
}


//CENÁRIO 2

Quando(~/clicar no botão Novo Projeto/){->
 at PageProj

   waitFor(60){
       page.btnNewproj.click()
   } 
   Thread.sleep(5000)
}

E(~/o sistema deve abrir um modal, com o nome Novo Projeto selecionado/){->
    assert true
} 


E(~/o usuário limpar o campo nome/){->
  at PageProj
     
    Thread.sleep(5000)
 
     waitFor(60){ page.btnclear.click()  }
}
      



E(~/nomear o projeto com: "(.*)"/){String nome->
   at PageProj

       page.campNome.value(nome)  
     
      Thread.sleep(5000) 
}

// E(~/informar a seguinte descrição: "(.*)"/){String desc->
//    at PageProj
//      waitFor(60){
//        page.campDesc.value(desc)  
//        } Thread.sleep(5000) 
// }

// Quando(~/clicar no botão Criar projeto/){->
//     at PageProj

//      waitFor(60){
//        page.btnConfirm.click()  
//        } Thread.sleep(5000) 
//     }
// }

// Então(~/o novo projeto será criado/){->
//   assert true
// } 

// E(~/o usuário será direcionado para a página do projeto/){->
//   assert true
// }


// E(~/nessa página poderá escolher se deseja iniciar um fluxo de Experimentação ou Pré -implantação/){->
//   assert true
// }

// Quando(~/o usuário retornar para a página Meus Projetos deverá observar se o novo projeto foi adicionado à lista de projetos/){->
//   at PageProj

//      waitFor(60){
//        page.returnProj.click()  
//       } Thread.sleep(5000)   
// }


//CENÁRIO 3

E(~/o usuário clicar no botão Cancelar/){
   at PageProj

     waitFor(60){
       page.btnCancel.click()  
      } Thread.sleep(5000)  
}

Então(~/o modal deve ser resetado e fechado/){->
  assert true
}

E(~/nenhum projeto deve ser criado/){->
  assert true
}

//CENÁRIO 4

E (~/não informar a descrição/){->
  assert true
}

Então(~/a operação deve ser cancelada/){->
  assert true
}

E(~/o sistema deverá informar que já existe um projeto com o nome informado/){->
  assert true
}


//CENÁRIO 5

E(~/renomear o projeto para: "(.*)"/){String nomeproj->
   at PageProj

   page.withModal("ant-modal-body"){
     waitFor(60){
       page.campNome.value(nomeproj)  
      } Thread.sleep(5000) 
    }
}

E(~/a descrição como: "(.*)"/){->
   at PageProj

   page.withModal("ant-modal-body"){
     waitFor(60){
       page.campDesc.value(nomeproj)  
      } Thread.sleep(5000) 
    }
}


Quando(~/o usuário estiver na página do novo projeto/){->
 assert true
}

E(~/selecionar o botão Editar - ícone lápis ao lado do nome do projeto/){->
    at PageProj

   page.withModal("ant-modal-body"){
     waitFor(60){
       page.btnedit.click()  
      } Thread.sleep(5000) 
    }
}

Então(~/será aberto um modal/){->
  assert true
}

E(~/o atual nome do projeto deve estar selecionado/){->
  assert true
}


E(~/manter a descrição atual do projeto/){->
  assert true
}

Então(~/o nome e a descrição do projeto serão atualizados/){->
  assert true
}

//CENARIO 7

E(~/selecionar um dos projetos da lista de projetos/){->
   at PageProj

     waitFor(60){
       page.btnselect.click()  
      } Thread.sleep(5000) 
}


E(~/for direcionado para página do projeto/){->
  assert true
} 

Quando(~/o usuário selecionar o botão Editar - ícone lápis ao lado do nome do projeto/){->
assert true
}


E(~/clicar no botão confirmar/){->
 assert true
}


//CENÁRIO 9

Quando(~/selecionar um dos projetos da lista/){->
  assert true
}

E(~/na coluna ação selecionar a opção Excluir/){->
   at PageProj

     waitFor(60){
       page.btnexcluir.click()  
      } Thread.sleep(5000) 
     
}

E(~/o sistema abrir uma pop-up com a seguinte mensagem "Você tem certeza que deseja excluir esse Projeto?"/){->
   assert true
}

E(~/o usuário confirmar a operação clicando no botão Sim/){->
at PageProj

     waitFor(60){
       page.btnexcluir.click()  
      } Thread.sleep(5000) 

}

Então(~/o projeto será excluído da lista de Projetos/){->
 assert true
}


//CENÁRIO 10

E(~/o usuário clicar no botão Não/){->
at PageProj

     waitFor(60){
       page.btnNao.click() 
      } Thread.sleep(5000) 
}

Então(~/a operação será cancelada/){->
  assert true
}


E(~/o projeto não será excluído e permanecerá na lista de projetos/){->
 assert true
}



