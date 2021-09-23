Title PlatIAgro
@echo off
cls
:menu
cls
color 07

date /t

echo Computador: %computername%        Usuario: %username%
cd /
cd \Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\lib\
start javaw -jar ambiente.jar
echo.
echo ==============================================
echo.
echo ::::::: Teste Automatizado - PlatIAgro :::::::
echo.
echo ==============================================
echo.
echo.
echo            MENU TESTES
echo  ==================================
echo.
echo *  1. Login - PlatIAgro            *
echo.
echo.
echo *  2. CRUD Experimento             *
echo.
echo.
echo *  3. CRUD Fluxos Implantados      *
echo.
echo.
echo *  4. CRUD Projetos                *
echo.
echo.
echo *  5. CRUD Tarefas                 *
echo.
echo.
echo *  6. Test All                     *
echo.
echo.
echo *  7. Sair                         *
echo.
echo  ==================================

set /p opcao= Escolha uma opcao: 
echo ------------------------------
if %opcao% equ 1 goto opcao1
if %opcao% equ 2 goto opcao2
if %opcao% equ 3 goto opcao3
if %opcao% equ 4 goto opcao4
if %opcao% equ 5 goto opcao5
if %opcao% equ 6 goto opcao6
if %opcao% equ 7 goto opcao7
if %opcao% GEQ 8 goto opcao8

:opcao1
cls
@echo off
echo.
echo.
echo =============================================
echo.
echo *********     Login - PlatIAgro     *********
echo.
echo =============================================
echo.
echo.
cd /
cd \Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\
call gradle bdd -Ptag=@LOGIN
pause
call C:\Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\build\reports\cucumber\cucumber-html-reports\overview-features.html
goto menu

:opcao2
cls
@echo off
echo.
echo.
echo =============================================
echo.
echo *********      CRUD Experimento     *********
echo.
echo =============================================
echo.
echo.
cd /
cd \Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\
call gradle bdd -Ptag=@EXPERIMENTO
pause
call C:\Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\build\reports\cucumber\cucumber-html-reports\overview-features.html
goto menu

:opcao3
cls
@echo off
echo.
echo.
echo =============================================
echo.
echo ******     CRUD Fluxos Implantados     ******
echo.
echo =============================================
echo.
echo.
cd /
cd \Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\
call gradle bdd -Ptag=@IMPLANTAR
pause
call C:\Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\build\reports\cucumber\cucumber-html-reports\overview-features.html
goto menu

:opcao4
cls
@echo off
echo.
echo.
echo =============================================
echo.
echo ***********     CRUD Projetos     ***********
echo.
echo =============================================
echo.
echo.
cd /
cd \Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\
call gradle bdd -Ptag=@PROJETO
call C:\Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\build\reports\cucumber\cucumber-html-reports\overview-features.html
pause
goto menu

:opcao5
cls
@echo off
echo.
echo.
echo =============================================
echo.
echo ***********     CRUD Tarefas     ************
echo.
echo =============================================
echo.
echo.
cd /
cd \Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\
call gradle bdd -Ptag=@TAREFA
call C:\Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\build\reports\cucumber\cucumber-html-reports\overview-features.html
pause
goto menu

:opcao6
cls
@echo off
echo.
echo.
echo =============================================
echo.
echo **********  Testing All Scenarios  **********
echo.
echo =============================================
echo.
echo.
cd /
cd \Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\
call gradle bdd -Ptag=@LOGIN@PROJETO@EXPERIMENTO@IMPLANTAR@TAREFA
call C:\Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\build\reports\cucumber\cucumber-html-reports\overview-features.html
pause
goto menu

:opcao7
cls
exit

:opcao8
echo.
echo ===============================================
echo * Opcao Invalida! Escolha outra opcao do menu *
echo ===============================================
echo.
pause
goto menu