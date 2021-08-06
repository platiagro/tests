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
echo *  1. CRUD Experimento             *
echo.
echo.
echo *  2. CRUD Fluxos Implantados      *
echo.
echo.
echo *  3. CRUD Projetos                *
echo.
echo.
echo *  4. CRUD Tarefas                 *
echo.
echo.
echo *  5. Test All                     *
echo.
echo.
echo *  6. Sair                         *
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
if %opcao% GEQ 7 goto opcao7

:opcao1
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
call gradle bdd -Ptag=@CRUDEXP
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
echo ******     CRUD Fluxos Implantados     ******
echo.
echo =============================================
echo.
echo.
cd /
cd \Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\
call gradle bdd -Ptag=@FLUXOIMP
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
echo ***********     CRUD Projetos     ***********
echo.
echo =============================================
echo.
echo.
cd /
cd \Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\
call gradle bdd -Ptag=@CRUDPROJ
call C:\Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\build\reports\cucumber\cucumber-html-reports\overview-features.html
pause
goto menu

:opcao4
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
call gradle bdd -Ptag=@CRUDTAREFA
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
echo **********  Testing All Scenarios  **********
echo.
echo =============================================
echo.
echo.
cd /
cd \Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\
call gradle bdd -Ptag=@CRUDPROJ@CRUDEXP@FLUXOIMP
call C:\Bitbucket\PlatIAgro\testes_automaticos\cucumber-geb\build\reports\cucumber\cucumber-html-reports\overview-features.html
pause
goto menu

:opcao6
cls
exit

:opcao7
echo.
echo ===============================================
echo * Opcao Invalida! Escolha outra opcao do menu *
echo ===============================================
echo.
pause
goto menu