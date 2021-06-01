package pages

import org.openqa.selenium.By
import pages.base.BasePage

class PageProj extends BasePage {

  static at = { title == "PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio" }
  static content = {

    titleMeusProjetos {$(By.xpath("//*[@id='root']/section/section/div[1]/div/div/span/div/div/h3"))}

    buttonClear {$(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[2]/form/div[1]/div[2]/div/div/span/span/span/svg/path"))}
       
    projetoMenu {$(By.xpath("//*[@id='root']/section/aside/div[1]/ul/li[1]"))}
       
    tarefaMenu {$(By.xpath("//*[@id='root']/section/aside/div[1]/ul/li[2]"))}

    //btnNewproj{$(By.xpath("//*[@id='root']/section/section/div[1]/div/span/div/button/span[1]"))}

    campnome {$(By.xpath("//*[@id='name']"))}

    limparcampo {$(By.xpath("//*[@id='projectForm']/div[1]/div[2]/div/div/"))}

    campDesc {$(By.xpath("//*[@id='description']"))}

    btnConfirm {$(By.xpath('/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]/span'))}

    btnCancel {$(By.xpath('/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[1]'))}

    cardExp {$(By.xpath("//*[@id='root']/section/section/section/main/section/div[1]/div[1]/div[2]"))}

    cardFluxos {$(By.xpath("//*[@id='root']/section/section/section/main/section/div[1]/div[2]/div[2]"))}

    returnProj {$(By.xpath("//*[@id='root']/section/header/ul/li[6]"))}

    btnclose {$(By.xpath('/html/body/div[3]/div/div[2]/div/div[2]/button/span'))}

    btnedit {$(By.xpath('/html/body/div[1]/section/section/div/div/div/span/div/div/span'))}

    btnalt {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[3]/td[5]/button[1]"))}

    editcancel {$(By.xpath('/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[1]'))}

    btndeleteProj {$(By.xpath("//*[@id='root']/section/section/div/div/span/button"))}

    deleteYes {$(By.xpath('/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]'))}

    deleteNo {$(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[1]'))}

    btnexcluir {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/tbody/tr[3]/td[6]/button"))}

    btnsim {$(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[2]'))}

    btnNao {$(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[1]'))}

    btnselect {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[2]/td[1]/button"))}

    campclear {$(By.xpath("//*[@id='projectForm']/div[1]/div[2]/div/div/span/span"))}

    btnproj {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/table/tbody/tr[1]/td[5]/button[1]]"))}

    btnsearch {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[2]/div/span[2]/span"))}

    btnpesq {$(By.xpath('/html/body/div[2]/div/div/div/div/div/div[1]/button'))}

    btnReset {$(By.xpath("//*[contains(text(), 'Reset')]"))}

    btntag {$(By.xpath("//*[@id='root']/section/section/div[2]/div/div/div/div/div/div/div/table/thead/tr/th[4]/div/span[2]/span"))}

    btnok {$(By.xpath('/html/body/div[2]/div/div/div/div/button[2]'))}

    btnresetar {$(By.xpath('/html/body/div[2]/div/div/div/div/button[1]'))}

    // Xpath - EXPERIMENTO
    menuconjunto {$(By.xpath("//*[@id='root']/section/section/section/aside/div/div/ul/li[2]"))} 

    uploadArq {$(By.xpath("//*[@id='DATASETS\$Menu']/li[2]/div/div[1]/span"))}

    operadorUpArq {$(By.className('task-elements'))}

    btnimport {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/span/div[1]/span/button"))}

    select {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]"))}

    inputFile {$("input[type='file']") }

    btnvisualizar {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/button"))}

    abaobs {$(By.xpath("//*[@id='rc-tabs-1-tab-2']"))}

    abaatb {$(By.xpath("//*[@id='rc-tabs-1-tab-1']"))}

    btnvisufechar {$(By.xpath('/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]'))}

    menuEngAt {$(By.xpath("//*[@id='root']/section/section/section/aside/div/div/ul/li[4]"))}

    opImputer {$(By.xpath("//*[contains(text(), 'Imputação de Valores Faltantes')]"))}

    //menuTreinamento{$(By.xpath("//*[@id='root']/section/section/section/aside/div/div/ul/li[5]"))}
    menuTreinamento {$(By.xpath("//*[@id='root']/section/section/section/aside/div/div/ul/li[6]/div/span/span[2]"))}

    //*[@id="root"]/section/section/section/aside/div/div/ul/li[6]/div/span/span[2]

    opReglog {$(By.xpath("//*[contains(text(), 'Regressão Logística')]"))}

    tarefaImputer {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[2]/div/div/div[2]/div/div"))}

    selectAtrib {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/span[1]"))}

    //atributoSpecies{$(By.xpath("//*[contains(text(), 'Species')]"))}
    atributoSpecies {$(By.xpath('/html/body/div[6]/div/div/div/div[2]/div/div/div[6]/div'))}

    campinput {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div[6]/div[2]/input"))}

    // tarefaReg {$(By.xpath("//*[@id='fb6604e9-222c-4da6-b1c2-ef474bfe538b']/div/div[2]"))}

    tarefaReg {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[2]/div/div/div[3]/div/div"))}
    //*[@id="DEFAULT$Menu"]/li[2]/div

    //*[@id="fb6604e9-222c-4da6-b1c2-ef474bfe538b"]/div/div[2]

    campomsf {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div/div"))}

    opincluir {$(By.xpath('/html/body/div[6]/div/div/div/div[2]/div/div/div[1]/div'))}

    campoFeature {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div[4]/div[2]"))}

    campofcode {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div[5]/div[2]/div"))}

    atributoSepalL {$(By.xpath('/html/body/div[6]/div/div/div/div[2]/div/div/div[2]'))}

    atributoPetal {$(By.xpath('/html/body/div[6]/div/div/div/div[2]/div/div/div[4]'))}

    btnexecut {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[2]"))}

    btnvisuresult {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[2]/div/button[1]"))}

    abaresult {$(By.xpath('/html/body/div[11]/div/div[2]/div/div[2]/div[2]/div/div/div[1]/div[1]/div/div[1]'))}

    abametricas {$(By.xpath("//*[contains(text(), 'Métricas')]"))}

    abaparametros {$(By.xpath("//*[contains(text(), 'Parâmetros')]"))}

    taskreglinear {$(By.xpath("//*[contains(text(), 'Regressão Linear')]"))}

    atributolabel {$(By.xpath('/html/body/div[5]/div/div/div/div[2]/div/div/div[1]'))}

    atributotext {$(By.xpath('/html/body/div[5]/div/div/div/div[2]/div/div/div[2]'))}

    atributoisvalid {$(By.xpath('/html/body/div[5]/div/div/div/div[2]/div/div/div[3]'))}

    opreglinear {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[2]/div/div/div[2]/div/div"))}

    btnjupyter {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/button[2]"))}

    campError {$(By.xpath("//*[@id='id-47a50ad1-bc31-451d-9726-4c0e985464c5']/div[20]/div[3]/div[2]/div/div[2]"))}

    selectProj {$(By.xpath("//*[contains(text(), 'TESTE J')]"))}

    newexp {$(By.xpath("//*[@id='root']/section/section/section/main/section/div[1]/div[1]/div[1]/button"))}

    btncleancamp {$(By.xpath("//*[@id='newExperimentForm']/div/div[2]/div/div/span/span"))}

    campnamExp {$(By.xpath("//*[@id='name']"))}

    btnNewExp {$(By.xpath('/html/body/div[2]/div/div[2]/div/div[2]/div[3]/button[2]'))}

    selectaba {$(By.xpath("//*[@id='rc-tabs-24-tab-e558b62f-9eb6-4046-b7d4-d7bb057f0762']/div/div/div"))}

    btnrename {$(By.xpath("//*[@id='root']/section/section/section/main/section/footer/div/nav/span[1]/div/div"))}

    clearcamp {$(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/span/span/span[1]/span'))}

    inputname {$(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/span/span/span[1]/input'))}

    btnokname {$(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/span/span/span[2]/button'))}

    btnsalvartemp {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[1]"))}

    btnlimptemplate {$(By.xpath("//*[@id='newTemplateForm']/div/div[2]/div/div/span/span/span"))}

    camptemplate {$(By.xpath("//*[@id='name']"))}

    btnSalvar {$(By.xpath("//*[contains(text(), 'Salvar')]"))}

    menutemplates {$(By.xpath("//*[contains(text(), 'Templates')]"))}

    newExperimento {$(By.xpath("//*[@id='root']/section/section/section/main/section/footer/div/button"))}

    selectTemplate {$(By.xpath("//*[@id='TEMPLATES']/li/div/div[1]/span"))}

    btninterromper {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[2]"))}

    btnImplantar {$(By.xpath("//*[@id='root']/section/section/div/div/span/div[1]/div/div[2]/button"))}

    btncriar {$(By.xpath('/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]'))}

    selectTask {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[2]/div/div/div[2]"))}

    btnremovetask {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[1]/button[5]"))}

    btnsimremover {$(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[2]'))}

    btnremoverExp {$(By.xpath("//*[@id='rc-tabs-7-tab-b40d5b1e-bd59-45f7-b500-5360f52729c4']/div/div/span/svg/path"))}

    btnRemoverconfirm {$(By.xpath('/html/body/div[3]/div/div/div/div[2]/div/div[2]/button[2]'))}

    btnremoverNo {$(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[1]'))}

    btndup {$(By.xpath("//*[@id='root']/section/section/section/main/section/footer/div/nav/span[2]/div"))}

    projeselect {$(By.xpath("//*[contains(text(), 'ProjTeste')]"))}

    btncomp {$(By.xpath("//*[@id='root']/section/section/div/div/span/div[1]/div/div[1]/button"))}

    selectprojteste {$(By.xpath("//*[contains(text(), 'Teste')]"))}

    btnaddresult {$(By.xpath('/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div/div/div/button'))}

    btnaddresult2 {$(By.xpath('/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div/button'))}

    btnselectexp {$(By.xpath('/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div[1]/div/div/div/div[2]'))}

    btnselectexp2 {$(By.xpath('/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div/div[1]/div/div/div/div[2]'))}

    btnexpe {$(By.xpath('/html/body/div[3]/div/div/div/ul/li[1]'))}

    btnexpe2 {$(By.xpath('/html/body/div[4]/div/div/div/ul/li[2]'))}

    btnopc {$(By.xpath('/html/body/div[3]/div/div/div/ul[2]/li[1]'))}

    btnopc2 {$(By.xpath(' /html/body/div[4]/div/div/div/ul[2]/li'))}

    selecttask {$(By.xpath('/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div[2]/div[1]'))}

    selectoptask {$(By.xpath('/html/body/div[3]/div/div/div/div[2]/div/div/div/div/div'))}

    selecttask2 {$(By.xpath('/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div/div[2]/div[1]'))}

    selectoptask2 {$(By.xpath('/html/body/div[5]/div/div/div/div[2]/div/div/div/div/div'))}

    btnelement {$(By.xpath("//*[@id='c42f7c3b-365a-4a00-b265-55b6d52f0e45']/div/div[3]/div"))}

  }

}