package pages

import org.openqa.selenium.By
import pages.base.BasePage

class PageProj extends BasePage {

  static at = { title == 'PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio' }
  static content = {
    // Interface de acesso a elementos da camada de visão relativa a Projetos

    titleMeusProjetos { $(By.xpath("//*[@id='root']/section/section/div[1]/div/div/span/div/div/h3")) }

    buttonClear { $(By.xpath('/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div/div/span/span/span/svg/path')) }

    projetoMenu { $(By.xpath("//*[@id='root']/section/aside/div[1]/ul/li[1]")) }

    tarefaMenu { $(By.xpath("//*[@id='root']/section/aside/div[1]/ul/li[2]")) }

    campnome { $(By.xpath("//*[@id='name']")) }

    limparcampo { $(By.xpath("//*[@id='projectForm']/div[1]/div[2]/div/div/")) }

    campDesc { $(By.xpath("//*[@id='description']")) }

    btnConfirm { $(By.xpath('/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]/span')) }

    btnCancel { $(By.xpath('/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]')) }

    cardExp { $(By.xpath('/html/body/div[1]/section/section/section/main/section/div/div[1]/div[1]/button/div[1]/div/img')) }

    cardFluxos { $(By.xpath("//*[@id='root']/section/section/section/main/section/div[1]/div[2]/div[2]")) }

    returnProj { $(By.xpath("//*[@id='root']/section/header/ul/li[6]")) }

    btnclose { $(By.xpath('/html/body/div[3]/div/div[2]/div/div[2]/button/span')) }

    btnedit { $(By.xpath('/html/body/div[1]/section/section/div/div/div/span/div/div/span')) }

    btnalt { $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[3]/td[5]/button[1]")) }

    editcancel { $(By.xpath('/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[1]')) }

    btndeleteProj { $(By.xpath("//*[@id='root']/section/section/div/div/span/button")) }

    deleteYes { $(By.xpath('/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]')) }

    deleteNo { $(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[1]')) }

    btnexcluir { $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[3]/td[6]/button")) }

    btnsim { $(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[2]')) }

    btnselect { $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[2]/td[1]/button")) }

    campclear { $(By.xpath("//*[@id='projectForm']/div[1]/div[2]/div/div/span/span")) }

    btnproj { $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[1]/td[5]/button[1]]")) }

    btnsearch { $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[2]/div/span[2]/span")) }

    btnpesq { $(By.xpath('/html/body/div[2]/div/div/div/div/div/div[1]/button')) }

    btnReset { $(By.xpath("//*[contains(text(), 'Reset')]")) }

    btntag { $(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[4]/div/span[2]/span")) }

    btnok { $(By.xpath('/html/body/div[2]/div/div/div/div/button[2]')) }

    btnresetar { $(By.xpath('/html/body/div[2]/div/div/div/div/button[1]')) }

    uploadArq { $(By.xpath("//*[@id='DATASETS\$Menu']/li[2]/div/div[1]/span")) }

    select { $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]")) }

    abaobs { $(By.xpath("//*[@id='rc-tabs-1-tab-2']")) }

    abaatb { $(By.xpath("//*[@id='rc-tabs-1-tab-1']")) }

    btnvisufechar { $(By.xpath('/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]')) }

    menuEngAt { $(By.xpath("//*[@id='root']/section/section/section/aside/div/div/ul/li[4]")) }

    opImputer { $(By.xpath("//*[contains(text(), 'Imputação de Valores Faltantes')]")) }

    opReglog { $(By.xpath("//*[contains(text(), 'Regressão Logística')]")) }

    atributoSpecies { $(By.xpath('/html/body/div[6]/div/div/div/div[2]/div/div/div[6]/div')) }

    tarefaReg { $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[2]/div/div/div[3]/div/div")) }

    abaresult { $(By.xpath('/html/body/div[11]/div/div[2]/div/div[2]/div[2]/div/div/div[1]/div[1]/div/div[1]')) }

    taskreglinear { $(By.xpath("//*[contains(text(), 'Regressão Linear')]")) }

    atributolabel { $(By.xpath('/html/body/div[5]/div/div/div/div[2]/div/div/div[1]')) }

    atributotext { $(By.xpath('/html/body/div[5]/div/div/div/div[2]/div/div/div[2]')) }

    atributoisvalid { $(By.xpath('/html/body/div[5]/div/div/div/div[2]/div/div/div[3]')) }

    selectProj { $(By.xpath("//*[contains(text(), 'TESTE J')]")) }

    newexp { $(By.xpath("//*[@id='root']/section/section/section/main/section/div[1]/div[1]/div[1]/button")) }

    btncleancamp { $(By.xpath("//*[@id='newExperimentForm']/div/div[2]/div/div/span/span")) }

    btnNewExp { $(By.xpath('/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]')) }

    selectaba { $(By.xpath("//*[@id='rc-tabs-24-tab-e558b62f-9eb6-4046-b7d4-d7bb057f0762']/div/div/div")) }

    btnrename { $(By.xpath("//*[@id='root']/section/section/section/main/section/footer/div/nav/span[1]/div/div")) }

    clearcamp { $(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/span/span/span[1]/span')) }

    inputname { $(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/span/span/span[1]/input')) }

    btnokname { $(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/span/span/span[2]/button')) }

    btnsalvartemp { $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[1]")) }

    btnSalvar { $(By.xpath("//*[contains(text(), 'Salvar')]")) }

    btninterromper { $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[2]")) }

    btnremovetask { $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[1]/button[5]")) }

    btnremoverExp { $(By.xpath("//*[@id='rc-tabs-7-tab-b40d5b1e-bd59-45f7-b500-5360f52729c4']/div/div/span/svg/path")) }

    btndup { $(By.xpath("//*[@id='root']/section/section/section/main/section/footer/div/nav/span[2]/div")) }

    projeselect { $(By.xpath("//*[contains(text(), 'ProjTeste')]")) }

    selectprojteste { $(By.xpath("//*[contains(text(), 'Teste')]")) }

    btnexpe { $(By.xpath('/html/body/div[3]/div/div/div/ul/li[1]')) }

    btnexpe2 { $(By.xpath('/html/body/div[4]/div/div/div/ul/li[2]')) }

    btnopc { $(By.xpath('/html/body/div[3]/div/div/div/ul[2]/li[1]')) }

    btnopc2 { $(By.xpath(' /html/body/div[4]/div/div/div/ul[2]/li')) }

    selectTask { $(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[2]/div/div/div[2]")) }

    selectoptask { $(By.xpath('/html/body/div[3]/div/div/div/div[2]/div/div/div/div/div')) }

    selectoptask2 { $(By.xpath('/html/body/div[5]/div/div/div/div[2]/div/div/div/div/div')) }

    btnelement { $(By.xpath("//*[@id='c42f7c3b-365a-4a00-b265-55b6d52f0e45']/div/div[3]/div")) }

    btnBuscar { $(By.xpath('/html/body/div[2]/div/div/div/div/div/div[1]/button/span[2]')) }
  }

}
