package pages

import org.openqa.selenium.By
import pages.base.BasePage

class PageExperimento extends BasePage {

  static at = { title == "PlatIAgro - Plataforma de Inteligência Artificial para o Agronegócio" }
  static content = {

    cardExperimento {$(By.xpath("/html/body/div[1]/section/section/section/main/section/div/div[1]/div[1]/button/div[1]/div/img"))}

    menuConjunto {$(By.xpath("//*[@id='root']/section/section/section/aside/div/div/ul/li[2]"))}

    select {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/span/div[1]/span/div/button[1]/span[2]"))}

    inputFile {$("input[type='file']")}

    btnConf {$(By.xpath('/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]/span'))}

    btnVisualizar {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/button/span[2]"))}

    menuEngAtributos {$(By.xpath("//*[@id='root']/section/section/section/aside/div/div/ul/li[5]/div/span/span[2]"))}

    menuTreinamento {$(By.xpath("//*[@id='root']/section/section/section/aside/div/div/ul/li[7]/div/span/span[2]"))}

    operadorUpArq {$(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[2]/div/div/div[1]/div/div/div"))}

    selManAtributos {$(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div[2]/div"))}

    selRegLinear {$(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div[2]/div"))}

    tarefaRegLog {$(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[2]/div/div/div[1]/div[2]/div/div/div[2]/div"))}

    campoAtrAlvo {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div[1]/div[2]/div"))}

    campoFeatFiltragem {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div/div[2]/div"))}

    species {$(By.xpath("//*[contains(text(), 'Species')]"))}

    label {$(By.xpath("//*[contains(@title, 'label')]"))}

    text {$(By.xpath("//*[contains(@title, 'text')]"))}

    isValid {$(By.xpath("//*[contains(@title, 'is_valid')]"))}

    selTask_I {$(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div[2]/div[1]/div"))}

    selTask_II {$(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div"))}

    campoMSF {$(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div[2]/div[2]/div/div/span[2]"))}

    opIncluir {$(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/div/div/div[1]/div"))}

    campoFeature {$(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div[3]/div[2]/div"))}

    atributoSepalL {$(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[2]/div"))}

    campoCodeOrd {$(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[1]/div[4]/div[2]/div/div/span[2]"))}

    atributoPetal {$(By.xpath('/html/body/div[6]/div/div/div/div[2]/div/div/div[4]'))}

    btnExecut {$(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[2]/span[2]"))}

    btnVisuResult {$(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[2]/div/button[1]/span[2]"))}

    abaDataset {$(By.xpath("//*[contains(text(), 'Dataset')]"))}

    abaParametros {$(By.xpath("//*[contains(text(), 'Parâmetros')]"))}

    btnJupyter {$(By.xpath("/html/body/div[1]/section/section/section/main/section/main/div[2]/div[2]/div/div[2]/div[2]/div/button[2]/span[2]"))}

    campError {$(By.xpath("//*[@id='id-47a50ad1-bc31-451d-9726-4c0e985464c5']/div[20]/div[3]/div[2]/div/div[2]"))}

    histErrMsg {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[2]/div/span/button"))}

    btnOK {$(By.xpath("//*[contains(text(), 'Ok')]"))}

    btnComp {$(By.xpath("//*[contains(text(), 'Comparar resultados')]"))}

    btnAddResult {$(By.xpath("//*[contains(text(), 'Adicionar resultado')]"))}

    btnSelectExp_I {$(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]"))}

    btnSelectExp_II {$(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div/div[1]/div/div/div/div[2]"))}

    btnSaveTempl {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[1]/span[2]"))}

    btnLimpTemplate {$(By.xpath("//*[@id='newTemplateForm']/div/div[2]/div/div/span/span/span"))}

    campTemplate {$(By.xpath("//*[@id='name']"))}

    menuTemplates {$(By.xpath("//*[contains(text(), 'Templates')]"))}

    newExperimento {$(By.xpath("//*[@id='root']/section/section/section/main/section/div/div[1]/div[1]/div/button/span[2]"))}

    btnCriar {$(By.xpath('/html/body/div[3]/div/div[2]/div/div[2]/div[3]/button[2]'))}

    selectTemplate {$(By.xpath("//*[@id='root']/section/section/section/aside/div/div/ul/li[1]"))}

    clearCampoExp {$(By.xpath("//*[@id='newExperimentForm']/div/div[2]/div/div/span/span"))}

    btnInterromper {$(By.xpath("//*[@id='root']/section/section/section/main/section/main/div[1]/div[1]/div[2]/button[2]/span[2]"))}

    remover {$(By.xpath("//*[contains(text(), 'Remover')]"))}

    removerNo {$(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[1]'))}

    removerYes {$(By.xpath('/html/body/div[2]/div/div/div/div[2]/div/div[2]/button[2]'))}

    btnImplantar {$(By.xpath("//*[contains(text(), 'Preparar para a implantação')]"))}

  }

}